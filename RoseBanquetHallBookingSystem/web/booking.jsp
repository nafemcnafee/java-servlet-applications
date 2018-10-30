<%-- 
    Document   : booking
    Created on : 18-Apr-2017, 5:42:36 PM
    Author     : nafe
--%>

<%@page import="bookingsystem.*"%>



<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Booking.jsp</title>
    </head>
    <body>
        <h1>Booking Halls Form</h1>
        <img src="images/flower.png" height="60" width="60" > <br>
        
        <%
            HallDAO hallDAO = new HallDAO(); 
            ClientDAO clientDAO=new ClientDAO();
            ArrayList<Hall> halls = hallDAO.retrieveAllHalls();
            ArrayList<Client> clients= clientDAO.retrieveAllClients();
            String errorMessage="Book a hall for your wedding ASAP!";
            errorMessage = (String) session.getAttribute("message");
            
        %>
        
        <form action="BookingSystemServlet" method="GET">
        Enter Booking ID: <input type="text" name="bookingID" > (eg: B01, B02 etc) <br> 
        Select Hall:<select name="hallID"> 
            <% for(Hall h: halls){ %> 
                        <option value="<%= h.getHallID() %>"> <%= h.getHallName() %></option><% } %>
                    </select> <br>
            
        Select Client:    
                    <select name="clientID">
                        <% for(Client c: clients){ %>
                        <option value="<%= c.getClientID() %>"> <%= c.getClientName() %></option> <% } %>
                    </select> <br> 
        Enter Date: <input type="date" name="date" > <br>
                    <input type="submit" name="action" value="Book it!"> <br> 
        </form>
                    <div id="message"> 
                        <h3>
                            <% if (errorMessage != null){out.println(errorMessage);} %>  
                        </h3>
                    </div>
                    <a href="index.jsp">Back to Main Page</a>
    </body>
</html>
