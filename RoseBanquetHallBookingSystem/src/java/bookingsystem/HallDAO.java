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
public class HallDAO{
  public void createHall(Hall hall){
    DBManager dbm=new DBManager();
    dbm.executeUpdate("INSERT INTO bookingsystem.halls(hallID,hallName)" +
    "VALUES('"+hall.getHallID()+"', '"+hall.getHallName()+"');");

  }
  public void updatHall(Hall hall){
      DBManager dbm = new DBManager();
      dbm.executeUpdate("UPDATE bookingsystem.halls SET " +
          "hallID='"+hall.getHallID()+"', hallName='"+hall.getHallName()+
          "WHERE hallID="+hall.getHallID()+";");
  }
  public void deleteHallById(String hallID){
      DBManager dbm = new DBManager();
      dbm.executeUpdate("DELETE FROM bookingsystem.halls WHERE hallID='"+hallID+"';");
  }
  public Hall retrieveHallById(String hallID){
    Hall h=null;
    DBManager dbm= new DBManager();
    ResultSet rs =dbm.executeQuery("SELECT * FROM bookingsystem.halls WHERE hallID='"+hallID+"';");
    try{
      if(rs.next()){
        h = new Hall();
        h.setHallID(rs.getString("hallID"));
        h.setHallName(rs.getString("hallName"));

      }
    }catch(Exception e){
      System.out.println("Error retreiving hall by id "+e);

    }return h;
  }
  public ArrayList<Hall> retrieveAllHalls(){
    ArrayList <Hall> halls=new ArrayList<Hall>();
    DBManager dbm = new DBManager();
    ResultSet rs = dbm.executeQuery("SELECT * FROM bookingsystem.halls ;");
    try{
      while(rs.next()){
        Hall h =new Hall();
        h.setHallID(rs.getString("hallID"));
        h.setHallName(rs.getString("hallName"));
        halls.add(h);
      }
    }catch(Exception e){
      System.out.println("Error retreiving all halls "+e);
    }
    return halls;
  }

}
