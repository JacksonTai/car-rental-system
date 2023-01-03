package com.CarRentalSystem.entity;

import com.CarRentalSystem.UI.menu.GuestMenu;
import com.CarRentalSystem.UI.menu.MemberMenu;
import com.CarRentalSystem.helper.RecordReader;
import com.CarRentalSystem.helper.UI.JTableInserter;
import java.util.Arrays;

import javax.swing.JTable;

public abstract class Customer extends User {
    
    protected String fullName;
     
    public Customer(String userID) {
        super(userID);
        fullName = Arrays.stream(RecordReader.readFile("user.txt"))
                .filter(user -> user[0].equals(userID))
                .toArray(String[][]::new)[0][2];
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
        String[][] carsInfo = Arrays.stream(RecordReader.readFile("car.txt"))
                .filter(car -> !"N/A".equals(car[4]))
                .toArray(String[][]::new);
        JTable customerTable = getUserID() == null ? GuestMenu.getTable() : MemberMenu.getTable();
        JTableInserter.insert(carFields, carsInfo, customerTable);
    }

    @Override
    public void searchCar(String searchKeyword) {
        final String keyword = searchKeyword.trim().toLowerCase();
        String[] carFields = {"Plate Number", "Model", "Colour", "Price/Day"};
        String[][] carsInfo = Arrays.stream(RecordReader.readFile("car.txt"))
                .filter(car -> !"N/A".equals(car[4]))
                .filter(car -> !"e.g. axia".equals(keyword) ? 
                        car[1].toLowerCase().contains(keyword) : true)
                .toArray(String[][]::new);
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
                if (!phoneNum.matches("^(\\+?6?01)[0-46-9]-*[0-9]{7,8}$") 
                        || phoneNum.contains(" ")) {
                    throwErr("Invalid phone number.");
                }
            }
            default -> super.validate(field, value);
        }
    }    
    
}
