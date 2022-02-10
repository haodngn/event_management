<%-- 
    Document   : home_page
    Created on : Jan 19, 2022, 8:20:31 PM
    Author     : HAO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>

    </head>
    <body>
        <c:if test="${not empty requestScope.email}">
            <font color="red">
            ${requestScope.email}
            </font>
        </c:if>
        <h1>Home</h1>
        <c:url var="logout" value="MainController">
            <c:param name="btnAction" value="Logout"></c:param>
        </c:url>
        <br><a href="${logout}">Logout |</a>
        <a href="create_event.jsp"> Create</a>
        <br>

        <table border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Speaker</th>
                    <th>Name</th>
                    <th>Location</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="event" items="${requestScope.listEvent}">
                    <tr>
                        <td>${event.id}</td>
                        <td>${event.speaker}</td>
                        <td>${event.eventName}</td>
                        <td>${event.loaction}</td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
        <c:forEach begin="1" end="${requestScope.page}" var="i">
            <c:url value="SearchEventController" var="paging">
                <c:param name="index" value="${i}"/>

            </c:url>
            <a href="${paging}">${i}</a>
        </c:forEach>

    </body>
</html>
