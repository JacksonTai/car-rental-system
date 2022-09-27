/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oodj_assignment;

import com.oodj_assignment.UI.CustomerMenu;

/**
 *
 * @author Jackson
 */
public class Customer extends User {

    private String username;
    private String phoneNum;
    
    public Customer(String[] customerInfo) {
        this.email = customerInfo[1];
        this.username = customerInfo[2];
        this.phoneNum = customerInfo[3];
        this.password = customerInfo[4];
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
    
}
