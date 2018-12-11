package com.xjw.zookeeper.viewresolver;

import java.util.Locale;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

/**      
 * 项目名称：spring-project  
 * 实现功能：  
 * 类名称：JsonViewResolver   
 * 版权所有：
 * 创建人：徐纪伟 
 * E-mail: 
 * 创建时间：2016年12月5日 下午2:06:29   	
 * 修改人：   
 * 修改时间：   
 * 修改备注：   
 * @version    
 */
public class JsonViewResolver implements ViewResolver {

	@Override
	public View resolveViewName(String arg0, Locale arg1) throws Exception {
		MappingJackson2JsonView view = new MappingJackson2JsonView();
		//便于阅读的排版
        view.setPrettyPrint(true);
        view.setExtractValueFromSingleKeyModel(true);
        return view;
	}

}

