<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload & Download</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background: linear-gradient(#22C1C3);
        height: 100vh;
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .container {
        background: #fff;
        padding: 30px;
        width: 400px;
        border-radius: 12px;
        box-shadow: 0 10px 25px rgba(0,0,0,0.2);
        text-align: center;
    }

    h2 {
        margin-bottom: 20px;
        color: #333;
    }

    label {
        font-weight: bold;
        display: block;
        margin-bottom: 10px;
    }

    input[type="file"] {
        width: 100%;
        padding: 8px;
        margin-bottom: 20px;
    }

    input[type="submit"] {
        background: #4CAF50;
        color: white;
        border: none;
        padding: 10px 20px;
        font-size: 16px;
        border-radius: 6px;
        cursor: pointer;
        width: 100%;
    }

    input[type="submit"]:hover {
        background: #45a049;
    }

    a {
        display: inline-block;
        margin-top: 20px;
        text-decoration: none;
        color: white;
        background: #2196F3;
        padding: 10px 20px;
        border-radius: 6px;
        font-weight: bold;
    }

    a:hover {
        background: #1976D2;
    }
</style>

</head>
<body>

<div class="container">
    <h2>Upload File</h2>

    <form action="Upload" method="post" enctype="multipart/form-data">
        <label>Select File</label>
        <input type="file" name="file" required>
        <input type="submit" value="Upload">
    </form>

    <h2>Download File</h2>
    <a href="Download">View Download Files</a>
</div>

</body>
</html>
