/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oodj_assignment;

import com.oodj_assignment.UI.CustomerMenu;
import com.oodj_assignment.helper.IdGenerator;
import com.oodj_assignment.helper.InfoContainer;
import com.oodj_assignment.helper.RecordWriter;
import com.oodj_assignment.validation.Validatable;

/**
 *
 * @author Jackson
 */
public class Customer extends User implements Validatable {

    private String username;
    private String phoneNum;
    
    public Customer(String[] customerInfo) {
        if (null != customerInfo && customerInfo.length >= 5) {
            this.userID = customerInfo[0];
            this.email = customerInfo[1];
            this.username = customerInfo[2];
            this.phoneNum = customerInfo[3];
            this.password = customerInfo[4];
        }
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    
    public String getPhoneNum() {
        return this.phoneNum;
    }

    @Override
    public void viewMenu() {
        new CustomerMenu(this).setVisible(true);
    }
    
    public InfoContainer signup(String [] signupInput) {
        String newEmail = signupInput[0].trim();
        String newUsername = signupInput[1].trim();
        String newPhoneNum = signupInput[2].trim();
        String newPassword = signupInput[3].trim();
        String confirmPassword = signupInput[4].trim();
        String errMsg = null;
        if (newEmail.isEmpty()) {
            errMsg = "Please enter your email.";
        } else if (newUsername.isEmpty()) {
            errMsg = "Please enter your username.";
        } else if (newPhoneNum.isEmpty()) {
            errMsg = "Please enter your phone number.";
        } else if (newPassword.isEmpty()) {
            errMsg = "Please enter your password.";
        } else if (confirmPassword.isEmpty()) {
            errMsg = "Please confirm your password.";
        } else if (!confirmPassword.equals(newPassword)) {
            errMsg = "Password do not match.";
        } else {
            if (null == errMsg) {
                errMsg = validateEmail(newEmail);
            }
            if (null == errMsg) {
                errMsg = validateUsername(newUsername);
            }
            if (null == errMsg) {
                errMsg = validatePhoneNum(newPhoneNum);
            }
            if (null == errMsg) {
                errMsg = validatePassword(newPassword);
            }
        }
        InfoContainer signupInfo = new InfoContainer();
        if (null == errMsg) {
            String newCustomerID = IdGenerator.generate("ctm-");
            signupInfo.set("newCustomerID", newCustomerID);
            signupInfo.set("newEmail", newEmail);
            signupInfo.set("newUsername", newUsername);
            signupInfo.set("newPhoneNum", newPhoneNum);
            signupInfo.set("newPassword", newPassword);
            RecordWriter.write(new String[] { 
                signupInfo.get("newCustomerID"),
                signupInfo.get("newEmail"),
                signupInfo.get("newUsername"),
                signupInfo.get("newPhoneNum"),
                signupInfo.get("newPassword"),
            }, "user.txt");
        } else {
            signupInfo.set("errMsg", errMsg);
        }
        return signupInfo;
    }
    
}
