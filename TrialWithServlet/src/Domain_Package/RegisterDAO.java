package Domain_Package;
import java.sql.*;
public class RegisterDAO {

	public static int Save(Registration r){
		int i=0;
		try{
			Connection cn;
			PreparedStatement pstm;
			Class.forName("com.mysql.jdbc.Driver");
			cn= DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/strutsTrial","root", "root");
			pstm= cn.prepareStatement("Insert into StrutsUser values(?,?,?,?,?)");
		    pstm.setString(1, r.getName());
		    pstm.setString(2, r.getPass1());
		    pstm.setString(3, r.getEmail());
		    pstm.setString(4, r.getGender());
		    pstm.setString(5, r.getCountry());
		    i= pstm.executeUpdate();
		    
		}
		catch(Exception e){
		System.out.println(e);	
		}
		return i;
	}
}
