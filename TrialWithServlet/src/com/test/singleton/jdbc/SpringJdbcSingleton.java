package com.test.singleton.jdbc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import Domain_Package.Mail;

public class SpringJdbcSingleton {

	private static SpringJdbcSingleton jdbc;
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedjdbcTemplate;
	public NamedParameterJdbcTemplate getNamedjdbcTemplate() {
		return namedjdbcTemplate;
	}

	public void setNamedjdbcTemplate(NamedParameterJdbcTemplate namedjdbcTemplate) {
		this.namedjdbcTemplate = namedjdbcTemplate;
	}

	//private Mail m;
	private SpringJdbcSingleton(){}
	
	
	
	public static SpringJdbcSingleton getInstance(){
		if(jdbc==null){
			jdbc=new SpringJdbcSingleton();
		}
		return jdbc;
	}
	
	
	
	public Map loadCache(){
		 ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		   // TableClient client = context.getBean(TableClient.class);
		   // client.start(context);
		 namedjdbcTemplate=(NamedParameterJdbcTemplate)context.getBean("namedJdbcTemplate");

		String sql="Select EmailNo as eId,EmailDate as eDate,FromUserId as fromUserId,ToUserId as toUserId,MailSubject as subject,EmailText as emailText from emails";
		Map<String, String> paramMap=new HashMap<>();
		List<Mail> listMail=namedjdbcTemplate.query(sql,paramMap, new BeanPropertyRowMapper(Mail.class));
		/*HashMap map=new HashMap();
		Object m= map.get(listMail.get(0));
		System.out.println(m);
		*/
		Map<String,Mail> m= new HashMap<>();
		for(Mail itr:listMail){
			String key=itr.geteId();
			m.put(key, itr);
		}
		return m;
}
	}
