<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MTA DevOps WebApp</title>
</head>
<body>
    <h1>Welcome to MTA DevOps Web Application Final version</h1>
    
    <!-- Text Input -->
    <form action="submit.jsp" method="post">
        <label for="username">Enter your name:</label><br>
        <input type="text" id="username" name="username" required>
        <br><br>
        
        <!-- Submit Button -->
        <input type="submit" value="Submit">
    </form>

    <br>

    <!-- Clickable Link -->
    <a href="https://www.mta.ac.il" target="_blank">Visit MTA Official Website</a>

    <hr>
    <p>This simple web app is part of the CI/CD project for the DevOps course (MTA 2025).</p>
</body>
</html>
