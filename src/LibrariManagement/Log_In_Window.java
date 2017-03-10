/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LibrariManagement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Biplob
 */
public class Log_In_Window extends javax.swing.JFrame {

    /**
     * Creates new form Log_In_Window
     */
    public Log_In_Window() {
        initComponents();
        windowProfile();
        try {
            this.setIconImage(ImageIO.read(new File("resources\\library.png")));
        } catch (IOException ex) {
            Logger.getLogger(MainWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    private Image scaledImg(byte[] img, int w, int h) {
        BufferedImage resizImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        try {
            Graphics2D g2 = resizImg.createGraphics();
            g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
            // CONVERT BYTE ARRAY   BACK TO    bufffereg images 
            ByteArrayInputStream in = new ByteArrayInputStream(img);
            BufferedImage bImageFormConvert = ImageIO.read(in);

            g2.drawImage(bImageFormConvert, 0, 0, w, h, null);
            g2.dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
        return resizImg;
    }
    public void windowProfile() {
        Toolkit tolkit = this.getToolkit();
        Dimension winSize = tolkit.getScreenSize();

        this.setLocation(winSize.width / 4, winSize.height / 4);
        this.setResizable(false);
    }
    String gt_email;
    MainWindow uf = new MainWindow();

    void logInMethod() {

        try {
            byte[] imageData1 = null;
            gt_email = tf_userName.getText();
            String get_pass = pf_passWord.getText();
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/library_managment", "root", "apcl123456");
            PreparedStatement pst = con.prepareStatement("select * from login_table where Email ='"+gt_email+"';");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                if (gt_email.equals(rs.getString(5)) && get_pass.equals(rs.getString(4))) {
                    //MainWindow uf = new MainWindow();
                    uf.lbl_logger_name_show.setText(gt_email);
//                    imageData1 = rs.getBytes("user_picture");
//                    ImageIcon formate = new ImageIcon(scaledImg(imageData1, uf.lbl_show_logger_img.getWidth(), uf.lbl_show_logger_img.getHeight()));
//                    uf.lbl_show_logger_img.setIcon(formate);

                    if (!gt_email.equals("Admin") && !get_pass.equals("Admin")) {
                        //MainWindow mw = new MainWindow();
                        uf.btn_add_book.setEnabled(false);
                        uf.btn_update.setEnabled(false);
                        uf.btn_delete.setEnabled(false);
                        uf.btn_isubk.setEnabled(false);
                        uf.btn_isuback.setEnabled(false);
                        uf.cbx_bk_ctagry.setEditable(false);
                        uf.btn_showAll_users.setEnabled(false);
                        uf.btn_show_Aii_issue.setEnabled(false);
                        uf.btn_report_book.setEnabled(false);
                        
                    }
                    uf.setVisible(true);
                    this.dispose();

                }

            }
            
            PreparedStatement psts = con.prepareStatement("select user_picture from login_table where Email ='"+gt_email+"';");
            ResultSet rss = pst.executeQuery();
            while(rss.next()){
               imageData1 = rss.getBytes("user_picture");
               ImageIcon formate = new ImageIcon(scaledImg(imageData1, uf.lbl_show_logger_img.getWidth(), uf.lbl_show_logger_img.getHeight()));
               uf.lbl_show_logger_img.setIcon(formate);
                
            }
                

            if (!uf.isVisible()) {
                JOptionPane.showMessageDialog(null, "Enter Valid Email And Password Please !! \n\t  Are You Registerd Mumber?");
            }

            pst.close();

        } catch (SQLException e) {
            System.err.println("SQL EXC ..");
        } catch (NullPointerException ex) {
            System.err.println("NULL");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Log_In_Window.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tf_userName = new javax.swing.JTextField();
        pf_passWord = new javax.swing.JPasswordField();
        btn_logIn = new javax.swing.JButton();
        btn_clr = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbl_signIn = new javax.swing.JLabel();
        lbl_valid = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Log In Window\n");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBackground(new java.awt.Color(98, 26, 74));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Email  :");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("PassWord :");

        tf_userName.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tf_userNameFocusLost(evt);
            }
        });
        tf_userName.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tf_userNameKeyReleased(evt);
            }
        });

        btn_logIn.setText("Log In");
        btn_logIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_logInActionPerformed(evt);
            }
        });

        btn_clr.setText("Clear");
        btn_clr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_clrActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(204, 204, 255));
        jLabel3.setText("You Don't Have an Account ?");

        jLabel4.setFont(new java.awt.Font("Monotype Corsiva", 0, 26)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Welcome to knowledge world ");

        jLabel5.setFont(new java.awt.Font("Monotype Corsiva", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 204, 204));
        jLabel5.setText("\"Civilian's Library \"");

        jLabel6.setFont(new java.awt.Font("Monotype Corsiva", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 102));
        jLabel6.setText("Developed By ");

        jLabel7.setFont(new java.awt.Font("MV Boli", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 204, 204));

        jLabel8.setFont(new java.awt.Font("Monotype Corsiva", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(204, 204, 255));
        jLabel8.setText("Hasan Mobarak");

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/LibrariManagement/logo.png"))); // NOI18N

        lbl_signIn.setForeground(new java.awt.Color(204, 204, 204));
        lbl_signIn.setText(" Click And Sign In.");
        lbl_signIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lbl_signIn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_signInMouseClicked(evt);
            }
        });

        lbl_valid.setBackground(new java.awt.Color(82, 10, 39));
        lbl_valid.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel6))
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(130, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_signIn))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_logIn)
                                .addGap(33, 33, 33)
                                .addComponent(btn_clr, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tf_userName)
                                .addComponent(pf_passWord, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(25, 25, 25)
                .addComponent(lbl_valid, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(tf_userName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_valid, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(pf_passWord, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_logIn)
                    .addComponent(btn_clr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lbl_signIn))
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_logInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_logInActionPerformed

        logInMethod();


    }//GEN-LAST:event_btn_logInActionPerformed

    private void lbl_signInMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbl_signInMouseClicked
        User_info uf = new User_info();
        uf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_lbl_signInMouseClicked

    private void btn_clrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_clrActionPerformed
        tf_userName.setText("");
        pf_passWord.setText("");
    }//GEN-LAST:event_btn_clrActionPerformed

    private void tf_userNameKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tf_userNameKeyReleased
        // TODO add Email validation :
        String get_txt = tf_userName.getText();
        String get_v ="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$" ;
        if(!get_txt.matches(get_v)){
            lbl_valid.setText("email is not valid");
            lbl_valid.setForeground(Color.pink);
        }else {
            lbl_valid.setText("email is valid");
            lbl_valid.setForeground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_tf_userNameKeyReleased

    private void tf_userNameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tf_userNameFocusLost
        // TODO add your handling code here:
        lbl_valid.setText("");
    }//GEN-LAST:event_tf_userNameFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Log_In_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Log_In_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Log_In_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Log_In_Window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Log_In_Window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_clr;
    private javax.swing.JButton btn_logIn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbl_signIn;
    private javax.swing.JLabel lbl_valid;
    private javax.swing.JPasswordField pf_passWord;
    public javax.swing.JTextField tf_userName;
    // End of variables declaration//GEN-END:variables
}
