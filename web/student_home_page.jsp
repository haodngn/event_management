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
        <c:url var="logout" value="MainController">
            <c:param name="btnAction" value="Logout"></c:param>
        </c:url>
        <br><a href="${logout}">Logout |</a>
        <br>
        <form action="MainController">
            <input type="text" name="txtSearchValue" value="${param.txtSearchValue}" placeholder="search name event..."/>
            <input type="submit" name="btnAction" value="Search event" />
        </form>
        <table border="1">
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Speaker</th>
                    <th>Location</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="event" items="${requestScope.listEvent}">
                <form action="MainController">
                    <tr>
                        <td>${event.id}</td>
                        <td>
                            <c:url var="getDetail" value="MainController">
                                <c:param name="btnAction" value="detail event"/>
                                <c:param name="txtId" value="${event.id}"/>
                                <c:param name="lastSearchValue" value="${param.txtSearchValue}"/>
                                <c:param name="index" value="${param.index}"/>
                            </c:url>
                            <a href="${getDetail}">${event.eventName}</a>
                        </td>
                        <td>${event.speaker}</td>
                        <td>${event.loaction}</td>
                    </tr>
                </form>
            </c:forEach>

        </tbody>
    </table>
    <c:forEach begin="1" end="${requestScope.page}" var="i">
        <c:url value="SearchEventController" var="paging">
            <c:param name="index" value="${i}"/>

        </c:url>
        <a href="${paging}">${i}</a>
    </c:forEach>

    <h1>This is home page for STUDENT</h1>
</body>
</html>
