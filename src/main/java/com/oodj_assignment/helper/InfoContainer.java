/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oodj_assignment.helper;

import java.util.HashMap;

/**
 * Helper class that provides custom setters and getters to work with different types of data.
 */
public class InfoContainer {
    
    private final HashMap responseInfo = new HashMap<>(); 

    public <T> void set(String field, T info) {
         responseInfo.put(field, info);
    }
    
    public <T> T get(String field) {
       return (T) responseInfo.get(field);
    }
    
}
