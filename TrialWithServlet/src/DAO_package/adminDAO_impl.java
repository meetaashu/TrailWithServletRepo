package DAO_package;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import Domain_Package.Admin;

public class adminDAO_impl implements adminDAO{
	private int a;

private NamedParameterJdbcTemplate namedJdbcTemplate;
	public NamedParameterJdbcTemplate getNamedJdbcTemplate() {
	return namedJdbcTemplate;
}

public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
	this.namedJdbcTemplate = namedJdbcTemplate;
}

	JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public adminDAO_impl(int a){
		this.a=a;
		System.out.println("test222");
	}
	
public String populate_admin(Admin a){
	String result= null;
	Connection cn;
	PreparedStatement pstm;
	try{
	String sql="Insert into admin (name, phoneNo) values (?,?)";
	/*Class.forName("com.mysql.jdbc.Driver");
	
	
	cn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/TrialwithServlet","root", "root");
	String sql="Insert into admin (name, phoneNo) values (?,?)";
	pstm=cn.prepareStatement(sql);
	pstm.setString(1, a.getaName());
	pstm.setString(2, a.getaPhNo());
	int rowsAffected= pstm.executeUpdate();*/
	Object[] objArray = new Object[2];
	objArray[0] = a.getaName();
	objArray[1]=a.getaPhNo();
	int rowsAffected=jdbcTemplate.update(sql,objArray);
	if(rowsAffected>0){
		result="Success";
	}
	else{
		result="Failure";
	}
	}catch(Exception e){
		e.getMessage();
	}
	return result;
}

//create this method in service and use it from UI or a main class method
public String getPhoneNoByName(String name){
	String phone;
	String sql="select phoneNo from admin where name= ?";
	List list =jdbcTemplate.queryForList(sql, String.class,new Object[]{name});
	
	//if for given name there are more than one record then above list will have those many phone numbers.
	//assuming for given name only one record exist so list will only have 1 result.
	return ((String) (list.get(0)));
}

//create this method in service and use it from UI or a main class method
public Admin getPhoneNoByNameInAdmin(String name){
	String phone;
	//to convert result into specific class in select query name of selected column should be same as 
	//property defined in class
	//in which you want to convert the results.
	String sql="select name as aName, phoneNo as aPhNo from admin where name= :empName";
	Map<String,String> paramMap= new HashMap<String,String>();
	paramMap.put("empName",name);
	//last argument in below method is used to tell spring that result need to be converted into this domain object.
	List<Admin> admin =namedJdbcTemplate.query(sql, paramMap,new BeanPropertyRowMapper(Admin.class));
	
	//if for given name there are more than one record then above list will have those many phone numbers.
	//assuming for given name only one record exist so list will only have 1 result.
	return admin.get(0);
}

}
