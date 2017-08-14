package Domain_Package;

public class Registration {
private String name;
private String pass1;
private String email;
private String gender;
private String country;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPass1() {
	return pass1;
}
public void setPass1(String password) {
	this.pass1 = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
public String getCountry() {
	return country;
}
public void setCountry(String country) {
	this.country = country;
}

public String execute(){
	int i= RegisterDAO.Save(this);
	if(i>0){
	return "success";
	}
	else 
		return "error";
} 
}
