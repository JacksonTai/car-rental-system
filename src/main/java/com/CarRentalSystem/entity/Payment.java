package com.CarRentalSystem.entity;

import com.CarRentalSystem.helper.IdGenerator;
import com.CarRentalSystem.helper.RecordReader;

public class Payment {

    private String paymentID;
    private Booking booking;

    public Payment(Booking booking) {
        this.paymentID = IdGenerator.generate("pmt-");
        this.booking = booking;
    }

    public Payment(String paymentID) {
        String[][] payments = RecordReader.readFile("payment.txt");
        for (String[] payment : payments) {
            if (paymentID.equals(payment[0])) {
                this.paymentID = payment[0];
                booking = new Booking(payment[1]);
                break;
            }
        }
    }
          
    public String getPaymentID() {
        return paymentID;
    }

    public Booking getBooking() {
        return booking;
    }
    
}
