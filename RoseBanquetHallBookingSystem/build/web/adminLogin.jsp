<%-- 
    Document   : admin
    Created on : 17-Apr-2017, 5:34:57 PM
    Author     : BahirahJ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
        <h1>Admin Login</h1>
        <form action="BookingSystemServlet" method="GET">
            Admin Name:<input type="text" name="adminname" value="" required> (Enter: "admin")<br>
            Password:  <input type="password" name="adminpass" value="" required pattern="1234"> (Enter "1234")<br>        
                       <input type="submit" name="action" value="LOGIN" >
        </form>
        <a href="index.jsp">Back to Main Page</a>
    </body>
</html>
