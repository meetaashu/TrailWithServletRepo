package com.test.debuggingpackage;

public class ClassC {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	 
	public boolean equals(Object obj1){
		boolean result=false;
		ClassC c1=(ClassC) obj1;
		
		if(this.getName().equals(c1.getName())){
			
			return true;
		}
		return result;
	}
	

}
