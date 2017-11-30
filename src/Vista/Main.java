/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

/**
 *
 * @author fred_
 */
public class Main {
    public static String dbUser;
    public static String dbPassword;
    public static String userName;
    public static String doctorName;
    public static String doctorId;
    public static String privilege;
    public static String actualTable;
//    public static DBHandler dbh = new DBHandler(user, password);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        new FInicial().setVisible(true);
    }
    
}
