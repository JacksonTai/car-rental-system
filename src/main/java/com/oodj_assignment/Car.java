/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oodj_assignment;

import com.oodj_assignment.validation.CarValidator;

/**
 *
 * @author Jackson
 */
public class Car implements CarValidator {
    
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
    
    public Car(String plateNum, String model, String colour, float pricePerDay, String status) {
        try {
            validatePlateNum(plateNum);
            validateModel(model);
            validateColour(colour);
            validatePricePerDay(pricePerDay);
        } catch (IllegalArgumentException e) {
            throw e;  
        }
        this.plateNum = plateNum;
        this.model = model;
        this.colour = colour;
        this.pricePerDay = pricePerDay;
        this.status = status;
    }
    
    public void setPlateNum(String plateNum) {
        try {
            validatePlateNum(plateNum);
        } catch (IllegalArgumentException e) {
            throw e;
        }
        this.plateNum = plateNum;
    }
    
    public String getPlateNum() {
        return plateNum;
    }
    
    public void setModel(String model) {
        try { 
            validateModel(model);
        } catch (IllegalArgumentException e) {
            throw e;
        }
        this.model = model;
    }
    
    public String getModel() {
        return model;
    }
       
    public void setColour(String colour) {
        try {
            validateColour(colour);
        } catch (IllegalArgumentException e) {
            throw e;
        }
        this.colour = colour;
    }
    
    public String getColour() {
        return colour;
    }
    
    public void setPricePerDay(float pricePerDay) {
        try {
            validatePricePerDay(pricePerDay);
        } catch (IllegalArgumentException e) {
            throw e;
        }
        this.pricePerDay = pricePerDay;
    }
    
    public void setPricePerDay(String pricePerDay) {
        if (pricePerDay.trim().isEmpty()) {
            throw new IllegalArgumentException("Please enter price of the car.");
        }
        try {
            setPricePerDay(Float.parseFloat(pricePerDay));
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid format of price.");
        }
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
    
    public String[] toArray() {
        return new String[] {
            plateNum, model, colour, String.valueOf(pricePerDay), status
        };
    }
    
}
