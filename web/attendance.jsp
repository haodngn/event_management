<%-- 
    Document   : attendance
    Created on : Mar 15, 2022, 8:19:19 PM
    Author     : MSI
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Attendance Page</title>
        <link rel="stylesheet" href="css/adminStyle.css"/>
        <link rel="stylesheet" href="css/attendanceStyle.css"/>
    </head>
    <body>
        <div class="side-menu">
            <div class="brand-name">
                <img src="assets/images/logo.jpg" alt="logo"/>
            </div>
            <ul>
                <li><a href="admin_home_page.jsp"><img src="assets/images/adminImages/dashboard.png" alt="">&nbsp; <span>Dashboard</span> </a></li>
                <li><a href="adminStudent.jsp"><img src="assets/images/adminImages/reading-book.png" alt="">&nbsp;<span>Students</span></a> </li>
                <li><a href="adminEvent.jsp"><img src="assets/images/adminImages/calendar.png" alt="">&nbsp;<span>Events</span></a> </li>
                        <c:url var="logout" value="MainController">
                            <c:param name="btnAction" value="Logout"></c:param>
                        </c:url>
                <li><a href="${logout}"><span>Logout</span></a></li>
            </ul>
        </div>
        <div class="attend-flex">
            <form action="MainController" method="POST" class="attend-input">
                Attendance Code: <input type="text" name="attendanceCode" />
                <input type="hidden" name="txtId" value="${requestScope.txtId}"/>
                <button type="submit" name="btnAction" value="takeAttend">Take Attendance</button>
            </form>
            <c:if test="${!requestScope.firstTime}">
                <font 
                    <c:if test="${requestScope.checkAttendMessage == 'Successfully'}">color="green"</c:if>
                    <c:if test="${requestScope.checkAttendMessage == 'Error'}">color="red"</c:if>
                        >
                ${requestScope.checkAttendMessage}
                </font>
            </c:if>
            <c:if test="${sessionScope.listRegisterStudent != null}">
                <table id="customers">
                    <tr>
                        <th>No</th>
                        <th>Student Name</th>
                        <th>Email</th>
                        <th>Attendance</th>
                    </tr>
                    <c:forEach items="${sessionScope.listRegisterStudent}" var="register" varStatus="index">
                        <tr>
                            <td>${index.index + 1}</td>
                            <td>${register.studentName}</td>
                            <td>${register.studentEmail}</td>
                            <td>
                                <c:if test="${register.attendance == 'true'}">Attended</c:if>
                                <c:if test="${register.attendance == 'false'}">Absent</c:if>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </c:if>
        </div>
    </body>
</html>
