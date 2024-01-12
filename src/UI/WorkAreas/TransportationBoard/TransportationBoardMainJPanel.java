/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.WorkAreas.TransportationBoard;

import Model.Travel;
import UI.WorkAreas.FinancialBoard.*;
import UI.WorkAreas.GovernmentBoard.*;
import UI.WorkAreas.OrganizationsManage.AddOrganizationJPanel;
import UI.WorkAreas.OrganizationsManage.ViewOrganizationJPanel;
import java.awt.CardLayout;
import javax.swing.JPanel;

/**
 *
 * @author ASUS
 */
public class TransportationBoardMainJPanel extends javax.swing.JPanel {

    /**
     * Creates new form GovernmentBoardMainJPanel
     */
    private JPanel userProcessContainer;
    private Travel travel;
    
    public TransportationBoardMainJPanel(JPanel userProcessContainer, Travel travel) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.travel = travel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBack1 = new javax.swing.JButton();
        btnRoadDep = new javax.swing.JButton();
        btnRailDep = new javax.swing.JButton();
        btnAirDep = new javax.swing.JButton();
        btnSeaDep = new javax.swing.JButton();
        btnAddOrg = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        btnBack1.setText("Logout");
        btnBack1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack1ActionPerformed(evt);
            }
        });

        btnRoadDep.setText("Manage Road Transportation");
        btnRoadDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRoadDepActionPerformed(evt);
            }
        });

        btnRailDep.setText("Manage Rail Transportation");
        btnRailDep.setToolTipText("");
        btnRailDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRailDepActionPerformed(evt);
            }
        });

        btnAirDep.setText("Manage Airways Transportation");
        btnAirDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAirDepActionPerformed(evt);
            }
        });

        btnSeaDep.setText("Manage Seaways Transportation");
        btnSeaDep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeaDepActionPerformed(evt);
            }
        });

        btnAddOrg.setText("Add Transportaion Organization");
        btnAddOrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddOrgActionPerformed(evt);
            }
        });

        btnBack.setBackground(new java.awt.Color(0, 0, 0));
        btnBack.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnRailDep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAirDep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRoadDep, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSeaDep, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
                    .addComponent(btnAddOrg, javax.swing.GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE))
                .addContainerGap(515, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(btnBack1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnRoadDep, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnRailDep, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAirDep, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnSeaDep, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAddOrg, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 180, Short.MAX_VALUE)
                .addComponent(btnBack)
                .addGap(48, 48, 48))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBack1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack1ActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBack1ActionPerformed

    private void btnRoadDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRoadDepActionPerformed
        // TODO add your handling code here:
        ViewOrganizationJPanel panel = new ViewOrganizationJPanel(userProcessContainer,travel,"Road");
        userProcessContainer.add("ViewOrganizationJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnRoadDepActionPerformed

    private void btnRailDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRailDepActionPerformed
        // TODO add your handling code here:
                ViewOrganizationJPanel panel = new ViewOrganizationJPanel(userProcessContainer,travel,"Rail");
        userProcessContainer.add("ViewOrganizationJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnRailDepActionPerformed

    private void btnAirDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAirDepActionPerformed
        // TODO add your handling code here:
                ViewOrganizationJPanel panel = new ViewOrganizationJPanel(userProcessContainer,travel,"Air");
        userProcessContainer.add("ViewOrganizationJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnAirDepActionPerformed

    private void btnSeaDepActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeaDepActionPerformed
               ViewOrganizationJPanel panel = new ViewOrganizationJPanel(userProcessContainer,travel,"Sea");
        userProcessContainer.add("ViewOrganizationJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnSeaDepActionPerformed

    private void btnAddOrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddOrgActionPerformed
        // TODO add your handling code here:
        AddOrganizationJPanel panel = new AddOrganizationJPanel(userProcessContainer,travel,"Transport Agency");
        userProcessContainer.add("AddOrganizationJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }//GEN-LAST:event_btnAddOrgActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddOrg;
    private javax.swing.JButton btnAirDep;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnBack1;
    private javax.swing.JButton btnRailDep;
    private javax.swing.JButton btnRoadDep;
    private javax.swing.JButton btnSeaDep;
    // End of variables declaration//GEN-END:variables
}
