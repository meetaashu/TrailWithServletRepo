package com.test.debuggingpackage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import Domain_Package.Admin;

//Resolve all error in this class and resolve all exceptions
//Some of them need to be solved by running in debug mode and putting breakpoint.
//Also create a custom exception Say InvalidBusinessRuleException and then use it in code
//see how to get lenght of an array and how to get lenght of arraylist and what is diff b/w those two

public class MainDebuggerTest1 {
	static Logger log = Logger.getLogger(MainDebuggerTest1.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 =new String("SAP Hybris");
		log.info("test logging info");
		
		String subString=s1.substring(5);
		System.out.println("lenght of substring is::"+subString.length());
		
		
		
		Admin a = new Admin();
		a.setaId(4);
		a.setaName("Jony");
		a.setaPhNo("23456");
		String ph=a.getaPhNo().trim();
		String name=a.getaName().trim();
		System.out.println("Ph: "+ph);
		System.out.println("NAme: "+name);
		
		ClassA classA = new ClassA();
		try {
			classA.test1();
		} catch (Exception e) {
			System.out.println("in classA test1");
			e.printStackTrace();
		}
		try {
			classA.test2();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("in classA test2");
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			classA.test3();
		} catch (InvalidBusinessRuleException e1) {
			System.out.println("Exception handled: "+e1); 
			//e1.printStackTrace();
		}
		
		Class3 class3 = new Class3(10);
		class3.test1();
		
		ClassB bObject =  new Class3(5);
		bObject.test2();
		bObject.test1();//create method test1()in ClassB or invoke it with Class3 reference variable only
		
		ClassC obj1 =new ClassC();
		obj1.setName("Jony");
		
		ClassC obj2 = new ClassC();
		obj2.setName("Jony");
		
		//what will be output of 
		System.out.println(obj1.equals(obj2) );
		//And how to change obove to ensure that if two objects are meaningfully equals , like in above case as both objects
		//have same name so that it returns true.
String sr1=new String("Aashu");
String sr2=new String("Aashu");
System.out.println(sr1.equals(sr2));
System.out.println("==result is:"+(sr1==sr2));
String sr3="Aashu";
String sr4="Aashu";
System.out.println(sr3.equals(sr4));
System.out.println("check.equals: "+(sr3==sr4));
try{
Object[] obj = new Object[5];
obj[1]="one";
obj[2]="one";
obj[3]="one";
obj[4]="one";
obj[0]="one";

for(int i=0 ;i<5;i++){
	log.info("i is::"+i);
	log.info("OBJ is::"+obj[i]);
	if(i==1){
		int z=6/i;
	}
}

File f = new File("/Users/jonysingla/documents/log2.out");
boolean result=f.canRead();
System.out.println("result is:"+result);
log.info("result is:"+result);
}catch(Exception e){
	log.error("exception occured",e);
	e.printStackTrace();
}

	ArrayList<String> al= new ArrayList<String>();
	al.add("A");
	al.add("B");
	System.out.println("Length of arraylist is:"+ al.size());
	int[] array=new int[2];
	array[0]= 1;
	array[1]=2;
	System.out.println("Length of array is: "+array.length);
	
	Product p = Product.getInstance();
	List<Product> prodList=p.populateProductsFromDB();
	}

}
