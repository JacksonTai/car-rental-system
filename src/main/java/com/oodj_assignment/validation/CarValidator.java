package com.oodj_assignment.validation;

public class CarValidator {

    public static void validatePlateNum(String plateNum) {
        String errMsg = null;
        if (plateNum.isEmpty()) {
            errMsg = "Please enter the car's plate number.";
        } else if (plateNum.contains(" ")) {
            errMsg = "Plate number must not contain spaces, please retry.";
        }
        if (null != errMsg) {
            throw new IllegalArgumentException(errMsg);
        }
    }
    
    public static void validateModel(String model) {
        String errMsg = null;
        if (model.isEmpty()) {
            errMsg = "Please enter the car model.";
        } else if (model.contains(" ")) {
            errMsg = "Model must not contain spaces, please retry.";
        }
        if (null != errMsg) {
            throw new IllegalArgumentException(errMsg);
        }
    }
    
    public static void validateColour(String colour) {
        String errMsg = null;
        if (colour.isEmpty()) {
            errMsg = "Please enter colour of the car.";
        } 
        if (null != errMsg) {
            throw new IllegalArgumentException(errMsg);
        }
    }
    
    public static void validatePricePerDay(float pricePerDay) {
        String errMsg = null;
        if (pricePerDay < 0) {
            errMsg = "Price cannot be a negative number.";
        }  
        if (null != errMsg) {
            throw new IllegalArgumentException(errMsg);
        }
    }
    
}