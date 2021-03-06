package com.xjw.zookeeper.service;

import java.util.List;

import com.xjw.zookeeper.entity.ZkServerInfo;

/**      
 * 项目名称：zmc  
 * 实现功能：  
 * 类名称：ZkServerInfoService   
 * 类描述：(该类的主要功能)
 * 创建人：徐纪伟 
 * E-mail: 289045706@qq.com
 * 创建时间：2016年12月25日下午8:51:59   
 * 修改人：   
 * 修改时间：   
 * 版权 :
 * 修改备注：   
 * @version    
 */
public interface ZkServerInfoService {

	public List<ZkServerInfo> getZkServerInfoByPage(int pageIndex, int pageSize) throws Exception;
	/**
	 * 启动单个zk服务器
	 * @param id
	 * @return
	 * @throws Exception
	 * author ： 徐纪伟
	 */
	public boolean startServer(int id) throws Exception;
	
	/**
	 * 添加一个zk服务器信息
	 * @param zkServerInfo
	 * @return
	 * @throws Exception
	 * author ： 徐纪伟
	 */
	public int addZkServerInfo(ZkServerInfo zkServerInfo) throws Exception;
	/**
	 * 通过主键id删除一个zk服务器信息
	 * @param id
	 * @return
	 * @throws Exception
	 * author ： 徐纪伟
	 */
	public int delZkServerInfoById(int id) throws Exception;
	
	/**
	 * 更新一个zk服务器信息
	 * @param zkServerInfo
	 * @return
	 * @throws Exception
	 * author ： 徐纪伟
	 */
	public int updZkServerInfo(ZkServerInfo zkServerInfo) throws Exception;
	/**
	 * 通过主键id获取一个zk服务器信息
	 * @param id
	 * @return
	 * @throws Exception
	 * author ： 徐纪伟
	 */
	public ZkServerInfo getZkServerInfoById(int id) throws Exception;
	
	/**
	 * 启动全部zk服务器
	 * @param id
	 * @return
	 * @throws Exception
	 * author ： 徐纪伟
	 */
	public boolean startAllServer() throws Exception;
	
	
}
