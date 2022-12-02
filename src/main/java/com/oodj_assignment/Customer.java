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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
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
    
    public Customer(String userID)   {
        String[][] users = RecordReader.readFile("user.txt");
        for (String[] user : users) {
            if (userID.equals(user[0])) {
                this.userID = userID;
                this.email = user[1];
                this.username = user[2];
                this.phoneNum = user[3];
                this.password = user[4]; 
                break;
            }
        }
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
    
    public void signUp(String email, String username, String phoneNum, String password, 
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
    
    public void viewBookingHistory() {
        String[] bookingHistoryField = {"Booking ID", "Plate number", "Pick-up date", "Return date", 
            "Duration(Day)", "Price/Day", "Total price"};
        String[][] bookingRecords = RecordReader.readFile("booking.txt");
        String[][] paymentRecords = RecordReader.readFile("payment.txt");
        List<String[]> bookingHistories = new ArrayList();
        if (bookingRecords.length > 0) {
            for (int i = 0; i < bookingRecords.length; i++) {
            if (bookingRecords[i][1].equals(userID)) {
                Booking booking = new Booking(bookingRecords[i][0]);
                Payment payment = new Payment(paymentRecords[i][0]);
                bookingHistories.add(new String[]{
                    booking.getBookingID(),
                    booking.getSelectedCar().getPlateNum(),
                    booking.getPickupDate().toString(),
                    booking.getReturnDate().toString(),
                    String.valueOf(booking.getRentDuration()),
                    String.valueOf(booking.getSelectedCar().getPricePerDay()),
                    String.valueOf(payment.getTotalPrice())
                    });
                }
            }    
        }
        JTable customerTable = CustomerMenu.getTable();
        JTableInserter.insert(bookingHistoryField, bookingHistories.toArray(new String[0][]),
                customerTable); 
    }
    
    public void makeBooking(Booking booking) {
        Car selectedCar = booking.getSelectedCar();        
        String bookingID = booking.getBookingID();
        String plateNum = selectedCar.getPlateNum();
        String pickupDate = booking.getPickupDate().toString();
        String returnDate = booking.getReturnDate().toString();
        String[] bookingRecord = new String[]{bookingID, userID, plateNum, pickupDate, returnDate};
        RecordWriter.write(bookingRecord, "booking.txt");
        
        // Update car status.
        selectedCar.setStatus("N/A");
        String model = selectedCar.getModel();
        String colour = selectedCar.getColour();
        String pricePerDay = String.valueOf(selectedCar.getPricePerDay());
        String status = selectedCar.getStatus();
        String[] carRecord = new String[] {plateNum, model, colour, pricePerDay, status};
        RecordUpdater.update(carRecord, "car.txt");
    }
    
    public void makePayment(Payment payment) {
        String paymentID = payment.getPaymentID();
        String bookingID = payment.getBooking().getBookingID();
        String paymentDate = LocalDate.now().toString();
        String totalPrice = String.valueOf(payment.getTotalPrice());
        String[] paymentRecord = new String[]{paymentID, bookingID, paymentDate, totalPrice};
        RecordWriter.write(paymentRecord, "payment.txt");
    }

}
