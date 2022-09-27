/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oodj_assignment;

import com.oodj_assignment.UI.AdminMenu;

/**
 *
 * @author Jackson
 */
public class Admin extends User {

    public Admin(String[] adminInfo) {
        this.email = adminInfo[1];
        this.password = adminInfo[4];
    }
    
    @Override
    public void viewMenu() {
        new AdminMenu().setVisible(true);
    }
    
}
