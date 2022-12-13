package com.CarRentalSystem.UI;

import com.CarRentalSystem.UI.menu.AdminMenu;
import com.CarRentalSystem.entity.Admin;
import com.CarRentalSystem.entity.Booking;
import com.CarRentalSystem.entity.Car;
import com.CarRentalSystem.entity.Member;

import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import javax.swing.JOptionPane;

public class BookingManagement extends javax.swing.JFrame {
    
    Admin admin;
    Booking booking;
    Car selectedCar;
    LocalDate pickupDate;
    LocalDate returnDate;
    Member member;
 
    public BookingManagement(Admin admin, Booking booking) {
        initComponents();
        this.admin = admin;
        this.booking = booking;
        this.selectedCar = booking.getSelectedCar();
        this.pickupDate = booking.getPickupDate();
        this.returnDate = booking.getReturnDate();
        this.member = booking.getMember();
        previewUserDetails();
        previewCarDetails();
        previewBookingDetails();
    }
    
    private void previewUserDetails() {
        userIDTf.setText(member.getUserID());
        fullNameTf.setText(member.getFullName());
        phoneNumTf.setText(member.getPhoneNum());
        emailTf.setText(member.getEmail());
    }  
    
    private void previewCarDetails() {
        modelTf.setText(selectedCar.getModel());
        plateNumTf.setText(selectedCar.getPlateNum());
        colourTf.setText(selectedCar.getColour());
        pricePerDayTf.setText(String.valueOf(selectedCar.getPricePerDay()));
    }

