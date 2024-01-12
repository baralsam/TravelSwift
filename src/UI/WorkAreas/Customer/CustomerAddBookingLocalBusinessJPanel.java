/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.WorkAreas.Customer;

import Model.LocalBusiness.Activity;
import Model.LocalBusiness.LocalActivity;
import Model.LocalBusiness.LocalBusiness;
import Model.Roles.Customer;
import Model.Travel;
import static Utilities.Validations.isFutureDate;
import static Utilities.Validations.validateDateFormat;
import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class CustomerAddBookingLocalBusinessJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CustomerAddBookingLocalBusinessJPanel
     */
    private JPanel userProcessContainer;
    private Travel travel;
    Customer customer;
    DefaultTableModel dtm;
    
    public CustomerAddBookingLocalBusinessJPanel(JPanel userProcessContainer, Travel travel, Customer customer) {
        initComponents();
         this.userProcessContainer = userProcessContainer;
        this.travel = travel;
        this.customer = customer;
        dtm = (DefaultTableModel) tblJobs.getModel();
        populateTable();
        lblDate.setVisible(false);
        txtDate.setVisible(false);
        btnBook.setVisible(false);
    }
    
    public void populateTable(){
        dtm.setRowCount(0);    
        for(LocalBusiness l: travel.getLocalBusinessDirectory().getLocalBusinessList()){
            for(LocalActivity a: l.getLocalActivity()){
                Object[] row = new Object[6];
                row[0] = l;
                row[1] = a;
                row[2] = a.getDescription();
                row[3] = a.getLocation();
                row[4] = a.getCost();
                row[5] = a.getCurrency();
                dtm.addRow(row);
            }
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

        btnBack = new javax.swing.JButton();
        btnUpdateStatus = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblJobs = new javax.swing.JTable();
        lblDate = new javax.swing.JLabel();
        txtDate = new javax.swing.JTextField();
        btnBook = new javax.swing.JButton();

        btnBack.setBackground(new java.awt.Color(0, 0, 0));
        btnBack.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnUpdateStatus.setBackground(new java.awt.Color(0, 0, 0));
        btnUpdateStatus.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnUpdateStatus.setForeground(new java.awt.Color(255, 255, 255));
        btnUpdateStatus.setText("Book Activity");
        btnUpdateStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUpdateStatusActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Local Activity");

        tblJobs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Local Business Name", "Activity Name", "Description", "Location", "Cost", "Currency"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblJobs);

        lblDate.setText("Date:");

        btnBook.setText("Book");
        btnBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBookActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnUpdateStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack)
                        .addGap(50, 50, 50))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnBook))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnBack)
                    .addComponent(btnUpdateStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDate, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnBook)
                .addContainerGap(111, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    private void btnUpdateStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateStatusActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblJobs.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(this, "Please select a Local Activity from the list!","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        LocalActivity a = (LocalActivity)tblJobs.getValueAt(selectedRow, 1);
        lblDate.setVisible(true);
        txtDate.setVisible(true);
        btnBook.setVisible(true);
    }//GEN-LAST:event_btnUpdateStatusActionPerformed

    private void btnBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBookActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblJobs.getSelectedRow();
        if(selectedRow < 0){
            JOptionPane.showMessageDialog(this, "Please select a Local Activity from the list!","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        String date = txtDate.getText().trim();
        if(validateDateFormat(date)){
            JOptionPane.showMessageDialog(this, "Please enter date in format mm/dd/yyyy!","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(isFutureDate(date)){
            JOptionPane.showMessageDialog(this, "Entered date should be future date than current!","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
        LocalActivity a = (LocalActivity)tblJobs.getValueAt(selectedRow, 1);
        LocalBusiness lb = (LocalBusiness)tblJobs.getValueAt(selectedRow, 0);
        int value = a.getCost();
        if(value > customer.getCurrency().get(a.getCurrency())){
            JOptionPane.showMessageDialog(this, "Insufficient Funds please top up your account!","Warning",JOptionPane.WARNING_MESSAGE);
            return;
        }
//        HashMap<LocalActivity,String> hm = new HashMap<>();
//        hm.put(a, date);
//        customer.getLocalActivity().put(lb, hm);
        Activity aa = new Activity(lb,a,date);
        customer.getLocalActivity().add(aa);
        customer.getCurrency().put(a.getCurrency(), customer.getCurrency().get(a.getCurrency())-a.getCost());
        JOptionPane.showMessageDialog(this, "Local Activity booked successfully!");
        txtDate.setText("");
        lblDate.setVisible(false);
        txtDate.setVisible(false);
        btnBook.setVisible(false);
    }//GEN-LAST:event_btnBookActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBook;
    private javax.swing.JButton btnUpdateStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDate;
    private javax.swing.JTable tblJobs;
    private javax.swing.JTextField txtDate;
    // End of variables declaration//GEN-END:variables
}