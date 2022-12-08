package com.oodj_assignment.UI.menu;
 
import com.oodj_assignment.UI.BookingStatus;
import com.oodj_assignment.entity.Car;
import com.oodj_assignment.entity.Member;
import com.oodj_assignment.UI.form.BookingForm;
import com.oodj_assignment.entity.Booking;
import com.oodj_assignment.helper.UI.JButtonActivator;
import com.oodj_assignment.helper.UI.JTableSelector;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class MemberMenu extends javax.swing.JFrame {

    Member member;
    JButtonActivator JBtnActivator;
    
    public MemberMenu(Member member) {
        initComponents();
        this.member = member;
        adminDashboardTitle.setText("Welcome " + member.getFullName()+ "!");  
        JButton[] memberMenuBtns = new JButton[] {bookCarBtn, myBookingBtn, bookHistoryBtn};
        JBtnActivator = new JButtonActivator(memberMenuBtns);
        JBtnActivator.activateBtn(bookCarBtn);
        viewBtn.setVisible(false);
        member.viewCar();
    }
    
    public static JTable getTable() {
        return memberTable;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        bookCarBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        bookHistoryBtn = new javax.swing.JButton();
        myBookingBtn = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        memberTable = new javax.swing.JTable();
        adminDashboardTitle = new javax.swing.JLabel();
        nextBtn = new javax.swing.JButton();
        bookCarHintLabel = new javax.swing.JLabel();
        viewBtn = new javax.swing.JButton();

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

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        bookCarBtn.setBackground(new java.awt.Color(255, 255, 255));
        bookCarBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bookCarBtn.setText("Book Car");
        bookCarBtn.setFocusPainted(false);
        bookCarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookCarBtnActionPerformed(evt);
            }
        });

        logoutBtn.setBackground(new java.awt.Color(255, 255, 255));
        logoutBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        logoutBtn.setText("Log out");
        logoutBtn.setFocusPainted(false);
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        bookHistoryBtn.setBackground(new java.awt.Color(255, 255, 255));
        bookHistoryBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bookHistoryBtn.setText("Booking History");
        bookHistoryBtn.setFocusPainted(false);
        bookHistoryBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bookHistoryBtnActionPerformed(evt);
            }
        });

        myBookingBtn.setBackground(new java.awt.Color(255, 255, 255));
        myBookingBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        myBookingBtn.setText("My Booking");
        myBookingBtn.setFocusPainted(false);
        myBookingBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myBookingBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bookCarBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bookHistoryBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(myBookingBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(46, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(168, 168, 168)
                .addComponent(bookCarBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(myBookingBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(bookHistoryBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 120, Short.MAX_VALUE)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(64, 64, 64))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        memberTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(memberTable);
        if (memberTable.getColumnModel().getColumnCount() > 0) {
            memberTable.getColumnModel().getColumn(0).setResizable(false);
            memberTable.getColumnModel().getColumn(1).setResizable(false);
            memberTable.getColumnModel().getColumn(2).setResizable(false);
            memberTable.getColumnModel().getColumn(3).setResizable(false);
        }

        adminDashboardTitle.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        adminDashboardTitle.setText("Welcome Back !");

        nextBtn.setBackground(new java.awt.Color(255, 255, 255));
        nextBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        nextBtn.setText("Next");
        nextBtn.setFocusPainted(false);
        nextBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextBtnActionPerformed(evt);
            }
        });

        bookCarHintLabel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        bookCarHintLabel.setText("# Click the one of the row in the table to select your desired car  : ) ");

        viewBtn.setBackground(new java.awt.Color(255, 255, 255));
        viewBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        viewBtn.setText("View");
        viewBtn.setFocusPainted(false);
        viewBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                    .addComponent(bookCarHintLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(adminDashboardTitle)
                        .addGap(385, 385, 385))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(154, 154, 154)
                        .addComponent(viewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(adminDashboardTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bookCarHintLabel)
                .addGap(30, 30, 30)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(viewBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bookCarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookCarBtnActionPerformed
        JBtnActivator.activateBtn(bookCarBtn);
        bookCarHintLabel.setVisible(true);
        nextBtn.setVisible(true);
        viewBtn.setVisible(false);
        member.viewCar();
    }//GEN-LAST:event_bookCarBtnActionPerformed
    
    private void bookHistoryBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bookHistoryBtnActionPerformed
        JBtnActivator.activateBtn(bookHistoryBtn);
        bookCarHintLabel.setVisible(false);
        nextBtn.setVisible(false);
        viewBtn.setVisible(false);
        member.viewBookingHistory();
    }//GEN-LAST:event_bookHistoryBtnActionPerformed

    private void nextBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextBtnActionPerformed
        try {
            String[] carRecord = JTableSelector.selectRow(memberTable);
            new BookingForm(member, new Car(carRecord[0])).setVisible(true);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Please select the car in table to book.");
        }
    }//GEN-LAST:event_nextBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        member.logout(this);
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void myBookingBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myBookingBtnActionPerformed
        JBtnActivator.activateBtn(myBookingBtn);
        bookCarHintLabel.setVisible(false);
        viewBtn.setVisible(true);
        member.viewBookingStatus();
    }//GEN-LAST:event_myBookingBtnActionPerformed

    private void viewBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewBtnActionPerformed
        try {
            String[] bookingRecord = JTableSelector.selectRow(memberTable);
            new BookingStatus(new Booking(bookingRecord[0])).setVisible(true);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Please select the booking in table to view.");
        }
    }//GEN-LAST:event_viewBtnActionPerformed
    
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
            java.util.logging.Logger.getLogger(MemberMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MemberMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MemberMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MemberMenu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JLabel adminDashboardTitle;
    private javax.swing.JButton bookCarBtn;
    private javax.swing.JLabel bookCarHintLabel;
    private javax.swing.JButton bookHistoryBtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutBtn;
    private static javax.swing.JTable memberTable;
    private javax.swing.JButton myBookingBtn;
    private javax.swing.JButton nextBtn;
    private javax.swing.JButton viewBtn;
    // End of variables declaration//GEN-END:variables
}
