
package Controlador;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/** @author fred_ */
public class DBConection {
    Connection con = null;
    Statement stmnt = null;
    ResultSet RS = null;
    ResultSetMetaData rsmd = null;
    static String user;
    static String password;
    boolean status;
    
    public DBConection(String user, String password){
        this.user = user;
        this.password = password;
        conect();
    }
    
    public Connection getConection(){
        return con;
    }
    
    public boolean getStatus(){
        return status;
    }
    
    public void conect(){
        try{
            String url = "jdbc:mysql://localhost:3306/antidoping";
//            String user = user;
//            String password = "root";
            try {
                try {
                    Class.forName("com.mysql.jdbc.Driver").newInstance();
                } catch (InstantiationException ex) {
                    Logger.getLogger(DBConection.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(DBConection.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DBConection.class.getName()).log(Level.SEVERE, null, ex);
            }
            con = DriverManager.getConnection(url, this.user, this.password);
            
            if(con != null){
                System.out.println("se a establecido una conexion a la base de datos \n"+
                        url);
                status = true;
            }
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void close(){
        if(con != null){
            try{
                con.close();
                stmnt.close();
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
    
    
    
}
