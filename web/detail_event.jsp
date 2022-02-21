<%-- 
    Document   : detail_event
    Created on : Feb 17, 2022, 9:49:08 PM
    Author     : HAO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Event</h1>
        <c:set value="${requestScope.UPDATE_ERR}" var="err"/>
        <c:set value="${requestScope.EVENT}" var="event"/>
        <form action="MainController" method="POST">
            <input type="hidden" name="txtId" value="${requestScope.EVENT_ID}" />

            speaker: ${event.speaker} <br/>

            Event name: ${event.eventName} <br/>

            Occur Date: ${event.occurDate} <br/>

            End Date: <a> ${event.endDate}</a> <br/>

            register Date: ${event.registerDate} <br/>

            Expiration Date: ${event.expirationDate} <br/>

            Description: ${event.description} <br/>

            Location: ${event.location} <br/>

            <input type="text" name="txtDescription_FB" value="${param.txtDescription_FB}"placeholder="Description" />
            <input type="number" name="txtRating" value="${param.txtRating}" placeholder="Rating" />

            <input type="submit" value="Feedback" name="btnAction" /> <br/>

            <input type="submit" value="Back to home" name="btnAction" />
        </form>
        <table border="1">
            <thead>
                <tr>
                    <th>User ID</th>
                    <th>Description</th>
                    <th>Rating</th>
                    <th>Post Time</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var= "Feedback" items="${requestScope.ListFeedbacks}">
                    <tr>
                        <td>${Feedback.posted_by}</td>
                        <td>${Feedback.description_fb}</td>
                        <td>${Feedback.rating}</td>
                        <td>${Feedback.post_time}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <c:forEach begin="1" end="${requestScope.page}" var="i">
            <c:url value="GetDetailEventController" var="paging">
                <c:param name="index" value="${i}"/>

            </c:url>
            <a href="${paging}">${i}</a>
        </c:forEach>

    </body>
</html>
