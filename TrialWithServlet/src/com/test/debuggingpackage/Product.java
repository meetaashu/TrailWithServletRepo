package com.test.debuggingpackage;

import java.util.List;

public class Product {
	
	private static Product product;
	private List<Product> productList;
	
	private Product(){
		
	}
	
	public static Product getInstance(){
		if(product==null){
			product=new Product();
			
		}
		return product;
	} 
	
	public List<Product> populateProductsFromDB(){
		//here call web service populate product of list inside productList
		
		return productList;
		
	}

}
