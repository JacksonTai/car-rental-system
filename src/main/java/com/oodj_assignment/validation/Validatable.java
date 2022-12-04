/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.oodj_assignment.validation;

import java.time.format.DateTimeFormatter;

/**
 *
 * @author Jackson
 */
public interface Validatable {
    
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d MMM yyyy");
    
    <T> void validate(ValidatableField field, T value);
    
    default void throwErr(String errMsg) {
        if (null != errMsg) {
            throw new IllegalArgumentException(errMsg);
        }
    }
    
    default void throwFieldErr(ValidatableField field) {
        throw new IllegalArgumentException('"' + getClass().getSimpleName() + '"' + " do not have " 
                + field + " Field."
        );
    }
    
}