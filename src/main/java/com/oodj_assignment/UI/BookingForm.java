/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.oodj_assignment.UI;

import com.oodj_assignment.Booking;
import com.oodj_assignment.Car;
import com.oodj_assignment.Customer;
import com.toedter.calendar.IDateEditor;
import com.toedter.calendar.JDateChooser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author KJ
 */
public class BookingForm extends javax.swing.JFrame {

    Customer customer;
    Booking booking;
    
    public BookingForm(){
        initComponents();
        Date date = new Date();
        pickupDateChooser.getJCalendar().setMinSelectableDate(date);
        returnDateChooser.getJCalendar().setMinSelectableDate(date);
    };
    
    public BookingForm(Customer customer, Booking booking) {
        this();
        this.customer = customer;
        this.booking = booking;
        Car selectedCar = booking.getSelectedCar(); 
        carPlateNumTf.setText(selectedCar.getPlateNum());
        modelTf.setText(selectedCar.getModel());
        colourTf.setText(selectedCar.getColour());
        priceTf.setText(Float.toString(selectedCar.getPricePerDay()));
    }
    
    private String jDateChooserToString(JDateChooser jDateChooser) {
        IDateEditor dateEditor = jDateChooser.getDateEditor();
        JTextField jTextField = (JTextField) dateEditor.getUiComponent();
        return jTextField.getText();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        backBtn = new javax.swing.JButton();
        returnDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel11 = new javax.swing.JLabel();
        pickupDateChooser = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        nextBtn = new javax.swing.JButton();
        carPlateNumTf = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        modelTf = new javax.swing.JTextField();
        colourTf = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        priceTf = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        backBtn.setBackground(new java.awt.Color(255, 255, 255));
        backBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        backBtn.setText("Back ");
        backBtn.setBorder(null);
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel11.setText("Return Date:");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Pick-up Date:");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Book Car");

        nextBtn.setBackground(new java.awt.Color(255, 255, 255));
        nextBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        nextBtn.setText("Next");
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });

        carPlateNumTf.setEditable(false);
        carPlateNumTf.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel9.setText("Car Model:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel10.setText("Car Plate Number:");

        modelTf.setEditable(false);
        modelTf.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        colourTf.setEditable(false);
        colourTf.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel12.setText("Colour:");

        priceTf.setEditable(false);
        priceTf.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel13.setText("Price/Day (RM)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(colourTf, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(carPlateNumTf))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(modelTf)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(0, 72, Short.MAX_VALUE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13)
                                    .addComponent(priceTf, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(pickupDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(returnDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)))
                .addGap(68, 68, 68))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pickupDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(carPlateNumTf, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(modelTf, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(colourTf, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(priceTf, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(5, 5, 5)
                        .addComponent(returnDateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        customer.viewMenu();
        dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        String errMsg = null;
        try {
            String pickupDate = jDateChooserToString(pickupDateChooser);
            String returnDate = jDateChooserToString(returnDateChooser);
            if (pickupDate.isEmpty()) {
                throw new NullPointerException("Pick-up date is a required field");
            } else if (returnDate.isEmpty()) {
                throw new NullPointerException("Return date is a required field");
            }
            System.out.println(pickupDate);
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            System.out.println(sdf.format(pickupDateChooser.getDate()));
            booking.setPickupDate(sdf.format(pickupDateChooser.getDate()));
            booking.setReturnDate(sdf.format(returnDateChooser.getDate()));
            customer.makePayment(booking);
            dispose();
        } catch (NullPointerException e) {
            errMsg = e.getMessage();
        } catch (ParseException e) {
            errMsg = "Invalid Format of Date! Please input dd-mm-yyyy";
        }
        if (null != errMsg) {
            JOptionPane.showMessageDialog(rootPane, errMsg);
        }
    }//GEN-LAST:event_nextBtnActionPerformed

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
            java.util.logging.Logger.getLogger(BookingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BookingForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField carPlateNumTf;
    private javax.swing.JTextField colourTf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField modelTf;
    private javax.swing.JButton nextBtn;
    private com.toedter.calendar.JDateChooser pickupDateChooser;
    private javax.swing.JTextField priceTf;
    private com.toedter.calendar.JDateChooser returnDateChooser;
    // End of variables declaration//GEN-END:variables
}
