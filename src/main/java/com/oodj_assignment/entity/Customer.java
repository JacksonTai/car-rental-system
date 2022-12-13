package com.oodj_assignment.entity;

import com.oodj_assignment.UI.menu.GuestMenu;
import com.oodj_assignment.UI.menu.MemberMenu;
import com.oodj_assignment.helper.ArrayUtils;
import com.oodj_assignment.helper.RecordReader;
import com.oodj_assignment.helper.UI.JTableInserter;

import javax.swing.JTable;

public abstract class Customer extends User {
    
    protected String fullName;
     
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
            validate("fullName", fullName);
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
    public void searchCar(String keyword) {
        keyword = keyword.trim().toUpperCase();
        String[] carFields = {"Plate Number", "Model", "Colour", "Price/Day"};
        String[][] carsInfo = RecordReader.readFile("car.txt");
        for (String[] carInfo : carsInfo) {
            String model = carInfo[1].toUpperCase();
            if ("N/A".equals(carInfo[4]) || 
                    !"E.G. AXIA".equals(keyword) && !model.contains(keyword)) {
                carsInfo = ArrayUtils.removeElement(carsInfo, carInfo); 
            }
        }
        JTable customerTable = getUserID() == null ? GuestMenu.getTable() : MemberMenu.getTable();
        JTableInserter.insert(carFields, carsInfo, customerTable);
    }
       
    @Override
    public void validate(String field, String value) {
        switch (field) {
            case "fullName" -> {
                String fullName = value.trim();
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
            }
            case "email" -> {
                String email = value.trim();
                if (email.isEmpty()) {
                    throwErr("Please enter your email.");
                }
                if (!email.matches("^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
                    throwErr("Invalid format of email.");
                }   
                String[][] users = RecordReader.readFile("user.txt");
                for (String[] user : users) {
                    if (user[1].equals(email)) {
                        throwErr("Email has been taken, please try another one.");
                    }
                }
            }
            case "phoneNum" -> {
                String phoneNum = String.valueOf(value).trim();
                if (phoneNum.isEmpty()) {
                    throwErr("Please enter your phone number.");
                }
                if (!phoneNum.matches("^(\\+?6?01)[0-46-9]-*[0-9]{7,8}$") || phoneNum.contains(" ")) {
                    throwErr("Invalid phone number.");
                }
            }
            default -> super.validate(field, value);
        }
    }    
    
}
