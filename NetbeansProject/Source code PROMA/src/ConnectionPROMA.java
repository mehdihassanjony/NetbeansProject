/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 9589693153
 */
import java.sql.*;
import javax.swing.*;
public class ConnectionPROMA {
    
     Connection conn= null;
    public static Connection ConnecrDb(){
    
    try{
    Class.forName("org.sqlite.JDBC");
    Connection conn =DriverManager.getConnection("jdbc:sqlite:Proma.db");
    //JOptionPane.showMessageDialog(null, "Connection Established");C:\Users\9589693153\Documents\NetBeansProjects\PROMA
    return conn;
       }catch (Exception e){
           JOptionPane.showMessageDialog(null, e);
       return null;
       
       }
    
    }
    
}
//Class.forName("org.sqlite.JDBC");
//cn=DriverManager.getConnection("jdbc:sqlite:c:/SQlite/PromaLG.db");
//st = cn.createStatement();