package Domain_Package;

import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport{

	public String Id, password;

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		this.Id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public void validate(){
		if(Id == null){
			addFieldError("Id", "Login id can not be blank!!");
		}
		
		if(password.length()<6){
			addFieldError("password", "Password legth should be atleast 6!!");
		}
		
	}
	
	public String execute(){
		return "Success";
	}
}
