package com.oodj_assignment.helper;

import java.util.regex.Pattern;

/**
 * Helper class for checking regex expression.
 */
public class RegexHelper {

    public static boolean check (String string, String regexExpression){
        return Pattern.compile(regexExpression)
                .matcher(string)
                .matches();
    }

}
