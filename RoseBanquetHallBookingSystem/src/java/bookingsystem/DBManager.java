/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingsystem;

import java.sql.*;

/**
 *
 * @author nafe
 */
public class DBManager {
    String conn="jdbc:mysql://localhost:3306/bookingsystem";
    String user="root";
    String pass="dbpass";
    public static Connection con=null;
    
    public Connection getConnection(){
        if(DBManager.con == null){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                DBManager.con = DriverManager.getConnection(conn,user, pass);
                
            }catch(Exception e){
                System.out.println("Error in getting connection: "+e);
            }
        }
        return DBManager.con;
    }
    public int executeUpdate(String sql){
        int result=0;
        try{
            Connection con=getConnection();
            if(con != null){
                Statement st=con.createStatement();
                result=st.executeUpdate(sql);
            }
        }catch(Exception e){
            System.out.println("Error executing update "+sql+": "+e);
        }
        return result;
    }
    public ResultSet executeQuery(String sql){
        ResultSet rs=null;
        try{
            Connection con=getConnection();
            if(con!=null){
                Statement st=con.createStatement();
                rs=st.executeQuery(sql);
            }
        }catch(Exception e){
            System.out.println("Error executing query '"+sql+"': "+e);
        }
            return rs;
        }
}

