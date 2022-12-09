package com.oodj_assignment.entity;

import com.oodj_assignment.Logoutable;
import com.oodj_assignment.UI.menu.MainMenu;
import com.oodj_assignment.UI.menu.MemberMenu;
import com.oodj_assignment.entity.Booking.Status;
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
            validate("email", email);
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
            validate("phoneNum", phoneNum);
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
        String status = booking.getStatus().name();
        String[] bookingRecord = new String[]{bookingID, userID, plateNum, pickupDate, returnDate, 
                                                status};
        RecordWriter.write(bookingRecord, "booking.txt");
    }
    
    public void makePayment(Payment payment) {
        Booking booking = payment.getBooking();
        Car selectedCar = booking.getSelectedCar();  
        String paymentID = payment.getPaymentID();
        String bookingID = booking.getBookingID();
        String paymentDate = LocalDate.now().toString();
        String totalPrice = String.valueOf(booking.getTotalPrice());
        String[] paymentRecord = new String[]{paymentID, bookingID, paymentDate, totalPrice};
        RecordWriter.write(paymentRecord, "payment.txt");
        
        // Update car status.
        selectedCar.setStatus("N/A");
        String plateNum = selectedCar.getPlateNum();
        String model = selectedCar.getModel();
        String colour = selectedCar.getColour();
        String pricePerDay = String.valueOf(selectedCar.getPricePerDay());
        String carStatus = selectedCar.getStatus();
        String[] carRecord = new String[] {plateNum, model, colour, pricePerDay, carStatus};
        RecordUpdater.update(carRecord, "car.txt");
        
        // Update booking status.
        String customerID = booking.getMember().getUserID();
        booking.setStatus(Status.PAID);
        String bookingStatus = booking.getStatus().name();
        String pickupDate = booking.getPickupDate().toString();
        String returnDate = booking.getReturnDate().toString();
        String[] bookingRecord = new String[] {bookingID, customerID, plateNum, pickupDate, 
            returnDate, bookingStatus};
        RecordUpdater.update(bookingRecord, "booking.txt");
    }
    
    public void viewBookingRequest() {
        String[] field = {"Booking ID", "Plate number", "Pick-up date", "Return date", 
            "Duration(Day)", "Price/Day", "Total price", "Status"};
        String[][] bookingRecords = RecordReader.readFile("booking.txt");
        List<String[]> bookingRequests = new ArrayList();
        if (bookingRecords.length > 0) {
            for (String[] bookingRecord : bookingRecords) {
                if (bookingRecord[1].equals(userID) && (
                        bookingRecord[5].equals(Status.PENDING.name()) || 
                        bookingRecord[5].equals(Status.APPROVED.name())
                        )
                    ) {
                    Booking booking = new Booking(bookingRecord[0]);
                    bookingRequests.add(new String[] {
                        booking.getBookingID(),
                        booking.getSelectedCar().getPlateNum(),
                        booking.getPickupDate().toString(),
                        booking.getReturnDate().toString(),
                        String.valueOf(booking.getRentDuration()),
                        String.valueOf(booking.getSelectedCar().getPricePerDay()),
                        String.valueOf(booking.getTotalPrice()),
                        booking.getStatus().name()
                    });
                }
            }    
        }
        JTable memberTable = MemberMenu.getTable();
        JTableInserter.insert(field, bookingRequests.toArray(new String[0][]), memberTable); 
    }
    
    public void viewBookingHistory() {
        String[] field = {"Booking ID", "Plate number", "Pick-up date", "Return date", 
            "Duration(Day)", "Price/Day", "Total price", "Status"};
        String[][] bookingRecords = RecordReader.readFile("booking.txt");
        List<String[]> bookingHistories = new ArrayList();
        if (bookingRecords.length > 0) {
            for (String[] bookingRecord : bookingRecords) {
                if (bookingRecord[1].equals(userID) && (
                        bookingRecord[5].equals(Status.PAID.name()) || 
                        bookingRecord[5].equals(Status.REJECTED.name())
                        )
                    ) {
                    Booking booking = new Booking(bookingRecord[0]);
                    bookingHistories.add(new String[] {
                        booking.getBookingID(),
                        booking.getSelectedCar().getPlateNum(),
                        booking.getPickupDate().toString(),
                        booking.getReturnDate().toString(),
                        String.valueOf(booking.getRentDuration()),
                        String.valueOf(booking.getSelectedCar().getPricePerDay()),
                        String.valueOf(booking.getTotalPrice()),
                        booking.getStatus().name()
                    });
                }
            }    
        }
        JTable memberTable = MemberMenu.getTable();
        JTableInserter.insert(field, bookingHistories.toArray(new String[0][]), memberTable); 
    }
   
    @Override
    public void logout(JFrame memberMenu) {
        memberMenu.dispose();
        new MainMenu().setVisible(true);
    }
    
    @Override
    public void validate(String field, String value) {
        switch (field) {
            case "email" -> {
                String email = value.trim();
                if (email.isEmpty()) {
                    throwErr("Please enter your email.");
                }
                if (!email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
                    throwErr("Invalid format of email.");
                }   
                String[][] users = RecordReader.readFile("user.txt");
                for (String[] user : users) {
                    if (user[1].equals(email)) {
                        throwErr("Email has been taken, please try another one.");
                    }
                }
            }
            case "phoneNum" -> {
                String phoneNum = String.valueOf(value).trim();
                if (phoneNum.isEmpty()) {
                    throwErr("Please enter your phone number.");
                }
                if (!phoneNum.matches("^(\\+?6?01)[0-46-9]-*[0-9]{7,8}$") || phoneNum.contains(" ")) {
                    throwErr("Invalid phone number.");
                }
            }
            default -> super.validate(field, value);
        }
    }    
    
}
