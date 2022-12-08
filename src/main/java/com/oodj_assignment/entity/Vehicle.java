package com.oodj_assignment.entity;

import com.oodj_assignment.Validatable;

public class Vehicle implements Validatable {

    protected String colour;

    public Vehicle() {
        this.colour = "N/A";
    }
    
    public Vehicle(String colour) {
        this.colour = colour;
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
    
    @Override
    public void validate(String field, String value) {
        if (field.equals("colour")) {
            String colour = value.trim();
            if (colour.trim().isEmpty()) {
                throwErr("Please enter colour of the car.");
            }
            if (!colour.matches("[a-zA-Z]+")) {
                throwErr("The colour must contains only alphabet letter.");
            }
        } else {
            throwFieldErr(field);
        }
    }
    
}
