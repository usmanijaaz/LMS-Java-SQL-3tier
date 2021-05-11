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
public class addAttend extends javax.swing.JFrame {

    Course co;
    Section se;
    GlobalClass gc = new GlobalClass();
     private DBConnect conobject= DBConnect.getInstance();
     
    /** Creates new form addAttend */
    public addAttend() {
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

        cinfo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        slist = new javax.swing.JList<>();
        present = new javax.swing.JRadioButton();
        absent = new javax.swing.JRadioButton();
        adbutton = new javax.swing.JButton();
        d = new java.awt.Choice();
        m = new java.awt.Choice();
        y = new java.awt.Choice();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        wlist = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(750, 480));
        getContentPane().setLayout(null);

        cinfo.setText("..");
        getContentPane().add(cinfo);
        cinfo.setBounds(10, 39, 200, 14);

        slist.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(slist);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(400, 40, 157, 206);

        present.setText("Present");
        present.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                presentActionPerformed(evt);
            }
        });
        getContentPane().add(present);
        present.setBounds(437, 282, 110, 23);

        absent.setText("Absent");
        absent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                absentActionPerformed(evt);
            }
        });
        getContentPane().add(absent);
        absent.setBounds(547, 282, 124, 23);

        adbutton.setText("Add");
        adbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                adbuttonActionPerformed(evt);
            }
        });
        getContentPane().add(adbutton);
        adbutton.setBounds(673, 282, 73, 23);
        getContentPane().add(d);
        d.setBounds(580, 60, 42, 20);
        getContentPane().add(m);
        m.setBounds(630, 60, 41, 20);
        getContentPane().add(y);
        y.setBounds(680, 60, 58, 20);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(20, 440, 78, 20);

        wlist.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(wlist);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(10, 71, 246, 318);

        jLabel1.setFont(new java.awt.Font("Arial Black", 3, 11)); // NOI18N
        jLabel1.setText("DD    /      MM  /   YYYY   ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(580, 40, 160, 17);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/projectsda/proj.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(4, -6, 810, 500);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void presentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_presentActionPerformed
        // TODO add your handling code here:
        absent.setSelected(false);
    }//GEN-LAST:event_presentActionPerformed

    private void absentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_absentActionPerformed
        // TODO add your handling code here:
        present.setSelected(false);
    }//GEN-LAST:event_absentActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
         this.setVisible(false);
        teachercoures tc = new teachercoures();
        tc.setVisible(true);
        tc.ShowCourses();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void adbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_adbuttonActionPerformed
        // TODO add your handling code here:
         String date = y.getSelectedItem()+"-"+m.getSelectedItem()+"-"+d.getSelectedItem();
        String s = slist.getSelectedValue();
        if ( s ==  null)
        {
             JOptionPane.showMessageDialog(null,"Select a Student first ");
        }
        else if(absent.isSelected() == false && present.isSelected() == false)
        {
             JOptionPane.showMessageDialog(null,"Select an Option for Attendance first ");
        }
        else
        {
            
            char ar[] = s.toCharArray();
            int length = 0;
            for(int i=0;i<s.length();i++)
            {  
                if(ar[i]==' ')
                {
                    length = i;
                    break;
                }
            }
            char r[] = new char[length];
            for(int i=0;i<length;i++)
            {
               r[i]=ar[i];
            }
            String roll= String.valueOf(r);
            length = Integer.parseInt(roll);
             Student S = conobject.populatestudentFrame(length);
             
             if(present.isSelected() == true)
             {
             gc.currentTeacher.addAttendance(S,co,se,"P",date);
             }
             else if(absent.isSelected() == true)
             {
                 gc.currentTeacher.addAttendance(S,co,se,"A",date);
             }
        }
        
    }//GEN-LAST:event_adbuttonActionPerformed

  
    
    public void showRegs(String c, String s)
    {
        cinfo.setText(c + " " + s);
        for(int i=1;i<32;i++)
        {
            d.add(String.valueOf(i));
        }
        for(int i=1;i<13;i++)
        {
            m.add(String.valueOf(i));
        }
        for(int i=2010;i<2024;i++)
        {
            y.add(String.valueOf(i));
        }
        
        ArrayList<String> Crs_id = conobject.getCourse(c);
      
        co = new Course(Integer.parseInt(Crs_id.get(0)),Crs_id.get(2),Crs_id.get(1),Integer.parseInt(Crs_id.get(3)),Integer.parseInt(Crs_id.get(4)));
        
        se = conobject.getSectionObject(c,s);
        
        
        DefaultListModel mod = new DefaultListModel();
        mod.clear();
        for(int i=0;i<se.getregs().size();i++)
        {
            mod.addElement(se.getregs().get(i).toString());
        }
        slist.setModel(mod);
        
        DefaultListModel mod1 = new DefaultListModel();
        mod1.clear();
       
            //mod1.addElement("All attendance record for : " + se.getregs().get(i).getId());
           ArrayList<Attendance> at = conobject.getAttendance(se.getname(),co.getCourseName());
            if(at.size() == 0)
            {
                mod1.addElement("Nothing to show !");
            }
            for(int j = 0;j<at.size();j++)
            {
               // System.out.println("j : " + j);
                 mod1.addElement(at.get(j).getStid() + " " + at.get(j).getDate() + "  |   " + at.get(j).getstatus()); 
            }
        
        wlist.setModel(mod1);
        
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
            java.util.logging.Logger.getLogger(addAttend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addAttend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addAttend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addAttend.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new addAttend().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton absent;
    private javax.swing.JButton adbutton;
    private javax.swing.JLabel cinfo;
    private java.awt.Choice d;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private java.awt.Choice m;
    private javax.swing.JRadioButton present;
    private javax.swing.JList<String> slist;
    private javax.swing.JList<String> wlist;
    private java.awt.Choice y;
    // End of variables declaration//GEN-END:variables

}
