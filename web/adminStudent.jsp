<%-- 
    Document   : adminStudent
    Created on : Mar 1, 2022, 12:44:02 PM
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
                                <input type="text" placeholder="Search.." name="txtSearchUser">
                                <button type="submit" name="btnAction" value="Admin"><img src="assets/images/adminImages/search.png" alt=""></button>
                            </form>
                        </div>
                        <div class="user">
                            <div class="img-case">
                                <img src="assets/images/avatar-among-us-9.jpg" alt="">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="content">
                    <div class="content-2">
                        <div class="recent-payments">
                            <div class="title">
                                <h2>Users</h2>
                            </div>
                            <table>
                                <tr>
                                    <th>Name</th>
                                    <th>Email</th>
                                    <th>Phone Number</th>
                                    <th>Gender</th>
                                    <th>Detail</th>
                                </tr>
                            <c:forEach items="${sessionScope.initUser}" var="user">
                                <tr>
                                    <td>${user.name}</td>
                                    <td>${user.email}</td>
                                    <td>${user.phoneNumber}</td>
                                    <c:if test="${user.gender == 'true'}"><td>Male</td></c:if>
                                    <c:if test="${user.gender == 'false'}"><td>Female</td></c:if>
                                        <td>
                                            <form action="MainController">
                                                <input type="hidden" name="status" value="${user.status}" />
                                            <input type="hidden" name="email" value="${user.email}" />
                                            <button name="btnAction" value="Profile" class="btn-detail">Detail</button>
                                        </form>
                                    </td>
                                </tr>
                            </c:forEach>
                        </table>
                        <c:if test="${sessionScope.initUser != null}">
                            <div class="pagination">
                                <c:forEach begin="1" end="${sessionScope.STUDENT_PAGE}" var="i">
                                    <c:url value="AdminController" var="paging">
                                        <c:param name="indexStudent" value="${i}"/>
                                        <c:param name="txtSearchUser" value="${param.txtSearchUser}"/>
                                    </c:url>
                                    <a href="${paging}" 
                                       <c:if test="${sessionScope.currentStudent == i}">class="active"</c:if>
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
