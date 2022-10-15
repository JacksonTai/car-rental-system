package com.oodj_assignment.validation;

public interface CarValidator extends Validator  {
    
    default void validatePlateNum(String plateNum) {
        if (plateNum.trim().isEmpty()) {
            throwErr("Please enter the car's plate number.");
        } else if (plateNum.contains(" ")) {
            throwErr("Plate number must not contain spaces, please retry.");
        }
    }
    
    default void validateModel(String model) {
        if (model.trim().isEmpty()) {
            throwErr("Please enter the car model.");
        }
    }
    
    default void validateColour(String colour) {
        if (colour.trim().isEmpty()) {
            throwErr("Please enter colour of the car.");
        } 
    }
    
    default Float validatePricePerDay(String pricePerDay) {
        if (pricePerDay.trim().isEmpty()) {
            throwErr("Please enter price of the car.");
        }
        try {
            if (Float.parseFloat(pricePerDay) < 0) {
                throwErr("Price cannot be a negative number.");
            }
            return Float.parseFloat(pricePerDay);
        } catch (NumberFormatException e) {
            throwErr("Invalid format of price.");
        } 
        return null;
    }
    
}