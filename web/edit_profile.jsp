<%-- 
    Document   : profile_page
    Created on : Feb 17, 2022, 4:03:44 PM
    Author     : Thúy Bắc
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Event Department Profile Page</title>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,700&display=swap&subset=latin-ext" rel="stylesheet">
        <link href="css/bootstrap.css" rel="stylesheet">
        <link href="css/fontawesome-all.css" rel="stylesheet">
        <link href="css/swiper.css" rel="stylesheet">
        <link href="css/magnific-popup.css" rel="stylesheet">
        <link href="css/profileStyle.css" rel="stylesheet">
        <script src="script/profileScript.js" defer></script>
    </head>
    <body>
        <div id="container">
            <div class="spinner-wrapper">
                <div class="spinner">
                    <div class="bounce1"></div>
                    <div class="bounce2"></div>
                    <div class="bounce3"></div>
                </div>
            </div>
            <!-- end of preloader -->

            <c:if test="${not empty sessionScope.userInfo}">
            <!-- Navigation -->
            <nav class="navbar navbar-expand-lg navbar-dark navbar-custom fixed-top" id="nav">
                <div class="container">
                    <!-- Text Logo - Use this if you don't have a graphic logo -->
                    <!-- <a class="navbar-brand logo-text page-scroll" href="index.html">Sync</a> -->

                    <!-- Image Logo -->
                    <a class="navbar-brand logo-image" href="index.html"><img src="assets/images/0001.jpg" alt="alternative"></a> 

                    <a class="navbar-brand logo-image" href="index.html"><img src="assets/images/logo.jpg" alt="alternative"></a> 



                    <!-- Mobile Menu Toggle Button -->
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-awesome fas fa-bars"></span>
                        <span class="navbar-toggler-awesome fas fa-times"></span>
                    </button>
                    <!-- end of mobile menu toggle button -->

                    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item">
                                <a class="nav-link page-scroll" href="#description">HOME <span class="sr-only">(current)</span></a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link page-scroll" href="#screens">EVENTS</a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link page-scroll" href="#screens">CONTACT</a>
                            </li>
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
                        </ul>
                        
                    </div>
                </div> <!-- end of container -->
            </nav> <!-- end of navbar -->
            <!-- end of navigation -->
            <div class="main">
                <div class="left-margin"></div>
                <div class="main-content">
                    <div class="direct-bar">
                        <div class="breadcrumbs">
                            <a id="linkBreadcrumbs" href="#">Profile</a>
                            <i id="linkBreadcrumbs" class="fa fa-angle-double-right"></i>
                            <span id="linkBreadcrumbs">Student Profile</span>
                        </div>
                    </div>
                    
                        <div class="body">
                            <div class="left-bar">
                                <div class="avatar-box">
                                    <img src=${sessionScope.userInfo.profilePicture} alt="Avatar" class="avatar">
                                    <p>${sessionScope.userInfo.name}</p>
                                    <p>Student</p>
                                </div>
                                <form method="POST" action="MainController">
                                    <div class="info">
                                        <div class="info-row">
                                            <span>Fullname: </span>
                                            <input type="text" class="input-field" name="name" value="${sessionScope.userInfo.name}"/>
                                        </div>
                                        <div class="horizontal-line"></div>
                                        <div class="info-row">
                                            <span>Email: </span>
                                            <input type="text" class="input-field" name="email" value="${sessionScope.userInfo.email}" readOnly/>
                                        </div>
                                        <div class="horizontal-line"></div>
                                        <div class="info-row">
                                            <span>Address: </span>
                                            <span>Bo sung sau</span>
                                        </div>
                                        <div class="horizontal-line"></div>
                                        <div class="info-row">
                                            <span>Phone: </span>
                                            <input class="input-field" type="text" name="phoneNumber" value="${sessionScope.userInfo.phoneNumber}"/>
                                            <font color="red">
                                                ${sessionScope.phoneNumberInvalid}
                                            </font>                                        
                                        </div>
                                        <div class="horizontal-line"></div>
                                        <div class="info-row">
                                            <span>Gender: </span>
                                            <span>
                                                  <input type="radio" id="male" name="genderRadio" value="Male" <c:if test="${sessionScope.userInfo.gender == true}">checked</c:if> >
                                                  <label for="male">Male</label><br>
                                                  <input type="radio" id="female" name="genderRadio" value="Female" <c:if test="${sessionScope.userInfo.gender == false}">checked</c:if>>
                                                  <label for="female">Female</label><br>
                                            </span>
                                        </div>
                                        <div class="btn-list">
                                            <input type="hidden" name="email" value="${sessionScope.userInfo.email}" />
                                            <input type="submit" class="btn-edit btn-span-all" name="btnAction" value="Save Profile"/>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="right-bar">
                                <div class="list-event">
                                    <img src="assets/images/72_Banner-hội-thảo_1024x400px.jpg" alt="Event 1">
                                    <img src="assets/images/cover-event-facebook-fts2021-toan-quoc-v1.1.jpg" alt="Event 2">
                                </div>
                            </div>
                        </div>
                    
                </div>
                <div class="right-margin"></div>
            </div>
            </c:if>
            <div class="footer">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="footer-col first">
                                <h5>About Us</h5>
                                <p class="p-small">Management SE Event in FPT University HCM</p>
                            </div> <!-- end of footer-col -->
                            <div class="footer-col second">
                                <h5>Contact Info</h5>
                                <ul class="list-unstyled li-space-lg p-small">
                                    <li class="media">
                                        <i class="fas fa-map-marker-alt"></i>
                                        <div class="media-body">Lot E2a-7, D1 Street, Hi-Tech Park, Long Thanh My, Thu Duc City, Ho Chi Minh City</div>
                                    </li>
                                    <li class="media">
                                        <i class="fas fa-envelope"></i>
                                        <div class="media-body"><a href="#your-link">seevent@fpt.com.vn</a></div>
                                    </li>
                                    <li class="media">
                                        <i class="fas fa-phone-alt"></i>
                                        <div class="media-body"><a href="#your-link">+84 376 945 23</a></div>
                                    </li>
                                </ul>
                            </div> <!-- end of footer-col -->
                            <div class="footer-col fifth">
                                <span class="fa-stack">
                                    <a href="#your-link">
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
                            <p class="p-small">Copyright © 2022 <a href="https://inovatik.com">SE Event</a> - All rights reserved</p>
                        </div> <!-- end of col -->
                    </div> <!-- enf of row -->
                </div> <!-- end of container -->
            </div> <!-- end of copyright --> 
            <!-- end of copyright -->
        </div>

        <script src="script/jquery.min.js"></script> <!-- jQuery for Bootstrap's JavaScript plugins -->
        <script src="script/popper.min.js"></script> <!-- Popper tooltip library for Bootstrap -->
        <script src="script/bootstrap.min.js"></script> <!-- Bootstrap framework -->
        <script src="script/jquery.easing.min.js"></script> <!-- jQuery Easing for smooth scrolling between anchors -->
        <script src="script/swiper.min.js"></script> <!-- Swiper for image and text sliders -->
        <script src="script/jquery.magnific-popup.js"></script> <!-- Magnific Popup for lightboxes -->
        <script src="script/validator.min.js"></script> <!-- Validator.js - Bootstrap plugin that validates forms -->
        <script src="script/scripts.js"></script> <!-- Custom scripts -->
    </body>
</html>
