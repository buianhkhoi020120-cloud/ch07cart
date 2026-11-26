<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>
<h1>Download page</h1>
<p>Thanks for registering, ${user.firstName}.</p>
<p>Product code: ${productCode}</p>
<p>Your download would start here.</p>
<div class="nav-links">
    <a href="download?action=viewAlbums">Return to the list of albums</a>
    <a href="index.html">Return to Home</a>
</div>
</body>
</html>