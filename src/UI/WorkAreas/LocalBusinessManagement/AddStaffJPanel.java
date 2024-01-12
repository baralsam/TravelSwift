/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.WorkAreas.LocalBusinessManagement;

import UI.WorkAreas.HotelManagement.*;
import Model.Hotel.Hotel;
import Model.Hotel.Staff;
import Model.LocalBusiness.LocalBusiness;
import Model.Travel;
import static Utilities.Validations.validateName;
import static Utilities.Validations.validatePhone;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author samik
 */
public class AddStaffJPanel extends javax.swing.JPanel {
    private JPanel userProcessContainer;
    private Travel travel;
    private LocalBusiness localBusiness;
    /**
     * Creates new form AddStaffJPanel
     */

    public AddStaffJPanel(JPanel userProcessContainer, Travel travel, LocalBusiness localBusiness) {
                this.userProcessContainer = userProcessContainer;
        this.travel = travel;
        this.localBusiness = localBusiness;
initComponents();
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
        txtName = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPosition = new javax.swing.JTextField();
        txtContact = new javax.swing.JTextField();
        btnCancel2 = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel1.setText("Name:");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, -1, 30));

        txtName.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 160, 232, 40));

        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel3.setText("Position:");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 220, -1, 30));

        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        jLabel4.setText("Contact:");
        add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, -1, 30));

        txtPosition.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        add(txtPosition, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 220, 233, 40));

        txtContact.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        add(txtContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 280, 233, 40));

        btnCancel2.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnCancel2.setText("Cancel");
        btnCancel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancel2ActionPerformed(evt);
            }
        });
        add(btnCancel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 340, -1, 40));

        btnAdd.setFont(new java.awt.Font("Trebuchet MS", 0, 18)); // NOI18N
        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 340, -1, 40));

        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 1, 48)); // NOI18N
        jLabel2.setText("Add Staff");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, -1, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancel2ActionPerformed
        // TODO add your handling code here:
        txtName.setText("");
        txtPosition.setText("");
        txtContact.setText("");
    }//GEN-LAST:event_btnCancel2ActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        String name = txtName.getText();  
        String position = txtPosition.getText();
        String contact = txtContact.getText();
                if(name.isEmpty() || position.isEmpty() || contact.isEmpty()){
            JOptionPane.showMessageDialog(this, "Please check if all fields are filled before processing", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if(validateName(name)){
            JOptionPane.showMessageDialog(this, "Name should be between 3 to 15 length and should not contain any special characters.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
                if(validateName(position)){
            JOptionPane.showMessageDialog(this, "Position should be between 3 to 15 length and should not contain any special characters.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
                        if(validatePhone(contact)){
            JOptionPane.showMessageDialog(this, "Please verify if Phone number is in correct format \"(000) 000-0000\"", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Staff staff = new Staff();
        staff.setContactInfo(contact);
        staff.setName(name);
        staff.setPosition(position);
        localBusiness.addStaff(staff);
        JOptionPane.showMessageDialog(this, "Staff registered successfuly!");
        txtContact.setText("");
        txtName.setText("");
        txtPosition.setText("");
    }//GEN-LAST:event_btnAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField txtContact;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPosition;
    // End of variables declaration//GEN-END:variables
}