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
        <script src="https://kit.fontawesome.com/70c2abc7ec.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/style.css">
        <script src="script/script.js" defer></script>
        <title>Login Page</title>
    </head>
    <body>
        <div id="container">
            <div id="login-form">
                <h2 id="login-header">Login</h2>
                <form action="MainController" method="POST" id="form">
                    <div class="input-field">
                        <i class="fas fa-user"></i>
                        <input type="text" name="txtUsername" required/>
                        <span class="input-label">Username</span>
                    </div>
                    <div class="input-field">
                        <i class="fas fa-lock"></i>
                        <span class="input-label">Password</span>
                        <input type="password" name="txtPassword" required/>
                    </div>
                    <div class="btn-field">
                        <input type="submit" class="btn" value="Login"/>
                        <input type="reset" class="btn" value="Reset">
                    </div>
                </form>
                <a href="https://accounts.google.com/o/oauth2/auth?scope=email&redirect_uri=http://localhost:8084/event_manage/login-google&response_type=code
    &client_id=204854685230-fpsjm98drnflpsignj0bqlb2122a5h7n.apps.googleusercontent.com&approval_prompt=force" class="google-login link"><i class="fab fa-google"></i>Sign in with @fpt.edu.vn</a>
                <a href="create.jsp" class="sign-up link">Sign up</a>
                <br>${sessionScope.mess}
            </div>
        </div>
    </body>
</html>
