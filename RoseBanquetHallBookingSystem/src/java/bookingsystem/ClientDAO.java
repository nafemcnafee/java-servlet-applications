/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingsystem;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author nafe
 */
public class ClientDAO {
    public void createClient(Client client){
        DBManager dbm=new DBManager();
        dbm.executeUpdate("INSERT INTO bookingsystem.clients (clientID, clientName, creditCard)" +
            "VALUES ('"+client.getClientID()+"', '"+client.getClientName()+"', "
                +" '"+client.getCreditCard()+ "');" );
    }
    public void updateClient(Client client){
        DBManager dbm=new DBManager();
        dbm.executeUpdate("UPDATE bookingsystem.clients SET " +
            "clientID='"+client.getClientID()+"', clientName='"+client.getClientName()+"', " +
            "creditCard='"+client.getCreditCard()+"';");
    }
    public void deleteClientById(String clientID){
        DBManager dbm = new DBManager();
        dbm.executeUpdate("DELETE FROM bookngsystem.clients WHERE clientID='"+clientID+"';");
    }
    public Client retrieveClientById(String clientID){
        Client c = null;
        DBManager dbm = new DBManager();
        ResultSet rs = dbm.executeQuery("SELECT * FROM bookingsystem.clients WHERE clientID='"+clientID+"';");
        try{
            if(rs.next()){
            c = new Client();
            c.setClientID(rs.getString("clientID"));
            c.setClientName(rs.getString("clientName"));
            c.setCreditCard(rs.getString("creditCard"));                     
            }
        }catch(Exception e){
            System.out.println("Error retreiving client by clientID "+e);
        }
        return c;
    }
    public ArrayList<Client> retrieveAllClients(){
        ArrayList <Client> clients = new ArrayList<Client>();
        DBManager dbm = new DBManager();
        ResultSet rs = dbm.executeQuery("SELECT * FROM bookingsystem.clients ;");
        try{
            while(rs.next()){
                Client c = new Client();
                c.setClientID(rs.getString("clientID"));
                c.setClientName(rs.getString("clientName"));
                c.setCreditCard(rs.getString("creditCard"));     
                clients.add(c);
            }
        }catch(Exception e){
            System.out.println("Error retreiving all clients "+e);
        }
        return clients;
    }
}
