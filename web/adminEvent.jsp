<%-- 
    Document   : adminEvent
    Created on : Mar 1, 2022, 12:44:11 PM
    Author     : MSI
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/adminStyle.css"/>
    </head>
    <body>
        <jsp:include page="adminCommon.jsp"></jsp:include>
            <div class="container">
                <div class="header">
                    <div class="nav">
                        <div class="search">
                            <form action="MainController" method="POST">
                                <input type="text" placeholder="Search.." name="txtSearchEvent">
                                <button type="submit" name="btnAction" value="Admin"><img src="assets/images/adminImages/search.png" alt=""></button>
                            </form>
                        </div>
                    </div>
                </div>
                <div class="content">
                    <div class="content-2">
                        <div class="recent-payments">
                            <div class="title">
                                <h2>All Events</h2>
                            </div>
                            <table>
                                <tr>
                                    <th>Event Name</th>
                                    <th>Speaker</th>
                                    <th>Occur Date</th>
                                    <th>End Date</th>
                                    <th>Register Date</th>
                                    <th>Expiration Date</th>
                                    <th>Student Count</th>
                                    
                                    <th>Location</th>
                                    <th>Detail</th>
                                    <th>Take Attendance</th>
                                </tr>
                            <c:forEach items="${sessionScope.initEvent}" var="event">
                                <tr>
                                    <td>${event.eventName}</td>
                                    <td>${event.speaker}</td>
                                    <td>${event.occurDate}</td>
                                    <td>${event.endDate}</td>
                                    <td>${event.registerDate}</td>
                                    <td>${event.expirationDate}</td>
                                    <td>${event.studentCount}</td>
                                    
                                    <td>${event.location}</td>
                                    <td>
                                        <form action="MainController">
                                            <input type="hidden" name="txtId" value="${event.id}" />
                                            <button name="btnAction" value="detail event" class="btn-detail">Detail</button>
                                        </form>
                                    </td>
                                    <td>
                                        <form action="MainController">
                                            <input type="hidden" name="txtId" value="${event.id}" />
                                            <button name="btnAction" value="takeAttend" class="btn-detail">Take Attendance</button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                        <c:if test="${sessionScope.initEvent != null}">
                            <div class="pagination">
                                <c:forEach begin="1" end="${sessionScope.EVENT_PAGE}" var="i">
                                    <c:url value="AdminController" var="paging">
                                        <c:param name="indexEvent" value="${i}"/>
                                        <c:param name="txtSearchEvent" value="${param.txtSearchEvent}"/>
                                    </c:url>
                                    <a href="${paging}" 
                                       <c:if test="${sessionScope.currentPage == i}">class="active"</c:if>
                                       >${i}</a>
                                </c:forEach>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
