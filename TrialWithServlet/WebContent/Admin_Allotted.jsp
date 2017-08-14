<%@page import="Domain_Package.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Allotment to students</title>

</head>
<body>
<%Student s= new Student();

String name=request.getParameter("name")+"";

int standard=Integer.parseInt(request.getParameter("std"));
String phNo=request.getParameter("phNo");
String city=request.getParameter("city");

s.setName(name);

s.setStandard(standard);
s.setPhNo(phNo);
s.setCity(city);
 %>
<center>
<form action="studentServlet">
<h1>Admin Allotted</h1>
<table>
<tr><td>Admin Id:</td><td><select><option>1</option><option>2</option><option>3</option><option>4</option></select></td></tr>
<tr><td>Admin Name:</td><td><input type="text" name="aName" id="aName"/></td></tr>
<tr><td colspan="2"><input type="submit" value="Submit"/></td></tr>

</table>
</form>
</center>
</body>
</html>