/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartcard1.Menu;

import java.awt.Toolkit;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import static smartcard1.Menu.MenuDkv.LessonIdDkv;
import static smartcard1.Menu.MenuDkv.ScheduleIdDkv;
import static smartcard1.Menu.MenuDkv.TeacherIdDkv;
import smartcard1.PilihMapel;

/**
 *
 * @author Haydar Dzaky S
 */
public class MenuFiqih extends javax.swing.JFrame {

    /**
     * Creates new form MenuFiqih
     */
    public static String ScheduleIdFiqih = null;
    public static String TeacherIdFiqih = null;
    public static String LessonIdFiqih = null;
    
    public MenuFiqih() {
        this.setUndecorated(true);
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        
        initComponents();
        data();
        clock();
        
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xsize = (int) tk.getScreenSize().getWidth();
        int ysize = (int) tk.getScreenSize().getHeight();
        
        this.setSize(xsize, ysize);
    }
    
    public void clock(){
        
        Thread clock = new Thread(){
            
            public void run(){
                
                try{
                    for(;;){
                    Calendar cal = new GregorianCalendar();
                    
                    int day = cal.get(Calendar.DAY_OF_MONTH);
                    int month = cal.get(Calendar.MONTH);
                    int year = cal.get(Calendar.YEAR);
                    
                    int hour = cal.get(Calendar.HOUR);
                    int minute = cal.get(Calendar.MINUTE);
                    int second = cal.get(Calendar.SECOND);
        
                    txtDate.setText("Date: "+day+":"+month+":"+year+"");
                    txtTime.setText("Time: "+hour+":"+minute+":"+second+"");
                    
                    sleep(100);
                    }
                } catch(InterruptedException e) {
                    //TODO Auto-generated catch block
                    e.printStackTrace();
                    
                }
                
        }
            
        };
        
        clock.start();
        
    }
    
    public Connection getConnection(){
        
        Connection con = null;
        
        try {
            con = DriverManager.getConnection("jdbc:mysql://103.28.13.26:3306/aris_UbkSantri", "aris_UbkSantri", "MyJava17");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(MenuDkv.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Not Connected");
            return null;
        }
        
    }
    
    public void data(){
        
        try {
            Calendar c = Calendar.getInstance();    
            int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
            
            Connection con = getConnection();
            String sql = "SELECT TbSchedule.LessonId, TbSchedule.ScheduleStart, TbSchedule.ScheduleEnd, TbSchedule.ScheduleId, TbListLesson.LessonName, TbListLesson.TeacherName, TbTeacher.TeacherId "
                    + "FROM TbSchedule LEFT JOIN TbListLesson ON TbSchedule.LessonId = TbListLesson.LessonId"
                    + " LEFT JOIN TbTeacher ON TbListLesson.TeacherName = TbTeacher.TeacherName "
                    + "WHERE TbListLesson.LessonName = 'Fiqih' AND TbSchedule.ScheduleDayNum="+dayOfWeek+"";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                String mLessonId = rs.getString("LessonId");
                String mLesson = rs.getString("LessonName");
                mLessonId = mLesson;
                txtLesson.setText(mLessonId);
                
                String mUstad = rs.getString("TeacherName");
                txtUstad.setText(mUstad);
                
                String mStart = rs.getString("ScheduleStart");
                txtStart.setText(mStart);
                
                String mEnd = rs.getString("ScheduleEnd");
                txtEnd.setText(mEnd);
                
                ScheduleIdFiqih = rs.getString("ScheduleId");
                LessonIdFiqih = rs.getString("LessonId");
                
                String mUstad1 = rs.getString("TeacherName");
                String TeacherId = rs.getString("TeacherId");
                mUstad1 = TeacherId;
                TeacherIdFiqih = mUstad1;
                
                
            }
            
            
            
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
        jText1 = new javax.swing.JLabel();
        btnAbsen = new javax.swing.JLabel();
        txtClock = new javax.swing.JLabel();
        jText3 = new javax.swing.JLabel();
        jText2 = new javax.swing.JLabel();
        txtClock1 = new javax.swing.JLabel();
        jText4 = new javax.swing.JLabel();
        btnAbsen1 = new javax.swing.JLabel();
        txtDate = new javax.swing.JLabel();
        txtLesson = new javax.swing.JLabel();
        txtEnd = new javax.swing.JLabel();
        txtUstad = new javax.swing.JLabel();
        txtStart = new javax.swing.JLabel();
        txtTime = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/logomss.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 40, 350, 110);

        jText1.setFont(new java.awt.Font("Verdana", 0, 40)); // NOI18N
        jText1.setForeground(new java.awt.Color(255, 255, 255));
        jText1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jText1.setText("Start Absent !");
        jText1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jText1);
        jText1.setBounds(960, 620, 290, 60);

