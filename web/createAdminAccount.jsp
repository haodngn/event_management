<%-- 
    Document   : createAdminAccount
    Created on : Mar 30, 2022, 7:35:48 PM
    Author     : MSI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Account</title>
    </head>
    <style>
        input[type=text], select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        
        input[type=email], select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }
        
        input[type=password], select {
            width: 100%;
            padding: 12px 20px;
            margin: 8px 0;
            display: inline-block;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        button {
            width: 100%;
            background-color: #4CAF50;
            color: white;
            padding: 14px 20px;
            margin: 16px 0;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        button:hover {
            background-color: #45a049;
        }

        div {
            border-radius: 5px;
            background-color: #f2f2f2;
            padding: 20px;
        }
    </style>
    <body>
        <h3>Create Manager Account</h3>
        <c:set value="${requestScope.USER_ERR}" var="err"/>
        
        <form action="MainController">
            <label for="fname">Name</label>
            <input type="text" id="fname" name="txtName" placeholder="Your name.." value="${param.txtName}" required>

            <label for="femail">Email</label>
            <input type="email" id="femail" name="txtEmail" placeholder="Your email.." value="${param.txtEmail}" required>
            
            <label for="password">Password</label>
            <input type="password" id="password" name="txtPassword" placeholder="Your password.." value="" required>
            <c:if test="${not empty err.passwordErr}">
                <font color="red">
                    ${err.passwordErr}
                </font><br/>
            </c:if>
            
            <label for="phone">Phone Number</label>
            <input type="text" id="phone" name="txtPhone" placeholder="Your phone number.." value="${param.txtPhone}" required>
            <c:if test="${not empty err.phoneErr}">
                <font color="red">
                    ${err.phoneErr}
                </font><br/>
            </c:if>
            
            <label for="gender">Gender</label>
            <select id="gender" name="txtGender">
                <option value="male">Male</option>
                <option value="female">Female</option>
            </select>
            
            <label for="role">Role</label>
            <select id="role" name="txtRole">
                <option value="admin">Admin</option>
                <option value="eventDep">Event Department</option>
            </select>

            <button value="createManagerAccount" name="btnAction">Create</button>
        </form>
    </body>
</html>
