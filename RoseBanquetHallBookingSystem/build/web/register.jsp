<%-- 
    Document   : register
    Created on : 17-Apr-2017, 12:04:02 AM
    Author     : BahirahJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Clients</title>
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
        <h1>Rose Banquet Halls Client Registration Form </h1>
        <div>
        <form action="BookingSystemServlet" method="GET" >
            Client ID:      <input type="text" name="clientID"> (eg: C01,C02 etc)<br> 
            Client Name:    <input type="text" name="clientName"><br>
            Credit Card#:   <input type="text" name="creditCard"><br>
                            <input type="submit" name="action" value="Register">
        </form>
        </div>
        <a href="index.jsp">Back to Main Page</a>
    </body>
</html>
