/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oodj_assignment;

import com.oodj_assignment.helper.IdGenerator;
import com.oodj_assignment.helper.RecordReader;
import com.oodj_assignment.validation.BookingValidator;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author KJ
 */
public class Booking implements BookingValidator
{
    private String bookingID;
    private Customer customer;
    private Car selectedCar;
    private LocalDate pickupDate; 
    private LocalDate returnDate;
    
    public Booking(Customer customer, Car selectedCar) {
        this.bookingID = IdGenerator.generate("bkg-");
        this.customer = customer;
        if (selectedCar == null) {
            throw new NullPointerException("Car cannot be null.");
        }
        this.selectedCar = selectedCar;
    }
    
    public Booking (String bookingID) {
        String[][] bookings = RecordReader.readFile("booking.txt");
        for (String[] booking : bookings) {
            if (bookingID.equals(booking[0])) {
                this.bookingID = booking[0];
                customer = new Customer(booking[1]);
                selectedCar = new Car(booking[2]);
                pickupDate = LocalDate.parse(booking[3]);
                returnDate = LocalDate.parse(booking[4]);
                break;
            }
        }
    }
    
    public String getBookingID() {
        return bookingID;
    }
    
    public Customer getCustomer() {
        return customer;
    }
    
    public Car getSelectedCar() {
        return selectedCar;
    }
    
    public void setPickupDate(String pickupDate) { 
        try {
            this.pickupDate = validatePickupDate(pickupDate);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
    
    public LocalDate getPickupDate() {
        return pickupDate;
    }
    
    public void setReturnDate(String returnDate) {
        try {
            this.returnDate = validateReturnDate(returnDate, pickupDate);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }
    
    public LocalDate getReturnDate() {
        return returnDate;
    }
    
    public int getRentDuration() {
        return (int) ChronoUnit.DAYS.between(pickupDate, returnDate) + 1;
    }
    
}
