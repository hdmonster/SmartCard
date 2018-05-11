/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MenuAbsen;

import static MenuAbsen.AbsenDkv.IdSCDKV;
import static MenuAbsen.AbsenFiqih.IdSCFiqih;
import static MenuAbsen.AbsenQcb.IdSCQCB;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import smartcard1.LoginGuru;
import static smartcard1.Menu.MenuFiqih.LessonIdFiqih;
import static smartcard1.Menu.MenuFiqih.ScheduleIdFiqih;
import static smartcard1.Menu.MenuFiqih.TeacherIdFiqih;
import static smartcard1.Menu.MenuQcb.LessonIdQcb;
import static smartcard1.Menu.MenuQcb.ScheduleIdQcb;
import static smartcard1.Menu.MenuQcb.TeacherIdQcb;
import smartcard1.PilihMapel;

/**
 *
 * @author Haydar Dzaky S
 */
public class FinalQcb extends javax.swing.JFrame {

    /**
     * Creates new form FinalQcb
     */
    public String SantriId = null;
    public static String IdQcb = null;
    
    public FinalQcb() {
        this.setUndecorated(true);
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        initComponents();
        data();
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight();
        
        this.setSize(xsize, ysize);
    }
    
    public Connection getConnection(){
        
        Connection con = null;
            
        try {
            con = DriverManager.getConnection("jdbc:mysql://103.28.13.26:3306/aris_UbkSantri", "aris_UbkSantri", "MyJava17");
            return con;
            
        } catch (SQLException ex) {
            Logger.getLogger(LoginGuru.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Not Connected ");
            return null;
        }
        
    }
    
    public void data(){
        
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement ("SELECT * FROM TbStudent WHERE StudentSmartCard = '" +IdSCQCB+ "'");
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                String mSantr = rs.getString("StudentName");
                mSantri.setText(mSantr);
                String mKelass = rs.getString("StudentClass");
                mKelas.setText(mKelass);
                
                SantriId = rs.getString("StudentId");
                
                
                byte[] img = rs.getBytes("StudentPhoto");
                ImageIcon image = new ImageIcon(img);
                Image im = image.getImage();
                Image myImage = im.getScaledInstance(mPic.getWidth(), mPic.getHeight(), Image.SCALE_SMOOTH);
                ImageIcon newImage = new ImageIcon(myImage);
                mPic.setIcon(newImage);
            }
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PilihMapel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public void sendAbsen(){
        
        String StudentId = SantriId;
        String status = "Attended";
        String info = "add info";
        
        try {
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement ("INSERT INTO TbAbsent(StudentId, ScheduleId, TeacherId, LessonId, AbsentDate, AbsentTime, AbsentStatus, AbsentInformation) VALUES (?,?,?,?,?,?,?,?);");
            
            
            ps.setString(1, StudentId);
            ps.setString(2, ScheduleIdQcb);
            ps.setString(3, TeacherIdQcb);
            ps.setString(4, LessonIdQcb);
            
            final Date c = Calendar.getInstance().getTime();
            final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String date = df.format(c);
            ps.setString(5, date);
            
            final DateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            Date Time = new Date();
            String time = sdf.format(Time);
            ps.setString(6, time);
            
            ps.setString(7, status);
            
            ps.setString(8, info);
            
            ps.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PilihMapel.class.getName()).log(Level.SEVERE, null, ex);
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

        jLabel1 = new javax.swing.JLabel();
        mSantri = new javax.swing.JLabel();
        mKelas = new javax.swing.JLabel();
        jText4 = new javax.swing.JLabel();
        btnContinue = new javax.swing.JLabel();
        mPic = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/logomss.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 50, 350, 90);

        mSantri.setFont(new java.awt.Font("Verdana", 0, 50)); // NOI18N
        mSantri.setForeground(new java.awt.Color(255, 255, 255));
        mSantri.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mSantri.setText("Santri");
        mSantri.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(mSantri);
        mSantri.setBounds(520, 450, 330, 60);

        mKelas.setFont(new java.awt.Font("Verdana", 0, 50)); // NOI18N
        mKelas.setForeground(new java.awt.Color(255, 255, 255));
        mKelas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        mKelas.setText("Kelas");
        mKelas.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(mKelas);
        mKelas.setBounds(520, 530, 330, 60);

        jText4.setFont(new java.awt.Font("Verdana", 0, 50)); // NOI18N
        jText4.setForeground(new java.awt.Color(255, 255, 255));
        jText4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jText4.setText("Continue");
        jText4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jText4);
        jText4.setBounds(570, 630, 240, 60);

        btnContinue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/button.png"))); // NOI18N
        btnContinue.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnContinueMouseClicked(evt);
            }
        });
        getContentPane().add(btnContinue);
        btnContinue.setBounds(510, 620, 350, 90);
        getContentPane().add(mPic);
        mPic.setBounds(590, 220, 200, 210);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/bgfinl.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(-10, -10, 1380, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnContinueMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnContinueMouseClicked
        // TODO add your handling code here:
        sendAbsen();
        new AbsenQcb().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnContinueMouseClicked

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FinalQcb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FinalQcb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FinalQcb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FinalQcb.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FinalQcb().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnContinue;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jText4;
    private javax.swing.JLabel mKelas;
    private javax.swing.JLabel mPic;
    private javax.swing.JLabel mSantri;
    // End of variables declaration//GEN-END:variables
}
