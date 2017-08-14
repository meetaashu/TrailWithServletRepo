package com.test.util;

import org.springframework.beans.BeansException;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class SpringContestBeanProviderUtility {

	public static Object beanProvider(String str){
		Object res=null;
		WebApplicationContext context= ContextLoader.getCurrentWebApplicationContext();
		try {
			res= (context.getBean(Class.forName(str)));
		} catch (BeansException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
		
	}
}
