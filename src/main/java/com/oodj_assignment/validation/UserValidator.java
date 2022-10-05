package com.oodj_assignment.validation;

import com.oodj_assignment.helper.RecordReader;
import com.oodj_assignment.helper.RegexHelper;

public class UserValidator  {
    
    // Check if the given input is an existing userID.
    public static void validateUserID(String userID) {
        userID = userID.trim();
        String[][] users = RecordReader.readFile("user.txt");
        for (String[] user : users) {
            if (userID.equals(user[0])) {
                return;
            }
        }
        throw new IllegalArgumentException("User ID not found.");
    }
    
    public static void validateEmail(String email) {
        String errMsg = null;
        email = email.trim();
        if (email.isEmpty()) {
            errMsg = "Please enter your email.";
        } else if (!RegexHelper.check(email, "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
            // Regex source: https://www.baeldung.com/java-email-validation-regex
            errMsg = "Invalid format of email.";
        } else {
            String[][] users = RecordReader.readFile("user.txt");
            for (String[] user : users) {
                if (user[1].equals(email)) {
                    errMsg = "Email has been taken, please try another one.";
                }
            }   
        }
        if (null != errMsg) {
            throw new IllegalArgumentException(errMsg);
        }
    }
    
    public static void validatePhoneNum (String phoneNum) {
        String errMsg = null;
        phoneNum = phoneNum.trim();
        if (phoneNum.isEmpty()) {
            errMsg = "Please enter your phone number.";
        } else if (!RegexHelper.check(phoneNum, "^(\\+?6?01)[0-46-9]-*[0-9]{7,8}$") ||
            phoneNum.contains(" ")) {
            // Regex source: https://stackoverflow.com/a/45406682/13367914
            errMsg = "Invalid phone number.";
        } 
        if (null != errMsg) {
            throw new IllegalArgumentException(errMsg);
        }
    }
    
    public static void validateUsername(String username) {
        String errMsg = null;
        username = username.trim();
        if (username.isEmpty()) {
            errMsg = "Please enter your username.";
        } else if (username.length() < 6 || username.length() > 20) {
            errMsg = "Username must contain 6 to 20 characters, please retry.";
        } else if (username.contains(" ")) {
            errMsg = "Username must not contain spaces, please retry.";
        } else {
            String[][] users = RecordReader.readFile("user.txt");
            for (String[] user : users) {
                if (user[2].equals(username)) {
                    errMsg = "Username has been taken, please try another one.";
                }
            }   
        }
        if (null != errMsg) {
            throw new IllegalArgumentException(errMsg);
        }
    }
    
    public static void validatePassword(String password) {
        String errMsg = null;
        password = password.trim();
        if (password.isEmpty()) {
            errMsg = "Please enter your password.";
        } else if (password.length() < 8 || password.length() > 64) {
            errMsg = "Password must contain 8 to 64 characters, please retry.";
        } else if (password.contains(" ")) {
            errMsg = "Password must not contain spaces, please retry.";
        }
        if (null != errMsg) {
            throw new IllegalArgumentException(errMsg);
        }
    }

    public static String[] validateCredential(String email, String password) throws Exception {
        String errMsg;  
        email = email.trim();
        password = password.trim();
        if (email.isEmpty() && password.isEmpty()) {
            errMsg = "Please fill in the credentials.";
        } else if (email.isEmpty()) {
            errMsg = "Email is a required field.";
        } else if (password.isEmpty()) {
            errMsg = "Password is a required field.";
        } else {
            // Check credentials.
            String [][] usersInfo = RecordReader.readFile("user.txt");
            for (String[] userInfo : usersInfo) {
                if (userInfo[1].equals(email) && userInfo[4].equals(password)) {
                    return userInfo;
                }
            }
            errMsg = "Invalid credentials";
        }
        throw new Exception(errMsg);
    }

}
