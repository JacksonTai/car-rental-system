/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oodj_assignment;

import com.oodj_assignment.helper.RecordReader;
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
    
    public void setPricePerDay(String pricePerDay) {
        try {
            this.pricePerDay = validatePricePerDay(pricePerDay);
        } catch (IllegalArgumentException e) {
            throw e;
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
    
}
