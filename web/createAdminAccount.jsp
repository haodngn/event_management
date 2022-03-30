<%-- 
    Document   : createAdminAccount
    Created on : Mar 30, 2022, 7:35:48 PM
    Author     : MSI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        <form action="MainController">
            <label for="fname">Name</label>
            <input type="text" id="fname" name="txtName" placeholder="Your name.." value="" required>

            <label for="email">Email</label>
            <input type="text" id="email" name="txtEmail" placeholder="Your email.." value="" required>
            
            <label for="password">Password</label>
            <input type="password" id="password" name="txtPassword" placeholder="Your password.." value="" required>
            
            <label for="phone">Phone Number</label>
            <input type="text" id="phone" name="txtPhone" placeholder="Your phone number.." value="" required>
            
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
