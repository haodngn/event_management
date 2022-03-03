<%-- 
    Document   : receipt
    Created on : Mar 1, 2022, 10:06:59 PM
    Author     : HAO
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment Receipt</title>
<style type="text/css">
    table { border: 0; }
    table td { padding: 5px; }
</style>
</head>
<body>
<div align="center">
    <h1>Payment Done. Thank you for joining our event</h1>
    <br/>
    <h2>Receipt Details:</h2>
    <table>
        <tr>
            <td><b>University:</b></td>
            <td>FPT HCM</td>
        </tr>
        <tr>
            <td><b>Payer:</b></td>
            <td>${sessionScope.USER.name}</td>      
        </tr>
        <tr>
            <td><b>Payment Status:</b></td>
            <td>Completed</td>
        </tr>
        <tr>
            <td><b>Price</b></td>
            <td>${sessionScope.price} USD</td>
        </tr>
        <tr>
            <td><b>Total:</b></td>
            <td>${sessionScope.price} USD</td>
        </tr>
        <form action="MainController">
            <tr>
            <td colspan="2" align="center">
                <input type="submit" value="Return Home" name="btnAction" />
            </td>
        </tr> 
        </form>
    </table>
</div>
</body>
</html>
