package DAO_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import Domain_Package.Student;


public class StudentDao_impl implements StudentDAO {
	
	public String student_admission(Student s){
		
		String result=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
		Connection cn;
		PreparedStatement pstm;
		cn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/TrialWithServlet", "root", "root");
		pstm=cn.prepareStatement("Insert into Student (SName, Class, PhNo, City) values (?,?,?,?)");
		pstm.setString(1, s.getName());
		//pstm.setInt(2, s.getRollNo());
		pstm.setInt(2, s.getStandard());
		pstm.setString(3, s.getPhNo());
		pstm.setString(4, s.getCity());
		int rows_affected=pstm.executeUpdate();
		if(rows_affected>0){
			result="Success";
		}else
			result="Failure";
		}catch(Exception e){
			e.getMessage();
		}
		return result;
	}
}
