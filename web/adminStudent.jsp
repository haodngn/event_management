<%-- 
    Document   : adminStudent
    Created on : Mar 1, 2022, 12:44:02 PM
    Author     : MSI
--%>

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
                        <input type="text" placeholder="Search..">
                        <button type="submit"><img src="assets/images/adminImages/search.png" alt=""></button>
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
                            <h2>Ongoing Events</h2>
                            <a href="#" class="btn">View All</a>
                        </div>
                        <table>
                            <tr>
                                <th>Event Name</th>
                                <th>Speaker</th>
                                <th>Occur Date</th>
                                <th>End Date</th>
                                <th>Student Count</th>
                            </tr>
                            <tr>
                                <td>John Doe</td>
                                <td>St. James College</td>
                                <td>$120</td>
                                <td>300</td>
                                <td><a href="#" class="btn">View</a></td>
                            </tr>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
