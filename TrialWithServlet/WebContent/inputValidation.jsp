<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<s:form action="RegisterAction">
<s:textfield name="Id" label="Login Id" ></s:textfield>
<s:textfield name="password" label="Password" ></s:textfield>
<s:submit value="Register"></s:submit>
</s:form>
</body>
</html>