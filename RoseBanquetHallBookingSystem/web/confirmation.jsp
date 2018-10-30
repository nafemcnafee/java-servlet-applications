<%-- 
    Document   : confirm
    Created on : 17-Apr-2017, 12:51:00 AM
    Author     : BahirahJ
--%>

<%@page import="bookingsystem.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirm Booking</title>
    </head>
    <body>
        <% 
            
            Booking booking= (Booking) session.getAttribute("confirmBooking");
            Hall hall = (Hall) session.getAttribute("hall");
            Client client = (Client) session.getAttribute("client");
            
        %>
        <h1>Rose Banquet Halls Book Hall</h1>
        <h3> Congratulations <%= client.getClientName() %>! 
            You have successfully booked: <%= hall.getHallName() %> on: 
            <%=  booking.getDate() %> </h3> 
              
            <a href="index.jsp">Back to home page</a>
    </body>
</html>
