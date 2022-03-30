<%-- 
    Document   : student_register
    Created on : Mar 30, 2022, 7:50:00 PM
    Author     : By Van Lung, IDStudent: SE140193
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1,
              shrink-to-fit=no">

        <!-- SEO Meta Tags -->
        <meta name="description" content="Sync is a landing page HTML template
              built with Bootstrap 4 for presenting mobile apps to the online
              audience and for getting visitors to become users.">
        <meta name="author" content="Inovatik">

        <!-- OG Meta Tags to improve the way the post looks when you share the page on LinkedIn, Facebook, Google+ -->
        <meta property="og:site_name" content="" /> <!-- website name -->
        <meta property="og:site" content="" /> <!-- website link -->
        <meta property="og:title" content="" /> <!-- title shown in the actual shared post -->
        <meta property="og:description" content="" /> <!-- description shown in the actual shared post -->
        <meta property="og:image" content="" /> <!-- image link, make sure it's jpg -->
        <meta property="og:url" content="" /> <!-- where do you want your post to link to -->
        <meta property="og:type" content="article" />

        <!-- Webpage Title -->
        <title>Event Details</title>

        <!-- Styles -->
        <link
            href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,700&display=swap&subset=latin-ext"
            rel="stylesheet">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/fontawesome-all.css" rel="stylesheet">
        <link href="css/swiper.css" rel="stylesheet">
        <link href="css/magnific-popup.css" rel="stylesheet">
        <link href="css/styles.css" rel="stylesheet">
        <link href="css/search.css" rel="stylesheet">
        <link href="css/event_dev.css" rel="stylesheet">


        <!-- Favicon  -->
        <link rel="icon"
              href="https://scontent.fsgn8-2.fna.fbcdn.net/v/t39.30808-6/271593937_1664244880583377_2174091405254032054_n.jpg?_nc_cat=105&ccb=1-5&_nc_sid=730e14&_nc_ohc=KZvQUUTXTt8AX8ezGc5&_nc_ht=scontent.fsgn8-2.fna&oh=00_AT8zmh_8x3msFpgytr2Yvszp1KfUnB9vuZ_2S8CzCxqHmQ&oe=61ED85A9">
    </head>
    <body data-spy="scroll" data-target=".fixed-top">


        <%--<c:set value="${requestScope.listEvent}" var="event"/>--%>

        <!-- Navigation -->
        <nav class="navbar navbar-expand-lg navbar-dark navbar-custom
             fixed-top">
            <!-- Text Logo - Use this if you don't have a graphic logo -->
            <!-- <a class="navbar-brand logo-text page-scroll" href="index.html">Sync</a> -->
            <!-- Image Logo -->
            <a href="SearchEventController"><img style="height: 73px;width: 259px;"
                                                 src="https://uni.fpt.edu.vn/Data/Sites/1/media/2020logoweb/0001.jpg"
                                                 alt="alternative"></a>
            <a href="SearchEventController"><img style="height: 65px; width: 200px; margin-left:
                                                 30px;"
                                                 src="assets/images/logo.jpg" alt="alternative"></a>
            <div class="container">

                <!-- Mobile Menu Toggle Button -->
                <button class="navbar-toggler" type="button"
                        data-toggle="collapse" data-target="#navbarsExampleDefault"
                        aria-controls="navbarsExampleDefault" aria-expanded="false"
                        aria-label="Toggle navigation">
                    <span class="navbar-toggler-awesome fas fa-bars"></span>
                    <span class="navbar-toggler-awesome fas fa-times"></span>
                </button>
                <!-- end of mobile menu toggle button -->

                <div class="collapse navbar-collapse"
                     id="navbarsExampleDefault">
                    <ul class="navbar-nav ml-auto">
                        <li class="nav-item">
                            <a class="nav-link page-scroll"
                               href="SearchEventController">HOME<span
                                    class="sr-only">(current)</span></a>
                        </li>

                        <li class="nav-item">
                            <c:url var="event_dev" value="MainController">
                                <c:param name="btnAction" value="manage"></c:param>
                                <c:param name="btnEventDev" value="eventDev"></c:param>
                            </c:url>
                            <a class="nav-link page-scroll"
                               href="${event_dev}">EVENTS<span
                                    class="sr-only">(current)</span></a>
                        </li>

                        <li class="nav-item">
                            <a class="nav-link page-scroll"
                               href="#">CONTACT<span
                                    class="sr-only">(current)</span></a>
                        </li>

                    </ul>
                    <li class="nav-item dropdown" style="list-style-type: none;">
                        <a class="nav-link dropdown-toggle page-scroll" id="navbarDropdown" role="button" aria-haspopup="true" aria-expanded="false">${sessionScope.USER.name}</a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <c:url var="profile" value="MainController">
                                <c:param name="btnAction" value="Profile"></c:param>
                                <c:param name="email" value="${sessionScope.USER.email}"/>
                            </c:url>
                            <a  class="dropdown-item" href="${profile}"><span class="item-text">Profile</span></a>

                            <hr/>

                            <c:url var="logout" value="MainController">
                                <c:param name="btnAction" value="Logout"></c:param>
                            </c:url>
                            <a  class="dropdown-item" href="${logout}"><span class="item-text">Logout</span></a>


                        </div>
                    </li>
                </div>
            </div> <!-- end of container -->
        </nav> <!-- end of navbar -->
        <!-- end of navigation -->

        <!--content-->
        <h2>Event table</h2>

        <div class="table-wrapper">


            <table class="fl-table">
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Student name</th>
                        <th>Attendance</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${requestScope.listEvent}" var="item">
                        <tr>
                            <td>${item.id}</td>

                            <c:url var="detail" value="MainController">
                                <c:param name="btnAction" value="detail event"/>
                                <c:param name="txtId" value="${item.id}"/>
                            </c:url>

                            <td>${item.student_name}</td>
                            <td>${item.Attendance}</td>
                        </tr>
                    </c:forEach>
                <tbody>
            </table>
        </div>
        <div class="pagination">
            <c:forEach begin="1" end="${requestScope.page}" var="i">
                <c:url value="SearchEventController" var="paging">
                    <c:param name="index" value="${i}"/>
                    <c:param name="btnEventDev" value="eventDev"/>
                    <c:param name="txtSearchValue" value="${param.txtSearchValue}"/>
                </c:url>
                <a href="${paging}" 
                   <c:if test="${requestScope.index == i}">class="active"</c:if>
                   >${i}</a>
            </c:forEach>
        </div>

        <!--end of content-->

        <!-- Footer -->
        <div class="footer">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="footer-col first">
                            <h5>About Us</h5>
                            <p class="p-small">Management SE Event in FPT
                                University HCM</p>
                        </div> <!-- end of footer-col -->
                        <div class="footer-col second">
                            <h5>Contact Info</h5>
                            <ul class="list-unstyled li-space-lg p-small">
                                <li class="media">
                                    <i class="fas fa-map-marker-alt"></i>
                                    <div class="media-body">Lot E2a-7, D1
                                        Street, Hi-Tech Park, Long Thanh My, Thu
                                        Duc City, Ho Chi Minh City</div>
                                </li>
                                <li class="media">
                                    <i class="fas fa-envelope"></i>
                                    <div class="media-body"><a
                                            href="#your-link">seevent@fpt.com.vn</a></div>
                                </li>
                                <li class="media">
                                    <i class="fas fa-phone-alt"></i>
                                    <div class="media-body"><a
                                            href="#your-link">+84 376 945 23</a></div>
                                </li>
                            </ul>
                        </div> <!-- end of footer-col -->
                        <div class="footer-col fifth">
                            <span class="fa-stack">
                                <a href="https://www.facebook.com/FPTU.HCM">

                                    <i class="fas fa-circle fa-stack-2x"></i>
                                    <i class="fab fa-facebook-f fa-stack-1x"></i>
                                </a>
                            </span>
                            <span class="fa-stack">
                                <a href="#your-link">
                                    <i class="fas fa-circle fa-stack-2x"></i>
                                    <i class="fab fa-twitter fa-stack-1x"></i>
                                </a>
                            </span>
                            <span class="fa-stack">
                                <a href="#your-link">
                                    <i class="fas fa-circle fa-stack-2x"></i>
                                    <i class="fab fa-pinterest-p fa-stack-1x"></i>
                                </a>
                            </span>
                            <span class="fa-stack">
                                <a href="#your-link">
                                    <i class="fas fa-circle fa-stack-2x"></i>
                                    <i class="fab fa-instagram fa-stack-1x"></i>
                                </a>
                            </span>
                        </div> <!-- end of footer-col -->
                    </div> <!-- end of col -->
                </div> <!-- end of row -->
            </div> <!-- end of container -->
        </div> <!-- end of footer -->
        <!-- end of footer -->
        <!-- Copyright -->
        <div class="copyright">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12">
                        <p class="p-small">Copyright © 2022 <a href="#">SE Event</a>
                            - All rights reserved</p>
                    </div> <!-- end of col -->
                </div> <!-- enf of row -->
            </div> <!-- end of container -->
        </div> <!-- end of copyright -->
        <!-- end of copyright -->

        <!-- Scripts -->
        <script src="js/jquery.min.js"></script> <!-- jQuery for Bootstrap's JavaScript plugins -->
        <script src="js/popper.min.js"></script> <!-- Popper tooltip library for Bootstrap -->
        <script src="js/bootstrap.min.js"></script> <!-- Bootstrap framework -->
        <script src="js/jquery.easing.min.js"></script> <!-- jQuery Easing for smooth scrolling between anchors -->
        <script src="js/swiper.min.js"></script> <!-- Swiper for image and text sliders -->
        <script src="js/jquery.magnific-popup.js"></script> <!-- Magnific Popup for lightboxes -->
        <script src="js/validator.min.js"></script> <!-- Validator.js - Bootstrap plugin that validates forms -->
        <script src="js/scripts.js"></script> <!-- Custom scripts -->


    </body>
</html>

