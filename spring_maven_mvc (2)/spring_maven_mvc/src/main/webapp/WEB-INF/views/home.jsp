<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="jakarta.tags.core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Management</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>

<body class="bg-gradient-to-br from-blue-500 via-cyan-500 to-teal-500 min-h-screen flex items-center justify-center p-6">

    <!-- Glass Card -->
    <div class="backdrop-blur-lg bg-white/20 shadow-2xl rounded-3xl p-8 w-full max-w-5xl border border-white/30">

        <!-- Title -->
        <h2 class="text-4xl font-bold text-center text-white mb-8 tracking-wide">
            User Management System
        </h2>

        <!-- Add User Form -->
        <div class="bg-white rounded-2xl p-6 shadow-lg mb-10">
            <h3 class="text-2xl font-semibold text-gray-700 mb-4">Add User</h3>

            <form action="save" method="post" class="grid grid-cols-1 md:grid-cols-3 gap-4">

                <input type="text" name="name" placeholder="Enter Name"
                    class="border border-gray-300 p-3 rounded-xl focus:ring-2 focus:ring-cyan-400 outline-none">

                <input type="text" name="email" placeholder="Enter Email"
                    class="border border-gray-300 p-3 rounded-xl focus:ring-2 focus:ring-cyan-400 outline-none">

                <button type="submit"
                    class="bg-gradient-to-r from-cyan-500 to-blue-600 text-white font-semibold rounded-xl hover:scale-105 transform transition duration-300">
                    Save User
                </button>

            </form>
        </div>

        <!-- User Table -->
        <div class="bg-white rounded-2xl shadow-lg overflow-hidden">
            <h3 class="text-2xl font-semibold text-gray-700 p-6 border-b">
                User List
            </h3>

            <div class="overflow-x-auto">
                <table class="w-full">

                    <thead>
                        <tr class="bg-gradient-to-r from-blue-600 to-cyan-600 text-white">
                            <th class="p-4 text-center">ID</th>
                            <th class="p-4 text-left">Name</th>
                            <th class="p-4 text-left">Email</th>
                            <th class="p-4 text-center">Action</th>
                        </tr>
                    </thead>

                    <tbody class="bg-gray-50">

                        <c:forEach var="u" items="${list}">
                            <tr class="border-b hover:bg-cyan-100 transition duration-200">

                                <td class="p-4 text-center font-bold text-blue-600">
                                    ${u.id}
                                </td>

                                <td class="p-4 font-medium">
                                    ${u.name}
                                </td>

                                <td class="p-4 text-gray-600">
                                    ${u.email}
                                </td>

                                <td class="p-4 text-center space-x-3">

                                    <a href="edit/${u.id}"
                                       class="bg-green-500 text-white px-4 py-2 rounded-lg hover:bg-green-600 transition duration-300">
                                        Edit
                                    </a>

                                    <a href="delete/${u.id}"
                                       onclick="return confirm('Are you sure you want to delete?')"
                                       class="bg-red-500 text-white px-4 py-2 rounded-lg hover:bg-red-600 transition duration-300">
                                        Delete
                                    </a>

                                </td>

                            </tr>
                        </c:forEach>

                    </tbody>

                </table>
            </div>
        </div>

    </div>

</body>
</html>