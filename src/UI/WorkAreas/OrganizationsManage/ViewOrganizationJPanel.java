/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.WorkAreas.OrganizationsManage;

import Model.Hotel.Hotel;
import Model.LocalBusiness.LocalBusiness;
import Model.Organizations.Organization;
import Model.TransportAgency.TransportAgency;
import Model.Travel;
import Model.TravelAgency.TravelAgency;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ASUS
 */
public class ViewOrganizationJPanel extends javax.swing.JPanel {

    private JPanel userProcessContainer;
    private Travel travel;
    private String type;

    /**
     * Creates new form ViewOrganizationJPanel
     */
    public ViewOrganizationJPanel(JPanel userProcessContainer, Travel travel, String type) {
        this.userProcessContainer = userProcessContainer;
        this.travel = travel;
        this.type = type;
        initComponents();
        populateTable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblOrganization = new javax.swing.JTable();
        btnDelete = new javax.swing.JButton();
        btnView = new javax.swing.JButton();
        btnBack = new javax.swing.JButton();

        tblOrganization.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Organization Name", "Organization Description", "Organization Type", "Manager Name", "Manager Contact"
            }
        ));
        jScrollPane1.setViewportView(tblOrganization);

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnView.setText("View");
        btnView.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewActionPerformed(evt);
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 788, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btnView)
                        .addGap(18, 18, 18)
                        .addComponent(btnDelete)
                        .addGap(18, 18, 18)
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 321, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnView)
                    .addComponent(btnDelete)
                    .addComponent(btnBack))
                .addContainerGap(230, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblOrganization.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row from table first to view details", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            if(type.equals("Hotel")){
            Hotel hot = (Hotel) tblOrganization.getValueAt(selectedRow, 0);
            ViewOrganizationDetailsJPanel panel = new ViewOrganizationDetailsJPanel(userProcessContainer, travel,hot, "Hotel");
            userProcessContainer.add("ViewOrganizationDeatilsJPanel", panel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
           if(type.equals("Local Business")) {
            LocalBusiness lb = (LocalBusiness) tblOrganization.getValueAt(selectedRow, 0);
            ViewOrganizationDetailsJPanel panel = new ViewOrganizationDetailsJPanel(userProcessContainer, travel,lb, "Local Business");
            userProcessContainer.add("ViewOrganizationDeatilsJPanel", panel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);               
           }
           
            if(type.equals("Air")) {
                System.out.print("HI MINAL");
            TransportAgency lb = (TransportAgency) tblOrganization.getValueAt(selectedRow, 0);
            ViewOrganizationDetailsJPanel panel = new ViewOrganizationDetailsJPanel(userProcessContainer, travel,lb, "Air");
            userProcessContainer.add("ViewOrganizationDeatilsJPanel", panel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);               
           }
            
            if(type.equals("Road")) {
            TransportAgency lb = (TransportAgency) tblOrganization.getValueAt(selectedRow, 0);
            ViewOrganizationDetailsJPanel panel = new ViewOrganizationDetailsJPanel(userProcessContainer, travel,lb, "Road");
            userProcessContainer.add("ViewOrganizationDeatilsJPanel", panel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);               
           }            

            if(type.equals("Rail")) {
            TransportAgency lb = (TransportAgency) tblOrganization.getValueAt(selectedRow, 0);
            ViewOrganizationDetailsJPanel panel = new ViewOrganizationDetailsJPanel(userProcessContainer, travel,lb, "Rail");
            userProcessContainer.add("ViewOrganizationDeatilsJPanel", panel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);               
           }
            
            if(type.equals("Sea")) {
            TransportAgency lb = (TransportAgency) tblOrganization.getValueAt(selectedRow, 0);
            ViewOrganizationDetailsJPanel panel = new ViewOrganizationDetailsJPanel(userProcessContainer, travel,lb, "Sea");
            userProcessContainer.add("ViewOrganizationDeatilsJPanel", panel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);               
           }  
            
                        if(type.equals("Travel Agency")) {
            TravelAgency lb = (TravelAgency) tblOrganization.getValueAt(selectedRow, 0);
            ViewOrganizationDetailsJPanel panel = new ViewOrganizationDetailsJPanel(userProcessContainer, travel,lb, "Travel Agency");
            userProcessContainer.add("ViewOrganizationDeatilsJPanel", panel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);               
           }
        }
    }//GEN-LAST:event_btnViewActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        // TODO add your handling code here:
        int selectedRow = tblOrganization.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select a row from table first to view details", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            if (type.equals("Hotel")) {
                Hotel hotel = (Hotel) tblOrganization.getValueAt(selectedRow, 0);
                for (Hotel h : travel.getHotelDirectory().getHotelList()) {
                    if (hotel.getBusinessName().equals(h.getBusinessName())) {
                        travel.getHotelDirectory().deleteHotel(hotel);
                        JOptionPane.showMessageDialog(this, "Organization removed successfuly!");
                        populateTable();
                        return;
                    }
                }
            }
            if (type.equals("Local Business")) {
                LocalBusiness localBusiness = (LocalBusiness) tblOrganization.getValueAt(selectedRow, 0);
                for (LocalBusiness lb : travel.getLocalBusinessDirectory().getLocalBusinessList()) {
                    if (lb.getBusinessName().equals(localBusiness.getBusinessName())) {
                        travel.getLocalBusinessDirectory().deleteLocalBusiness(lb);
                        JOptionPane.showMessageDialog(this, "Organization removed successfuly!");
                        populateTable();
                        return;
                    }
                }
            }  
            
            if ((type.equals("Air")) || (type.equals("Road")) || (type.equals("Rail")) || (type.equals("Sea"))) {
                TransportAgency trasportAgency = (TransportAgency) tblOrganization.getValueAt(selectedRow, 0);
                for (TransportAgency lb : travel.getTrnsportAgencyDirectory().getTransporAgencyList()) {
                    if (lb.getBusinessName().equals(trasportAgency.getBusinessName())) {
                        travel.getTrnsportAgencyDirectory().deleteTransporAgency(trasportAgency);
                        JOptionPane.showMessageDialog(this, "Organization removed successfuly!");
                        populateTable();
                        return;
                    }
                }
            }       
            
            if (type.equals("Travel Agency")) {
                TravelAgency travelAgency = (TravelAgency) tblOrganization.getValueAt(selectedRow, 0);
                for (TravelAgency lb : travel.getTravelAgencyDirectory().getTravelAgencyList()) {
                    if (lb.getBusinessName().equals(travelAgency.getBusinessName())) {
                        travel.getTravelAgencyDirectory().deleteTravelAgency(travelAgency);
                        JOptionPane.showMessageDialog(this, "Organization removed successfuly!");
                        populateTable();
                        return;
                    }
                }
            }             
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }//GEN-LAST:event_btnBackActionPerformed

    public void populateTable() {
        
        
        DefaultTableModel dtm = (DefaultTableModel) tblOrganization.getModel();
        dtm.setRowCount(0);
        if (type.equals("Hotel")) {
            for (Hotel hotel : travel.getHotelDirectory().getHotelList()) {
                Object[] row = new Object[5];
                row[0] = hotel;
                row[1] = hotel.getBusinessDescription();
                row[2] = hotel.getType();
                row[3] = hotel.getManagerName();
                row[4] = hotel.getManagerPhone();
                dtm.addRow(row);
            }
        }
        if (type.equals("Local Business")) {
            for (LocalBusiness lb : travel.getLocalBusinessDirectory().getLocalBusinessList()) {
                Object[] row = new Object[5];
                row[0] = lb;
                row[1] = lb.getBusinessDescription();
                row[2] = lb.getType();
                row[3] = lb.getManagerName();
                row[4] = lb.getManagerPhone();
                dtm.addRow(row);
            }
        }
        if ((type.equals("Air")) || (type.equals("Road")) || (type.equals("Rail")) || (type.equals("Sea"))) {
            
            for (TransportAgency lb : travel.getTrnsportAgencyDirectory().getTransporAgencyList()) {
                
                Object[] row = new Object[5];
                row[0] = lb;
                row[1] = lb.getBusinessDescription();
                row[2] = lb.getType();
                row[3] = lb.getManagerName();
                row[4] = lb.getManagerPhone();
                dtm.addRow(row);
            }
        }        
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnView;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblOrganization;
    // End of variables declaration//GEN-END:variables
}