<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student registration</title>
</head>
<body>
<s:form action="Registration">
<s:textfield name="name" label="Student Name:"></s:textfield>
<s:textfield name="pass1" label="Student Password:"></s:textfield>
<s:textfield name="email" label="Email:"></s:textfield>
<s:select name="gender" label="Gender:" list="{'Male', 'female'}"></s:select>
<s:select name="country" label="Country:" list="{'India', 'Other'}"></s:select>
<s:submit value="Register"></s:submit>
</s:form>
</body>
</html>