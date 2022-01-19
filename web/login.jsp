<%-- 
    Document   : login
    Created on : Jan 19, 2022, 8:18:26 PM
    Author     : HAO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <form action="MainController" method="POST">
            Email<input type="text" name="txtEmail"/></br>
            Password<input type="password" name="txtPassword"/></br>
            <input type="submit" name="btnAction" value="Login">
            <input type="reset" value="Reset">
        </form>
        <a href="create.jsp">Sign up</a>
        <br>${sessionScope.mess}
    </body>
</html>
