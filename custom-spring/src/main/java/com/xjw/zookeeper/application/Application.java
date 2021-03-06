package com.xjw.zookeeper.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;

import com.xjw.zookeeper.client.ZookeeperClient;
import com.xjw.zookeeper.systemconfig.SystemConfig;
import com.xjw.zookeeper.systemconfig.ZookeeperConfig;
import com.xjw.zookeeper.util.ZookeeperUtil;
import com.xjw.zookeeper.viewresolver.JsonViewResolver;

/**
 * 
 * 项目名称：spring  
 * 实现功能： 应用主入口 
 * 类名称：Application   
 * 类描述：(该类的主要功能)
 * 创建人：徐纪伟 
 * E-mail: 289045706@qq.com
 * 创建时间：2016-12-14下午04:50:41   
 * 修改人：   
 * 修改时间：   
 * 版权 :
 * 修改备注：   
 * @version
 */
@EnableAutoConfiguration
@Configuration
@ComponentScan("com.xjw.zookeeper")//指定扫描包
@EnableConfigurationProperties({ZookeeperConfig.class})
@SpringBootApplication//启动器
public class Application{
	/**
	 * 上下文对象
	 */
	private static ApplicationContext ac;
	
 
    public static ApplicationContext getApplicationContext() {
		return ac;
	}


	/**
     * json输出，访问时url以json结尾
    	* @方法名称: jsonViewResolver
    	* @return
    	* @author 徐纪伟
    	* 2016年12月5日 下午3:16:32
     */
    @Bean
    public ViewResolver jsonViewResolver() {
        return new JsonViewResolver();
    }
    
    
    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = SpringApplication.run(Application.class);
        ac = ctx;
        SystemConfig.setApplicationContext(ctx);
        ZookeeperConfig zookeeperConfig = SystemConfig.getZookeeperConfig();
        ZookeeperClient zookeeperClient = new ZookeeperClient(zookeeperConfig.getHost(), zookeeperConfig.getTimeout());
        ZookeeperUtil.setZkClient(zookeeperClient);
    }
    
    
}
