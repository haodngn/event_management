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
        <link rel="stylesheet" href="css/attendanceStyle.css"/>
    </head>
    <body>
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
                        <td>${index.index}</td>
                        <td>${register.studentName}</td>
                        <td>${register.studentEmail}</td>
                        <td>${register.attendance}</td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>

    </body>
</html>
