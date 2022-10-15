/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.oodj_assignment.validation;

/**
 *
 * @author Jackson
 */
public interface Validator {
    
    default void throwErr(String errMsg) {
        if (null != errMsg) {
            throw new IllegalArgumentException(errMsg);
        }
    }
    
}