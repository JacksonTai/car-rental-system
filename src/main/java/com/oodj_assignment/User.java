/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oodj_assignment;

import com.oodj_assignment.helper.RecordReader;

/**
 *
 * @author Jackson
 */
public abstract class User {
    
    protected String userID;
    protected String email;
    protected String password;
    
    public void setUserID(String userID) {
        this.userID = userID;
    }
    
    public String getUserID() {
        return this.userID;
    }
        
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEmail() {
        return this.email;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public abstract void viewMenu();
    
    public static String[] login(String email, String password){
        String [][] users = RecordReader.readFile("user.txt");
        for (String[] user : users) {
            if (user[1].equals(email) && user[4].equals(password)) {
                return user;
            }
        }
        return null;
    }
    
}
