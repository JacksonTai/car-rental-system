/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oodj_assignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author KJ
 */
public class Booking 
{
    private String pickupDate; 
    private String returnDate;
    private Car selectedCar;
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

    public void setSelectedCar(Car selectedCar) {
        if (selectedCar == null) {
            throw new NullPointerException("Car cannot be null.");
        }
        this.selectedCar = selectedCar;
    }
    
    public Car getSelectedCar() {
        return this.selectedCar;
    }
    
    public void setPickupDate(String pickupDate) throws ParseException {
        try {
            simpleDateFormat.parse(pickupDate);
        } catch (ParseException e) {
            throw e;
        }
        this.pickupDate = pickupDate;
    }
    
    public String getPickupDate() {
        return pickupDate;
    }
    
    public void setReturnDate(String returnDate) throws ParseException {
        try {
            simpleDateFormat.parse(returnDate);
        } catch (ParseException e) {
            throw e;
        }
        this.returnDate = returnDate;
    }
    
    public String getReturnDate() {
        return returnDate;
    }
    
}
