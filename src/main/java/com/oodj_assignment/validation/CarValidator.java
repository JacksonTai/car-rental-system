package com.oodj_assignment.validation;

import com.oodj_assignment.helper.RegexHelper;

public class CarValidator {

    public static String validatePlateNum(String plateNum) {
        if (plateNum.isEmpty()) {
            return "Please enter the car's plate number.";
        } 
        if (plateNum.contains(" ")) {
            return "Plate number must not contain spaces, please retry.";
        }
        return null;
    }
    
    public static String validateModel(String model) {
        if (model.isEmpty()) {
            return "Please enter the car model.";
        } 
        if (model.contains(" ")) {
            return "Model must not contain spaces, please retry.";
        }
        return null;
    }
    
    public static String validateColour(String colour) {
        if (colour.isEmpty()) {
            return "Please enter colour of the car.";
        }
        return null;
    }
    
    public static String validatePricePerDay(String pricePerDay) {
        if (pricePerDay.isEmpty()) {
            return  "Please enter price per day of the car.";
        }
        if (!RegexHelper.check(pricePerDay, "-?\\d+(\\.\\d+)?")) {
            return "Invalid format of price.";
        }
        return null;
    }
    
}