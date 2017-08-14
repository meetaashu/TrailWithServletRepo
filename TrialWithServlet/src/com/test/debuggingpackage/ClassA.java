package com.test.debuggingpackage;

import java.io.File;
import java.io.FileNotFoundException;

public class ClassA {
	private static int b;
	private static int c;
	public void test1() throws ArrayIndexOutOfBoundsException, FileNotFoundException, Exception{
		test2();
	}
	
	public void test2() throws Exception,FileNotFoundException{
		
		try{
		File f = new File("");
		b=7;
		}catch(Exception e){
			throw new Exception("thowing it back");
		}
	}
	
	public static void test3() throws InvalidBusinessRuleException{
		c=8;//non-static variables cannot be called inside static method...either make the variable static or make method non static
	if(c<10){
		throw new InvalidBusinessRuleException("Invalid value");
	}
	}

}
