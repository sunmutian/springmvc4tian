package com.xjw.zookeeper.server;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.StringUtils;
import org.apache.zookeeper.ServerAdminClient;
import org.apache.zookeeper.server.quorum.QuorumPeer;
import org.apache.zookeeper.server.quorum.QuorumPeerConfig;
import org.apache.zookeeper.server.quorum.QuorumPeerConfig.ConfigException;
import org.apache.zookeeper.server.quorum.QuorumPeerMain;

/**      
 * 项目名称：zmc  
 * 实现功能： zk服务器管理操作类  
 * 类名称：ZookeeperServer   
 * 类描述：(该类的主要功能)
 * 创建人：徐纪伟 
 * E-mail: 289045706@qq.com
 * 创建时间：2017年1月8日下午6:48:08   
 * 修改人：   
 * 修改时间：   
 * 版权 :
 * 修改备注：   
 * @version    
 */
public class ZookeeperServer {
	
	
	public static boolean bootServer(final String configPath){
		if (StringUtils.isBlank(configPath)) {
			return false;
		}
		final CountDownLatch connectedLatch = new CountDownLatch(1);
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					QuorumPeerConfig config = new QuorumPeerConfig();
					config.parse(configPath);
					QuorumPeerMain peerMain = new QuorumPeerMain();
					peerMain.runFromConfig(config);
				} catch (Exception e) {
					connectedLatch.countDown();
					e.printStackTrace();
				}
			}
		}).start();
		try {
			boolean b = connectedLatch.await(5000, TimeUnit.MILLISECONDS);
			return !b;
		} catch (InterruptedException e) {
			e.printStackTrace();
			return true;
		}
	}
}
