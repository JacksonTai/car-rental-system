package com.oodj_assignment;

import com.oodj_assignment.helper.IdGenerator;

public class Payment {

    private String paymentID; 
    private Booking booking;

    public Payment(Booking booking) {
        this.paymentID = IdGenerator.generate("pmt-");
        this.booking = booking;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public Customer getCustomer() {
        return booking.getCustomer();
    }

    public Booking getBooking() {
        return booking;
    }
    
    public float getTotalPrice(){
        return booking.getSelectedCar().getPricePerDay() * booking.getRentDuration();
    }
    
}
