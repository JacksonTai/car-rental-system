/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oodj_assignment;

/**
 *
 * @author Jackson
 */
public class Car {
    
    private String plateNum;
    private String model;
    private String colour;
    private int pricePerDay;
    
    public void setPlateNum(String plateNum) {
        this.plateNum = plateNum;
    }
    
    public String getPlateNum() {
        return this.plateNum;
    }
    
    public void setModel(String model) {
        this.model = model;
    }
    
    public String getModel() {
        return this.model;
    }
       
    public void setColour(String colour) {
        this.colour = colour;
    }
    
    public String getColour() {
        return this.colour;
    }
    
    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
    
    public int getPricePerDay() {
        return this.pricePerDay;
    }
    
}
