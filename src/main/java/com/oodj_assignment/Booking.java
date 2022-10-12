/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oodj_assignment;

import com.oodj_assignment.helper.IdGenerator;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author KJ
 */
public class Booking 
{
    private final String bookingID;
    private LocalDate pickupDate; 
    private LocalDate returnDate;
    private Car selectedCar;
    private final DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd MMM yyyy");
    
    public Booking() {
        this.bookingID = IdGenerator.generate("bkg-");
    }
    
    public String getBookingID() {
        return this.bookingID;
    }
    
    public void setSelectedCar(Car selectedCar) {
        if (selectedCar == null) {
            throw new NullPointerException("Car cannot be null.");
        }
        this.selectedCar = selectedCar;
    }
    
    public Car getSelectedCar() {
        return this.selectedCar;
    }
    
    public void setPickupDate(String pickupDate) throws Exception { 
        try {
            this.pickupDate = LocalDate.parse(pickupDate, DTF);
        } catch (Exception e) {
            throw new Exception("Invalid format of pick-up date."); 
        }
        if (ChronoUnit.DAYS.between(LocalDate.now(), this.pickupDate) < 0) {
            throw new Exception("Pick-up date must be no earlier than today.");
        }
    }
    
    public LocalDate getPickupDate() {
        return pickupDate;
    }
    
    public void setReturnDate(String returnDate) throws Exception {
        try {
            this.returnDate = LocalDate.parse(returnDate, DTF);
        } catch (Exception e) {
             throw new Exception("Invalid format of return date.");
        }
        if (getRentDuration() < 0) {
            throw new Exception("Return date must be no earlier than pick-up date.");
        }
    }
    
    public LocalDate getReturnDate() {
        return returnDate;
    }
    
    public int getRentDuration() {
        return (int) ChronoUnit.DAYS.between(pickupDate, returnDate) + 1;
    }
    
    public float getTotalPrice(){
        return selectedCar.getPricePerDay() * getRentDuration();
    }
}
