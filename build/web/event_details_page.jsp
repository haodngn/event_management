<%-- 
    Document   : event_details_page
    Created on : Feb 17, 2022, 9:37:09 PM
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
            <a href="#"><img style="height: 73px;width: 259px;"
                    src="https://uni.fpt.edu.vn/Data/Sites/1/media/2020logoweb/0001.jpg"
                    alt="alternative"></a>
            <a href="#"><img style="height: 65px; width: 200px; margin-left:
                    30px;"
                     src="images/logo.jpg" alt="alternative"></a>
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
                                href="home_page.jsp">HOME<span
                                    class="sr-only">(current)</span></a>
                        </li>
                        
                        <li class="nav-item">
                            <a class="nav-link page-scroll"
                                href="create_event_page.jsp">EVENTS<span
                                    class="sr-only">(current)</span></a>
                        </li>
                        
                        <li class="nav-item">
                            <a class="nav-link page-scroll"
                                href="#">CONTACT<span
                                    class="sr-only">(current)</span></a>
                        </li>

                    </ul>
                    <li class="nav-item dropdown" style="list-style-type: none;">
                        <a class="nav-link dropdown-toggle page-scroll" id="navbarDropdown" role="button" aria-haspopup="true" aria-expanded="false">ADMIN</a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                            <a  class="dropdown-item" href="#"><span class="item-text">LOGOUT</span></a>
                            
                            
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
                                        id="linkBreadcrumbs">Event Details</span>
                                </div> <!-- end of breadcrumbs -->
                            </div> <!-- end of col -->
                        </div> <!-- end of row -->
                    </div> <!-- end of container -->
                </div> <!-- end of ex-basic-1 -->
                <!-- end of breadcrumbs -->
            </div> <!-- end of container -->
        </header> <!-- end of ex-header -->
        <!-- end of header -->





        <!-- Privacy Content -->
        <div class="ex-basic-2">
            <div class="container">
                <div class="row">
                    <div class="col-lg-12" >
                        <div class="image-container-large">
                            <img class="img-fluid"
                                src="https://uni.fpt.edu.vn/Data/Sites/1/News/7482/172691562_4556790501014704_2647057800056739214_n-800x999.jpg"
                                alt="alternative">
                        </div> <!-- end of image-container-large -->
                        <div class="text-container">
                            <h3>FPT Students with the desire to start up F
                                -Shark</h3>

                            <div class="location_time" style="width: 50%;
                                float:left">

                                <p class="location_time_p">Location</p>
                                <i class="fas fa-map-marker"></i>
                                <p>Đại học FPT Đà Nẵng</p>
                            </div>
                            <div class="location_time" style="width: 50%;
                                float:right">
                                <p class="location_time_p">Time</p>
                                <i class="fas fa-calendar-alt"></i>
                                <p>16/4 - 20/5/202</p>
                            </div>

                            <p style="width: 50%;float: left;">F-Shark Contest - FPT University Danang:</p>
                            <p style="width: 50%;float: right;">❤ FPT UNIVERSITY DANANG</p>
                            <div class="row">
                                <div class="col-md-6">
                                    <ul class="list-unstyled li-space-lg">
                                        <li class="media">
                                            <div class="media-body">
                                                ❤ Time to open idea round
                                                application: April 16, 2021 -
                                                May 20, 2021

                                            </div>
                                        </li>
                                        <li class="media">
                                            <div class="media-body">❤ The Board
                                                of Directors scores the ideas:
                                                May 21, 2021 - May 23, 2021
                                            </div>
                                        </li>
                                        <li class="media">
                                            <div class="media-body"> ❤ Time of
                                                result announcement: May 24,
                                                2021
                                            </div>
                                        </li>
                                        <li class="media">
                                            <div class="media-body">Registration link:
                                                <a href="https://bom.to/WWHnJmUbKbNEG">https://bom.to/WWHnJmUbKbNEG</a></div>
                                        </li>
                                        
                                    </ul>
                                </div> <!-- end of col -->

                                <div class="col-md-6">
                                    <ul class="list-unstyled li-space-lg">
                                        <li class="media">
                                            <i class="fas fa-square"></i>
                                            <div class="media-body">🎪 ADDRESS: FPT Urban Area Da Nang, Hoa Hai Ward, Ngu Hanh Son District, Da Nang City.
                                                </div>
                                        </li>
                                        <li class="media">
                                            <i class="fas fa-square"></i>
                                            <div class="media-body">🌏 FANPAGE: https://www.facebook.com/daihocfptdanang
                                                </div>
                                        </li>
                                        <li class="media">
                                            <i class="fas fa-square"></i>
                                            <div class="media-body">📞 HOTLINE: 0236 7300 999
                                                </div>
                                        </li>
                                        <li class="media">
                                            <i class="fas fa-square"></i>
                                            <div class="media-body">🌐 WEBSITE:<a href="https://dnuni.fpt.edu.vn/">https://dnuni.fpt.edu.vn/</a></div>
                                        </li>
                                    </ul>
                                </div> <!-- end of col -->
                            </div> <!-- end of row -->
                        </div> <!-- end of text-container-->

                        <a class="btn-solid-reg" href="#">Register</a>
                        <a class="btn-solid-reg" href="#">Follow</a>
                        
                    </div> <!-- end of col-->
                </div> <!-- end of row -->
            </div> <!-- end of container -->
        </div> <!-- end of ex-basic-2 -->
        <!-- end of privacy content -->

        <!-- Discuss -->

    <div class="row d-flex justify-content-center">
        <div class="col-md-8">
            <div class="headings d-flex justify-content-between align-items-center mb-3">
                <h5>Comments</h5>
                
            </div>
            <small class="font-weight-bold text-primary">FPT University</small>
            <div class="bg-light p-2">
                <div class="d-flex flex-row align-items-start"><img class="rounded-circle" ><textarea class="form-control ml-1 shadow-none textarea">Comment here!</textarea></div>
                <div class="mt-2 text-right"><button class="btn btn-primary btn-sm shadow-none" type="button">Post comment</button><button class="btn btn-outline-primary btn-sm ml-1 shadow-none" type="button">Cancel</button></div>
            </div>
            <div class="card p-3">
                <div class="d-flex justify-content-between align-items-center">
                    <div class="user d-flex flex-row align-items-center"><span><small class="font-weight-bold text-primary">james_olesenn</small> <small class="font-weight-bold"><br>Hmm, This poster looks cool</small></span> </div> <small>2 days ago</small>
                </div>
                <div class="action d-flex justify-content-between mt-2 align-items-center">
                    <div class="reply px-4"> <small>Remove</small> <span class="dots"></span> <small style="color: #2f8d01;">Reply</small> <span class="dots"></div>
                    <div class="icons align-items-center">  <i class="fa fa-check-circle-o check-icon"></i> </div>
                </div>
            </div>
            <div class="bg-light p-2">
                <div class="d-flex flex-row align-items-start"> <img class="rounded-circle" ><textarea class="form-control ml-1 shadow-none textarea" >Reply here!</textarea></div>
                <div class="mt-2 text-right"><button class="btn btn-primary btn-sm shadow-none" type="button">Post comment</button><button class="btn btn-outline-primary btn-sm ml-1 shadow-none" type="button">Cancel</button></div>
            </div>

            <div class="card p-3 mt-2">
                <div class="d-flex justify-content-between align-items-center">
                    <div class="user d-flex flex-row align-items-center"> <span><small class="font-weight-bold text-primary">olan_sams</small> <small class="font-weight-bold"><br>Loving your work and profile! </small></span> </div> <small>3 days ago</small>
                </div>
                <div class="action d-flex justify-content-between mt-2 align-items-center">
                    <div class="reply px-4"> <small>Remove</small> <span class="dots"></span> <small>Reply</small> <span class="dots"></span>  </div>
                    <div class="icons align-items-center"> <i class="fa fa-check-circle-o check-icon text-primary"></i> </div>
                </div>
            </div>
            <div class="card p-3 mt-2">
                <div class="d-flex justify-content-between align-items-center">
                    <div class="user d-flex flex-row align-items-center">  <span><small class="font-weight-bold text-primary">rashida_jones</small> <small class="font-weight-bold"><br>Really cool Which filter are you using? </small></span> </div> <small>3 days ago</small>
                </div>
                <div class="action d-flex justify-content-between mt-2 align-items-center">
                    <div class="reply px-4"> <small>Remove</small> <span class="dots"></span> <small>Reply</small> <span class="dots"></span></div>
                    <div class="icons align-items-center">  <i class="fa fa-star-o text-muted"></i> <i class="fa fa-check-circle-o check-icon text-primary"></i> </div>
                </div>
            </div>
          
        </div>
    </div>
</div>
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
