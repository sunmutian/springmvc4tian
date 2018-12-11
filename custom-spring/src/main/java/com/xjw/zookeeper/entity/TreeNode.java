package com.xjw.zookeeper.entity;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * ztree节点类
	 * 项目名称：com.bj58.wf.shredder  
	 * 实现功能：  
	 * 类名称：TreeNode   
	 * 版权所有：
	 * 创建人：徐纪伟 
	 * E-mail: 289045706@qq.com
	 * 创建时间：2016年12月6日 上午10:56:55   	
	 * 修改人：   
	 * 修改时间：   
	 * 修改备注：   
	 * @version
 */
public class TreeNode {

	/**
	 * 节点id
	 */
	private String id;
	
	/**
	 * 父节点id
	 */
	private String pId;
	/**
	 * 节点名称
	 */
	private String name;
	/**
	 * 节点是否展开
	 */
	private boolean open;
	/**
	 * 是否选中
	 */
	private boolean checked;
	/**
	 * 是否是叶子节点
	 */
	private boolean isLeafNode;
	/**
	 * 是否是父级节点
	 */
	private boolean isParent;

	public TreeNode(){
		
	}
	
	public TreeNode(String id, String pId, String name, boolean open, boolean checked){
		this.id = id;
		this.pId = pId;
		this.name = name;
		this.open = open;
		this.checked = checked;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getpId() {
		return pId;
	}

	public void setPId(String pid) {
		this.pId = pid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public boolean isLeafNode() {
		return isLeafNode;
	}

	public void setLeafNode(boolean isLeafNode) {
		this.isLeafNode = isLeafNode;
	}

	public boolean getIsParent() {
		return isParent;
	}

	public void setParent(boolean isParent) {
		this.isParent = isParent;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
	
}

