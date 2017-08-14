package Service_Package;

import DAO_package.StudentDAO;
import DAO_package.StudentDao_impl;
import Domain_Package.Student;

public class StudentService_impl implements Student_Service{
	private StudentDAO dao;
	
public StudentDAO getDao() {
		return dao;
	}

	public void setDao(StudentDAO dao) {
		System.out.println("inside setter of dao");
		this.dao = dao;
	}

	/*public StudentService_impl(){
		System.out.println("iside cons of service impl");
	}*/
public String student_admission(Student s){
	String result =null;
	
	String msg=dao.student_admission(s);
	if (msg.equalsIgnoreCase("Success")){
		result="Congratulations!! your child is successfully registered."; 

	}else
		result="Oops!! some error whileregistering...";

return result;
}
}
