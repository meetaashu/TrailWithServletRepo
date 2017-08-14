<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Print table</title>

</head>
<body>
<%
int n=Integer.parseInt(request.getParameter("number"));

for(int i=1; i<=10;i++)
{
	int x=(i*n);
	out.println(x);
}


%>
</body>
</html>