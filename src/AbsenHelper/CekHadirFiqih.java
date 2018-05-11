/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbsenHelper;

import java.awt.Toolkit;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import smartcard1.LoginGuru;
import smartcard1.Menu.MenuDkv;
import smartcard1.MenuCekHadir;
import smartcard1.PilihMapel;

/**
 *
 * @author Haydar Dzaky S
 */
public class CekHadirFiqih extends javax.swing.JFrame {

    /**
     * Creates new form CekHadirFiqih
     */
    public String LessonId = null;
    
    public CekHadirFiqih() {
        this.setUndecorated(true);
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        initComponents();
        ShowData();
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
        
                    int hour = cal.get(Calendar.HOUR);
                    int minute = cal.get(Calendar.MINUTE);
                    int second = cal.get(Calendar.SECOND);
        
                    txtClock.setText(""+hour+":"+minute+":"+second+"");
                    
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
            Logger.getLogger(LoginGuru.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Not Connected ");
            return null;
        }
        
    }
    
    public void getId(){
        
        try {
            Connection con = getConnection();
            PreparedStatement ps;
            ps = con.prepareStatement ("SELECT * FROM TbListLesson WHERE LessonName = 'Fiqih'");
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                LessonId = rs.getString("LessonId");
            }
        } catch (SQLException ex) {
            Logger.getLogger(MenuDkv.class.getName()).log(Level.SEVERE, null, ex);
        }
            
    }
    
    public ArrayList<AbsentFiqih> getAbsentList(){
    
        ArrayList<AbsentFiqih> absentList = new ArrayList<AbsentFiqih>();
            Connection con = getConnection();
            
            final Date c = Calendar.getInstance().getTime();
            final SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String date = df.format(c);
            
            String IdLesson = LessonId;
            
            String sql = "SELECT TbAbsent.AbsentDate, TbAbsent.AbsentTime, TbAbsent.StudentId, TbStudent.StudentName FROM TbAbsent "
                    + "INNER JOIN TbStudent ON TbAbsent.StudentId = TbStudent.StudentId WHERE LessonId='"+IdLesson+"' AND AbsentDate='"+date+"'";
            String query = (sql);
            
            Statement st;
            ResultSet rs;
            
        try {
            
            st = con.createStatement();
            rs = st.executeQuery(query);
            AbsentFiqih absent;
            
            while(rs.next()){
                absent = new AbsentFiqih(rs.getString("StudentId"), rs.getString("StudentName"), rs.getString("AbsentTime"), rs.getString("AbsentDate"));
                
                absentList.add(absent);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CekHadirDkv.class.getName()).log(Level.SEVERE, null, ex);
        }
        return absentList;
        
    }
    
    public void ShowData(){
        
        ArrayList<AbsentFiqih> list = getAbsentList();
        DefaultTableModel model = (DefaultTableModel)TableHadir.getModel();
        
        Object[] row = new Object[4];
        for(int i = 0; i < list.size(); i++){
            row[0] = list.get(i).getStudentId();
            row[1] = list.get(i).getStudent();
            row[2] = list.get(i).getTime();
            row[3] = list.get(i).getDate();
            
            
            model.addRow(row);
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
        jText3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtClock = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableHadir = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/logomss.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 50, 360, 90);

        jText3.setFont(new java.awt.Font("Verdana", 0, 50)); // NOI18N
        jText3.setForeground(new java.awt.Color(255, 255, 255));
        jText3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jText3.setText("Ok");
        jText3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jText3);
        jText3.setBounds(330, 660, 80, 60);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/button.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2);
        jLabel2.setBounds(190, 650, 350, 80);

        txtClock.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        txtClock.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtClock);
        txtClock.setBounds(1080, 680, 240, 40);

        TableHadir.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        TableHadir.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Student Id", "Student Name", "Absent Time", "Absent Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        TableHadir.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(TableHadir);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(190, 162, 1010, 480);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/bgfinl.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(-10, -10, 1380, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        new MenuCekHadir().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel2MouseClicked

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
            java.util.logging.Logger.getLogger(CekHadirFiqih.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CekHadirFiqih.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CekHadirFiqih.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CekHadirFiqih.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CekHadirFiqih().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableHadir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel jText3;
    private javax.swing.JLabel txtClock;
    // End of variables declaration//GEN-END:variables
}
