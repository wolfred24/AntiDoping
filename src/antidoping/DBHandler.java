
package antidoping;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/** @author fred_ */
public class DBHandler {
    Connection con = null;
    Statement stmnt = null;
    ResultSet RS = null;
    ResultSetMetaData rsmd = null;
    static String user;
    static String password;
    boolean status;
    
    public DBHandler(String user, String password){
        this.user = user;
        this.password = password;
        conect();
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
                    Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public ResultSet getColumnNames(){
        conect();
        
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
        conect();
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
        conect();
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
