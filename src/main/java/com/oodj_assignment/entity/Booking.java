/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oodj_assignment.entity;

import com.oodj_assignment.helper.IdGenerator;
import com.oodj_assignment.helper.RecordReader;
import com.oodj_assignment.validation.Validatable;
import com.oodj_assignment.validation.ValidatableField;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author KJ
 */
public class Booking implements Validatable {
    
    private String bookingID;
    private Member member;
    private Car selectedCar;
    private LocalDate pickupDate; 
    private LocalDate returnDate;
    
    protected enum BookingField implements ValidatableField {
        PICKUPDATE,
        RETURNDATE,
    }
    
    public Booking(Member member, Car selectedCar) {
        if (selectedCar == null) {
            throw new NullPointerException("\"selectedCar\" cannot be null.");
        }
        if (member == null) {
            throw new NullPointerException("\"member\" cannot be null.");
        }
        this.bookingID = IdGenerator.generate("bkg-");
        this.member = member;
        this.selectedCar = selectedCar;
    }
    
    public Booking (String bookingID) {
        String[][] bookings = RecordReader.readFile("booking.txt");
        for (String[] booking : bookings) {
            if (bookingID.equals(booking[0])) {
                this.bookingID = booking[0];
                member = new Member(booking[1]);
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
    
    public Member getMember() {
        return member;
    }
    
    public Car getSelectedCar() {
        return selectedCar;
    }
    
    public void setPickupDate(String pickupDate) { 
        try {
            validate(BookingField.PICKUPDATE, pickupDate);
        } catch (DateTimeParseException e) {
            throwErr("Invalid format of pick-up date.");
        } catch (IllegalArgumentException e) {
            throw e;
        }
        this.pickupDate = LocalDate.parse(pickupDate, dateTimeFormatter);
    }
    
    public LocalDate getPickupDate() {
        return pickupDate;
    }
    
    public void setReturnDate(String returnDate) {
        try {
            validate(BookingField.RETURNDATE, returnDate);
        } catch (DateTimeParseException e) {
            throwErr("Invalid format of return date.");
        } catch (IllegalArgumentException e) {
            throw e;
        }
        this.returnDate = LocalDate.parse(returnDate, dateTimeFormatter);
    }
    
    public LocalDate getReturnDate() {
        return returnDate;
    }
    
    public int getRentDuration() {
        return (int) ChronoUnit.DAYS.between(pickupDate, returnDate) + 1;
    }

    @Override
    public <T> void validate(ValidatableField field, T value) {
        if (field.equals(BookingField.PICKUPDATE)) {
            String pickupDate = String.valueOf(value).trim();
            LocalDate pickupDateObj = LocalDate.parse(pickupDate, dateTimeFormatter);
            if (ChronoUnit.DAYS.between(LocalDate.now(), pickupDateObj) < 0) {
                throwErr("Pick-up date must be no earlier than today.");
            }
        } else if (field.equals(BookingField.RETURNDATE)) {
            String returnDate = String.valueOf(value).trim();
            LocalDate returnDateObj = LocalDate.parse(returnDate, dateTimeFormatter);
            if (ChronoUnit.DAYS.between(pickupDate, returnDateObj) < 0) {
                throwErr("Return date must be no earlier than pick-up date.");
            }
        } else {
            throwFieldErr(field);
        }
    }
    
}
