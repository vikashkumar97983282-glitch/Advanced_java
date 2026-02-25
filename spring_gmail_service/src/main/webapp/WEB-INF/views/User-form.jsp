<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Email Service</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="min-h-screen bg-gradient-to-r from-indigo-500 via-purple-500 to-pink-500 flex items-center justify-center">

<div class="bg-white shadow-2xl rounded-2xl p-10 w-96">

    <h2 class="text-2xl font-bold text-center mb-6 text-gray-700">
        Send Email With File
    </h2>

    <form:form action="register" 
               method="post" 
               modelAttribute="user"
               enctype="multipart/form-data"
               class="space-y-4">

        <form:input path="name"
            placeholder="Enter name"
            cssClass="w-full px-4 py-2 border rounded-lg"/>

        <form:input path="email"
            type="email"
            placeholder="Enter email"
            cssClass="w-full px-4 py-2 border rounded-lg"/>

        <!-- File Upload -->
        <input type="file" 
               name="file"
               class="w-full border p-2 rounded-lg bg-gray-50"/>

        <input type="submit"
               value="Send Email"
               class="w-full bg-purple-600 text-white py-2 rounded-lg hover:bg-purple-700"/>

    </form:form>

</div>

</body>
</html>