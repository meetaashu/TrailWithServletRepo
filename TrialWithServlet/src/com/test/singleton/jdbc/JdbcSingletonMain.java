package com.test.singleton.jdbc;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import Domain_Package.Mail;

public class JdbcSingletonMain {

	public static void main(String[] args) {
/*		// TODO Auto-generated method stub
JdbcSingleton jdbc=JdbcSingleton.getInstance();
jdbc.getConnection();*/
		
		
		
		SpringJdbcSingleton jdbc=SpringJdbcSingleton.getInstance();
		Map<String,Mail> m=jdbc.loadCache();
		Set<String> s=m.keySet();
		Iterator<String> itr= s.iterator();
		while(itr.hasNext()){
			String key=(String) itr.next();
			Mail value=(Mail) m.get(key);
			System.out.println("Key is:"+key+"Value is:"+value);
			System.out.println(value.geteId()+" "+value.geteDate()+" "+value.getSubject()+" "+value.getEmailText());
		}
	}

}
