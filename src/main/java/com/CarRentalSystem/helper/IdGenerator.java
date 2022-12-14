package com.CarRentalSystem.helper;

import java.util.UUID;

/**
 * Helper class for generating unique ID.
 */
public class IdGenerator {
    
    /**
    * Generate random unique ID in UUID format.
    * @param prefix beginning characters of ID
    * @return String - unique UUID
    */
    public static String generate(String prefix) {
        return prefix + UUID.randomUUID();
    }
    
}
