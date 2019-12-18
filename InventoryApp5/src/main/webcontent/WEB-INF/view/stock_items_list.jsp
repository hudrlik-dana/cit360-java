<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.dana.util.Mappings" %>

<html>
<head>

    <title>Stock Inventory Items</title>
</head>

<body>

    <div>

        <c:url var="addUrl" value="${Mappings.ADD_STOCK_ITEM}"/>
        <a href="${addUrl}">New Stock Item</a>

        <table>

            <caption><h2>Inventory Items</h2></caption>

            <tr>
                <th>Name</th>
                <th>Type</th>
                <th>View Stock Item</th>
                <th>Update</th>
                <th>Remove</th>
            </tr>

            <c:forEach var="stock" items="${Stock.stock}">

                <c:url var="viewUrl" value="${Mappings.VIEW_STOCK_ITEM}">
                    <c:param name="id" value="${stock.stockId}"/>
                </c:url>

                <c:url var="updateUrl" value="${Mappings.ADD_STOCK_ITEM}">
                    <c:param name="id" value="${stock.stockId}"/>
                </c:url>

                <c:url var="updateUrl" value="${Mappings.UPDATE_STOCK_ITEM}">
                    <c:param name="id" value="${stock.stockId}"/>
                </c:url>

                <c:url var="removeUrl" value="${Mappings.REMOVE_STOCK_ITEM}">
                    <c:param name="id" value="${stock.stockId}"/>
                </c:url>

                <tr>
                    <td><c:out value="${stock.stock_name}"/></td>
                    <td><c:out value="${stock.type}"/></td>
                    <td><a href="${viewUrl}">View</a></td>
                    <td><a href="${updateUrl}">Edit</a></td>
                    <td><a href="${removeUrl}">Remove</a></td>
                </tr>

            </c:forEach>

        </table>
    </div>

</body>

</html>