package com.xjw.zookeeper.systemconfig;

import org.springframework.context.ApplicationContext;

/**      
 * 项目名称：zmc  
 * 实现功能：系统配置类  
 * 类名称：SystemConfig   
 * 类描述：(该类的主要功能)
 * 创建人：徐纪伟 
 * E-mail: 289045706@qq.com
 * 创建时间：2016年12月18日下午2:47:21   
 * 修改人：   
 * 修改时间：   
 * 版权 :
 * 修改备注：   
 * @version    
 */
public class SystemConfig {
	
	
	private static ApplicationContext ctx;
	
	public static ApplicationContext getApplicationContext() {
		return ctx;
	}
	public static void setApplicationContext(ApplicationContext ctx) {
		SystemConfig.ctx = ctx;
	}
	/**
	 * 获取zk配置
	 * @return
	 * author ： 徐纪伟
	 */
	public static ZookeeperConfig getZookeeperConfig() {
		return (ZookeeperConfig)ctx.getBean("zookeeperConfig");
	}
}
