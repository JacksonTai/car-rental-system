/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oodj_assignment;

import com.oodj_assignment.validation.UserValidator;

/**
 *
 * @author Jackson
 */
public abstract class User implements UserValidator {
    
    protected String userID;
    protected String email;
    protected String password;
    
    public User() {
        this.userID = null;
        this.email = null;
        this.password = null; 
    }
    
    public void setUserID(String userID) {
        if (null != userID) {
            throw new IllegalArgumentException("User ID has been set.");
        }
        this.userID = userID;
    }
    
    public String getUserID() {
        return userID;
    }
        
    public void setEmail(String email) {
        try {
            validateEmail(email.trim());
        } catch (IllegalArgumentException e) {
            throw e;
        }
        this.email = email;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setPassword(String password) {
        try {
            validatePassword(password.trim());
        } catch (IllegalArgumentException e) {
            throw e;
        }
        this.password = password;
    }
    
    public String getPassword() {
        return password;
    }
    
    public abstract void viewMenu();
    
    public static User login(String email, String password) throws Exception {
        try {
            String[] userInfo = UserValidator.validateCredential(email, password);
            String userID = userInfo[0];
            String username = userInfo[1];
            String phoneNum = userInfo[2];
            email = userInfo[3];
            password = userInfo[4];
            return switch(userID.substring(0, 3)) {
                case "ctm" -> new Customer(userID, username, phoneNum, email, password);
                case "adm" -> new Admin();
                default -> null;
            };
        } catch (Exception e) {
            throw e;
        }
    }
    
}
