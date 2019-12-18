<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
    <title>Login</title>
    <link href="../css/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
<form action="${pageContext.request.contextPath}../LoginServlet" method="post">
    <div style="padding: 100px 0 0 250px;">
        <div id="login-box">
            <h2>Login</h2>
            Please enter your username and password to access
            <br>
            <br>
            <div id="login-box-name" style="margin-top:20px;">Username:</div>
            <div id="login-box-field" style="margin-top:20px;">
                <input name="username" class="form-login" title="Username" value="" size="24" maxlength="40" />
            </div>
            <div id="login-box-name2">Password:</div>
            <div id="login-box-field2">
                <input name="password" type="password" class="form-login" title="Password" value="" size="24" maxlength="40" />
            </div>
            <br />
            <span class="login-box-options"> New User?
                <a href="register.jsp" style="margin-left:30px;">Register Here</a>
            </span>
            <br />
            <br />
            <input style="margin-left:100px;" type="submit" value="Login" />
        </div>
    </div>
</form>
</body>
</html>