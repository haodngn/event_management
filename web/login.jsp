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
        <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8084/event_manage/login-google&response_type=code
    &client_id=204854685230-fpsjm98drnflpsignj0bqlb2122a5h7n.apps.googleusercontent.com&approval_prompt=force">Login With Google</a>
        <br>${sessionScope.mess}
    </body>
</html>
