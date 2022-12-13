package com.oodj_assignment.entity;

import com.oodj_assignment.helper.RecordReader;

public class Car extends Vehicle {
    
    private String plateNum;
    private String model;
    private float pricePerDay;
    private String status; 
    
    public Car() {
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
    public void validate(String field, String value) {
        switch (field) {
            case "plateNum" -> {
                String plateNum = value.trim();
                if (plateNum.isEmpty()) {
                    throwErr("Please enter the car's plate number.");
                }   
                if (plateNum.contains(" ")) {
                    throwErr("Plate number must not contain spaces, please retry.");
                }
            }
            case "model" -> {
                String model = value.trim();
                if (model.trim().isEmpty()) {
                    throwErr("Please enter the car model.");
                }
            }
            case "pricePerDay" -> {
                if (value.trim().isEmpty()) {
                    throwErr("Please enter price of the car.");
                }   
                if (!value.trim().matches("^\\d{0,8}(\\.\\d{1,2})?$")) {
                    throwErr("Invalid price format, please retry.");
                }
                float pricePerDay = Float.parseFloat(value);
                if (pricePerDay < 0) {
                    throwErr("Price cannot be a negative number.");
                }
            }
            default -> super.validate(field, value);
        }
    }
    
}
