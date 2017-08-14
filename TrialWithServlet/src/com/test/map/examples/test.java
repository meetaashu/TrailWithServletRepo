package com.test.map.examples;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class test {

	public static void main(String[] args) throws java.lang.Exception{
		// TODO Auto-generated method stub

		// This is java
		System.out.println("Please enter number of times it should be printed");
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String input = br.readLine();
	    System.out.println("Please enter any no:"+input);
		  
		    int no=Integer.parseInt(input);
		for(int i=0;i<no;i++){
		  System.out.println("Hello");
		}    
		  
	}	
	}


