package com.lizhenfang.cms.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
*@program:lizhenfang-cms
* @author: 李振芳
*
* @version:2019年12月23日 下午1:15:55
**/
@Component
public class SpringBeanUtils implements ApplicationContextAware{
	
	private static ApplicationContext applicationContext = null;
	
	@Autowired
	public void setApplicationContext(ApplicationContext applicationContext) {
		if(SpringBeanUtils.applicationContext == null) {
			SpringBeanUtils.applicationContext = applicationContext;
		}
	}

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	public static <T> T getBean(String name,Class<T> clazz) {
		return applicationContext.getBean(name, clazz);
	}
	
	public static <T> T getBean(Class<T> clazz) {
		return applicationContext.getBean(clazz);
	}

}
