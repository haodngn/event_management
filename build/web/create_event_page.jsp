<%-- 
    Document   : create_event
    Created on : Feb 10, 2022, 10:25:45 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<!--<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create</title>
    </head>
    <body>
<c:set value="${requestScope.CREATE_ERR}" var="err"/>
<form action="MainController" method="POST">
    speaker 
    <input type="text" name="txtSpeaker" value="${param.txtSpeaker}" placeholder="Speaker"/></br>
<c:if test="${not empty err.speakerLength}">
    <font color="red">
    ${err.speakerLength}<br/>
</font>
</c:if>
Event name 
<input type="text" name="txtEventName" value="${param.txtEventName}" placeholder="EventName"/></br>
<c:if test="${not empty err.nameLength}">
    <font color="red">
    ${err.nameLength}<br/>
</font>
</c:if>
Occur Date 
<input type="date" name="txtOccurDate" value="${param.txtOccurDate}" placeholder="txtOccurDate"/></br>
<c:if test="${not empty err.occurDateCheck}">
    <font color="red">
    ${err.occurDateCheck}<br/>
</font>
</c:if>
End Date 
<input type="date" name="txtEndDate" value="${param.txtEndDate}" placeholder="txtEndDate"/></br>
<c:if test="${not empty err.endDateCheck}">
    <font color="red">
    ${err.endDateCheck}<br/>
</font>
</c:if>
register Date 
<input type="date" name="registerDate" value="${param.registerDate}" placeholder="registerDate"/></br>
<c:if test="${not empty err.registerDateCheck}">
    <font color="red">
    ${err.registerDateCheck}<br/>
</font>
</c:if>
Expiration Date 
<input type="date" name="txtExpirationDate" value="${param.txtExpirationDate}" placeholder="txtExpirationDate"/></br>
<c:if test="${not empty err.expDateCheck}">
    <font color="red">
    ${err.expDateCheck}<br/>
</font>
</c:if>

Description
<input type="text" name="txtDescription" value="${param.txtDescription}" placeholder="txtDescription"/></br>
<c:if test="${not empty err.desLength}">
    <font color="red">
    ${err.desLength}<br/>
</font>
</c:if>
Location
<input type="text" name="txtLocation" value="${param.txtLocation}" placeholder="txtLocation"/></br>
<c:if test="${not empty err.locationLength}">
    <font color="red">
    ${err.locationLength}<br/>
</font>
</c:if>
Posted By 
<input type="number" name="txtPostedBy" value="${param.txtPostedBy}" placeholder="txtPostedBy"/></br>
Post Id 
<input type="number" name="txtPostId" value="${param.txtPostId}" placeholder="txtPostId"/></br>

<input type="submit" value="Create" name="btnAction" />
</form>

<c:if test="${not empty CREATE_SUCCESS}">
    <h1>${CREATE_SUCCESS}</h1>
</c:if>
</body>
</html>-->

<%-- 
    Document   : event_details_page
    Created on : Feb 17, 2022, 9:37:09 PM
    Author     : By Van Lung, IDStudent: SE140193