    private void previewBookingDetails(){
        bookingIDTf.setText(booking.getBookingID());
        String datePattern = "dd MMM yyyy";
        pickupDateTf.setText(pickupDate.format(DateTimeFormatter.ofPattern(datePattern)));
        returnDateTf.setText(returnDate.format(DateTimeFormatter.ofPattern(datePattern)));
        int rentDuration = booking.getRentDuration();
        rentDurationTf.setText(String.valueOf(rentDuration) + (rentDuration > 1 ? " Days" : " Day"));
        totalPriceTf.setText("RM" + String.valueOf(booking.getTotalPrice()));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        colourTf = new javax.swing.JTextField();
        plateNumTf = new javax.swing.JTextField();
        modelTf = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        pickupDateTf = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        returnDateTf = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        rentDurationTf = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel17 = new javax.swing.JLabel();
        pricePerDayTf = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        totalPriceTf = new javax.swing.JTextField();
        approveBtn = new javax.swing.JButton();
        rejectBtn = new javax.swing.JButton();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        fullNameTf = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        phoneNumTf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        emailTf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        userIDTf = new javax.swing.JTextField();
        bookingIDTf = new javax.swing.JTextField();
        backBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Manage Booking Request");

        jSeparator1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Car details");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel15.setText("Model");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel16.setText("Plate Number:");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel14.setText("Colour:");

        colourTf.setEditable(false);
        colourTf.setBackground(new java.awt.Color(255, 255, 255));
        colourTf.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        colourTf.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        colourTf.setText("Blue");
        colourTf.setBorder(null);

        plateNumTf.setEditable(false);
        plateNumTf.setBackground(new java.awt.Color(255, 255, 255));
        plateNumTf.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        plateNumTf.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        plateNumTf.setText("JI1230");
        plateNumTf.setBorder(null);

        modelTf.setEditable(false);
        modelTf.setBackground(new java.awt.Color(255, 255, 255));
        modelTf.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        modelTf.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        modelTf.setText("Bezza");
        modelTf.setBorder(null);

        jLabel18.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel18.setText("Pick-up Date:");

        pickupDateTf.setEditable(false);
        pickupDateTf.setBackground(new java.awt.Color(255, 255, 255));
        pickupDateTf.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pickupDateTf.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        pickupDateTf.setText("8 Dec 2022");
        pickupDateTf.setBorder(null);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setText("Booking details");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel19.setText("Return Date:");

        returnDateTf.setEditable(false);
        returnDateTf.setBackground(new java.awt.Color(255, 255, 255));
        returnDateTf.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        returnDateTf.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        returnDateTf.setText("10 Dec 2022");
        returnDateTf.setBorder(null);

        jLabel20.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel20.setText("Rent Duration:");

        rentDurationTf.setEditable(false);
        rentDurationTf.setBackground(new java.awt.Color(255, 255, 255));
        rentDurationTf.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        rentDurationTf.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        rentDurationTf.setText("3 Days");
        rentDurationTf.setBorder(null);

        jSeparator3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel17.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel17.setText("Price/Day");

        pricePerDayTf.setEditable(false);
        pricePerDayTf.setBackground(new java.awt.Color(255, 255, 255));
        pricePerDayTf.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        pricePerDayTf.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        pricePerDayTf.setText("RM50");
        pricePerDayTf.setBorder(null);

        jLabel21.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel21.setText("Total Price");

        totalPriceTf.setEditable(false);
        totalPriceTf.setBackground(new java.awt.Color(255, 255, 255));
        totalPriceTf.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        totalPriceTf.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        totalPriceTf.setText("RM150");
        totalPriceTf.setBorder(null);

        approveBtn.setBackground(new java.awt.Color(9, 117, 240));
        approveBtn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        approveBtn.setForeground(new java.awt.Color(255, 255, 255));
        approveBtn.setText("Approve");
        approveBtn.setBorder(null);
        approveBtn.setBorderPainted(false);
        approveBtn.setDefaultCapable(false);
        approveBtn.setFocusPainted(false);
        approveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                approveBtnActionPerformed(evt);
            }
        });

        rejectBtn.setBackground(new java.awt.Color(255, 0, 0));
        rejectBtn.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        rejectBtn.setForeground(new java.awt.Color(255, 255, 255));
        rejectBtn.setText("Reject");
        rejectBtn.setBorder(null);
        rejectBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rejectBtnActionPerformed(evt);
            }
        });

        jSeparator4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setText("User details");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel3.setText("Full name:");

        fullNameTf.setEditable(false);
        fullNameTf.setBackground(new java.awt.Color(255, 255, 255));
        fullNameTf.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        fullNameTf.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        fullNameTf.setText("John Doe");
        fullNameTf.setBorder(null);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel9.setText("Phone number:");

        phoneNumTf.setEditable(false);
        phoneNumTf.setBackground(new java.awt.Color(255, 255, 255));
        phoneNumTf.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        phoneNumTf.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        phoneNumTf.setText("0123456789");
        phoneNumTf.setBorder(null);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel5.setText("Email:");

        emailTf.setEditable(false);
        emailTf.setBackground(new java.awt.Color(255, 255, 255));
        emailTf.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        emailTf.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        emailTf.setText("email@gmail.com");
        emailTf.setBorder(null);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel4.setText("User ID:");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jLabel10.setText("Booking ID:");

        userIDTf.setEditable(false);
        userIDTf.setBackground(new java.awt.Color(255, 255, 255));
        userIDTf.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        userIDTf.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        userIDTf.setText("ctm-723c1178-2b71-21e9-x953-7d5dceebaf42");
        userIDTf.setBorder(null);

        bookingIDTf.setEditable(false);
        bookingIDTf.setBackground(new java.awt.Color(255, 255, 255));
        bookingIDTf.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        bookingIDTf.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        bookingIDTf.setText("bkg-50a49333-a71f-4d86-a77b-670348ca6fcf");
        bookingIDTf.setBorder(null);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(277, 277, 277)
                        .addComponent(rejectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(approveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(25, 25, 25)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pricePerDayTf, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(modelTf)
                                        .addComponent(plateNumTf, javax.swing.GroupLayout.DEFAULT_SIZE, 409, Short.MAX_VALUE))
                                    .addComponent(colourTf, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(88, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(62, 62, 62)
                                        .addComponent(emailTf, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fullNameTf, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(phoneNumTf, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(userIDTf, javax.swing.GroupLayout.PREFERRED_SIZE, 383, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(rentDurationTf, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(returnDateTf, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pickupDateTf, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(totalPriceTf)
                                    .addComponent(bookingIDTf, javax.swing.GroupLayout.DEFAULT_SIZE, 391, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 2, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userIDTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fullNameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(phoneNumTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(13, 13, 13)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(modelTf, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(plateNumTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(colourTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pricePerDayTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bookingIDTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pickupDateTf))
                .addGap(4, 4, 4)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(returnDateTf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rentDurationTf))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalPriceTf)
                    .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(approveBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rejectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void approveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_approveBtnActionPerformed
        String confirmTitle = "Approve Booking";
        String confirmMsg = "Are you sure to approve this booking?";
        int response = JOptionPane.showConfirmDialog(rootPane, confirmMsg, confirmTitle, 
                JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE
        );
        if (response == JOptionPane.YES_OPTION) {
            booking.setStatus(Booking.BookingStatus.APPROVED);
            admin.updateBookingRequest(booking);
            JOptionPane.showMessageDialog(rootPane, "Booking approved.");
            dispose();
            AdminMenu adminMenu = new AdminMenu(admin);
            adminMenu.setVisible(true);
            adminMenu.actionPerformed(evt);
        }
    }//GEN-LAST:event_approveBtnActionPerformed

    private void rejectBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rejectBtnActionPerformed
        String confirmTitle = "Reject Booking";
        String confirmMsg = "Are you sure to reject this booking?";
        int response = JOptionPane.showConfirmDialog(rootPane, confirmMsg, confirmTitle, 
                JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE
        );
        if (response == JOptionPane.YES_OPTION) {
            booking.setStatus(Booking.BookingStatus.REJECTED);
            booking.getSelectedCar().setStatus("Available");
            admin.updateBookingRequest(booking);
            JOptionPane.showMessageDialog(rootPane, "Booking rejected.");
            dispose();
            AdminMenu adminMenu = new AdminMenu(admin);
            adminMenu.setVisible(true);
            adminMenu.actionPerformed(evt);
        }
    }//GEN-LAST:event_rejectBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        dispose();
        AdminMenu adminMenu = new AdminMenu(admin);
        adminMenu.setVisible(true);
        adminMenu.actionPerformed(evt);
    }//GEN-LAST:event_backBtnActionPerformed

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
            java.util.logging.Logger.getLogger(BookingManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BookingManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BookingManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BookingManagement.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton approveBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField bookingIDTf;
    private javax.swing.JTextField colourTf;
    private javax.swing.JTextField emailTf;
    private javax.swing.JTextField fullNameTf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField modelTf;
    private javax.swing.JTextField phoneNumTf;
    private javax.swing.JTextField pickupDateTf;
    private javax.swing.JTextField plateNumTf;
    private javax.swing.JTextField pricePerDayTf;
    private javax.swing.JButton rejectBtn;
    private javax.swing.JTextField rentDurationTf;
    private javax.swing.JTextField returnDateTf;
    private javax.swing.JTextField totalPriceTf;
    private javax.swing.JTextField userIDTf;
    // End of variables declaration//GEN-END:variables

}
