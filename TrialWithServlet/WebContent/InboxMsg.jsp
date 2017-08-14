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
<title>Inbox message Page</title>
</head>
<body>
<%
//Cookie ck[]=request.getCookies();
//int id=Integer.parseInt(ck[1].getValue());
int eNo=Integer.parseInt(request.getParameter("eNo"));
//out.print(eNo);
Connection cn;
PreparedStatement pstm;
Class.forName("com.mysql.jdbc.Driver");
cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/emailDb","root", "root");
pstm=cn.prepareStatement("Select EmailText from emails where EmailNo=?" );
pstm.setInt(1, eNo);
ResultSet rs=pstm.executeQuery();
while(rs.next()){
	out.println(rs.getString(1));
}
rs.close();
 %>
</body>
</html>