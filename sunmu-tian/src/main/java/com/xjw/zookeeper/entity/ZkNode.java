package com.xjw.zookeeper.entity;

import org.apache.zookeeper.CreateMode;

import com.xjw.zookeeper.enums.NodeModelEnum;

/**      
 * 项目名称：zmc  
 * 实现功能：  
 * 类名称：ZkNode   
 * 类描述：(该类的主要功能)
 * 创建人：徐纪伟 
 * E-mail: 289045706@qq.com
 * 创建时间：2016年12月24日下午10:01:05   
 * 修改人：   
 * 修改时间：   
 * 版权 :
 * 修改备注：   
 * @version    
 */
public class ZkNode {
	/**
	 * 当前节点id 如 serviceA
	 */
	private String id;
	/**
	 * 父节点id 如 /service
	 */
	private String pId;
	/**
	 * 当前节点数据
	 */
	private String data;
	/**
	 * 当前节点的全部path，如 /service/serviceA
	 */
	private String fullId;
	/**
	 * 节点的类型
	 */
	private NodeModelEnum nodeModel;

	public String getpId() {
		return pId;
	}

	public void setpId(String pId) {
		this.pId = pId;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFullId() {
		return fullId;
	}

	public void setFullId(String fullId) {
		this.fullId = fullId;
	}

	public NodeModelEnum getNodeModel() {
		return nodeModel;
	}

	public void setNodeModel(NodeModelEnum nodeModel) {
		this.nodeModel = nodeModel;
	}

}
