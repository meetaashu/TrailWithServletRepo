package springTrialPackage;

public class Student {
String name;
Address address;

public Student(){
	System.out.println("default constructor");
}

public Student(String name, Address address){
	super();
	this.name=name;
	this.address=address;
}

public Address getAddress() {
	return address;
}

public void setAddress(Address address) {
	this.address = address;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public void displayInfo(){
	
	String str=address.print();
	System.out.println("Hello "+ name+" belonging to address:"+ str);
}
}
