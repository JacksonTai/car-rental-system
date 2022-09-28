/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oodj_assignment;

import com.oodj_assignment.helper.InfoContainer;
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
    
    public static InfoContainer login(String email, String password){
        email = email.trim();
        password = password.trim();
        InfoContainer loginInfo = new InfoContainer();
        String errMsg;
        if (email.isEmpty() && password.isEmpty()) {
            errMsg = "Please fill in the credentials.";
        } else if (email.isEmpty()) {
            errMsg = "Email is a required field.";
        } else if (password.isEmpty()) {
            errMsg = "Password is a required field.";
        } else {
            // Check credentials.
            String [][] usersInfo = RecordReader.readFile("user.txt");
            for (String[] userInfo : usersInfo) {
                if (userInfo[1].equals(email) && userInfo[4].equals(password)) { 
                    loginInfo.set("userInfo", userInfo);
                    return loginInfo;
                }
            }
            errMsg = "Invalid credentials";
        }
        loginInfo.set("errMsg", errMsg);
        return loginInfo;
    }
    
}
