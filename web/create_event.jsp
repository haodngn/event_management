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
        <c:set value="${requestScope.CREATE_ERR}" var="err"/>
        <form action="MainController" method="POST">
            speaker 
            <input type="text" name="txtSpeaker" value="${param.txtSpeaker}" placeholder="Speaker"/></br>
            <c:if test="${not empty err.speakerLength}">
                <font color="red">
                    ${err.speakerLength}<br/>
                </font>
            </c:if>
            Event name 
            <input type="text" name="txtEventName" value="${param.txtEventName}" placeholder="EventName"/></br>
            <c:if test="${not empty err.nameLength}">
                <font color="red">
                    ${err.nameLength}<br/>
                </font>
            </c:if>
            Occur Date 
            <input type="date" name="txtOccurDate" value="${param.txtOccurDate}" placeholder="txtOccurDate"/></br>
            End Date 
            <input type="date" name="txtEndDate" value="${param.txtEndDate}" placeholder="txtEndDate"/></br>
            register Date 
            <input type="date" name="registerDate" value="${param.registerDate}" placeholder="registerDate"/></br>
            Expiration Date 
            <input type="date" name="txtExpirationDate" value="${param.txtExpirationDate}" placeholder="txtExpirationDate"/></br>
            
            Description
            <input type="text" name="txtDescription" value="${param.txtDescription}" placeholder="txtDescription"/></br>
            <c:if test="${not empty err.desLength}">
                <font color="red">
                    ${err.desLength}<br/>
                </font>
            </c:if>
            Location
            <input type="text" name="txtLocation" value="${param.txtLocation}" placeholder="txtLocation"/></br>
            <c:if test="${not empty err.locationLength}">
                <font color="red">
                    ${err.locationLength}<br/>
                </font>
            </c:if>
            Posted By 
            <input type="number" name="txtPostedBy" value="${param.txtPostedBy}" placeholder="txtPostedBy"/></br>
            Post Id 
            <input type="number" name="txtPostId" value="${param.txtPostId}" placeholder="txtPostId"/></br>
            
            <input type="submit" value="Create" name="btnAction" />
        </form>
            
            <c:if test="${not empty CREATE_SUCCESS}">
                <h1>${CREATE_SUCCESS}</h1>
            </c:if>
    </body>
</html>
