<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>
<h1>Cookies</h1>
<p>Here's a table with all of the cookies that this browser is sending to the current server.</p>

<table>
    <tr>
        <th>Name</th>
        <th>Value</th>
    </tr>
    <c:forEach var="c" items="${cookie}">
        <tr>
            <td><c:out value="${c.value.name}"/></td>
            <td><c:out value="${c.value.value}"/></td>
        </tr>
    </c:forEach>
</table>

<div class="nav-links">
    <a href="download?action=viewAlbums">View list of albums</a>
    <a href="download?action=deleteCookies">Delete all persistent cookies</a>
    <a href="index.html">Return to Home</a>
</div>
</body>
</html>