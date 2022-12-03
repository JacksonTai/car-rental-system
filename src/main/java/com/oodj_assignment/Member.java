package com.oodj_assignment;

import com.oodj_assignment.UI.menu.MainMenu;
import com.oodj_assignment.UI.menu.MemberMenu;
import com.oodj_assignment.helper.RecordReader;
import com.oodj_assignment.helper.RecordUpdater;
import com.oodj_assignment.helper.RecordWriter;
import com.oodj_assignment.helper.UI.JTableInserter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;

public class Member extends Customer implements Logoutable {

    protected String email;
    protected String phoneNum;
    
    public Member(String userID) {
        super(userID);
        String[][] users = RecordReader.readFile("user.txt");
        for (String[] user : users) {
            if (user[0].equals(userID)) {
                this.email = user[1];
                this.phoneNum = user[3];
                break;
            }
        }
    }
 
    public void setEmail(String email) {
        try {
            validateEmail(email.trim());
        } catch (IllegalArgumentException e) {
            throw e;
        }
        this.email = email;
    }
    
    public String getEmail() {
        return email;
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
        new MemberMenu(this).setVisible(true);
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
                bookingHistories.add(new String[] {
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
        JTable customerTable = MemberMenu.getTable();
        JTableInserter.insert(bookingHistoryField, bookingHistories.toArray(new String[0][]),
                customerTable); 
    }
   
    @Override
    public void logout(JFrame memberMenu) {
        memberMenu.dispose();
        new MainMenu().setVisible(true);
    }
    
}