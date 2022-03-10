<%-- 
    Document   : admin_home_page
    Created on : Feb 12, 2022, 3:59:15 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
        <link rel="stylesheet" href="css/adminStyle.css"/>
    </head>
    <body>
        <jsp:include page="adminCommon.jsp"></jsp:include>
            <div class="container">
                <div class="content">
                    <div class="cards">
                        <div class="card">
                            <div class="box">
                                <h1>${sessionScope.totalUser}</h1>
                            <h3>Students Joined</h3>
                        </div>
                        <div class="icon-case">
                            <img src="assets/images/adminImages/students.png" alt="">
                        </div>
                    </div>
                    <div class="card">
                        <div class="box">
                            <h1>${sessionScope.totalEvent}</h1>
                            <h3>Events Ongoing</h3>
                        </div>
                        <div class="icon-case">
                            <img src="assets/images/adminImages/calendar.png" alt="">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
