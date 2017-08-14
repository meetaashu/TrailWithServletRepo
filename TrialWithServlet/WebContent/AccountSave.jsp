<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Account java file</title>
</head>
<body>
<%
int acNo= Integer.parseInt(request.getParameter("acNo"));
String acName= request.getParameter("acName");
String bDate=request.getParameter("bDate");
String city=request.getParameter("city");
String phNo=request.getParameter("phNo");
String bal=request.getParameter("bal");

Connection cn;
PreparedStatement pstm;
try{
Class.forName("com.mysql.jdbc.Driver");
cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/accountDb","root","root");
pstm=cn.prepareStatement("Insert into Account values (?,?,?,?,?,?)");
pstm.setInt(1, acNo);
pstm.setString(2, acName);
pstm.setString(3, bDate);
pstm.setString(4, city);
pstm.setString(5, phNo);
pstm.setString(6, bal);
pstm.executeUpdate();
System.out.println("Values added successfully");
}catch(Exception e)
{
	e.printStackTrace();
}

%>
</body>
</html>