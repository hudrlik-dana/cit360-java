<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.dana.util.Mappings" %>

<html>

<head>
    <title>Inventory Application</title>
</head>

<body>

    <div align="center">
        <c:url var="stockItemsLink" value="${Mappings.STOCK_ITEMS}"/>
        <h2><a href="${stockItemsLink}">Show Inventory Stock Items</a></h2>
    </div>

</body>

</html>