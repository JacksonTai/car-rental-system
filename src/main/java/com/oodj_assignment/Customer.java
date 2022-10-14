/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oodj_assignment;

import com.oodj_assignment.UI.CustomerMenu;
import com.oodj_assignment.helper.ArrayUtils;
import com.oodj_assignment.helper.IdGenerator;
import com.oodj_assignment.helper.RecordReader;
import com.oodj_assignment.helper.RecordUpdater;
import com.oodj_assignment.helper.RecordWriter;
import com.oodj_assignment.helper.UI.JTableInserter;
import com.oodj_assignment.validation.UserValidator;
import javax.swing.JTable;

/**
 *
 * @author Jackson
 */
public class Customer extends User {

    private String username;
    private String phoneNum;
    
    public Customer() {
        super();
        this.username = null;
        this.phoneNum = null;
    }
    
    public Customer(String userID, String email, String username, String phoneNum, 
            String password) throws Exception {
        try {
            UserValidator.validateCredential(email, password);
        } catch (Exception e) {
            throw e;
        }
        this.userID = userID;
        this.email = email;
        this.username = username;
        this.phoneNum = phoneNum;
        this.password = password; 
    }
    
    public void setUsername(String username) {
        try {
            validateUsername(username.trim());
        } catch (IllegalArgumentException e) {
            throw e;
        }
        this.username = username;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setPhoneNum(String phoneNum) {
        try {
            validatePhoneNum(phoneNum.trim());
        } catch (IllegalArgumentException e) {
            throw e;
        }
        this.phoneNum = phoneNum;
    }
    
    public String getPhoneNum() {
        return phoneNum;
    }

    @Override
        public void viewMenu() {
        new CustomerMenu(this).setVisible(true);
    }
    
    public void signup(String email, String username, String phoneNum, String password, 
            String confirmPassword) throws Exception {
        try {
            validateEmail(email);
            validateUsername(username);
            validatePhoneNum(phoneNum);
            validatePassword(password); 
            if (null != userID) {
                throw new Exception("Customer has been signed up");
            } else if (confirmPassword.trim().isEmpty()) { 
                throw new Exception("Please confirm your password.");
            } else if (!confirmPassword.trim().equals(password.trim())) {
                throw new Exception("Password do not match.");
            }
        } catch (Exception e) {
            throw e;
        }
        this.userID = IdGenerator.generate("ctm-");
        this.email = email;
        this.username = username;
        this.phoneNum = phoneNum;
        this.password = password; 
        RecordWriter.write(new String[] {userID, email, username, phoneNum, password,}, "user.txt");
    }
    
    public void viewCar() {
        String[] carFields = {"Plate Number", "Model", "Colour", "Price/Day"};
        String[][] carsInfo = RecordReader.readFile("car.txt");
        for (String[] carInfo : carsInfo) {
            if (carInfo[4].equals("N/A")) {
                carsInfo = ArrayUtils.removeElement(carsInfo, carInfo); 
            }
        }
        JTable customerTable = CustomerMenu.getTable();
        JTableInserter.insert(carFields, carsInfo, customerTable);
    }
    
    public void viewbookingHistory() {
        String[] carFields = {"Booking ID", "Plate Number", "Pick-up Date", "Return Date", 
            "Duration", "Price/Day", "Total Price"};
        String[][] bookingHistories = RecordReader.readFile("booking.txt");
        for (String[] bookingHistory : bookingHistories) {
            if (!bookingHistory[0].equals(userID)) {
                bookingHistories = ArrayUtils.removeElement(bookingHistories, bookingHistory); 
            }
        }
        for (int i = 0; i < bookingHistories.length; i++) {
            bookingHistories[i] = ArrayUtils.removeElement( bookingHistories[i], userID);
        }
        JTable customerTable = CustomerMenu.getTable();
        JTableInserter.insert(carFields, bookingHistories, customerTable); 
    }
    
    public void makeBooking(Booking booking) {
        Car selectedCar = booking.getSelectedCar();        
        String bookingID = booking.getBookingID();
        String plateNum = selectedCar.getPlateNum();
        String pickupDate = booking.getPickupDate().toString();
        String returnDate = booking.getReturnDate().toString();
        RecordWriter.write(new String[]{bookingID, userID, plateNum, pickupDate, returnDate}, 
                "booking.txt");
        
        // Update car status.
        selectedCar.setStatus("N/A");
        RecordUpdater.update(selectedCar.toArray(), "car.txt");
    }
    
    public void makePayment(Payment payment) {
        String paymentID = payment.getPaymentID();
        String customerID = payment.getCustomer().getUserID();
        String bookingID = payment.getBooking().getBookingID();
        String totalPrice = String.valueOf(payment.getTotalPrice());
        RecordWriter.write(new String[]{paymentID, bookingID, customerID, totalPrice}, "payment.txt");
    }

}
