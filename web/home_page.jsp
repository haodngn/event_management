<%-- 
    Document   : home_page
    Created on : Jan 19, 2022, 8:20:31 PM
    Author     : VanLungFE,HaoBE
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
        <title>Home Page</title>

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
        <link href="css/home_style.css" rel="stylesheet">

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
                                         src="assets/images/logo.jpg"
                                         alt="alternative"></a>
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
                            <a class="nav-link page-scroll"
                               href="event_dev.jsp">EVENTS<span
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
                            <a  class="dropdown-item" href="profile_dev.jsp"><span class="item-text">Profile</span></a>
                            
                            <hr/>
                            
                            <c:url var="logout" value="MainController">
                                <c:param name="btnAction" value="Logout"></c:param>
                            </c:url>
                            <a  class="dropdown-item" href="${logout}"><span class="item-text">Logout</span></a>


                        </div>
                    </li>
                    <!-- <span class="nav-item avt-account">
                        <a
                        style="text-decoration: none;"  href="#"><img style="
                                vertical-align:middle;
                                width: 40px;
                                margin: 2px;
                               
                                height: 40px;
                                border-radius: 50%;
                                " src="images/AVT1.PNG"
                                alt="avatar"></a>

                                
                    </span> -->

                </div>
            </div> <!-- end of container -->
        </nav> <!-- end of navbar -->
        <!-- end of navigation -->








        <!-- Header -->
        <header id="header" class="ex-header">

            <div class="search-form">
                <form action="MainController" method="post" class="search">

                    <div class="form__field">
                        <input type="text" name="txtSearchValue" placeholder="What are you looking for?" value="${param.txtSearchValue}" class="form__input">
                        <input type="submit" value="Search" name="btnAction" class="button">
                    </div>

                </form>  
            </div>

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
                                        id="linkBreadcrumbs"></span>
                                </div> <!-- end of breadcrumbs -->
                            </div> <!-- end of col -->
                        </div> <!-- end of row -->
                    </div> <!-- end of container -->
                </div> <!-- end of ex-basic-1 -->
                <!-- end of breadcrumbs -->

                <div class="row">
                    <div class="col-lg-12">
                        <div class="image-container">
                            <img style="margin-top: 1rem; margin-bottom: 1rem" class="img-fluid"
                                 src="https://uni.fpt.edu.vn/Data/Sites/1/Banner/b%E1%BA%A3n-ta.jpg"
                                 alt="alternative">
                        </div> <!-- end of text-container -->
                    </div> <!-- end of col -->
                </div> <!-- end of row -->
            </div> <!-- end of container -->
        </header> <!-- end of ex-header -->
        <!-- end of header -->

        <!-- Slider Event -->
        <div id="screens" class="slider">
            <div class="container">
                <div class="row">
                    <h1>Events</h1>
                    <div class="col-lg-12">

                        <!-- Image Slider -->
                        <div class="slider-container">
                            <div class="swiper-container image-slider">
                                <div class="swiper-wrapper">
                                    <c:forEach items="${requestScope.listEvent}" var="item">
                                        <!-- Slide -->
                                        <div class="swiper-slide">
                                            <c:url var="update" value="MainController">
                                                <c:param name="btnAction" value="Edit"/>
                                                <c:param name="txtId" value="${item.id}"/>
                                            </c:url>
                                            <a href="${update}" class="popup-link"
                                               data-effect="fadeIn">
                                                <img style="height: 355px; width: 100%" class="img-fluid"
                                                     src="https://uni.fpt.edu.vn/Data/Sites/1/News/7482/172691562_4556790501014704_2647057800056739214_n-800x999.jpg"
                                                     alt="alternative">
                                                <div class="event-infos">
                                                    <h5>${item.eventName}</h5>
                                                    <h6>${item.speaker}</h6>
                                                    <h6>${item.location}</h6>
                                                </div>
                                            </a>
                                        </div>
                                    </c:forEach>
                                    <!-- end of slide -->


                                </div> <!-- end of swiper-wrapper -->

                                <!-- Add Arrows -->
                                <div class="swiper-button-next"></div>
                                <div class="swiper-button-prev"></div>
                                <!-- end of add arrows -->

                            </div> <!-- end of swiper-container -->
                        </div> <!-- end of slider-container -->
                        <!-- end of image slider -->

                    </div> <!-- end of col -->
                </div> <!-- end of row -->
            </div> <!-- end of container -->
        </div> <!-- end of slider -->

        <!-- Slider News -->
        <div id="screens" class="slider">
            <div class="container">
                <div class="row">
                    <h1>News</h1>
                    <div class="col-lg-12">

                        <!-- Image Slider -->
                        <div class="slider-container">
                            <div class="swiper-container image-slider">
                                <div class="swiper-wrapper">

                                    <!-- Slide -->
                                    <div class="swiper-slide">
                                        <a href="#" class="popup-link"
                                           data-effect="fadeIn">
                                            <img class="img-fluid"
                                                 src="assets/images/event1.jpg"
                                                 alt="alternative">
                                        </a>
                                    </div>
                                    <!-- end of slide -->

                                    <!-- Slide -->
                                    <div class="swiper-slide">
                                        <a href="#" class="popup-link"
                                           data-effect="fadeIn">
                                            <img class="img-fluid"
                                          src="assets/images/event1.jpg"
                                                 alt="alternative">
                                        </a>
                                    </div>
                                    <!-- end of slide -->

                                    <!-- Slide -->
                                    <div class="swiper-slide">
                                        <a href="#" class="popup-link"
                                           data-effect="fadeIn">
                                            <img class="img-fluid"
                                                 src="assets/images/event1.jpg"
                                                 alt="alternative">
                                        </a>
                                    </div>
                                    <!-- end of slide -->

                                    <!-- Slide -->
                                    <div class="swiper-slide">
                                        <a href="#" class="popup-link"
                                           data-effect="fadeIn">
                                            <img class="img-fluid"
                                              src="assets/images/event1.jpg"
                                                 alt="alternative">
                                        </a>
                                    </div>
                                    <!-- end of slide -->
                                    <!-- Slide -->
                                    <div class="swiper-slide">
                                        <a href="#" class="popup-link"
                                           data-effect="fadeIn">
                                            <img class="img-fluid"
                                                src="assets/images/event1.jpg"
                                                 alt="alternative">
                                        </a>
                                    </div>
                                    <!-- end of slide -->
                                    <!-- Slide -->
                                    <div class="swiper-slide">
                                        <a href="#" class="popup-link"
                                           data-effect="fadeIn">
                                            <img class="img-fluid"
                                                 src="assets/images/event1.jpg"
                                                 alt="alternative">
                                        </a>
                                    </div>
                                    <!-- end of slide -->
                                    <!-- Slide -->
                                    <div class="swiper-slide">
                                        <a href="#" class="popup-link"
                                           data-effect="fadeIn">
                                            <img class="img-fluid"
                                                 src="assets/images/event1.jpg"
                                                 alt="alternative">
                                        </a>
                                    </div>
                                    <!-- end of slide -->
                                </div> <!-- end of swiper-wrapper -->

                                <!-- Add Arrows -->
                                <div class="swiper-button-next"></div>
                                <div class="swiper-button-prev"></div>
                                <!-- end of add arrows -->

                            </div> <!-- end of swiper-container -->
                        </div> <!-- end of slider-container -->
                        <!-- end of image slider -->

                    </div> <!-- end of col -->
                </div> <!-- end of row -->
            </div> <!-- end of container -->
        </div> <!-- end of slider -->
        <!-- end of slider news -->

        <!-- end of discuss -->

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
                                            href="#">seevent@fpt.com.vn</a></div>
                                </li>
                                <li class="media">
                                    <i class="fas fa-phone-alt"></i>
                                    <div class="media-body"><a
                                            href="#">+84 376 945 23</a></div>
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
