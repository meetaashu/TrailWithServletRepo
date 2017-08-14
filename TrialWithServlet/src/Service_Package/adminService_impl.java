package Service_Package;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;

import com.test.debuggingpackage.MainDebuggerTest1;

import DAO_package.adminDAO;
import Domain_Package.Admin;

public class adminService_impl implements admin_service{
	static Logger log = Logger.getLogger(MainDebuggerTest1.class.getName());
	private adminDAO dao;
public adminDAO getDao() {
		return dao;
	}
	public void setDao(adminDAO dao) {
		System.out.println("inside setter of setDao");
		log.info("insider setter of set dao logger");
		this.dao = dao;
	}
	
	public adminService_impl(){
		System.out.println("service impl");
	}
@Override
public void populate_admin(Admin a) {
	String msg=dao.populate_admin(a);
if(msg!=null && msg.equalsIgnoreCase("success")){
	System.out.println("Congrats!!!you are added");
}	
else{
	System.out.println("Sorry!!try later");
}
}
public void getPhoneNoByName(String name){
	String msg=dao.getPhoneNoByName(name);
	if(msg!=null){
		System.out.println("Phone No is: "+msg);
	}else{
		System.out.println("No phone no found");
	}
}

public void getPhoneNoByNameInAdmin(String name){
	Admin a=dao.getPhoneNoByNameInAdmin(name);
	
	
		System.out.println("Admin details are: name:"+a.getaName()+"phone no: "+a.getaPhNo());
	
}
}
