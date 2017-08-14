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
<title>Inbox Page</title>
</head>
<body>
<%
Cookie ck[]=request.getCookies();
int id=Integer.parseInt(ck[0].getValue());
Connection cn;
PreparedStatement pstm;
Class.forName("com.mysql.jdbc.Driver");
cn=DriverManager.getConnection("jdbc:mysql://localhost:3306/emailDb","root", "root");
pstm=cn.prepareStatement("Select EmailNo,EmailDate, FromUserId, MailSubject from emails where ToUserId=?" );
pstm.setInt(1, id);
ResultSet rs=pstm.executeQuery();
if(rs != null){
	out.println("<table>");
	out.println("<tr><th>Email Date</th><th>From User Id</th><th>Subject</th></tr>");
while(rs.next()){
	out.println("<tr>");
	int no=rs.getInt(1);
	out.println("<td>"+rs.getString(2)+"</td>");
	out.println("<td>"+rs.getString(3)+"</td>");
	out.println("<td><a href=InboxMsg.jsp?eNo="+ no+">"+rs.getString(4)+"</a></td>");
	//out.println("<iframe name="work" style="width=40% ; height=500px"></iframe>);
	out.println("</tr>");
}
out.println("</table>");
}rs.close();
%>
</body>
</html>