--%>


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
        <link href="css/search.css" rel="stylesheet"

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
                        <a class="nav-link dropdown-toggle page-scroll" id="navbarDropdown" role="button" aria-haspopup="true" aria-expanded="false">Nguyễn Văn Lưng</a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
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

            <!--search-->

            <div>
                <form action="MainController" method="get" class="search">

                    <div class="form__field">
                        <input type="search" name="txtSearchValue" placeholder="What are you looking for?" value="${param.txtSearchValue}" required class="form__input">
                        <input type="submit" value="Search" name="btnAction" class="button">
                    </div>

                </form>  
            </div>

            <!--end search-->
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
                                        id="linkBreadcrumbs">Create New Event</span>
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
        <h3 style="text-align: center">EVENT REGISTRATION FORM</h3>


        <table  align="center" cellpadding = "15" style="margin-bottom: 3rem">
             
            <!----- SPEAKER ---------------------------------------------------------->
            <tr>
                <td>Speaker</td>
                <td><input type="text" name="speaker" maxlength="50" placeholder="Speaker..." />

                </td>
            </tr>

            <!----- EVENT'S NAME ---------------------------------------------------------->
            <tr>
                <td>Event's Name</td>
                <td><input type="text" name="eventName" maxlength="50" placeholder="Event's name..." />

                </td>
            </tr>
            <!----- OCCUR DATE ---------------------------------------------------------->
            <tr>
                <td>Occur Date</td>
                <td>
                    <select name="Birthday_day" id="Birthday_Day">
                        <option value="-1"> </option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>

                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>

                        <option value="13">13</option>
                        <option value="14">14</option>
                        <option value="15">15</option>
                        <option value="16">16</option>
                        <option value="17">17</option>
                        <option value="18">18</option>
                        <option value="19">19</option>
                        <option value="20">20</option>
                        <option value="21">21</option>

                        <option value="22">22</option>
                        <option value="23">23</option>
                        <option value="24">24</option>
                        <option value="25">25</option>
                        <option value="26">26</option>
                        <option value="27">27</option>
                        <option value="28">28</option>
                        <option value="29">29</option>
                        <option value="30">30</option>

                        <option value="31">31</option>
                    </select>

                    <select id="Birthday_Month" name="Birthday_Month">
                        <option value="-1"> </option>
                        <option value="January">Jan</option>
                        <option value="February">Feb</option>
                        <option value="March">Mar</option>
                        <option value="April">Apr</option>
                        <option value="May">May</option>
                        <option value="June">Jun</option>
                        <option value="July">Jul</option>
                        <option value="August">Aug</option>
                        <option value="September">Sep</option>
                        <option value="October">Oct</option>
                        <option value="November">Nov</option>
                        <option value="December">Dec</option>
                    </select>

                    <select name="Birthday_Year" id="Birthday_Year">

                        <option value="-1"> </option>
                        <option value="2012">2022</option>
                        <option value="2011">2021</option>


                    </select>
                </td>    

            </tr>
            <!----- END DATE ---------------------------------------------------------->
            <tr>
                <td>End Date</td>
                <td>
                    <select name="Birthday_day" id="Birthday_Day">
                        <option value="-1"> </option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>

                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>

                        <option value="13">13</option>
                        <option value="14">14</option>
                        <option value="15">15</option>
                        <option value="16">16</option>
                        <option value="17">17</option>
                        <option value="18">18</option>
                        <option value="19">19</option>
                        <option value="20">20</option>
                        <option value="21">21</option>

                        <option value="22">22</option>
                        <option value="23">23</option>
                        <option value="24">24</option>
                        <option value="25">25</option>
                        <option value="26">26</option>
                        <option value="27">27</option>
                        <option value="28">28</option>
                        <option value="29">29</option>
                        <option value="30">30</option>

                        <option value="31">31</option>
                    </select>

                    <select id="Birthday_Month" name="Birthday_Month">
                        <option value="-1"> </option>
                        <option value="January">Jan</option>
                        <option value="February">Feb</option>
                        <option value="March">Mar</option>
                        <option value="April">Apr</option>
                        <option value="May">May</option>
                        <option value="June">Jun</option>
                        <option value="July">Jul</option>
                        <option value="August">Aug</option>
                        <option value="September">Sep</option>
                        <option value="October">Oct</option>
                        <option value="November">Nov</option>
                        <option value="December">Dec</option>
                    </select>

                    <select name="Birthday_Year" id="Birthday_Year">

                        <option value="-1"> </option>
                        <option value="2012">2022</option>
                        <option value="2011">2021</option>


                    </select>
                </td>
            </tr>
            <!----- Register Date ---------------------------------------------------------->
            <tr>
                <td>Register Date</td>
                <td>
                    <select name="Birthday_day" id="Birthday_Day">
                        <option value="-1"> </option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>

                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>

                        <option value="13">13</option>
                        <option value="14">14</option>
                        <option value="15">15</option>
                        <option value="16">16</option>
                        <option value="17">17</option>
                        <option value="18">18</option>
                        <option value="19">19</option>
                        <option value="20">20</option>
                        <option value="21">21</option>

                        <option value="22">22</option>
                        <option value="23">23</option>
                        <option value="24">24</option>
                        <option value="25">25</option>
                        <option value="26">26</option>
                        <option value="27">27</option>
                        <option value="28">28</option>
                        <option value="29">29</option>
                        <option value="30">30</option>

                        <option value="31">31</option>
                    </select>

                    <select id="Birthday_Month" name="Birthday_Month">
                        <option value="-1"> </option>
                        <option value="January">Jan</option>
                        <option value="February">Feb</option>
                        <option value="March">Mar</option>
                        <option value="April">Apr</option>
                        <option value="May">May</option>
                        <option value="June">Jun</option>
                        <option value="July">Jul</option>
                        <option value="August">Aug</option>
                        <option value="September">Sep</option>
                        <option value="October">Oct</option>
                        <option value="November">Nov</option>
                        <option value="December">Dec</option>
                    </select>

                    <select name="Birthday_Year" id="Birthday_Year">

                        <option value="-1"> </option>
                        <option value="2012">2022</option>
                        <option value="2011">2021</option>


                    </select>
                </td>
            </tr>

            <!----- Expiration Date ---------------------------------------------------------->
            <tr>
                <td>Expiration Date</td>
                <td>
                    <select name="Birthday_day" id="Birthday_Day">
                        <option value="-1"> </option>
                        <option value="1">1</option>
                        <option value="2">2</option>
                        <option value="3">3</option>

                        <option value="4">4</option>
                        <option value="5">5</option>
                        <option value="6">6</option>
                        <option value="7">7</option>
                        <option value="8">8</option>
                        <option value="9">9</option>
                        <option value="10">10</option>
                        <option value="11">11</option>
                        <option value="12">12</option>

                        <option value="13">13</option>
                        <option value="14">14</option>
                        <option value="15">15</option>
                        <option value="16">16</option>
                        <option value="17">17</option>
                        <option value="18">18</option>
                        <option value="19">19</option>
                        <option value="20">20</option>
                        <option value="21">21</option>

                        <option value="22">22</option>
                        <option value="23">23</option>
                        <option value="24">24</option>
                        <option value="25">25</option>
                        <option value="26">26</option>
                        <option value="27">27</option>
                        <option value="28">28</option>
                        <option value="29">29</option>
                        <option value="30">30</option>

                        <option value="31">31</option>
                    </select>

                    <select id="Birthday_Month" name="Birthday_Month">
                        <option value="-1"> </option>
                        <option value="January">Jan</option>
                        <option value="February">Feb</option>
                        <option value="March">Mar</option>
                        <option value="April">Apr</option>
                        <option value="May">May</option>
                        <option value="June">Jun</option>
                        <option value="July">Jul</option>
                        <option value="August">Aug</option>
                        <option value="September">Sep</option>
                        <option value="October">Oct</option>
                        <option value="November">Nov</option>
                        <option value="December">Dec</option>
                    </select>

                    <select name="Birthday_Year" id="Birthday_Year">

                        <option value="-1"> </option>
                        <option value="2012">2022</option>
                        <option value="2011">2021</option>


                    </select>
                </td>
            </tr>
            <!----- Description ---------------------------------------------------------->
            <tr>
                <td>Description </td>
                <td>
                    <!--<input type="text" name="eventName" maxlength="300" st="true" placeholder="Short Description..."/>-->
                    <textarea name="Address" rows="2" cols="60" placeholder="Short description..."></textarea>
                </td>
            </tr>




            <!--            --- Email Id --------------------------------------------------------
            <tr>
                <td>EMAIL ID</td>
                <td><input type="text" name="Email_Id" maxlength="100" /></td>
            </tr>

            --- Mobile Number --------------------------------------------------------
            <tr>
                <td>MOBILE NUMBER</td>
                <td>
                    <input type="text" name="Mobile_Number" maxlength="10" />
                    (10 digit number)
                </td>
            </tr>

            --- Gender ---------------------------------------------------------
            <tr>
                <td>GENDER</td>
                <td>
                    Male <input type="radio" name="Gender" value="Male" />
                    Female <input type="radio" name="Gender" value="Female" />
                </td>
            </tr>-->

            <!----- Location ---------------------------------------------------------->
            <tr >
                <td>Location <br /><br /><br /></td>
                <td><textarea name="Address" rows="2" cols="60" placeholder="Location"></textarea></td>
            </tr>
            <!--
                        --- City --------------------------------------------------------
                        <tr>
                            <td>CITY</td>
                            <td><input type="text" name="City" maxlength="100" />
                                
                            </td>
                        </tr>
            
                        --- Pin Code --------------------------------------------------------
                        <tr>
                            <td>PIN CODE</td>
                            <td><input type="text" name="Pin_Code" maxlength="6" />
                                (6 digit number)
                            </td>
                        </tr>
            
                        --- State --------------------------------------------------------
                        <tr>
                            <td>STATE</td>
                            <td><input type="text" name="State" maxlength="30" />
                                (max 30 characters a-z and A-Z)
                            </td>
                        </tr>
            
                        --- Country --------------------------------------------------------
                        <tr>
                            <td>COUNTRY</td>
                            <td><input type="text" name="Country" value="India" readonly="readonly" /></td>
                        </tr>
            
                        --- Hobbies --------------------------------------------------------
            
                        <tr>
                            <td>HOBBIES <br /><br /><br /></td>
            
                            <td>
                                Drawing
                                <input type="checkbox" name="Hobby_Drawing" value="Drawing" />
                                Singing
                                <input type="checkbox" name="Hobby_Singing" value="Singing" />
                                Dancing
                                <input type="checkbox" name="Hobby_Dancing" value="Dancing" />
                                Sketching
                                <input type="checkbox" name="Hobby_Cooking" value="Cooking" />
                                <br />
                                Others
                                <input type="checkbox" name="Hobby_Other" value="Other">
                                <input type="text" name="Other_Hobby" maxlength="30" />
                            </td>
                        </tr>
            
                        --- Qualification--------------------------------------------------------
                        <tr>
                            <td>QUALIFICATION <br /><br /><br /><br /><br /><br /><br /></td>
            
                            <td>
                                <table>
            
                                    <tr>
                                        <td align="center"><b>Sl.No.</b></td>
                                        <td align="center"><b>Examination</b></td>
                                        <td align="center"><b>Board</b></td>
                                        <td align="center"><b>Percentage</b></td>
                                        <td align="center"><b>Year of Passing</b></td>
                                    </tr>
            
                                    <tr>
                                        <td>1</td>
                                        <td>Class X</td>
                                        <td><input type="text" name="ClassX_Board" maxlength="30" /></td>
                                        <td><input type="text" name="ClassX_Percentage" maxlength="30" /></td>
                                        <td><input type="text" name="ClassX_YrOfPassing" maxlength="30" /></td>
                                    </tr>
            
                                    <tr>
                                        <td>2</td>
                                        <td>Class XII</td>
                                        <td><input type="text" name="ClassXII_Board" maxlength="30" /></td>
                                        <td><input type="text" name="ClassXII_Percentage" maxlength="30" /></td>
                                        <td><input type="text" name="ClassXII_YrOfPassing" maxlength="30" /></td>
                                    </tr>
            
                                    <tr>
                                        <td>3</td>
                                        <td>Graduation</td>
                                        <td><input type="text" name="Graduation_Board" maxlength="30" /></td>
                                        <td><input type="text" name="Graduation_Percentage" maxlength="30" /></td>
                                        <td><input type="text" name="Graduation_YrOfPassing" maxlength="30" /></td>
                                    </tr>
            
                                    <tr>
                                        <td>4</td>
                                        <td>Masters</td>
                                        <td><input type="text" name="Masters_Board" maxlength="30" /></td>
                                        <td><input type="text" name="Masters_Percentage" maxlength="30" /></td>
                                        <td><input type="text" name="Masters_YrOfPassing" maxlength="30" /></td>
                                    </tr>
            
                                    <tr>
                                        <td></td>
                                        <td></td>
                                        <td align="center">(10 char max)</td>
                                        <td align="center">(upto 2 decimal)</td>
                                    </tr>
                                </table>
            
                            </td>
                        </tr>
            
            <!----- Course ---------------------------------------------------------->
            <!--            <tr>
                            <td>COURSES<br />APPLIED FOR</td>
                            <td>
                                BCA
                                <input type="radio" name="Course_BCA" value="BCA">
                                B.Com
                                <input type="radio" name="Course_BCom" value="B.Com">
                                B.Sc
                                <input type="radio" name="Course_BSc" value="B.Sc">
                                B.A
                                <input type="radio" name="Course_BA" value="B.A">
                            </td>
                        </tr>-->

            <!----- Submit and Reset ------------------------------------------------->
            <tr >

            <div class="login-box">

                <form>
                    <a href="#" style="font-size: 20px" type="submit">
                        SUBMIT
                    </a>
                </form>
            </div>
        </tr>
    </table>


 


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

