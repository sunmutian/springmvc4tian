package com.xjw.zookeeper.entity;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * action执行json结果模型
	 * 项目名称： 
	 * 实现功能：  
	 * 类名称：JsonResult   
	 * 版权所有：
	 * 创建人：徐纪伟 
	 * E-mail: 289045706@qq.com
	 * 创建时间：2016年5月6日 上午10:41:19   	
	 * 修改人：   
	 * 修改时间：   
	 * 修改备注：   
	 * @version
 */
public class JsonResult {

	/**
	 * 执行结果
	 */
	private boolean success;
	/**
	 * 信息
	 */
	private String message;
	
	/**
	 * 通过指定参数创建json返回值对象
	 * @param success 是否成功
	 * @param message 信息
	 */
	public JsonResult(boolean success, String message){
		this.success = success;
		this.message = message;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this,
				ToStringStyle.SHORT_PREFIX_STYLE);
	}
}

