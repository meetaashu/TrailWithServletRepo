<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Page</title>
<script type="text/javascript">
function checkPass(){
	pass=document.getElementById("pass").value;
	cPass=document.getElementById("cPass").value;
	if(pass==cPass){
		document.getElementById("ans").innerHTML="";
	}else
		document.getElementById("ans").innerHTML="Password and Check Password does not match";
}
</script>
</head>
<body>
<form action="RegisterSave.jsp">
<table>

<tr><td>Password</td><td><input type="text" name="pass" id="pass"></td></tr>
<tr><td>Confirm Password</td><td><input type="text" name="cPass" id="cPass" onmouseout="checkPass()">
<p id="ans"></p></td></tr>
<tr><td>User Name</td><td><input type="text" name="uName"></td></tr>
<tr><td>Gender</td><td><select name="gen"><option>Male</option><option>Female</option></select></td></tr>
<tr><td colspan="2"><input type="Submit" value="Submit"></td></tr>
</table>
</form>
</body>
</html>