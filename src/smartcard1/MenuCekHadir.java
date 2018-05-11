/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smartcard1;

import AbsenHelper.CekHadirAkhlak;
import AbsenHelper.CekHadirArab;
import AbsenHelper.CekHadirDev;
import AbsenHelper.CekHadirDkv;
import AbsenHelper.CekHadirFiqih;
import AbsenHelper.CekHadirInggris;
import AbsenHelper.CekHadirKemandirian;
import AbsenHelper.CekHadirQcb;
import AbsenHelper.CekHadirTajwid;
import java.awt.Toolkit;
import static java.lang.Thread.sleep;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author Haydar Dzaky S
 */
public class MenuCekHadir extends javax.swing.JFrame {

    /**
     * Creates new form MenuCekHadir
     */
    public MenuCekHadir() {
        this.setUndecorated(true);
        this.setAlwaysOnTop(true);
        this.setResizable(false);
        
        initComponents();
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

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel30 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel55 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtClock = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel30.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 153, 204));
        jLabel30.setText("DKV");
        getContentPane().add(jLabel30);
        jLabel30.setBounds(390, 250, 100, 50);

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/buttonlesson.png"))); // NOI18N
        jLabel29.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel29MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel29);
        jLabel29.setBounds(300, 220, 260, 110);

        jLabel39.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(0, 153, 204));
        jLabel39.setText("Fiqih");
        getContentPane().add(jLabel39);
        jLabel39.setBounds(390, 390, 90, 50);

        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/buttonlesson.png"))); // NOI18N
        jLabel40.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel40MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel40);
        jLabel40.setBounds(300, 360, 260, 110);

        jLabel31.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 153, 204));
        jLabel31.setText("B. Arab");
        getContentPane().add(jLabel31);
        jLabel31.setBounds(360, 530, 140, 50);

        jLabel41.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/buttonlesson.png"))); // NOI18N
        jLabel41.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel41MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel41);
        jLabel41.setBounds(300, 500, 260, 110);

        jLabel33.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(0, 153, 204));
        jLabel33.setText("B. Inggris");
        getContentPane().add(jLabel33);
        jLabel33.setBounds(610, 530, 180, 50);

        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/buttonlesson.png"))); // NOI18N
        jLabel43.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel43MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel43);
        jLabel43.setBounds(570, 500, 260, 110);

        jLabel35.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(0, 153, 204));
        jLabel35.setText("Akhlak");
        getContentPane().add(jLabel35);
        jLabel35.setBounds(640, 390, 140, 50);

        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/buttonlesson.png"))); // NOI18N
        jLabel44.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel44MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel44);
        jLabel44.setBounds(570, 360, 260, 110);

        jLabel45.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(0, 153, 204));
        jLabel45.setText("Programming");
        getContentPane().add(jLabel45);
        jLabel45.setBounds(580, 250, 250, 50);

        jLabel46.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/buttonlesson.png"))); // NOI18N
        jLabel46.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel46MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel46);
        jLabel46.setBounds(570, 220, 260, 110);

        jLabel36.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(0, 153, 204));
        jLabel36.setText("Tajwid");
        getContentPane().add(jLabel36);
        jLabel36.setBounds(910, 390, 120, 50);

        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/buttonlesson.png"))); // NOI18N
        jLabel49.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel49MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel49);
        jLabel49.setBounds(840, 360, 260, 110);

        jLabel51.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(0, 153, 204));
        jLabel51.setText("Kemandirian");
        getContentPane().add(jLabel51);
        jLabel51.setBounds(860, 530, 226, 50);

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/buttonlesson.png"))); // NOI18N
        jLabel52.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel52MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel52);
        jLabel52.setBounds(840, 500, 260, 110);

        jLabel38.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 153, 204));
        jLabel38.setText("QCB");
        getContentPane().add(jLabel38);
        jLabel38.setBounds(930, 250, 90, 50);

        jLabel55.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/buttonlesson.png"))); // NOI18N
        jLabel55.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel55MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel55);
        jLabel55.setBounds(840, 220, 260, 110);

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 50)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Choose Lesson");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(500, 120, 390, 50);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 45)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Main Menu");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(370, 660, 230, 70);

        btnLogout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/button.png"))); // NOI18N
        btnLogout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLogoutMouseClicked(evt);
            }
        });
        getContentPane().add(btnLogout);
        btnLogout.setBounds(300, 650, 354, 100);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/logomss.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 40, 350, 110);

        txtClock.setFont(new java.awt.Font("Verdana", 0, 36)); // NOI18N
        txtClock.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txtClock);
        txtClock.setBounds(1080, 700, 240, 40);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resource/bgfinl.png"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, -10, 1380, 800);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel29MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel29MouseClicked
        // TODO add your handling code here:
        new CekHadirDkv().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel29MouseClicked

    private void jLabel41MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel41MouseClicked
        // TODO add your handling code here:
        new CekHadirArab().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel41MouseClicked

    private void jLabel44MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel44MouseClicked
        // TODO add your handling code here:
        new CekHadirAkhlak().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel44MouseClicked

    private void btnLogoutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLogoutMouseClicked
        // TODO add your handling code here:
        new PilihMapel().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnLogoutMouseClicked

    private void jLabel46MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel46MouseClicked
        // TODO add your handling code here:
        new CekHadirDev().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel46MouseClicked

    private void jLabel55MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel55MouseClicked
        // TODO add your handling code here:
        new CekHadirQcb().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel55MouseClicked

    private void jLabel40MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel40MouseClicked
        // TODO add your handling code here:
        new CekHadirFiqih().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel40MouseClicked

    private void jLabel49MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel49MouseClicked
        // TODO add your handling code here:
        new CekHadirTajwid().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel49MouseClicked

    private void jLabel43MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel43MouseClicked
        // TODO add your handling code here:
        new CekHadirInggris().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel43MouseClicked

    private void jLabel52MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel52MouseClicked
        // TODO add your handling code here:
        new CekHadirKemandirian().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jLabel52MouseClicked

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
            java.util.logging.Logger.getLogger(MenuCekHadir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuCekHadir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuCekHadir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuCekHadir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuCekHadir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel btnLogout;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel txtClock;
    // End of variables declaration//GEN-END:variables
}
