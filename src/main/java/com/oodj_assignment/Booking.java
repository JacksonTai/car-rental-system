/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oodj_assignment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author KJ
 */
public class Booking 
{
    private Date pickupDate; 
    private Date returnDate;
    private Car selectedCar;
    private final SimpleDateFormat SDF = new SimpleDateFormat("dd-MM-yyyy");

    public void setSelectedCar(Car selectedCar) {
        if (selectedCar == null) {
            throw new NullPointerException("Car cannot be null.");
        }
        this.selectedCar = selectedCar;
    }
    
    public Car getSelectedCar() {
        return this.selectedCar;
    }
    
    public void setPickupDate(Date pickupDate) throws ParseException {
        try {
            SDF.parse(SDF.format(pickupDate));
        } catch (ParseException e) {
            throw e;
        }
        this.pickupDate = pickupDate;
    }
    
    public Date getPickupDate() {
        return pickupDate;
    }
    
    public void setReturnDate(Date returnDate) throws ParseException {
        try {
           SDF.parse(SDF.format(returnDate));
        } catch (ParseException e) {
            throw e;
        }
        this.returnDate = returnDate;
    }
    
    public Date getReturnDate() {
        return returnDate;
    }
    
}
