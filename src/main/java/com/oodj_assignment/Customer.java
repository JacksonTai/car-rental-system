/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oodj_assignment;

import com.oodj_assignment.UI.CustomerMenu;
import com.oodj_assignment.helper.ArrayUtils;
import com.oodj_assignment.helper.IdGenerator;
import com.oodj_assignment.helper.InfoContainer;
import com.oodj_assignment.helper.RecordReader;
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
    
    public Customer(String[] customerInfo) {
        if (null != customerInfo && customerInfo.length >= 5) {
            this.userID = customerInfo[0];
            this.email = customerInfo[1];
            this.username = customerInfo[2];
            this.phoneNum = customerInfo[3];
            this.password = customerInfo[4];
        }
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    
    public String getPhoneNum() {
        return this.phoneNum;
    }

    @Override
        public void viewMenu() {
        new CustomerMenu(this).setVisible(true);
    }
    
    public InfoContainer signup(String [] signupInput) {
        String newEmail = signupInput[0].trim();
        String newUsername = signupInput[1].trim();
        String newPhoneNum = signupInput[2].trim();
        String newPassword = signupInput[3].trim();
        String confirmPassword = signupInput[4].trim();
        String errMsg = UserValidator.validateEmail(newEmail);
        if (null == errMsg) {
            errMsg = UserValidator.validateUsername(newUsername);
        }
        if (null == errMsg) {
            errMsg = UserValidator.validatePhoneNum(newPhoneNum);
        }
        if (null == errMsg) {
            errMsg = UserValidator.validatePassword(newPassword);
        }
        if (null == errMsg) {
            if (confirmPassword.isEmpty()) { 
                errMsg = "Please confirm your password.";
            } else if (!confirmPassword.equals(newPassword)) {
                errMsg = "Password do not match.";
            } 
        }
        InfoContainer signupInfo = new InfoContainer();
        if (null == errMsg) {
            String newCustomerID = IdGenerator.generate("ctm-");
            signupInfo.set("newCustomerID", newCustomerID);
            signupInfo.set("newEmail", newEmail);
            signupInfo.set("newUsername", newUsername);
            signupInfo.set("newPhoneNum", newPhoneNum);
            signupInfo.set("newPassword", newPassword);
            RecordWriter.write(new String[] { 
                signupInfo.get("newCustomerID"),
                signupInfo.get("newEmail"),
                signupInfo.get("newUsername"),
                signupInfo.get("newPhoneNum"),
                signupInfo.get("newPassword"),
            }, "user.txt");
        } else {
            signupInfo.set("errMsg", errMsg);
        }
        return signupInfo;
    }
    
    public void viewCar() {
        String[] carFields = {"Plate Number", "Model", "Colour", "Price/Day"};
        String[][] carsInfo = RecordReader.readFile("car.txt");
        JTable bookingtable = CustomerMenu.getTable();
        JTableInserter.insert(carFields, carsInfo, bookingtable);
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
        JTable bookingtable = CustomerMenu.getTable();
        JTableInserter.insert(carFields, bookingHistories, bookingtable); 
    }
    
    public Booking makeBooking(Car selectedCar) {
        Booking booking = new Booking();
        booking.setSelectedCar(selectedCar);
        return booking;
    }
    
    public void makePayment(Booking booking) {
         
    }

}
