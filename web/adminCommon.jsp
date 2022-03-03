<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="side-menu">
    <div class="brand-name">
        <img src="assets/images/logo.jpg" alt="logo"/>
    </div>
    <ul>
        <li><a href="admin_home_page.jsp"><img src="assets/images/adminImages/dashboard.png" alt="">&nbsp; <span>Dashboard</span> </a></li>
        <li><a href="adminStudent.jsp"><img src="assets/images/adminImages/reading-book.png" alt="">&nbsp;<span>Students</span></a> </li>
        <li><a href="adminEvent.jsp"><img src="assets/images/adminImages/calendar.png" alt="">&nbsp;<span>Events</span></a> </li>
        <c:url var="logout" value="MainController">
            <c:param name="btnAction" value="Logout"></c:param>
        </c:url>
        <li><a href="${logout}"><span>Logout</span></a></li>
    </ul>
</div>