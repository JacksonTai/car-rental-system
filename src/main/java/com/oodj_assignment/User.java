/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oodj_assignment;

import com.oodj_assignment.helper.RecordReader;
import com.oodj_assignment.validation.UserValidator;

/**
 *
 * @author Jackson
 */
public abstract class User implements UserValidator {
    
    protected String userID;
    protected String password;
    
    public User() {
        this.userID = null;
        this.password = null; 
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
            validatePassword(password.trim());
        } catch (IllegalArgumentException e) {
            throw e;
        }
        this.password = password;
    }
    
    public String getPassword() {
        return password;
    }
        
    public static User login(String email, String password) throws Exception {
        try {
            String[] userInfo = UserValidator.validateCredential(email, password);
            String userID = userInfo[0];
            return switch(userID.substring(0, 3)) {
                case "ctm" -> new Member(userID);
                case "adm" -> new Admin(userID);
                default -> null;
            };
        } catch (Exception e) {
            throw e;
        }
    }
     
    public abstract void viewMenu();
    
}
