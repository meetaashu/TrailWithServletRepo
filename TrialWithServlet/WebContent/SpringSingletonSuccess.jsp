<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/struts-tags" prefix="s" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Singleton success</title>
</head>
<body>
get the fetched result:
<s:iterator value="m">
<tr><td>
<s:property value="key"/></td><td>
<s:property value="value"/></td></tr>
<!-- 
<s:property value="eId"/><br/>
<s:property value="eDate"/><br/>
<s:property value="fromUserId"/><br/>
<s:property value="toUserId"/><br/>
<s:property value="subject"/><br/>
<s:property value="emailText"/><br/> 
 -->

</s:iterator>

</body>
</html>