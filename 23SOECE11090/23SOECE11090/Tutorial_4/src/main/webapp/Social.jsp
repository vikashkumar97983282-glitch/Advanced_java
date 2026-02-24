<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Social Media Dashboard</title>

<style>
body{
	font-family:Arial;
	background:#f2f2f2;
}
.box{
	width:600px;
	margin:auto;
	background:#fff;
	padding:20px;
	border-radius:10px;
}
textarea{
	width:100%;
	height:80px;
	padding:8px;
}
button{
	padding:8px 15px;
	background:#007bff;
	color:white;
	border:none;
	border-radius:5px;
	cursor:pointer;
}
.post{
	background:#eee;
	padding:10px;
	margin-top:10px;
	border-radius:6px;
}
</style>

</head>

<body>

<div class="box">
	<h2>Social Media Dashboard</h2>

	<!-- CREATE POST -->
	<form action="SocialServlet" method="post">
		<input type="hidden" name="action" value="create">
		<textarea name="content" placeholder="What's on your mind?" required></textarea><br><br>
		<button type="submit">Post</button>
	</form>

	<hr>
	<h3>Posts</h3>

	<!-- READ POSTS -->
	${posts}

</div>

</body>
</html>
