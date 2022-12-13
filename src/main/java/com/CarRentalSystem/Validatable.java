package com.CarRentalSystem;

import java.time.format.DateTimeFormatter;

public interface Validatable {
    
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d MMM yyyy");
    
    void validate(String field, String value);
    
    default void throwErr(String errMsg) {
        if (null != errMsg) {
            throw new IllegalArgumentException(errMsg);
        }
    }
    
    default void throwFieldErr(String field) {
        throw new IllegalArgumentException('"' + getClass().getSimpleName() + '"' + " do not have " 
                + field + " Field."
        );
    }
    
}
