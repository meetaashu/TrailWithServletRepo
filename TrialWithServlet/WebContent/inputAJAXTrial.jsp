<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Input number page</title>
<script>
function sendInfo(){
	alert("Entered func");
	number=document.getElementById("no").value;
	alert("No:"+number);
	
	if(window.XMLHttpRequest){
		alert('XMLHttpRequest');
		x= new XMLHttpRequest();	
	}
	else if(window.ActiveXObject){
		x=new ActiveXObject("Microsoft.XMLHTTP");
	}
	try{
		alert("inside try");
	x.open("GET", "check.jsp?number="+number, true);
		x.onreadystatechange=function (){
			alert("ready state");
			ans1=x.responseText();
			alert(ans1);
			document.getElementById("ans").innerHTML=ans1;
		}
alert ("about to open get connection");
	x.send();
	}
catch(e){
	alert("Unable to connect to server");
}
}
	

/*
function sendInfo(){
	alert("entered func");
	number= document.getElementById("no").value;
	alert("no: "+ number);
	x= new XMLHttpRequest();
	alert("created x");
	x.open("GET", "check.jsp?number="+number, true);
	alert("about to enter function");
	x.onreadystatechange= getInfo;
	
	x.send();
	alert("entering function");
	function getInfo(){
		alert("Entered function");
		alert("ready state");
		ans= x.responseText;
		alert("ans");
		document.getElementById("ans").innerHTML=ans;
	}
}
*/
</script>
</head>
<body>
<form method="get">
Input number:<input type="text" name="no" id="no"/>
<br>
<input type="button" value="Print table" onclick="sendInfo()"/>
<br>
<p id="ans"></p>
</form>

</body>
</html>