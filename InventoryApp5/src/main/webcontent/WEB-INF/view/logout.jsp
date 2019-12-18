<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <title>Logout</title>
</head>
<body>
<%
    session.removeAttribute("username");
    session.removeAttribute("password");
    session.invalidate();
%>
<div style="text-align: center;">
    <h1>Successfull Logout</h1>
    Login <a href="login.jsp">click here</a>.
</div>
</body>
</html>