package com.oodj_assignment.entity;

import com.oodj_assignment.Logoutable;
import com.oodj_assignment.UI.menu.MainMenu;
import com.oodj_assignment.UI.menu.MemberMenu;
import com.oodj_assignment.helper.RecordReader;
import com.oodj_assignment.helper.RecordUpdater;
import com.oodj_assignment.helper.RecordWriter;
import com.oodj_assignment.helper.RegexHelper;
import com.oodj_assignment.helper.UI.JTableInserter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;
import com.oodj_assignment.validation.ValidatableField;

public class Member extends Customer implements Logoutable {

    protected String email;
    protected String phoneNum;
    
    protected enum MemberField implements ValidatableField {
        EMAIL,
        PHONENUM,
    }
    
    public Member() {
        super();
    }
    
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
            validate(MemberField.EMAIL, email);
        } catch (IllegalArgumentException e) {
            throw e;
        }
        this.email = email.trim();
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setPhoneNum(String phoneNum) {
        try {
            validate(MemberField.PHONENUM, phoneNum);
        } catch (IllegalArgumentException e) {
            throw e;
        }
        this.phoneNum = phoneNum.trim();
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
    
    @Override
    public <T> void validate(ValidatableField field, T value) {
        if (field.equals(MemberField.EMAIL)) {
            String email = String.valueOf(value).trim();
            if (email.isEmpty()) {
                throwErr("Please enter your email.");
            } 
            if (!RegexHelper.check(email, "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
                throwErr("Invalid format of email."); 
            } 
            String[][] users = RecordReader.readFile("user.txt");
            for (String[] user : users) {
                if (user[1].equals(email)) {
                    throwErr("Email has been taken, please try another one."); 
                }
            }
        } else if (field.equals(MemberField.PHONENUM)) {
            String phoneNum = String.valueOf(value).trim();
            if (phoneNum.isEmpty()) {
                throwErr("Please enter your phone number.");
            } 
            if (!RegexHelper.check(phoneNum, "^(\\+?6?01)[0-46-9]-*[0-9]{7,8}$") ||
                phoneNum.contains(" ")) { 
                throwErr("Invalid phone number.");
            }
        } else {
            super.validate(field, value);
        }
    }    
    
}
