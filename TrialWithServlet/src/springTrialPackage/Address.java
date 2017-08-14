package springTrialPackage;

public class Address {
String street, city;

public String getStreet() {
	return street;
}

public void setStreet(String street) {
	this.street = street;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}

public Address(String city, String street){
	super();
	
	this.city=city;
	this.street=street;
	
}

public String print(){
	return city+" "+street;
}
}
