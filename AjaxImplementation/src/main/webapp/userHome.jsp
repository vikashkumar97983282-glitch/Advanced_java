<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome page</title>
</head>
<body>

<h4>welcome user</h4>
<p>welcome,${sessionScope.user}</p>
<a href="LogoutServlet">logout</a>
</body>
</html>