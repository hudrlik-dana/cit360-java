<html>
<head>
    <title>Registration Form</title>
    <style type="text/css">
        h3{
            font-family: serif; font-size: 22pt; font-style: normal; font-weight: bold; color:bisque;
            text-align: center; text-decoration: underline }
        table{
            font-family: serif; color:black; font-size: 11pt; font-style: normal;width: 50%;
            text-align: center; background-color: bisque; border-collapse: collapse; border: 2px solid indianred}
        table.inner{border: 0 }
    </style>
</head>
<body>
<h3>Registration</h3>
<form action="${pageContext.request.contextPath}../RegistrationServlet" class="registration" method="POST">
    <table>
        <tr>
            <td>First Name</td>
            <td><label>
                <input type="text" name="firstName" maxlength="24"/>
            </label>
                (only use characters a-z and A-Z, max 24)
            </td>
        </tr>
        <tr>
            <td>Middle Initial</td>
            <td><label>
                <input type="text" name="middleInitial" maxlength="1"/>
            </label>
                (only use 1 character a-z and A-Z)
            </td>
        </tr>
        <tr>
            <td>Last Name</td>
            <td><label>
                <input type="text" name="lastName" maxlength="24"/>
            </label>
                (only use characters a-z and A-Z, max 24)
            </td>
        </tr>
        <tr>
            <td>Email</td>
            <td><label>
                <input type="text" name="email" maxlength="50" />
            </label>
            </td>
        </tr>
        <tr>
            <td>Username</td>
            <td><label>
                <input type="text" name="username" maxlength="50" />
            </label>
            </td>
        </tr>
        <tr>
            <td>Password</td>
            <td><label>
                <input type="text" name="password" maxlength="50" />
            </label>
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" value="Submit">
                <input type="reset" value="Reset">
            </td>
        </tr>
    </table>
</form>
</body>
</html>