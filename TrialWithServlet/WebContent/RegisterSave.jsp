<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Save Page</title>
</head>
<body>
<%
//String uid=request.getParameter("uid");
String pass= request.getParameter("pass");
String cPass= request.getParameter("cPass");
String uName=request.getParameter("uName");
String gen=request.getParameter("gen");

Connection cn;
PreparedStatement pstm;
Class.forName("com.mysql.jdbc.Driver");
cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/emailDb", "root","root");
pstm=cn.prepareStatement("Insert into users (UserPassword, UserName, Gender) values (?,?,?)");
pstm.setString(1, pass);
pstm.setString(2,uName);
pstm.setString(3,gen);
int rowsaffected=pstm.executeUpdate();
if(rowsaffected>0){
out.println("Congratulations!!!You successfully registered");
response.sendRedirect("emailLogin.jsp");
}else{
	out.println("Please register again");
}

%>
</body>
</html>