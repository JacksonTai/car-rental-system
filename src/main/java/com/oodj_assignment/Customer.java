    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oodj_assignment;

import com.oodj_assignment.UI.menu.GuestMenu;
import com.oodj_assignment.UI.menu.MemberMenu;
import com.oodj_assignment.helper.ArrayUtils;
import com.oodj_assignment.helper.RecordReader;
import com.oodj_assignment.helper.UI.JTableInserter;

import javax.swing.JTable;
import com.oodj_assignment.validation.ValidatableField;

/**
 *
 * @author Jackson
 */
public abstract class Customer extends User {
    
    protected String fullName;
    
    protected enum CustomerField implements ValidatableField {
        FULLNAME
    }
    
    public Customer() {
        super();
    }
    
    public Customer(String userID) {
        super(userID);
        String[][] users = RecordReader.readFile("user.txt");
        for (String[] user : users) {
            if (user[0].equals(userID)) {
                this.fullName = user[2];
                break;
            }
        }
    }

    public void setFullName(String fullName) {
        try {
            validate(CustomerField.FULLNAME, fullName);
        } catch (IllegalArgumentException e) {
            throw e;
        }
        this.fullName = fullName.trim();
    }
        
    public String getFullName() {
        return fullName;
    }
    
    public void viewCar() {
        String[] carFields = {"Plate Number", "Model", "Colour", "Price/Day"};
        String[][] carsInfo = RecordReader.readFile("car.txt");
        for (String[] carInfo : carsInfo) {
            if ("N/A".equals(carInfo[4])) {
                carsInfo = ArrayUtils.removeElement(carsInfo, carInfo); 
            }
        }
        JTable customerTable = getUserID() == null ? GuestMenu.getTable() : MemberMenu.getTable();
        JTableInserter.insert(carFields, carsInfo, customerTable);
    }
    
    @Override
    public <T> void validate(ValidatableField field, T value) {
        if (field.equals(CustomerField.FULLNAME)) {
            String fullName = String.valueOf(value).trim();
            if (fullName.isEmpty()) {
                throwErr("Please enter your full name.");
            } 
            if (fullName.length() < 6 || fullName.length() > 20) {
                throwErr("Full name must contain 6 to 20 characters, please retry.");
            }  
            String[][] users = RecordReader.readFile("user.txt");
            for (String[] user : users) {
                if (user[2].equals(fullName)) {
                    throwErr("This name has been registered. Please retry");
                }
            }
        } else {
            super.validate(field, value);
        }
    }    
    
}
