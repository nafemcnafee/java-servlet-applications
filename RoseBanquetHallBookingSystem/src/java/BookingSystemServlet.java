/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import bookingsystem.*;
import java.io.IOException;
import static java.lang.System.out;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nafe
 */
@WebServlet(name = "BookingSystemServlet", urlPatterns = {"/BookingSystemServlet"})
public class BookingSystemServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.text.ParseException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ParseException {
        String action=request.getParameter("action"); 
        
        if(action.equals("Register Client")){
            response.sendRedirect("register.jsp");
                     
        } else if (action.equals("Book Hall")){
            response.sendRedirect("booking.jsp");          
        }else if(action.equals("Admin View")){
            response.sendRedirect("adminLogin.jsp");    
                                                        
        } else if(action.equals("Register")){
            Client client= new Client();
            client.setClientID(request.getParameter("clientID"));
            client.setClientName(request.getParameter("clientName"));
            client.setCreditCard(request.getParameter("creditCard"));
            
            ClientDAO clientDAO=new ClientDAO();
            clientDAO.createClient(client);
            response.sendRedirect("index.jsp");
        }else if(action.equals("Book it!")){
            HttpSession session = request.getSession();
            Booking booking=new Booking();
            
            if (checkDate(request.getParameter("date"), request.getParameter("hallID"))== true) {
                String errorMessage="Same hall is booked on the same day. Please choose another day or hall.";
                session.setAttribute("message",errorMessage);
                response.sendRedirect("booking.jsp"); 
            } else{           
            booking.setBookingID(request.getParameter("bookingID"));
            booking.setHallID(request.getParameter("hallID"));
            booking.setClientID(request.getParameter("clientID"));           
            booking.setDate( request.getParameter("date"));
            
            BookingDAO bookingDAO=new BookingDAO();
            bookingDAO.createBooking(booking); 
            
            ClientDAO clientDAO = new ClientDAO();
            Client client = clientDAO.retrieveClientById(booking.getClientID());
            
            HallDAO hallDAO = new HallDAO();
            Hall hall = hallDAO.retrieveHallById(booking.getHallID());
            
            
            session.setAttribute("confirmBooking", booking);
            session.setAttribute("hall", hall);
            session.setAttribute("client", client);
            response.sendRedirect("confirmation.jsp");
            }
        }else if(action.equals("tutorial")){
            response.sendRedirect("tutorial.jsp"); 
        }else if(action.equals("LOGIN")){ 
                    String adminname=request.getParameter("adminname");
                    String adminpass=request.getParameter("adminpass");             
                    if(adminname.equals("admin")&& adminpass.equals("1234")){
                        response.sendRedirect("adminView.jsp");
                    }
        }else if(action.equals("Add New Hall")){
            Hall hall=new Hall();
            hall.setHallID(request.getParameter("hallID"));
            hall.setHallName(request.getParameter("hallName")); 
            
            HallDAO hallDAO=new HallDAO();
            hallDAO.createHall(hall); 
            response.sendRedirect("index.jsp"); 
        }else if(action.equals("delete")){
            
            HallDAO hallDAO=new HallDAO();
            hallDAO.deleteHallById(request.getParameter("deleteHallID"));
            response.sendRedirect("adminView.jsp");
        }
                   
    }
    //this method checks if another hall is booked on the same day
    public boolean checkDate(String date, String hallID){
        BookingDAO bookingDAO = new BookingDAO();
        ArrayList<Booking> bookings= bookingDAO.retrieveAllBookings();
        Boolean match =false; 
        for(Booking b: bookings){                       
             if (date.equals(b.getDate()) && hallID.equals(b.getHallID())){
                match=true; 
             }                    
        }
       return match;
        
    }
 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(BookingSystemServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(BookingSystemServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Booking System Servlet";
    }// </editor-fold>
    
}

