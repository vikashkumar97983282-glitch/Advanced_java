<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="java.util.Date" %>

  <!-- JSP Scriptlet -->
  <%
      int a = 20;
  %>

  a = <%= a %> <br>

    <!-- JSP Declaration -->
    <%! 
        int square(int x) {
            return x * x;
        }
    %>

    Square of 4 = <%= square(4) %> <br>

    <!-- JSP Action -->
    <jsp:include page="html/welcome.html" />

    <!-- JSTL -->
    <c:set var="name" value="Admin" />
    Welcome ${name} <br>

    <!-- Date -->
    <%
        Date d = new Date();
        out.println(d);
    %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP Example</title>
</head>
<body>

<form action="index.jsp" method="get">
Enter email : <input type="email" name="email">
<button type="submit" value="submit" >submit</button>
</form>

</body>
</html>
