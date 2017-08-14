<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Deposits page</title>
</head>
<body>
<%
int acNo=Integer.parseInt(request.getParameter("acNo"));
try {
	Connection cn;
	PreparedStatement pstm;
	
	Class.forName("com.mysql.jdbc.Driver");
	cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/accountDb","root","root");
	pstm=cn.prepareStatement("Select * from Account where AccountNo=?");
	pstm.setInt(1, acNo);
	ResultSet rs=pstm.executeQuery();
	System.out.println("<table>");
	System.out.println("<tr><th>Account No</th><th>Account Name</th><th>Birth Date</th><th>City</th><th>Phone No</th><th>Balance</th></tr>");
	//System.out.println("<tr><th>Voucher No</th><th>Voucher Date</th><th>Account No</th><th>Balance</th></tr>");
	while(rs.next()){
		System.out.println("<tr>");
		System.out.println("<td>"+rs.getInt(1)+"</td>");
		System.out.println("<td>"+rs.getString(2)+"</td>");
		System.out.println("<td>"+rs.getDate(3)+"</td>");
		System.out.println("<td>"+rs.getString(4)+"</td>");
		System.out.println("<td>"+rs.getString(5)+"</td>");
		System.out.println("<td>"+rs.getString(6)+"</td>");
		System.out.println("</tr>");
	}
	System.out.println("</table>");
	rs.close();
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


%>
</body>
</html>