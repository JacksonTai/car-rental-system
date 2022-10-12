package com.oodj_assignment.validation;

public interface CarValidator extends Validator  {
    
    default void validatePlateNum(String plateNum) {
        if (plateNum.isEmpty()) {
            throwErr("Please enter the car's plate number.");
        } else if (plateNum.contains(" ")) {
            throwErr("Plate number must not contain spaces, please retry.");
        }
    }
    
    default void validateModel(String model) {
        if (model.isEmpty()) {
            throwErr("Please enter the car model.");
        } else if (model.contains(" ")) {
            throwErr("Model must not contain spaces, please retry.");
        }
    }
    
    default void validateColour(String colour) {
        if (colour.isEmpty()) {
            throwErr("Please enter colour of the car.");
        } 
    }
    
    default void validatePricePerDay(float pricePerDay) {
        if (pricePerDay < 0) {
            throwErr("Price cannot be a negative number.");
        }
    }
    
}