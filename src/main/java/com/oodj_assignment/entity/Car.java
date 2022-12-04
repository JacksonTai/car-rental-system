/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oodj_assignment.entity;

import com.oodj_assignment.helper.RecordReader;
import com.oodj_assignment.validation.Validatable;

/**
 *
 * @author Jackson
 */
public class Car implements Validatable {
    
    private String plateNum;
    private String model;
    private String colour;
    private float pricePerDay;
    private String status; 
    
    public Car() {
        this.plateNum = "N/A";
        this.model = "N/A";
        this.colour = "N/A";
        this.pricePerDay = 0;
        this.status = "Available";
    }
    
    public Car(String plateNum) {
        String[][] cars = RecordReader.readFile("car.txt");
        for (String[] car : cars) {
            if (plateNum.equals(car[0])) {
                this.plateNum = car[0];
                this.model = car[1];
                this.colour = car[2];
                this.pricePerDay = Float.parseFloat(car[3]);
                this.status = car[4];
                break;
            }
        }
    }
    
    public void setPlateNum(String plateNum) {
        try {
            validate("plateNum", plateNum);
        } catch (IllegalArgumentException e) {
            throw e;
        }
        this.plateNum = plateNum.trim();
    }
    
    public String getPlateNum() {
        return plateNum;
    }
    
    public void setModel(String model) {
        try { 
            validate("model", model);
        } catch (IllegalArgumentException e) {
            throw e;
        }
        this.model = model.trim();
    }
    
    public String getModel() {
        return model;
    }
       
    public void setColour(String colour) {
        try {
            validate("colour", colour);
        } catch (IllegalArgumentException e) {
            throw e;
        }
        this.colour = colour.trim();
    }
    
    public String getColour() {
        return colour;
    }
    
    public void setPricePerDay(String pricePerDay) {
        try {
            validate("pricePerDay", pricePerDay);
        } catch (NumberFormatException e) {
            throwErr("Invalid format of price.");
        } catch (IllegalArgumentException e) {
            throw e;
        }
        this.pricePerDay = Float.parseFloat(pricePerDay);
    }
    
    public float getPricePerDay() {
        return pricePerDay;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getStatus() {
        return status;
    } 

    @Override
    public <T> void validate(String field, T value) {
        switch (field) {
            case "plateNum" -> {
                String plateNum = String.valueOf(value).trim();
                if (plateNum.isEmpty()) {
                    throwErr("Please enter the car's plate number.");
                }   
                if (plateNum.contains(" ")) {
                    throwErr("Plate number must not contain spaces, please retry.");
                }
            }
            case "model" -> {
                String model = String.valueOf(value).trim();
                if (model.trim().isEmpty()) {
                    throwErr("Please enter the car model.");
                }
            }
            case "colour" -> {
                String colour = String.valueOf(value).trim();
                if (colour.trim().isEmpty()) {
                    throwErr("Please enter colour of the car.");
                }
            }
            case "pricePerDay" -> {
                if (String.valueOf(value).trim().isEmpty()) {
                    throwErr("Please enter price of the car.");
                }   float pricePerDay = Float.parseFloat((String) value);
                if (pricePerDay < 0) {
                    throwErr("Price cannot be a negative number.");
                }
            }
            default -> throwFieldErr(field);
        }
    }
    
}
