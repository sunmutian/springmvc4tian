package com.xjw.zookeeper.util;

import com.xjw.zookeeper.client.ZookeeperClient;

/**      
 * 项目名称：zookeeper  
 * 实现功能：zk操作工具类  
 * 类名称：ZookeeperUtil   
 * 类描述：(该类的主要功能)
 * 创建人：徐纪伟 
 * E-mail: 289045706@qq.com
 * 创建时间：2016年12月14日下午9:58:05   
 * 修改人：   
 * 修改时间：   
 * 版权 :
 * 修改备注：   
 * @version    
 */
public class ZookeeperUtil {
	/**
	 * 节点分隔符
	 */
	public static final String SEPARATOR = "/"; 
	
	private static ZookeeperClient zkClient = null;

	public static ZookeeperClient getZkClient() {
		return zkClient;
	}

	public static void setZkClient(ZookeeperClient zkClient) {
		ZookeeperUtil.zkClient = zkClient;
	}

}
