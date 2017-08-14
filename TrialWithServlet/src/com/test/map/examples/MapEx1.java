package com.test.map.examples;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import Domain_Package.Admin;

public class MapEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Admin a1= new Admin();
		Admin a2= new Admin();
		a1.setaId(1);
		a1.setaName("a1");
		a1.setaPhNo("123");
		a2.setaId(2);
		a2.setaName("a2");
		a2.setaPhNo("456");
HashMap<String, Object> map=new HashMap<String, Object>();
map.put("1", a1);
map.put("2", a2);
Set<String> s=map.keySet();
Iterator<String> itr=s.iterator();
while(itr.hasNext()){
	Admin obj= (Admin) map.get(itr.next());
	System.out.println(obj.getaId()+" "+obj.getaName()+" "+obj.getaPhNo());
}


	}

}
