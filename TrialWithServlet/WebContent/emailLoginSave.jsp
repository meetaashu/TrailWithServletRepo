<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Save</title>
</head>
<body>
<%
String uid=request.getParameter("uId");
String pass= request.getParameter("pass");
Connection cn;
PreparedStatement pstm;
Class.forName("com.mysql.jdbc.Driver");
cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/emailDb","root","root");
pstm=cn.prepareStatement("Select * from users where userId =?");
pstm.setString(1, uid);
ResultSet rs= pstm.executeQuery();
Cookie ck= new Cookie("UserId", uid);


if(rs.next()){
	response.addCookie(ck);
	response.sendRedirect("EmailHome.html");
	
}
else
	out.println("Not valid user id or password");
%>

</body>
</html>