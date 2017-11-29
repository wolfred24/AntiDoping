/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.DBConection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author fred_
 */
public class DBHandler {
    
    DBConection dbc;
    
    Connection con;
    Statement stmnt;
    ResultSet RS = null;
    ResultSetMetaData rsmd = null;
    static String user;
    static String password;
    boolean status;
    
    public DBHandler(String user, String password) {
         dbc = new DBConection(user, password);
         con = dbc.getConection();
    }
    
    public boolean getStatus(){
        return dbc.getStatus();
    }

    
    public ResultSet getColumnNames(){
        dbc.conect();
        
        try {
            stmnt = con.createStatement();
            RS = stmnt.executeQuery("Describe producto;");
            rsmd = RS.getMetaData();
            while(RS.next())
            System.out.println(RS.getString(1));
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return RS;
    }
    
        public ResultSet getValues(String query){
        String[] valores;
        dbc.conect();
        try{
            stmnt = con.createStatement();
            RS = stmnt.executeQuery(query);
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        return RS;
    }
    
        public boolean login(String user, String password){
        String[] valores;
        boolean result = false;
        dbc.conect();
        try{
            stmnt = con.createStatement();
            RS = stmnt.executeQuery("SELECT userName, permisos FROM Medicos WHERE userName='"+user+"' AND password='"+password+"'");
            result = RS.first();
            //Main.privileges = RS.
            System.out.println(RS.first());
        } catch(SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    
    /*public static void main(String[] args) {
        BaseDatos BD = new BaseDatos();
        BD.getColumnNames();
    }*/
}
