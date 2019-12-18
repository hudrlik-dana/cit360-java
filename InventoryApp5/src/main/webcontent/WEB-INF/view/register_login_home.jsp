<%@page import="java.util.List"%>
<%@page import="com.dana.controller.Login"%>
<%@page import="java.util.Date"%>
<%@page import="com.dana.model.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/style.css"/>
    <title>Results</title>
</head>
<body>
<div style="text-align: center;">
    <div id="container">
        <h1>Results</h1>
        <b>Sample results page</b>
            <%=new Date()%></>
        <%
            User user = (User) session.getAttribute("user");
        %>
        <b>Hello <%= user.getFirstName() + " " + user.getLastName()%></b>
        <br/>
        <a href="logout.jsp">Logout</a>
    <br>
    <table>
            <thead>
            <tr>
                <th>username</th>
                <th>First Name</th>
                <th>Middle Initial</th>
                <th>Last Name</th>
                <th>email</th>
            </tr>
            </thead>
            <tbody>
                <%
                     Login login = new Login();
                     List<User> list = login.getListOfUsers();
                     for (User user1 : list) {
                 %>
            <tr>
                <td><%=user1.getUsername()%></td>
                <td><%=user1.getFirstName()%></td>
                <td><%=user1.getMiddleInitial()%></td>
                <td><%=user1.getLastName()%></td>
                <td><%=user1.getEmail()%></td>
            </tr>
                <%}%>
            <tbody>
        </table>
        <br/>
    </div>
</div>
</body>
</html>