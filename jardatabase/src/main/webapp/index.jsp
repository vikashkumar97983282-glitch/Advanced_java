<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<div>
		<form action="insert" method="get">
			<label>Enter your name:</label>
			<input type="text" placeholder="your name" name="ename">
			<br><br>
			<label>mobile no:</label>
			<input type="text" placeholder="mob no." name="mobile">
			<br><br>
			<button type="submit">Submit</button>
			<button type="submit" name="show user">
				<a href="select">show user</a>
			</button>
		</form>
	</div>

</body>
</html>