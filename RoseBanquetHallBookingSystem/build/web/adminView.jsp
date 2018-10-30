<%-- 
    Document   : adminView
    Created on : 17-Apr-2017, 6:43:14 PM
    Author     : BahirahJ
--%>

<%@page import="bookingsystem.Hall"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bookingsystem.HallDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            
            *{text-align: center;}
            table, tr, td {border: 1px solid black;}
        </style>
        
    </head>
    <body>
        <img src="images/flower.png"  height="60" width="60" id="#upper_left">
        <h1>Rose Banquet Halls Admin Management</h1>
        <form action="BookingSystemServlet" method="GET">
            Add New Hall : <br>
            Enter Hall ID: <input type="text" name="hallID"> <br>
            Enter Hall Name: <input type="text" name="hallName"> <br> 
            <input type="submit" name="action" value="Add New Hall">
        </form><br>
        
        <h2>List of Halls in the system: </h2>         
        Hall Name:
        <table align="center" id="table">
            <%
                HallDAO hallDAO= new HallDAO();
                ArrayList<Hall> halls= hallDAO.retrieveAllHalls();
                for(Hall h: halls){
            %>
            <tr> 
                <td><% out.println(h.getHallName()); %></td>                    
                <td><form action="BookingSystemServlet" method="GET" >
                        <input type="hidden" name="deleteHallID" value="<%=h.getHallID()%>">
                        <button type="submit" name="action" value="delete">
                            <img src="images/bin.png" height="12" >
                        </button>
                    </form>
                </td>
                </tr>
            <% } %>
        </table>  
        <a href="index.jsp">Back to Main Page</a>
    </body>
</html>
