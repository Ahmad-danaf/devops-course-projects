<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String username = request.getParameter("username");
%>
<html>
<head>
    <title>Submission Received</title>
</head>
<body>
    <h2>Hello, <%= username %>! Thanks for submitting your name.</h2>
    <a href="index.jsp">Go Back</a>
</body>
</html>
