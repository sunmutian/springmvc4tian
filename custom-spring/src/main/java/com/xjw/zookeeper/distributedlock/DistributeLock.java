package com.xjw.zookeeper.distributedlock;

import java.util.Collections;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.Watcher.Event.EventType;
import org.apache.zookeeper.Watcher.Event.KeeperState;
import org.apache.zookeeper.data.Stat;

import com.xjw.zookeeper.client.ZookeeperClient;

/**      
 * 项目名称：zookeeper  
 * 实现功能：  
 * 类名称：DistributeLock   
 * 类描述：(该类的主要功能)
 * 创建人：徐纪伟 
 * E-mail: 289045706@qq.com
 * 创建时间：2016年12月14日下午10:09:48   
 * 修改人：   
 * 修改时间：   
 * 版权 :
 * 修改备注：   
 * @version    
 */
public class DistributeLock implements Watcher{
	/**
	 * 锁根节点 持久化节点， 该节点目录用于存放所有业务的锁
	 */
	private final static String lOCK_ROOT_PATH = "/lock";
	/**
	 * 二级业务锁节点 持久化节点 ，用于存放所有业务的锁的节点，每个业务有单独的目录
	 * 例如/lock/bussLock
	 */
	private String bussLockPath; 
	/**
	 * 业务锁子节点 临时递增节点 竞争资源  节点原始名称设置为sub
	 * 例如 /lock/bussLock/sub000000001
	 */
	private String subLockPath;
	
	private ZookeeperClient zookeeperClient;
	/**
	 * 当前的竞争节点
	 */
	private String currrentSubPath;
	/**
	 * 等待的前一个节点
	 */
	private String preSubPath;
	/**
	 * 业务工作
	 */
	private Worker worker;
	
	public DistributeLock(String connectString, int sessionTimeOut, String bussLockPath, Worker worker) throws Exception{
		this.bussLockPath = lOCK_ROOT_PATH + "/" + bussLockPath;
		this.subLockPath = this.bussLockPath+"/sub";
		this.worker = worker;
		//初始化zk连接
		zookeeperClient = new ZookeeperClient(connectString, sessionTimeOut);
		/*如果在此处进行根节点和二级节点的创建，那么此处也会有并发问题，可能会出现重复创建而导致出现异常
		 *有的说此处可以使用分布式锁，那么我们本身就是要设计分布式锁，在依赖一个分布式锁，感觉没有必要
		 *所以这些持久化的锁节点完全可以初始化进去，而且一般都会有zk的管理平台，直接初始化进去，减少很多工作量，风险也比较小，便于维护
		 *那么缺点就是万一节点丢了，业务就会报错了。。
		 * try {
			if (!zookeeperClient.exists(lOCK_ROOT_PATH, false)) {
				zookeeperClient.create(lOCK_ROOT_PATH, null, CreateMode.PERSISTENT); 
			}
			if (!zookeeperClient.exists(this.bussLockPath, false)) {
				zookeeperClient.create(this.bussLockPath, null, CreateMode.PERSISTENT); 
			}
		} catch (Exception e) {
			zookeeperClient.releaseConnection();
			throw e;
		}finally{
			
		}*/
	}
	
	public void tryLock() throws Exception{
		try {
			currrentSubPath = zookeeperClient.create(subLockPath,null, CreateMode.EPHEMERAL_SEQUENTIAL);  
	        System.out.println("创建竞争节点："+currrentSubPath);
	        if(this.isMinNode()){  
	            this.getLockSuccess();
	        }  
		} catch (Exception e) {
			zookeeperClient.releaseConnection();
			throw e;
		}finally{
			
		}
	}
	
	public void getLockSuccess() throws Exception{
		System.out.println("节点"+currrentSubPath+"成功获取锁.");
		System.out.println("节点"+currrentSubPath+"执行工作...");
		worker.doWork();
        releaseLock();
	}
	/**
	 * 检查是否是最小节点
	 * @return
	 * @throws KeeperException
	 * @throws InterruptedException
	 */
	public boolean isMinNode() throws KeeperException, InterruptedException{
		boolean b = false;
		List<String> subNodes = zookeeperClient.getChildren(bussLockPath, false);  
		Collections.sort(subNodes);
		int index = subNodes.indexOf(currrentSubPath.substring((bussLockPath).length()+1));  
		switch (index) {
		case -1:
			System.out.println("节点不存在."+currrentSubPath);
			break;
		case 0:
			System.out.println("我是最小的节点."+currrentSubPath);
			return true;  
		default:
			//等待的前一个节点
			preSubPath = bussLockPath +"/"+ subNodes.get(index - 1);  
			try{  
				//监听前一个节点的变化事件
                zookeeperClient.getData(preSubPath, this, new Stat());
                return false;  
            }catch(KeeperException e){  
                if(!zookeeperClient.exists(preSubPath,false)){  
                    System.out.println("前面的节点"+preSubPath+"消失了...");
                    return isMinNode();  
                }else{  
                    throw e;  
                }  
            }  
		}
		return b;
	}
	
	/**
	 * 释放锁
	 * @throws KeeperException
	 * @throws InterruptedException
	 */
	public void releaseLock() throws KeeperException, InterruptedException{
		System.out.println("节点"+currrentSubPath+"工作完毕释放锁...");
		zookeeperClient.delete(currrentSubPath);
		zookeeperClient.releaseConnection();
	}

	/**
	 * 节点变化监听
	 */
	@Override
	public void process(WatchedEvent event) {
		if (event == null) {
			return;
		}
		//成功连接服务器
		if (KeeperState.SyncConnected == event.getState()) {  
            if (EventType.None == event.getType()) {  
                System.out.println("zookeeper connect success"); 
            }else if (EventType.NodeDeleted == event.getType() && event.getPath().equals(preSubPath)) {
				//监听到等待的前一个节点已经消失了，尝试获取锁
            	System.out.println("前面的节点("+preSubPath+")已经消失了，节点("+currrentSubPath+")尝试获取锁.");
            	try {
					if(isMinNode()){  
					    getLockSuccess();
					}
				} catch (Exception e) {
					zookeeperClient.releaseConnection();
					e.printStackTrace();
				}
			}  
        } else if (KeeperState.Disconnected == event.getState()) {  
            System.out.println("zookeeper Disconnected");  
        } else if (KeeperState.AuthFailed == event.getState()) {  
            System.out.println("zookeeper AuthFailed");  
        } else if (KeeperState.Expired == event.getState()) {  
            System.out.println("zookeeper Expired");  
        }  
	}

}
