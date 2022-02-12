<%-- 
    Document   : create_event
    Created on : Feb 10, 2022, 10:25:45 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create</title>
    </head>
    <body>
        <form action="MainController" method="POST">
            <input type="text" name="txtSpeaker" value="${param.txtSpeaker}" placeholder="Speaker"/></br>
            <input type="text" name="txtEventName" value="${param.txtEventName}" placeholder="EventName"/></br>
            <input type="text" name="txtOccurDate" value="${param.txtOccurDate}" placeholder="txtOccurDate"/></br>
            <input type="text" name="txtEndDate" value="${param.txtSpeaker}" placeholder="txtEndDate"/></br>
            <input type="text" name="registerDate" value="${param.txtSpeaker}" placeholder="registerDate"/></br>
            <input type="text" name="txtExpirationDate" value="${param.txtSpeaker}" placeholder="txtExpirationDate"/></br>
            <input type="text" name="txtStudentCount" value="${param.txtSpeaker}" placeholder="txtStudentCount"/></br>
            <input type="text" name="txtDescription" value="${param.txtSpeaker}" placeholder="txtDescription"/></br>
            <input type="text" name="txtLocation" value="${param.txtSpeaker}" placeholder="txtLocation"/></br>
            <input type="text" name="txtPostedBy" value="${param.txtSpeaker}" placeholder="txtPostedBy"/></br>
            <input type="text" name="txtPostId" value="${param.txtSpeaker}" placeholder="txtPostId"/></br>
            
            <input type="submit" value="Create" name="btnAction" />
        </form>
            
            <c:if test="${not empty CREATE_SUCCESS}">
                <h1>${CREATE_SUCCESS}</h1>
            </c:if>
    </body>
</html>
