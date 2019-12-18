<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.dana.util.Mappings" %>

<html>

<head>
    <title>View Stock Items</title>
</head>

<body>
    <div>

        <table>
            <tr>
                <td><label>ID</label></td>
                <td>
                    <c:out value="${stock.stockId}"/>
                </td>
            </tr>

            <tr>
                <td><label>Name</label></td>
                <td>
                    <c:out value="${stock.stockName}"/>
                </td>
            </tr>

            <tr>
                <td><label>Type</label></td>
                <td>
                    <c:out value="${stock.type}"/>
                </td>
            </tr>

            <tr>
                <td><label>Quantity</label></td>
                <td>
                    <c:out value="${stock.quantity}"/>
                </td>
            </tr>

        </table>

        <c:url var="tableUrl" value="${Mappings.STOCK_ITEMS}"/>
        <a href="${tableUrl}">Show Table</a>

    </div>

</body>

</html>