package com.test.singleton.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcSingleton {

	private static JdbcSingleton jdbc;
	private JdbcSingleton(){}
	
	public static JdbcSingleton getInstance(){
		
		if(jdbc==null){
			jdbc= new JdbcSingleton();
		}
		return jdbc;
	}
	
	public void getConnection(){
		
		Connection cn;
		PreparedStatement pstm;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/emaildb","root","root");
			pstm=cn.prepareStatement("Select * from emails");
			ResultSet rs=pstm.executeQuery();
			if(rs!= null){
			System.out.println("<table>");
			System.out.println("<tr><th>EmailNo</th><th>Email date</th><th>FromUser Id</th><th>To User Id</th><th>Mail Subject</th><th>Email Text</th></tr>");
			
			while(rs.next()){
				System.out.println("<tr>");
				System.out.println("<td>"+rs.getInt(1)+"</td>");
				System.out.println("<td>"+rs.getDate(2)+"</td>");
				System.out.println("<td>"+rs.getString(3)+"</td>");
				System.out.println("<td>"+rs.getString(4)+"</td>");
				System.out.println("<td>"+rs.getString(5)+"</td>");
				System.out.println("<td>"+rs.getString(6)+"</td>");
				System.out.println("</tr>");
			}
			
			System.out.println("</table>");
			}
		}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
