<%-- 
    Document   : update_event
    Created on : Feb 14, 2022, 12:20:04 PM
    Author     : HAO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Event Detail</title>
    </head>
    <body>
        <h1>Event</h1>
    <c:set value="${requestScope.UPDATE_ERR}" var="err"/>
    <c:set value="${requestScope.EVENT}" var="event"/>
    <form action="MainController" method="POST">
        <input type="hidden" name="txtId" value="${requestScope.EVENT_ID}" />
        speaker 
        <input type="text" name="txtSpeaker" value="${event.speaker}" placeholder="Speaker"/></br>
        <c:if test="${not empty err.speakerLength}">
            <font color="red">
            ${err.speakerLength}<br/>
            </font>
        </c:if>
        Event name 
        <input type="text" name="txtEventName" value="${event.eventName}" placeholder="EventName"/></br>
        <c:if test="${not empty err.nameLength}">
            <font color="red">
            ${err.nameLength}<br/>
            </font>
        </c:if>
        Occur Date 
        <input type="date" name="txtOccurDate" value="${event.occurDate}" placeholder="txtOccurDate"/></br>
        <c:if test="${not empty err.occurDateCheck}">
            <font color="red">
            ${err.occurDateCheck}<br/>
            </font>
        </c:if>
        End Date 
        <input type="date" name="txtEndDate" value="${event.endDate}" placeholder="txtEndDate"/></br>
        <c:if test="${not empty err.endDateCheck}">
            <font color="red">
            ${err.endDateCheck}<br/>
            </font>
        </c:if>
        register Date 
        <input type="date" name="registerDate" value="${event.registerDate}" placeholder="registerDate"/></br>
        <c:if test="${not empty err.registerDateCheck}">
            <font color="red">
            ${err.registerDateCheck}<br/>
            </font>
        </c:if>
        Expiration Date 
        <input type="date" name="txtExpirationDate" value="${event.expirationDate}" placeholder="txtExpirationDate"/></br>
        <c:if test="${not empty err.expDateCheck}">
            <font color="red">
            ${err.expDateCheck}<br/>
            </font>
        </c:if>

        Description
        <input type="text" name="txtDescription" value="${event.description}" placeholder="txtDescription"/></br>
        <c:if test="${not empty err.desLength}">
            <font color="red">
            ${err.desLength}<br/>
            </font>
        </c:if>
        Location
        <input type="text" name="txtLocation" value="${event.location}" placeholder="txtLocation"/></br>
        <c:if test="${not empty err.locationLength}">
            <font color="red">
            ${err.locationLength}<br/>
            </font>
        </c:if>
            
        <input type="submit" value="Edit Event" name="btnAction" />
        <input type="submit" value="Back to home" name="btnAction" />
    </form>
    </body>
</html>
