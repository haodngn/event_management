<%-- 
    Document   : invalid
    Created on : Feb 15, 2022, 10:04:04 PM
    Author     : HAO
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
        <link href="css/detail_event.css" rel="stylesheet">
        <!-- Favicon  -->
        <link rel="icon"
              href="https://scontent.fsgn8-2.fna.fbcdn.net/v/t39.30808-6/271593937_1664244880583377_2174091405254032054_n.jpg?_nc_cat=105&ccb=1-5&_nc_sid=730e14&_nc_ohc=KZvQUUTXTt8AX8ezGc5&_nc_ht=scontent.fsgn8-2.fna&oh=00_AT8zmh_8x3msFpgytr2Yvszp1KfUnB9vuZ_2S8CzCxqHmQ&oe=61ED85A9">
    </head>
    <body data-spy="scroll" data-target=".fixed-top">

        <c:set value="${requestScope.UPDATE_ERR}" var="err"/>
        <c:set value="${requestScope.EVENT}" var="event"/>
        <c:set value="${sessionScope.USER}" var="user"/>


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
                        <c:if test="${sessionScope.USER.roleID == '2'}">
                            <li class="nav-item">
                                <c:url var="event_dev" value="SearchEventController">
                                    <c:param name="btnAction" value="manage"></c:param>
                                    <c:param name="btnEventDev" value="eventDev"></c:param>
                                </c:url>
                                <a class="nav-link page-scroll"
                                   href="${event_dev}">EVENTS<span
                                        class="sr-only">(current)</span></a>
                            </li>
                        </c:if>


                        <li class="nav-item">
                            <a class="nav-link page-scroll"
                               href="#">CONTACT<span
                                    class="sr-only">(current)</span></a>
                        </li>

                    </ul>
                    <li class="nav-item dropdown" style="list-style-type: none; margin-top:16px">
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
        <div class="ex-basic-2" >
            <div class="container">
                <div class="row">
                    <div class="col-lg-12" >
                        <div class="image-container-large">
                            <img class="img-fluid"
                                 src="${event.image}" alt="alternative">
                        </div> <!-- end of image-container-large -->
                        <div class="text-container">
                            <h3>${event.eventName}</h3>
                            <h4>Speaker: ${event.speaker}</h4>
                            <div class="location_time" style="width: 50%;
                                 float:left">

                                <p class="location_time_p">Location</p>
                                <i class="fas fa-map-marker"></i>
                                <p>${event.location}</p>

                                <p class="location_time_p">Fee :$ ${requestScope.FEE.price} </p>
                                <i class="fas fa-money-bill"></i>

                            </div>
                            <div class="location_time" style="width: 50%;
                                 float:left">
                                <p class="location_time_p">Seats</p>
                                <i class="fas fa-audio-description"></i>
                                <p>50/150</p>
                            </div>
                            <div class="location_time" style="width: 50%;
                                 float:right">
                                <p class="location_time_p">Time</p>
                                <i class="fas fa-calendar-alt"></i>
                                <p>${event.occurDate} ~  ${event.endDate}</p>
                            </div>

                            <div class="location_time" style="width: 50%;
                                 float:right">
                                <p class="location_time_p">Description</p>
                                <i class="fas fa-audio-description"></i>
                                <p>${event.description}</p>
                            </div>

                            <!--                            <p style="width: 50%;float: right;">❤ FPT UNIVERSITY DANANG</p>
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
                                                            </div>  end of col 
                            
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
                                                            </div>  end of col 
                                                    </div>  end of row -->
                            <c:if test="${user.roleID == '1'}">
                                <c:if test="${!requestScope.isOverDate == true}">
                                    <div class="loginx-box">
                                        <form action="MainController">
                                            <input type="hidden" name="txtEventID" value="${requestScope.EVENT_ID}"/>
                                            <input type="hidden" name="EventID" value="${requestScope.EVENT_ID}"/>
                                            <input type="hidden" name="txtUserID" value="${sessionScope.USER.userID}"/>
                                            <input type="hidden" name="txtEmail" value="${user.email}" />
                                            <c:if test="${requestScope.isPayEvent}">
                                                <button style="font-size: 20px; background-color: #f60;" type="submit" name="btnAction" value="Checkout">Register</button>
                                            </c:if>
                                            <c:if test="${requestScope.isPayEvent == false}">
                                                <input style="font-size: 20px; background-color: #f60;" type="submit" name="btnAction" value="Register"/>
                                            </c:if>
                                        </form>
                                    </div>
                                </c:if>
                                <script type="text/javascript">
                                    var Msg = '<%=request.getAttribute("message")%>';
                                    if (Msg !== "null") {
                                        alert(Msg);
                                    }
                                </script>
                                <!--                                <td colspan="2" align="center">
                                                                    <form action="MainController">
                                                                        <input type="hidden" name="EventID" value="${requestScope.EVENT_ID}" />
                                                                        <input type="submit" name="btnAction" value="Checkout" />
                                                                    </form>                             
                                                                </td>-->
                            </c:if>
                            <c:if test="${user.roleID == '2'}">
                                <div class="logins-box">
                                    <form action="MainController" method="POST">
                                        <input type="hidden" name="txtId" value="${requestScope.EVENT_ID}"/>
                                        <input type="hidden" name="isUpdate" value="updateEV" />
                                        <input type="hidden" name="txtUserID" value="${sessionScope.USER.userID}"/>
                                        <input style="font-size: 20px; background-color: #f60;" type="submit" name="btnAction" value="EDIT"/>
                                    </form>
                                    <div class="register-message">
                                        ${requestScope.message}
                                    </div>
                                </div>
                                <div class="login-box">
                                    <form action="MainController" method="POST">
                                        <input type="hidden" name="txtEventID" value="${requestScope.EVENT_ID}"/>
                                        <input type="hidden" name="txtUserID" value="${sessionScope.USER.userID}"/>
                                        <input style="font-size: 20px; background-color: #f60;" type="submit" name="btnAction" value="CLOSE"/>
                                    </form>
                                    <div class="register-message">
                                        ${requestScope.message}
                                    </div>
                                </div>
                            </c:if>



                        </div> <!-- end of text-container-->



                    </div> <!-- end of col-->
                </div> <!-- end of row -->
            </div> <!-- end of container -->
        </div> <!-- end of ex-basic-2 -->
        <!-- end of privacy content -->




        <div class="container" >
            <div class="headings d-flex justify-content-between align-items-center mb-3">
                <h3>Comments</h3>

            </div>
            <h5 class="font-weight-bold text-primary">${sessionScope.USER.name}</h5>

            <div class="bg-light p-2">
                <form action="MainController">
                    <input type="hidden" name="txtId" value="${requestScope.EVENT_ID}" />
                    <div class="d-flex flex-row align-items-start">
                        <img class="rounded-circle" >

                        <textarea  class="form-control ml-1 shadow-none textarea" name="txtDescription_FB" value="${param.txtDescription_FB}" placeholder="Comment here!"></textarea>
                    </div>
                    <div class="action d-flex justify-content-between mt-2 align-items-center">
                        <div class="reply px-4">
                            1<input type="radio" name="txtRating" value="1" required="" class="btn fa fa-star text-warning"/>  
                            2<input type="radio" name="txtRating" value="2" required="" class="btn fa fa-star text-warning"/>  
                            3<input type="radio" name="txtRating" value="3" required="" class="btn fa fa-star text-warning"/>  
                            4<input type="radio" name="txtRating" value="4" required="" class="btn fa fa-star text-warning"/>  
                            5<input type="radio" name="txtRating" value="5" required="" class="btn fa fa-star text-warning"/>
                        </div>
                    </div>
                    <c:if test="${not empty requestScope.CREAT_CMT_ERR}">
                        <font color="red">${requestScope.CREAT_CMT_ERR.ratingError}</font>
                    </c:if>

                    <div class="mt-2 text-right">

                        <button class="btn btn-primary btn-sm shadow-none" type="submit" name="btnAction" value="Feedback">Post comment</button>
                        <button class="btn btn-outline-primary btn-sm ml-1 shadow-none" type="button">Cancel</button>
                    </div>
                </form>
            </div>


        </div>
        <div class="review-list" >
            <ul style="    margin-left: auto;
                margin-right: auto;
                max-width: 1140px;">
                <c:forEach items="${requestScope.ListFeedbacks}" var="cmt">
                    <li>
                        <div class="d-flex">
                            <div class="left">
                                <span>
                                    <img src="https://bootdey.com/img/Content/avatar/avatar1.png" class="profile-pict-img img-fluid" alt="" />
                                </span>
                            </div>
                            <div class="right" >
                                <h4>
                                    ${cmt.posted_by}
                                    <span class="gig-rating text-body-2">
                                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 1792 1792" width="15" height="15">
                                        <path
                                            fill="currentColor"
                                            d="M1728 647q0 22-26 48l-363 354 86 500q1 7 1 20 0 21-10.5 35.5t-30.5 14.5q-19 0-40-12l-449-236-449 236q-22 12-40 12-21 0-31.5-14.5t-10.5-35.5q0-6 2-20l86-500-364-354q-25-27-25-48 0-37 56-46l502-73 225-455q19-41 49-41t49 41l225 455 502 73q56 9 56 46z"
                                            ></path>
                                        </svg>
                                        ${cmt.rating}
                                    </span>
                                    <c:if test="${sessionScope.USER.roleID == 3}">
                                        <form action="MainController" method="POST">
                                            <input type="hidden" name="txtId" value="${requestScope.EVENT_ID}" />
                                            <input type="hidden" name="commentID" value="${cmt.id}" />
                                            <button name="btnAction" class="delete-comment" value="DeleteComment">Delete</button>
                                        </form>
                                    </c:if>
                                </h4>
                                <div class="review-description">
                                    <p>
                                        ${cmt.description_fb}
                                    </p>
                                </div>

                            </div >
                        </div>
                    </li>
                </c:forEach>


            </ul>
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
