package Domain_Package;

import com.opensymphony.xwork2.ActionSupport;

public class Register extends ActionSupport{
String username, password, email;

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String execute(){
	return "success";
}

public void validate(){
	if(username==null||username.trim().equals("")){
		addFieldError(username, "username is required");
	}
}
}
