package com.oodj_assignment.validation;

import com.oodj_assignment.helper.RecordReader;
import com.oodj_assignment.helper.RegexHelper;

public class UserValidator  {
    
    public static String validateEmail(String email) {
        if (email.isEmpty()) {
            return "Please enter your email.";
        } 
        // Regex source: https://www.baeldung.com/java-email-validation-regex
        if (!RegexHelper.check(email, "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
            return "Invalid format of email.";
        }
        String[][] users = RecordReader.readFile("user.txt");
        for (String[] user : users) {
            if (user[1].equals(email)) {
                return "Email has been taken, please try another one.";
            }
        }
        return null;
    }
    
    public static String validatePhoneNum (String phoneNum) {
        if (phoneNum.isEmpty()) {
            return "Please enter your phone number.";
        }
        // Regex source: https://stackoverflow.com/a/45406682/13367914
        if (!RegexHelper.check(phoneNum, "^(\\+?6?01)[0-46-9]-*[0-9]{7,8}$") ||
            phoneNum.contains(" ")) {
            return "Invalid phone number.";
        } 
        return null;
    }
    
    public static String validateUsername(String username) {
        if (username.isEmpty()) {
            return "Please enter your username.";
        } 
        if (username.length() < 6 || username.length() > 20) {
            return "Username must contain 6 to 20 characters, please retry.";
        }
        if (username.contains(" ")) {
            return "Username must not contain spaces, please retry.";
        }
        String[][] users = RecordReader.readFile("user.txt");
        for (String[] user : users) {
            if (user[2].equals(username)) {
                return "Username has been taken, please try another one.";
            }
        }
        return null;
    }
    
    public static String validatePassword(String password) {
        if (password.isEmpty()) {
            return "Please enter your password.";
        } 
        if (password.length() < 8 || password.length() > 64) {
            return "Password must contain 8 to 64 characters, please retry.";
        }
        if (password.contains(" ")) {
            return "Password must not contain spaces, please retry.";
        }
        return null;
    }


}
