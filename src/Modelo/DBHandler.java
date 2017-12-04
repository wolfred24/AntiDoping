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
import javax.swing.JOptionPane;

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
    String user;
    String password;
    boolean status;

    public DBHandler() {
        dbc = new DBConection();
        con = dbc.getConection();
    }
    
    
    
    public DBHandler(String user, String password) {
         dbc = new DBConection(user, password);
         con = dbc.getConection();
    }
    
    public boolean getStatus(){
        return dbc.getStatus();
    }

    
    public String[] getColumnNames(String tableName){
        dbc.conect();
        int count = 0;
        
        
        try {
            stmnt = con.createStatement();
            RS = stmnt.executeQuery("SELECT * FROM "+tableName);
            ResultSetMetaData metaData = RS.getMetaData();
            rsmd = RS.getMetaData();
            count = metaData.getColumnCount();
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String columnName[] = new String[count];
        for (int i = 1; i <= count; i++) {
            try {
                columnName[i - 1] = rsmd.getColumnLabel(i);
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(columnName[i - 1]);
        }
        return columnName;
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
        
        public boolean update(String query){
            dbc.conect();
            boolean flag = false;
        try {
            stmnt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            flag = true;
            JOptionPane.showMessageDialog(null,"Tipo de valor introducido incorrecto");
            return flag;
        }
        return flag;
        }
        
        public void deleteRow(String table, String column, String value){
            dbc.conect();
        try {
            System.out.println("entro");
            
            stmnt.executeUpdate("DELETE FROM "+table+" WHERE "+column+"='"+value+"'");
            System.out.println(table+" "+column+" "+value);
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
        public ResultSet login(String user, String password){
        String[] valores;
        boolean result = false;
        dbc.conect();
        try{
            stmnt = con.createStatement();
            RS = stmnt.executeQuery("SELECT idMedico, nameMedico, userName, permisos FROM Medicos WHERE userName='"+user+"' AND password='"+password+"'");
            result = RS.first();
            //Main.privileges = RS.
            System.out.println(RS.first());
        } catch(SQLException e){
            e.printStackTrace();
        }
        return RS;
    }
        
       public void insertDonante(String name, String licen, String fecha, int genero, String empresa) {
        try {
            dbc.conect();

            stmnt = con.createStatement();

            stmnt.executeUpdate("INSERT INTO donantes VALUES ('" + 0 + "','" + name + "','" + licen + "','" + fecha + "','"
                    + genero + "',(select idempresa from empresas where nameempresa='" + empresa + "'))");
            JOptionPane.showMessageDialog(null, "Los valores han sido agregados a la base de datos");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                    stmnt.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }

    }
       
       public void insertarMedico(String nmedico, String uname, String pass, int permit) {

        try {
            dbc.conect();

            stmnt = con.createStatement();

            stmnt.executeUpdate/*inser delete update*/("INSERT INTO medicos VALUES ('" + 0 + "','" +
                    nmedico + "','" + uname + "','" + pass + "','" + permit + "')");
            JOptionPane.showMessageDialog(null, "Los valores han sido agregados a la base de datos");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (con != null) {
                try {
                    con.close();
                    stmnt.close();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }

    }

    
    /*public static void main(String[] args) {
        BaseDatos BD = new BaseDatos();
        BD.getColumnNames();
    }*/
}
