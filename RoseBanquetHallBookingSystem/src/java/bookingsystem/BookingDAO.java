/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingsystem;

import java.sql.*;
import java.util.*;

/**
 *
 * @author nafe
 */
public class BookingDAO {
    public void createBooking(Booking booking){
        DBManager dbm = new DBManager();
        dbm.executeUpdate("INSERT INTO bookingsystem.bookings (bookingID, hallID, clientID, date) " +
            "VALUES ('"+booking.getBookingID()+"', '"+booking.getHallID()+"', "+
            " '"+booking.getClientID()+"', '"+booking.getDate()+ "');" );
    }
    public void updatBooking(Booking booking){
        DBManager dbm = new DBManager();
        dbm.executeUpdate("UPDATE bookingsystem.bookings SET " +
            "bookingID='"+booking.getBookingID()+"', hallID='"+booking.getHallID()+"', " +
            " clientID='"+booking.getClientID()+"', date="+booking.getDate()+" " +
            "WHERE bookingID="+booking.getBookingID()+";");
    }
    public void deleteBookingById(String bookingID){
        DBManager dbm = new DBManager();
        dbm.executeUpdate("DELETE FROM bookingsystem.bookings WHERE bookingID='"+bookingID+"';");
    }
    public Booking retrieveBookingById(String bookingID){
     Booking b = null;
     DBManager dbm = new DBManager();
     ResultSet rs = dbm.executeQuery("SELECT * FROM world.city WHERE bookingID='"+bookingID+"';");
     try{
        if(rs.next()){
            b = new Booking();
            b.setBookingID(rs.getString("bookingID"));
            b.setHallID(rs.getString("hallID"));
            b.setClientID(rs.getString("clientID"));
            b.setDate(rs.getString("date"));
            
        }
     }catch(Exception e){
         System.out.println("Error retreiving booking by bookingID "+e);
     }
     return b;
    }
    public ArrayList<Booking> retrieveAllBookings(){
    ArrayList <Booking> bookings=new ArrayList<Booking>();
    DBManager dbm = new DBManager();
    ResultSet rs = dbm.executeQuery("SELECT * FROM bookingsystem.bookings ;");
    try{
      while(rs.next()){
        Booking b =new Booking();
        b.setBookingID(rs.getString("bookingID"));
        b.setHallID(rs.getString("hallID"));
        b.setClientID(rs.getString("clientID"));
        b.setDate(rs.getString("date")); 
        bookings.add(b);
      }
    }catch(Exception e){
      System.out.println("Error retreiving all halls "+e);
    }
    return bookings;
  }
}
