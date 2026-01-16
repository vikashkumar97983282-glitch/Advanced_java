<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head >
<link rel="stylesheet" href="login.css">

<body>
<div class="login-box">
    <h2>Login</h2>

    <form action="LoginCookie" method="post">
        <label>username</label>
        <input type="text" name="uname" required>
        <br />

        <label>Password</label>
        <input type="password" name="pwd" required>
        <br />

        <input type="submit" value="Login">
    </form>
</div>
</body>
</html>