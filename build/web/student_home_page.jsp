<%-- 
    Document   : student_home_page
    Created on : Feb 12, 2022, 3:57:50 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
      
        <c:if test="${ not empty sessionScope.USER}">
            <font color="red">
            <h1>${sessionScope.USER.email}</h1>
            </font>  
        </c:if>
        
        <h1>This is home page for STUDENT</h1>
        <form method="POST" action="MainController">
            <input type="hidden" name="email" value="${sessionScope.USER.email}" />
            <input type="submit" name="btnAction" value="Profile"/>
        </form>
    </body>
</html>
