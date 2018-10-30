<%-- 
    Document   : index
    Created on : 16-Apr-2017, 11:58:25 PM
    Author     : BahirahJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>main</title>
        <style>
            *{
                text-align: center;}
            #upper_left {
                position: absolute;
                top: 0;
                left: 0;}
        </style>
    </head>
    <body>
        <img src="images/flower.png" height="60" width="60" id="#upper_left">
        <h1>Rose Banquet Halls Booking System</h1>      
        <form action="BookingSystemServlet" method="GET">
            <input type="submit" name="action" value="Register Client"><br><br>
            <input type="submit" name="action" value="Book Hall"><br><br>
            <input type="submit" name="action" value="Admin View"><br><br>
            <input type="submit" name="action" value="tutorial"> <br><br>
        </form>
    </body>
</html>
