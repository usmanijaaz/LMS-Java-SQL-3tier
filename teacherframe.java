/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectsda;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JScrollPane;
import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
/**
 *
 * @author Usman
 */
public class teacherframe extends javax.swing.JFrame {

    
     private DBConnect conobject= DBConnect.getInstance();
    GlobalClass gc = new GlobalClass();
    
    /** Creates new form teacherframe */
    public teacherframe() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        id = new javax.swing.JLabel();
        name = new javax.swing.JLabel();
        email = new javax.swing.JLabel();
        phone = new javax.swing.JLabel();
        stat = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(750, 480));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel1.setText("ID:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 63, 49, 13);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel2.setText("Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 95, 59, 13);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel3.setText("Email: ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 127, 59, 13);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel4.setText("Phone: ");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 159, 69, 13);

        jLabel5.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel5.setText("Status : ");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(347, 111, 80, 13);

        jButton1.setText("Log Out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(627, 13, 95, 23);

        id.setText("..");
        getContentPane().add(id);
        id.setBounds(85, 62, 112, 14);

        name.setText("..");
        getContentPane().add(name);
        name.setBounds(85, 94, 122, 14);

        email.setText("..");
        getContentPane().add(email);
        email.setBounds(85, 126, 122, 14);

        phone.setText("..");
        getContentPane().add(phone);
        phone.setBounds(85, 158, 112, 14);

        stat.setText("..");
        getContentPane().add(stat);
        stat.setBounds(433, 110, 115, 14);

        jLabel6.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel6.setText("Welcome to LMS");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(155, 11, 195, 22);

        jButton2.setText("Show my Courses");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(10, 270, 162, 23);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectsda/proj.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, -30, 780, 540);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         this.setVisible(false);
         JOptionPane.showMessageDialog(null,"You Logged Out of System !");
         new LoginFrame().setVisible(true);
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        teachercoures tc = new teachercoures();
        tc.setVisible(true);
        tc.ShowCourses();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    public void populateFrame(int ids)
    {
       
        
        
        gc.currentTeacher = conobject.populateFrameTeacher(ids);
        id.setText(String.valueOf(gc.currentTeacher.getId()));
        name.setText(gc.currentTeacher.getName());
        email.setText(gc.currentTeacher.getEmail());
        stat.setText(gc.currentTeacher.getStatus());
        phone.setText(gc.currentTeacher.getPhone());
        
//        for(int i=0;i<gc.currentTeacher.getCourses().size();i++)
//        {
//            System.out.println(gc.currentTeacher.getCourses().get(i).getCourseName());
//            System.out.println(gc.currentTeacher.getsections().get(i).toString());
//        }
        
    }
    
    
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
            java.util.logging.Logger.getLogger(teacherframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(teacherframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(teacherframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(teacherframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new teacherframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel email;
    private javax.swing.JLabel id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel name;
    private javax.swing.JLabel phone;
    private javax.swing.JLabel stat;
    // End of variables declaration//GEN-END:variables

}
