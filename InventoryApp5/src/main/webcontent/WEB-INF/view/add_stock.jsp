<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import="com.dana.util.InventoryStockNames" %>

<html>
<head>
    <title>Add Items</title>
</head>
<body>
<div>
<form:form method="POST">
    <table>
        <tr>
            <td><label>ID</label></td>
            <td>
                <modelAttribute>${InventoryStockNames.STOCK_ITEM}</modelAttribute>
                <form:input path="id" disabled="true" />
            </td>
        </tr>

        <tr>
            <td><label>Name</label></td>
            <td><form:input path="stock_name"/></td>
        </tr>

        <tr>
            <td><label>Type</label></td>
            <td><form:input path="type"/></td>
        </tr>

        <tr>
            <td><label>Quantity</label></td>
            <td><form:textarea path="quantity"/></td>
        </tr>

        <tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>

</form:form>
</div>
</body>
</html>