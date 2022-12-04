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
public abstract class User implements Validatable {
    
    protected String userID;
    protected String password;
    
    public User() {
    }
    
    public User(String userID) {
        String[][] users = RecordReader.readFile("user.txt");
        for (String[] user : users) {
            if (user[0].equals(userID)) {
                this.userID = userID;
                this.password = user[4]; 
                break;
            }
        }
    }
    
    public String getUserID() {
        return userID;
    }
        
    public void setPassword(String password) {
        try {
            validate("password", password);
        } catch (IllegalArgumentException e) {
            throw e;
        }
        this.password = password.trim();
    }
    
    public String getPassword() {
        return password;
    }
        
    public static User login(String email, String password) throws Exception {
        String errMsg;
        email = email.trim();
        if (email.isEmpty() && password.isEmpty()) {
            errMsg = "Please fill in the credentials.";
        } else if (email.isEmpty()) {
            errMsg = "Email is a required field.";
        } else if (password.isEmpty()) {
            errMsg = "Password is a required field.";
        } else {
            String [][] usersInfo = RecordReader.readFile("user.txt");
            for (String[] userInfo : usersInfo) {
                // Admin login using userID and customer login using email.
                String userID = userInfo[0];
                String userIDPrefix = userID.substring(0, 3);
                if ("adm".equals(userIDPrefix) && email.equals(userID) ||
                        "ctm".equals(userIDPrefix) && email.equals(userInfo[1])) {
                    if (password.equals(userInfo[4])) {
                        return switch(userIDPrefix) {
                            case "ctm" -> new Member(userID);
                            case "adm" -> new Admin(userID);
                            default -> null;
                        };
                    }
                }
            }
            errMsg = "Invalid credentials";
        }
        throw new Exception(errMsg);
    }
     
    public abstract void viewMenu();

    @Override
    public <T> void validate(String field, T value) {
        if (field.equals("password")) {
            String password = String.valueOf(value).trim();
            if (password.isEmpty()) {
                throwErr("Please enter your password.");
            } 
            if (password.length() < 8 || password.length() > 64) {
                throwErr("Password must contain 8 to 64 characters, please retry.");
            } 
            if (password.contains(" ")) {
                throwErr("Password must not contain spaces, please retry.");
            }
        } else {
            throwFieldErr(field);
        }
    }

}
