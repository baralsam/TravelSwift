/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package UI.WorkAreas.Customer;

import Model.Roles.Customer;
import Model.Travel;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.CardLayout;
import java.awt.Component;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.json.JSONObject;

/**
 *
 * @author ASUS
 */
public class CustomerConvertCurrenyJPanel extends javax.swing.JPanel {

    /**
     * Creates new form CustomerConvertCurrenyJPanel
     */
    private JPanel userProcessContainer;
    private Travel travel;
    Customer customer;
    DecimalFormat decimalFormat = new DecimalFormat("#.##");
    double usdRate, inrRate, cnyRate, usdToCny, usdToInr, usdToEur;
    private static HashMap<String, Double> exchangeRates = new HashMap<>();
    String toCurrency;
    String fromCurrency;
    double curr;
    double conCurr;
    double forexCharged;
            
   public CustomerConvertCurrenyJPanel(JPanel userProcessContainer, Travel travel, Customer customer) {
        initComponents();
        this.userProcessContainer = userProcessContainer;
        this.travel = travel;
        this.customer = customer;
        currencyConverter();
    }
   
   private void currencyConverter() {
        try {
            // URL for the exchange rates API
            String apiUrl = "http://api.exchangeratesapi.io/v1/latest?access_key=64f496528f9b7c78ec53b499c3c7efa3&base=EUR&symbols=USD,INR,CNY";

            // Create a URL object
            URL url = new URL(apiUrl);

            // Create an HttpURLConnection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // Reading the response
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // Parse the JSON response
                JSONObject jsonResponse = new JSONObject(response.toString());

                // Extract rates
                usdRate = jsonResponse.getJSONObject("rates").getDouble("USD");
                inrRate = jsonResponse.getJSONObject("rates").getDouble("INR");
                cnyRate = jsonResponse.getJSONObject("rates").getDouble("CNY");

                // Calculate the values for 1 INR
                usdToCny = cnyRate / usdRate;
                usdToInr = inrRate / usdRate;
                usdToEur = 1 / usdRate;  // Since the base is EUR, use USD rate for EUR conversion
                exchangeRates.put("USD",1.0);
                exchangeRates.put("CNY",usdToCny);
                exchangeRates.put("EUR",usdToEur);
                exchangeRates.put("INR",usdToInr);

                txtCNYConvert.setText(String.format("%.2f", usdToCny));
                txtINRConvert.setText(String.format("%.2f", usdToInr));
                txtEURConvert.setText(String.format("%.2f", usdToEur));

            } else {
                System.out.println("HTTP GET request failed with response code: " + responseCode);
            }

            // Close the connection
            connection.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
   public static double convertCurrency(String fromCurrency, String toCurrency, double amount) {
        // Ensure that the currencies are valid
        if (!exchangeRates.containsKey(fromCurrency) || !exchangeRates.containsKey(toCurrency)) {
            throw new IllegalArgumentException("Invalid currency");
        }

        // Convert the amount from the source currency to USD
        double amountInUSD = amount / exchangeRates.get(fromCurrency);

        // Convert the amount from USD to the target currency
        return amountInUSD * exchangeRates.get(toCurrency);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCurrencyConvert = new javax.swing.JLabel();
        lblConvertFrom = new javax.swing.JLabel();
        txtConvertFrom = new javax.swing.JTextField();
        optionsConvertFrom = new javax.swing.JComboBox<>();
        lblConvertTo = new javax.swing.JLabel();
        optionsConvertTo = new javax.swing.JComboBox<>();
        btnConvertCurrency = new javax.swing.JButton();
        lblCurrentRate = new javax.swing.JLabel();
        txtEURConvert = new javax.swing.JTextField();
        txtINRConvert = new javax.swing.JTextField();
        lblINRConvert = new javax.swing.JLabel();
        txtCNYConvert = new javax.swing.JTextField();
        lblCNYConvert = new javax.swing.JLabel();
        lblEURConvert = new javax.swing.JLabel();
        btnBack2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnReceipt = new javax.swing.JButton();

        lblCurrencyConvert.setText("Currency Conversion:");

        lblConvertFrom.setText("Convert from:");

        txtConvertFrom.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtConvertFromInputMethodTextChanged(evt);
            }
        });

        optionsConvertFrom.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CNY", "EUR", "INR", "USD" }));

        lblConvertTo.setText("Convert to:");

        optionsConvertTo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CNY", "EUR", "INR", "USD" }));

        btnConvertCurrency.setText("Convert Currency");
        btnConvertCurrency.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConvertCurrencyActionPerformed(evt);
            }
        });

        lblCurrentRate.setText("Current Rate by 1 USD:");

        txtEURConvert.setEditable(false);
        txtEURConvert.setEnabled(false);

        txtINRConvert.setEditable(false);
        txtINRConvert.setEnabled(false);

        lblINRConvert.setText("INR:");

        txtCNYConvert.setEditable(false);
        txtCNYConvert.setEnabled(false);

        lblCNYConvert.setText("CNY:");

        lblEURConvert.setText("EUR:");

        btnBack2.setText("Back");
        btnBack2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBack2ActionPerformed(evt);
            }
        });

        jButton1.setText("Check Converted Amount");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnReceipt.setText("Download Receipt ");
        btnReceipt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReceiptActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnBack2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(197, 197, 197)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblCurrentRate)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblEURConvert)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtEURConvert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblCNYConvert)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtCNYConvert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblINRConvert)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtINRConvert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(btnConvertCurrency, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(38, 38, 38)
                                .addComponent(btnReceipt, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 61, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(194, 194, 194)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblConvertFrom)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(optionsConvertFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(21, 21, 21)
                            .addComponent(txtConvertFrom, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(lblCurrencyConvert)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblConvertTo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(optionsConvertTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(118, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(lblCurrentRate)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCNYConvert)
                    .addComponent(txtCNYConvert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEURConvert)
                    .addComponent(txtEURConvert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblINRConvert)
                    .addComponent(txtINRConvert, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(138, 138, 138)
                .addComponent(jButton1)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnConvertCurrency)
                    .addComponent(btnReceipt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                .addComponent(btnBack2)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(168, 168, 168)
                    .addComponent(lblCurrencyConvert)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblConvertFrom)
                        .addComponent(txtConvertFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(optionsConvertFrom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblConvertTo)
                        .addComponent(optionsConvertTo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(202, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnBack2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBack2ActionPerformed
        // TODO add your handling code here:
        
        Component component = userProcessContainer.getComponent(userProcessContainer.getComponentCount() - 2);
        if(component instanceof CustomerCurrencyJPanel customerCurrencyJPanel) {
            customerCurrencyJPanel.updateCurrency();
        }
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
        
    }//GEN-LAST:event_btnBack2ActionPerformed

    private void btnConvertCurrencyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConvertCurrencyActionPerformed
        // TODO add your handling code here:
         if(txtConvertFrom.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please check if all fields are filled before processing", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try{
            Double.valueOf(txtConvertFrom.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Value should be Integer!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String toCurrency = String.valueOf(optionsConvertTo.getSelectedItem());
        String fromCurrency = String.valueOf(optionsConvertFrom.getSelectedItem());
        if(toCurrency.equals(fromCurrency)){
            JOptionPane.showMessageDialog(this, "Currency cannot be converted as To and From have same Type!");
            return;
        }
        double curr = Double.valueOf(txtConvertFrom.getText());
        double conCurr = convertCurrency(fromCurrency,toCurrency,curr);
        double forexCharged = 0;
        if(toCurrency.equals("CNY"))
            forexCharged = conCurr * travel.getForexFinance().getForexCNY();
        else if(toCurrency.equals("INR"))
            forexCharged =  conCurr * travel.getForexFinance().getForexINR();
        else if(toCurrency.equals("USD"))
            forexCharged =  conCurr * travel.getForexFinance().getForexUSD();
        else{
            forexCharged =  conCurr * travel.getForexFinance().getForexEUR();
        }
        double finalAmount = conCurr-forexCharged;
        if(finalAmount<0){
            JOptionPane.showMessageDialog(this, "Final Converted Amount should be Positive!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(customer.getCurrency().get(fromCurrency)<curr){
            JOptionPane.showMessageDialog(this, "Entered Amount is higher than Available.Please top up your account!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        customer.getCurrency().put(fromCurrency,customer.getCurrency().get(fromCurrency)-curr);
        customer.getCurrency().put(toCurrency,customer.getCurrency().get(toCurrency)+finalAmount);
        JOptionPane.showMessageDialog(this, "Currency converted Successfully!");
        
        txtConvertFrom.setText("");
    }//GEN-LAST:event_btnConvertCurrencyActionPerformed

    private void txtConvertFromInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtConvertFromInputMethodTextChanged
        // TODO add your handling code here:
       

    }//GEN-LAST:event_txtConvertFromInputMethodTextChanged

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(txtConvertFrom.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please check if all fields are filled before processing", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try{
            Double.valueOf(txtConvertFrom.getText());
        }catch(Exception e){
            JOptionPane.showMessageDialog(this, "Value should be Integer!", "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
         toCurrency = String.valueOf(optionsConvertTo.getSelectedItem());
         fromCurrency = String.valueOf(optionsConvertFrom.getSelectedItem());
        if(toCurrency.equals(fromCurrency)){
            JOptionPane.showMessageDialog(this, "Currency cannot be converted as To and From have same Type!");
            return;
        }
         curr = Double.valueOf(txtConvertFrom.getText());
         conCurr = convertCurrency(fromCurrency,toCurrency,curr);
         forexCharged = 0;
        if(toCurrency.equals("CNY"))
            forexCharged = conCurr * travel.getForexFinance().getForexCNY();
        else if(toCurrency.equals("INR"))
            forexCharged =  conCurr * travel.getForexFinance().getForexINR();
        else if(toCurrency.equals("USD"))
            forexCharged =  conCurr * travel.getForexFinance().getForexUSD();
        else{
            forexCharged =  conCurr * travel.getForexFinance().getForexEUR();
        }
        JOptionPane.showMessageDialog(this,"Forex Fees charged : "+ decimalFormat.format(forexCharged) + ". Final Amount After conversion = "+ decimalFormat.format(conCurr-forexCharged));
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnReceiptActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReceiptActionPerformed
        // TODO add your handling code here:
        String path = "";
        JFileChooser jFile = new JFileChooser();
        jFile.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int x = jFile.showSaveDialog(this);
        if (x == JFileChooser.APPROVE_OPTION) {
            path = jFile.getSelectedFile().getPath();
        }
        Document doc = new Document();

        try {
            PdfWriter.getInstance(doc, new FileOutputStream(path + "/CurrencyExchangeBill.pdf"));
            doc.open();
            Paragraph title = new Paragraph("CURRENCY EXCHANGE BILLING");
            title.setSpacingBefore(20f);
            title.setSpacingAfter(20f);
            title.setAlignment(Element.ALIGN_CENTER);
            doc.add(title);
            Paragraph name = new Paragraph("Customer Name: " + customer.getName());
            doc.add(name);
            Paragraph nameId = new Paragraph("Customer Email: " + customer.getEmail());
            doc.add(nameId);
            Paragraph nameC = new Paragraph("Customer Contact: " + customer.getPhone());
            doc.add(nameC);            
            
            PdfPTable tblCertificate = new PdfPTable(2);
            tblCertificate.addCell("Amount to be Coverted");
            tblCertificate.addCell("Amount Coverted To");
            tblCertificate.addCell(String.valueOf(curr) + fromCurrency);
            tblCertificate.addCell(decimalFormat.format(conCurr-forexCharged) + toCurrency);
            doc.add(tblCertificate);
            Paragraph concern = new Paragraph("If you have any questions or concerns, feel free to reach out to us .");
            concern.setSpacingBefore(100f);
            doc.add(concern);
            Paragraph email = new Paragraph("Email: stravelswift@gmail.com");
            email.setSpacingAfter(20f);
            doc.add(email);
            Paragraph electronicStatement = new Paragraph("This is an electronically generated document and doesn't require any signature or external verification.");
            electronicStatement.setSpacingBefore(50f);
            doc.add(electronicStatement);
            doc.close();
            JOptionPane.showMessageDialog(null, "Downloaded PDF File", "ALERT_MESSAGE", JOptionPane.WARNING_MESSAGE);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CustomerConvertCurrenyJPanel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(CustomerConvertCurrenyJPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnReceiptActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack2;
    private javax.swing.JButton btnConvertCurrency;
    private javax.swing.JButton btnReceipt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel lblCNYConvert;
    private javax.swing.JLabel lblConvertFrom;
    private javax.swing.JLabel lblConvertTo;
    private javax.swing.JLabel lblCurrencyConvert;
    private javax.swing.JLabel lblCurrentRate;
    private javax.swing.JLabel lblEURConvert;
    private javax.swing.JLabel lblINRConvert;
    private javax.swing.JComboBox<String> optionsConvertFrom;
    private javax.swing.JComboBox<String> optionsConvertTo;
    private javax.swing.JTextField txtCNYConvert;
    private javax.swing.JTextField txtConvertFrom;
    private javax.swing.JTextField txtEURConvert;
    private javax.swing.JTextField txtINRConvert;
    // End of variables declaration//GEN-END:variables
}


