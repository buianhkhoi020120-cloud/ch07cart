<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>
<h1>List of albums</h1>
<p>
    <a href="download?action=checkUser&amp;productCode=8601">
        86 (the band) - True Life Songs and Pictures
    </a><br><br>
    <a href="download?action=checkUser&amp;productCode=pf01">
        Paddlefoot - The First CD
    </a><br><br>
    <a href="download?action=checkUser&amp;productCode=pf02">
        Paddlefoot - The Second CD
    </a><br><br>
    <a href="download?action=checkUser&amp;productCode=jr01">
        Joe Rut - Genuine Wood Grained Finish
    </a>
</p>

<div class="nav-links">
    <a href="download?action=viewCookies">View all cookies</a>
    <a href="download?action=deleteCookies">Delete all persistent cookies</a>
    <a href="index.html">Return to Home</a>
</div>
</body>
</html>