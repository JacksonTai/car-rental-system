package com.oodj_assignment.helper;

import java.util.regex.Pattern;

/**
 * Helper class for checking regex expression.
 */
public class RegexHelper {

    /**
    * Check if given string matches specified regex expression.
    * @param string input of string
    * @param regexExp regex expression format
    * @return boolean - regex matching result
    */
    public static boolean check (String string, String regexExp){
        return Pattern.compile(regexExp)
                .matcher(string)
                .matches();
    }

}
