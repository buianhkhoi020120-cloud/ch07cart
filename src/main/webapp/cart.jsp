<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Murach's Java Servlets and JSP</title>
    <link rel="stylesheet" href="index.css">
</head>
<body>
<h1>Your cart</h1>
<table>
    <thead>
    <tr>
        <th>Quantity</th>
        <th>Description</th>
        <th>Price</th>
        <th>Amount</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="item" items="${cart.items}">
        <tr>
            <td>
                <form action="add-cart" method="post">
                    <input type="hidden" name="id" value="${item.product.code}">
                    <input type="text" name="quantity" value="${item.quantity}" size="2">
                    <button type="submit">Update</button>
                </form>
            </td>
            <td>${item.product.description}</td>
            <td class="right">${item.product.priceCurrencyFormat}</td>
            <td class="right">${item.totalCurrencyFormat}</td>
            <td>
                <form action="add-cart" method="post">
                    <input type="hidden" name="id" value="${item.product.code}">
                    <input type="hidden" name="quantity" value="0">
                    <button type="submit">Remove Item</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<p><b>To change the quantity</b>, enter the new quantity and click on the Update button.</p>

<form action="add-cart" method="post" style="margin-bottom: 0.5em;">
    <input type="hidden" name="action" value="shop">
    <button type="submit">Continue Shopping</button>
</form>

<form action="add-cart" method="post">
    <input type="hidden" name="action" value="checkout">
    <button type="submit">Checkout</button>
</form>
</body>
</html>