<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Compose Mail</title>
</head>
<center>
<body>
<form method="get" action="ComposeSaveServlet">
<table >
<tr><td>To User Id</td><td><input type="text" name="uId" id="uId"></td></tr>
<tr><td>Subject</td><td><input type="text" name="sub" id="sub"></td></tr>
<tr><td>Message</td><td><textarea rows=10 cols=30 name="msg" id="msg"></textarea></td></tr>
<tr><td colspan="2"><input type="submit" value="Send"></td></tr>
</table>
</form>
</body>
</center>
</html>