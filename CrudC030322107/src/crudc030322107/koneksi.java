/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crudc030322107;

/**
 *
 * @author AsaPratama
 */
import java.sql.*;
import javax.swing.JOptionPane;

public class koneksi {
    Connection conn;
    public static Connection BukaKoneksi(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/db_pbo", "root", "");
            return conn;
    }catch (Exception e){
        JOptionPane.showMessageDialog(null, e);
        return null;
    }
        
    }
            
}
