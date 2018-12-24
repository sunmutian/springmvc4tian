package com.xjw.zookeeper.entity;
/**      
 * 项目名称：zmc  
 * 实现功能：  
 * 类名称：ResultStat   
 * 类描述：(该类的主要功能)
 * 创建人：徐纪伟 
 * E-mail: 289045706@qq.com
 * 创建时间：2016年12月28日下午9:18:39   
 * 修改人：   
 * 修改时间：   
 * 版权 :
 * 修改备注：   
 * @version    
 */
public class ResultStat {
	
	private String ZookeeperVersion;
	
	private String mode;
	
	private int connections;
	
	private int nodeCount;

	public String getZookeeperVersion() {
		return ZookeeperVersion;
	}

	public void setZookeeperVersion(String zookeeperVersion) {
		ZookeeperVersion = zookeeperVersion;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public int getConnections() {
		return connections;
	}

	public void setConnections(int connections) {
		this.connections = connections;
	}

	public int getNodeCount() {
		return nodeCount;
	}

	public void setNodeCount(int nodeCount) {
		this.nodeCount = nodeCount;
	}
	

}