        btnAbsen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/button.png"))); // NOI18N
        btnAbsen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAbsenMouseClicked(evt);
            }
        });
        getContentPane().add(btnAbsen);
        btnAbsen.setBounds(920, 610, 350, 90);

        txtClock.setFont(new java.awt.Font("Verdana", 0, 50)); // NOI18N
        txtClock.setForeground(new java.awt.Color(255, 255, 255));
        txtClock.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtClock.setText("End:");
        txtClock.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(txtClock);
        txtClock.setBounds(90, 470, 118, 60);

        jText3.setFont(new java.awt.Font("Verdana", 0, 50)); // NOI18N
        jText3.setForeground(new java.awt.Color(255, 255, 255));
        jText3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jText3.setText("Teacher:");
        jText3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jText3);
        jText3.setBounds(90, 330, 230, 60);

        jText2.setFont(new java.awt.Font("Verdana", 0, 50)); // NOI18N
        jText2.setForeground(new java.awt.Color(255, 255, 255));
        jText2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jText2.setText("Lesson:");
        jText2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jText2);
        jText2.setBounds(90, 260, 200, 60);

        txtClock1.setFont(new java.awt.Font("Verdana", 0, 50)); // NOI18N
        txtClock1.setForeground(new java.awt.Color(255, 255, 255));
        txtClock1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtClock1.setText("Start:");
        txtClock1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(txtClock1);
        txtClock1.setBounds(90, 400, 148, 60);

        jText4.setFont(new java.awt.Font("Verdana", 0, 40)); // NOI18N
        jText4.setForeground(new java.awt.Color(255, 255, 255));
        jText4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jText4.setText("Main Menu");
        jText4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jText4);
        jText4.setBounds(140, 670, 220, 70);

        btnAbsen1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/button.png"))); // NOI18N
        btnAbsen1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAbsen1MouseClicked(evt);
            }
        });
        getContentPane().add(btnAbsen1);
        btnAbsen1.setBounds(70, 660, 350, 90);

        txtDate.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        txtDate.setForeground(new java.awt.Color(255, 255, 255));
        txtDate.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtDate.setText("Date:");
        txtDate.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(txtDate);
        txtDate.setBounds(1010, 30, 340, 60);

        txtLesson.setFont(new java.awt.Font("Verdana", 0, 50)); // NOI18N
        txtLesson.setForeground(new java.awt.Color(255, 255, 255));
        txtLesson.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtLesson.setText("unavailable");
        txtLesson.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(txtLesson);
        txtLesson.setBounds(320, 260, 300, 60);

        txtEnd.setFont(new java.awt.Font("Verdana", 0, 50)); // NOI18N
        txtEnd.setForeground(new java.awt.Color(255, 255, 255));
        txtEnd.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtEnd.setText("unavailable");
        txtEnd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(txtEnd);
        txtEnd.setBounds(320, 470, 400, 60);

        txtUstad.setFont(new java.awt.Font("Verdana", 0, 50)); // NOI18N
        txtUstad.setForeground(new java.awt.Color(255, 255, 255));
        txtUstad.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtUstad.setText("unavailable");
        txtUstad.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(txtUstad);
        txtUstad.setBounds(320, 330, 350, 60);

        txtStart.setFont(new java.awt.Font("Verdana", 0, 50)); // NOI18N
        txtStart.setForeground(new java.awt.Color(255, 255, 255));
        txtStart.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtStart.setText("unavailable");
        txtStart.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(txtStart);
        txtStart.setBounds(320, 400, 370, 60);

        txtTime.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        txtTime.setForeground(new java.awt.Color(255, 255, 255));
        txtTime.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txtTime.setText("Time:");
        txtTime.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(txtTime);
        txtTime.setBounds(1010, 90, 340, 60);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/bgfinl.png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(-10, -10, 1380, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAbsenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAbsenMouseClicked
        // TODO add your handling code here:
        //new AbsenDkv().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAbsenMouseClicked

    private void btnAbsen1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAbsen1MouseClicked
        // TODO add your handling code here:
        new PilihMapel().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnAbsen1MouseClicked

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
            java.util.logging.Logger.getLogger(MenuFiqih.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuFiqih.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuFiqih.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuFiqih.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuFiqih().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnAbsen;
    private javax.swing.JLabel btnAbsen1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jText1;
    private javax.swing.JLabel jText2;
    private javax.swing.JLabel jText3;
    private javax.swing.JLabel jText4;
    private javax.swing.JLabel txtClock;
    private javax.swing.JLabel txtClock1;
    private javax.swing.JLabel txtDate;
    private javax.swing.JLabel txtEnd;
    private javax.swing.JLabel txtLesson;
    private javax.swing.JLabel txtStart;
    private javax.swing.JLabel txtTime;
    private javax.swing.JLabel txtUstad;
    // End of variables declaration//GEN-END:variables
}
