package com.xjw.zookeeper.distributedlock;
/**      
 * 项目名称：zookeeper  
 * 实现功能： 工作者接口，通过实现该接口，设置分布式锁的业务操作
 * 类名称：Worker   
 * 类描述：(该类的主要功能)
 * 创建人：徐纪伟 
 * E-mail: 289045706@qq.com
 * 创建时间：2016年12月18日下午2:18:00   
 * 修改人：   
 * 修改时间：   
 * 版权 :
 * 修改备注：   
 * @version    
 */
public interface Worker{
	/**
	 * 
	 * @return
	 * @throws Exception
	 * author ： 徐纪伟
	 */
	public boolean doWork() throws Exception;
}
