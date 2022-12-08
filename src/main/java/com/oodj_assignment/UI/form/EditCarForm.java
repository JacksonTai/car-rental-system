package com.oodj_assignment.UI.form;

import com.oodj_assignment.UI.menu.AdminMenu;
import com.oodj_assignment.entity.Admin;
import com.oodj_assignment.entity.Car;
import javax.swing.JOptionPane;

public class EditCarForm extends javax.swing.JFrame {
    
    Admin admin;
    Car selectedCar;

    public EditCarForm(Admin admin, Car selectedCar) {
        initComponents();
        this.admin = admin;
        this.selectedCar = selectedCar;
        plateNumTf.setText(selectedCar.getPlateNum());
        modelTf.setText(selectedCar.getModel());
        colourTf.setText(selectedCar.getColour());
        pricePerDayTf.setText(Float.toString(selectedCar.getPricePerDay()));
        statusComboBox.setSelectedItem(selectedCar.getStatus());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        addCarPanel = new javax.swing.JPanel();
        AddCarTitle = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        plateNumTf = new javax.swing.JTextField();
        plateNumLabel = new javax.swing.JLabel();
        modelLabel = new javax.swing.JLabel();
        modelTf = new javax.swing.JTextField();
        colourTf = new javax.swing.JTextField();
        colourLabel = new javax.swing.JLabel();
        pricePerDayTf = new javax.swing.JTextField();
        pricePerDayLabel = new javax.swing.JLabel();
        confirmBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        statusComboBox = new javax.swing.JComboBox<>();
        statusLabel = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(58, 63, 84));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 145, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(240, 240, 240), 10, true));

        addCarPanel.setBackground(new java.awt.Color(255, 255, 255));

        AddCarTitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        AddCarTitle.setText("Edit Car");

        backBtn.setBackground(new java.awt.Color(255, 255, 255));
        backBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        backBtn.setText("Back");
        backBtn.setBorder(null);
        backBtn.setFocusPainted(false);
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        plateNumTf.setEditable(false);
        plateNumTf.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        plateNumLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        plateNumLabel.setText("Plate number");

        modelLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        modelLabel.setText("Model");

        modelTf.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        colourTf.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        colourLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        colourLabel.setText("Colour");

        pricePerDayTf.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        pricePerDayLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        pricePerDayLabel.setText("Price/Day (RM)");

        confirmBtn.setBackground(new java.awt.Color(255, 255, 255));
        confirmBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        confirmBtn.setText("Confirm");
        confirmBtn.setFocusPainted(false);
        confirmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmBtnActionPerformed(evt);
            }
        });

        clearBtn.setBackground(new java.awt.Color(255, 255, 255));
        clearBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        clearBtn.setText("Clear");
        clearBtn.setFocusPainted(false);
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        statusComboBox.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        statusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Available", "N/A" }));

        statusLabel.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        statusLabel.setText("Status");

        javax.swing.GroupLayout addCarPanelLayout = new javax.swing.GroupLayout(addCarPanel);
        addCarPanel.setLayout(addCarPanelLayout);
        addCarPanelLayout.setHorizontalGroup(
            addCarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addCarPanelLayout.createSequentialGroup()
                .addGap(272, 272, 272)
                .addComponent(AddCarTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, addCarPanelLayout.createSequentialGroup()
                .addGroup(addCarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(addCarPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addCarPanelLayout.createSequentialGroup()
                        .addGroup(addCarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(addCarPanelLayout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addGroup(addCarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(plateNumLabel)
                                    .addComponent(plateNumTf, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(colourTf, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(colourLabel)
                                    .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(statusLabel)))
                            .addGroup(addCarPanelLayout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                        .addGroup(addCarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pricePerDayTf, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pricePerDayLabel)
                            .addComponent(modelLabel)
                            .addComponent(modelTf, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(141, 141, 141))
        );
        addCarPanelLayout.setVerticalGroup(
            addCarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addCarPanelLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(AddCarTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(addCarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addCarPanelLayout.createSequentialGroup()
                        .addComponent(plateNumLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(plateNumTf, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addCarPanelLayout.createSequentialGroup()
                        .addComponent(modelLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(modelTf, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(addCarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addCarPanelLayout.createSequentialGroup()
                        .addComponent(colourLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(colourTf, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addCarPanelLayout.createSequentialGroup()
                        .addComponent(pricePerDayLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(pricePerDayTf, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(statusLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(addCarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addCarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(confirmBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(clearBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(statusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addCarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(addCarPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        dispose();
        new AdminMenu(admin).setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void confirmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmBtnActionPerformed
        try {
            selectedCar.setPlateNum(plateNumTf.getText());
            selectedCar.setModel(modelTf.getText());
            selectedCar.setColour(colourTf.getText());
            selectedCar.setPricePerDay(pricePerDayTf.getText());
            selectedCar.setStatus(String.valueOf(statusComboBox.getSelectedItem()));
            admin.editCar(selectedCar);
            JOptionPane.showMessageDialog(rootPane, "Car edited successfully");
            dispose();
            new AdminMenu(admin).setVisible(true);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage());
        }
    }//GEN-LAST:event_confirmBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        modelTf.setText("");
        colourTf.setText("");
        pricePerDayTf.setText("");
    }//GEN-LAST:event_clearBtnActionPerformed

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
            java.util.logging.Logger.getLogger(EditCarForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EditCarForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EditCarForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EditCarForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
 
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AddCarTitle;
    private javax.swing.JPanel addCarPanel;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JLabel colourLabel;
    private javax.swing.JTextField colourTf;
    private javax.swing.JButton confirmBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel modelLabel;
    private javax.swing.JTextField modelTf;
    private javax.swing.JLabel plateNumLabel;
    private javax.swing.JTextField plateNumTf;
    private javax.swing.JLabel pricePerDayLabel;
    private javax.swing.JTextField pricePerDayTf;
    private javax.swing.JComboBox<String> statusComboBox;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}
