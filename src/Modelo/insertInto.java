
package Modelo;

import Controlador.DBConection;
import static Vista.Main.dbPassword;
import static Vista.Main.dbUser;
import java.sql.SQLException;


public class insertInto {
     
    DBConection con = new DBConection(dbUser,dbPassword);
    
      //----------jimmy------------------isertar doctor 
        public String nmedico;
        public String uname;
        public String pass;
        public int permit;
        //----------miriam------------------isertar drogas
         public String nombre;
         //----------miriam------------------isertar empresas 
          public String nempresa;
        public String domicilio;
        public String rfc;
         public String colonia;
        
         public void insertar(){
        
         try { 
                 con.conect();
      
     con.stmnt= con.con.createStatement();
      //stmnt = con.createStatement();
                  
                  con.stmnt.executeUpdate/*inser delete update*/("INSERT INTO medicos VALUES ('"+0+"','"+nmedico+"','"+uname+"','"+pass+"','"+permit+"')"); 

                  System.out.println("Los valores han sido agregados a la base de datos "); 
                  } 
                  catch( SQLException e ) { 
                      e.printStackTrace(); 
                  } 
  
              finally { 
                  if ( con != null ) { 
                      try    { 
                          con.close(); 
                          con.stmnt.close(); 
                      } catch( Exception e ) { 
                          System.out.println( e.getMessage()); 
                      } 
                  }}
         
        }
         public void insertardroga(){
         DBConection con = new DBConection(dbUser,dbPassword);
    
      //----------miriam------------------isertar droga 
       
      
        
         try { 
                 con.conect();
      
     con.stmnt= con.con.createStatement();
      //stmnt = con.createStatement();
                  
                  con.stmnt.executeUpdate/*inser delete update*/("INSERT INTO drogas VALUES ('"+0+"','"+nombre+"')"); 

                  System.out.println("Los valores han sido agregados a la base de datos "); 
                  } 
                  catch( SQLException e ) { 
                      e.printStackTrace(); 
                  } 
  
              finally { 
                  if ( con != null ) { 
                      try    { 
                          con.close(); 
                          con.stmnt.close(); 
                      } catch( Exception e ) { 
                          System.out.println( e.getMessage()); 
                      } 
                  }}
         
        }
        
         public void insertarempresa(){
         DBConection con = new DBConection(dbUser,dbPassword);
    
      //----------miriam------------------isertar empresa 
       
      
        
         try { 
                 con.conect();
      
     con.stmnt= con.con.createStatement();
      //stmnt = con.createStatement();
                  
                  con.stmnt.executeUpdate/*inser delete update*/("INSERT INTO empresas VALUES ('"+0+"','"+nempresa+"','"+domicilio+"','"+rfc+"','"+colonia+"')"); 

                  System.out.println("Los valores han sido agregados a la base de datos "); 
                  } 
                  catch( SQLException e ) { 
                      e.printStackTrace(); 
                  } 
  
              finally { 
                  if ( con != null ) { 
                      try    { 
                          con.close(); 
                          con.stmnt.close(); 
                      } catch( Exception e ) { 
                          System.out.println( e.getMessage()); 
                      } 
                  }}
         
        }
}   
         

     

