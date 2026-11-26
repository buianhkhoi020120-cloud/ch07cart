<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>
<h1>Download registration</h1>
<p>To register for our downloads, enter your name and email address below. Then, click on the Submit button.</p>

<form action="download" method="post">
    <input type="hidden" name="action" value="registerUser">

    <label>Email:</label>
    <input type="email" name="email" value="${user.email}" required><br><br>

    <label>First Name:</label>
    <input type="text" name="firstName" value="${user.firstName}" required><br><br>

    <label>Last Name:</label>
    <input type="text" name="lastName" value="${user.lastName}" required><br><br>

    <input type="submit" value="Register">
</form>
</body>
</html>