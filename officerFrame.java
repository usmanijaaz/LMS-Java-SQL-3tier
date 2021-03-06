/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package projectsda;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.sql.Date;
/**
 *
 * @author Usman
 */
public class officerFrame extends javax.swing.JFrame {

    
     private DBConnect conobject= DBConnect.getInstance();
    GlobalClass gc = new GlobalClass();
    
    /** Creates new form officerFrame */
    public officerFrame() {
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
        off_id = new javax.swing.JLabel();
        off_name = new javax.swing.JLabel();
        off_mail = new javax.swing.JLabel();
        off_ph = new javax.swing.JLabel();
        logout = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        updatebutton = new javax.swing.JButton();
        addbutton = new javax.swing.JButton();
        withdrawbutton = new javax.swing.JButton();
        update = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        sem = new java.awt.Choice();
        jLabel6 = new javax.swing.JLabel();
        sem1 = new java.awt.Choice();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(750, 480));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Officer Id: ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(10, 42, 70, 14);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel2.setText("Name: ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(10, 67, 50, 13);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel3.setText("Email: ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 99, 50, 13);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        jLabel4.setText("Phone No:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 124, 70, 13);

        off_id.setText("..");
        getContentPane().add(off_id);
        off_id.setBounds(90, 40, 152, 14);

        off_name.setText("..");
        getContentPane().add(off_name);
        off_name.setBounds(70, 70, 116, 14);

        off_mail.setText("..");
        getContentPane().add(off_mail);
        off_mail.setBounds(70, 100, 130, 14);

        off_ph.setText("..");
        getContentPane().add(off_ph);
        off_ph.setBounds(90, 120, 117, 14);

        logout.setBackground(new java.awt.Color(204, 255, 255));
        logout.setText("Log Out");
        logout.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutActionPerformed(evt);
            }
        });
        getContentPane().add(logout);
        logout.setBounds(580, 10, 100, 23);

        jLabel5.setFont(new java.awt.Font("Arial", 3, 18)); // NOI18N
        jLabel5.setText("Welcome To LMS");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(227, 12, 214, 24);

        updatebutton.setBackground(new java.awt.Color(255, 255, 255));
        updatebutton.setText("Update Registration Period for Courses");
        updatebutton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        getContentPane().add(updatebutton);
        updatebutton.setBounds(10, 176, 234, 30);

        addbutton.setText("Add a new Course");
        addbutton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        addbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(addbutton);
        addbutton.setBounds(10, 220, 137, 30);

        withdrawbutton.setBackground(new java.awt.Color(204, 255, 255));
        withdrawbutton.setText("Withdrawal of Courses :");
        withdrawbutton.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        getContentPane().add(withdrawbutton);
        withdrawbutton.setBounds(10, 280, 187, 30);

        update.setText("Change");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        getContentPane().add(update);
        update.setBounds(210, 320, 80, 23);

        jLabel9.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel9.setText("Semester No: ");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(210, 290, 80, 13);
        getContentPane().add(sem);
        sem.setBounds(290, 290, 40, 20);

        jLabel6.setFont(new java.awt.Font("Arial", 3, 11)); // NOI18N
        jLabel6.setText("Semester No: ");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(250, 180, 80, 13);
        getContentPane().add(sem1);
        sem1.setBounds(340, 170, 40, 20);

        jButton1.setText("Change");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(400, 170, 90, 23);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectsda/proj.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 750, 480);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutActionPerformed
        // TODO add your handling code here:
         this.setVisible(false);
         JOptionPane.showMessageDialog(null,"You Logged Out of System !");
         new LoginFrame().setVisible(true);
        
    }//GEN-LAST:event_logoutActionPerformed

    private void addbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addbuttonActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        addCourseframe af = new addCourseframe();
        af.setVisible(true);
        af.makeFrame();
    }//GEN-LAST:event_addbuttonActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        // TODO add your handling code here:
       
        int semester = Integer.parseInt(sem.getSelectedItem());
        String S = conobject.setWithdrawal(semester);
        
        JOptionPane.showMessageDialog(null,"Withdrawal for semester "+String.valueOf(semester)+" is "+ S );
        
    }//GEN-LAST:event_updateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         int semester = Integer.parseInt(sem1.getSelectedItem());
        String S = conobject.setRegistration(semester);
        
        JOptionPane.showMessageDialog(null,"Registrations for semester "+String.valueOf(semester)+" are "+ S );
    }//GEN-LAST:event_jButton1ActionPerformed

    
   
    public void populateFrame(int id)
    {
        ArrayList<String> info = conobject.getOfficerInfo(id);
        
        gc.officer = new Academic_Officer(info.get(1),info.get(2),Integer.parseInt(info.get(0)),info.get(3),info.get(4));
        
        off_id.setText(info.get(0));
        off_name.setText(info.get(1));
        off_mail.setText(info.get(2));
        off_ph.setText(info.get(4));
        
         for(int i=1;i<9;i++ )
        {
            sem.add(String.valueOf(i));
            sem1.add(String.valueOf(i));
        }
         
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
            java.util.logging.Logger.getLogger(officerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(officerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(officerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(officerFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new officerFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addbutton;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JButton logout;
    private javax.swing.JLabel off_id;
    private javax.swing.JLabel off_mail;
    private javax.swing.JLabel off_name;
    private javax.swing.JLabel off_ph;
    private java.awt.Choice sem;
    private java.awt.Choice sem1;
    private javax.swing.JButton update;
    private javax.swing.JButton updatebutton;
    private javax.swing.JButton withdrawbutton;
    // End of variables declaration//GEN-END:variables

}
