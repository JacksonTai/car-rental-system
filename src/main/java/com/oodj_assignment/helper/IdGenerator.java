/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oodj_assignment.helper;

import java.util.UUID;

/**
 *
 * @author Jackson
 */
public class IdGenerator {
    
    public static String generate(String prefix) {
        return prefix + UUID.randomUUID();
    }
    
}
