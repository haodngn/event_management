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
        <a href="profile_page.jsp">Profile</a>
        <br><a href="${logout}">Logout |</a>
        <a href="create_event.jsp"> Create</a>
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
                                <c:param name="id" value="${event.id}"/>
                                <c:param name="lastSearchValue" value="${param.txtSearchValue}"/>
                                <c:param name="index" value="${param.index}"/>
                            </c:url>
                            <a href="${getDetail}">${event.eventName}</a>
                        </td>
                        <td>${event.speaker}</td>
                        <td>${event.loaction}</td>
                        <td>
                            <input type="hidden" name="id" value="${event.id}" />
                            <input type="hidden" name="lastSearchValue" value="${param.txtSearchValue}" />
                            <input type="hidden" name="index" value="${param.index}" />
                            
                            <input type="submit" value="Edit" name="btnAction" />
                            <input type="submit" value="Delete" name="btnAction" />

                        </td>
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

</body>
</html>
