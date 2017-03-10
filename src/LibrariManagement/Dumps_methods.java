package LibrariManagement;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author APCL
 */
public class Dumps_methods {
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    String connect = "jdbc:mysql://localhost:3306/";
    String schema = "library_managment";
    String user = "root";
    String DBpss = "apcl123456";
    
    public int auto_incres_bookIsu_ID(){
        MainWindow mm = new MainWindow();
        mm.tf_bk_isu_id.setBackground(Color.red);
        int iss_id = 0;
        try {
            con = DriverManager.getConnection(connect + schema, user, DBpss);
            String sqlS = "select max(book_issu_id) from issue_book;";
            pst = con.prepareStatement(sqlS);
            rs = pst.executeQuery();
            if(rs.next()){
                 iss_id = rs.getInt(1);
            }else{
                System.out.println("isuu id not found");
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(mm, e);
        }
        return ++iss_id;
    }
}
