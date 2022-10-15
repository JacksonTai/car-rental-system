/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.oodj_assignment.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 *
 * @author Jackson
 */
public interface BookingValidator extends Validator {
    
    DateTimeFormatter DTF = DateTimeFormatter.ofPattern("dd MMM yyyy");
    
    default LocalDate validatePickupDate(String pickupDate) {
        LocalDate pickupDateObj = null;
        try {
            pickupDateObj = LocalDate.parse(pickupDate.trim(), DTF);
        } catch (Exception e) {
            throwErr("Invalid format of return date.");
        }
        if (ChronoUnit.DAYS.between(LocalDate.now(), pickupDateObj) < 0) {
            throwErr("Pick-up date must be no earlier than today.");
        }
        return pickupDateObj;
    }
    
    default LocalDate validateReturnDate(String returnDate, LocalDate pickupDate) {
        LocalDate returnDateObj = null;
        try {
            returnDateObj = LocalDate.parse(returnDate.trim(), DTF);
        } catch (Exception e) {
            throwErr("Invalid format of return date.");
        }
        if (ChronoUnit.DAYS.between(pickupDate, returnDateObj) < 0) {
            throwErr("Return date must be no earlier than pick-up date.");
        }
        return returnDateObj;
    }
    
}
