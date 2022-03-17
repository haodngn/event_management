<%-- 
    Document   : update_event
    Created on : Feb 14, 2022, 12:20:04 PM
    Author     : HAO
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
        <link href="css/create_event_dev.css" rel="stylesheet">

        <!-- Favicon  -->
        <link rel="icon"
              href="https://scontent.fsgn8-2.fna.fbcdn.net/v/t39.30808-6/271593937_1664244880583377_2174091405254032054_n.jpg?_nc_cat=105&ccb=1-5&_nc_sid=730e14&_nc_ohc=KZvQUUTXTt8AX8ezGc5&_nc_ht=scontent.fsgn8-2.fna&oh=00_AT8zmh_8x3msFpgytr2Yvszp1KfUnB9vuZ_2S8CzCxqHmQ&oe=61ED85A9">
    </head>
    <body data-spy="scroll" data-target=".fixed-top">



        <!-- Preloader -->
        <div class="spinner-wrapper">
            <div class="spinner">
                <div class="bounce1"></div>
                <div class="bounce2"></div>
                <div class="bounce3"></div>
            </div>
        </div>
        <!-- end of preloader -->


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
                            <c:url var="event_dev" value="SearchEventController">
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




        <!-- Header -->
        <header id="header" class="ex-header">

            
            <div class="container">
                <!-- Breadcrumbs -->
                <div class="ex-basic-1">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-12">
                                <div class="breadcrumbs">
                                    <a id="linkBreadcrumbs" href="#">Home</a><i
                                        id="linkBreadcrumbs" class="fa
                                        fa-angle-double-right"></i><span
                                        id="linkBreadcrumbs">Update Event</span>
                                </div> <!-- end of breadcrumbs -->
                            </div> <!-- end of col -->
                        </div> <!-- end of row -->
                    </div> <!-- end of container -->
                </div> <!-- end of ex-basic-1 -->
                <!-- end of breadcrumbs -->
            </div> <!-- end of container -->
        </header> <!-- end of ex-header -->
        <!-- end of header -->


        <!--content-->
        <h3 style="text-align: center">EVENT UPDATE FORM</h3>

        <c:set value="${requestScope.CREATE_ERR}" var="err"/>
        <c:set value="${requestScope.EVENT}" var="event"/>
        <form action="MainController" method="POST">
            <div class="container_form_create">
                <form class="form_create_event" action="MainController" method="POST">

                    <label for="speaker">Speaker</label>
                    <input id="speaker" type="text" name="txtSpeaker"  value="${event.speaker}"/></br>
                    <c:if test="${not empty err.speakerLength}">
                        <font color="red">
                        ${err.speakerLength}<br/>
                        </font>
                    </c:if>


                    <label for="eName">Event Name</label>
                    <input id="eName" type="text" name="txtEventName" value="${event.eventName}"/></br>
                    <c:if test="${not empty err.nameLength}">
                        <font color="red">
                        ${err.nameLength}<br/>
                        </font>
                    </c:if>


                    <label for="oDate">Occur Date</label>
                    <input id="oDate" type="date" name="txtOccurDate" value="${event.occurDate}"/></br>
                    <c:if test="${not empty err.occurDateCheck}">
                        <font color="red">
                        ${err.occurDateCheck}<br/>
                        </font>
                    </c:if>


                    <label for="eDate">End Date</label>
                    <input id="eDate" type="date" name="txtEndDate" value="${event.endDate}""/></br>
                    <c:if test="${not empty err.endDateCheck}">
                        <font color="red">
                        ${err.endDateCheck}<br/>
                        </font>
                    </c:if>


                    <label for="rDate">Register Date</label>
                    <input id="rDate" type="date" name="registerDate" value="${event.registerDate}"/></br>
                    <c:if test="${not empty err.registerDateCheck}">
                        <font color="red">
                        ${err.registerDateCheck}<br/>
                        </font>
                    </c:if>


                    <label for="exDate">Expiration Date</label>
                    <input id="exDate" type="date" name="txtExpirationDate" value="${event.expirationDate}" /></br>
                    <c:if test="${not empty err.expDateCheck}">
                        <font color="red">
                        ${err.expDateCheck}<br/>
                        </font>
                    </c:if>


                    <label for="description">Description</label>
                    <textarea id="description" type="text" name="txtDescription"  value="${event.description}">${event.description}</textarea></br>
                    <c:if test="${not empty err.desLength}">
                        <font color="red">
                        ${err.desLength}<br/>
                        </font>
                    </c:if>


                    <label for="location">Location</label>
                    <input id="location" type="text" name="txtLocation" value="${event.location}""/></br>
                    <c:if test="${not empty err.locationLength}">
                        <font color="red">
                        ${err.locationLength}<br/>
                        </font>
                    </c:if>

                    <label for="price">Price($)</label>
                    <input id="location" type="text" name="txtPrice" value="${event.price}" readonly="true"/></br>

                    <label for="count">Number of student</label>
                    <input id="count" type="number" name="txtAmount" value="${event.studentMax}" readonly="true" /></br>
                    <c:if test="${not empty err.amountStudentErr}">
                        <font color="red">
                        ${err.amountStudentErr}<br/>
                        </font>
                    </c:if>

                    <div class="btn-action">
                        <input type="hidden" name="txtId" value="${requestScope.EVENT_ID}" />
                        <input type="submit" value="Edit Event" name="btnAction" />
                        <input type="submit" value="Back to home" name="btnAction" />
                    </div>

                </form>

            </div>
        </form>
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

