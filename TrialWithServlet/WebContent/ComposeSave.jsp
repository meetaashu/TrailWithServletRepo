<%@page import="java.util.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Compose Page</title>
</head>
<body>
<%
String ToUserId=request.getParameter("uId");
String sub= request.getParameter("sub");
String msg=request.getParameter("msg");
Cookie ck[]=request.getCookies();
String toUId=ck[0].getValue();

Connection cn;
PreparedStatement pstm;
Date dt= new Date();
int y, m,d;
y=dt.getYear()+1900;
m=dt.getMonth()+1;
d=dt.getDate();
String eDate= y+"-"+m+"-"+d;
Class.forName("com.mysql.jdbc.Driver");
cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/emailDb", "root", "root");
pstm=cn.prepareStatement("Insert into emails (Emaildate, FromUserId, ToUserId, MailSubject, EmailText) values (?,?,?,?,?)");
pstm.setString(1,eDate);
pstm.setString(2, toUId);
pstm.setString(3, ToUserId);
pstm.setString(4, sub);
pstm.setString(5, msg);
int rowsaffected=pstm.executeUpdate();
if(rowsaffected>0){
out.println("Record successfully saved");
}else
	out.println("an error occured while saving the record");
%>
</body>
</html>