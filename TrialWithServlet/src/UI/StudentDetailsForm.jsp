<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body><center>
<form action="studentServlet.java" method="get">
<h2>
Student Admission Form
</h2>
<table>
<tr><td>Name:</td><td><input type="text" id="name"/></td></tr>
<tr><td>Roll No:</td><td><input type="text" id="rollNo"/></td></tr>
<tr><td>Standard:</td><td><input type="text" id="std"/></td></tr>
<tr><td>Phone No:</td><td><input type="text" id="phNo"/></td></tr>
<tr><td>City:</td><td><input type="text" id="city"/></td></tr>
<tr><td colspan="2"><input type="Submit" value="Submit" id="submit"/></td></tr>
</table>
</form>
</center>

</body>
</html>