package com.oodj_assignment.validation;

import com.oodj_assignment.helper.RecordReader;
import com.oodj_assignment.helper.RegexHelper;

public interface UserValidator extends Validator {
    
    // Check if the given input is an existing userID.
    default void validateUserID(String userID) {
        userID = userID.trim();
        String[][] users = RecordReader.readFile("user.txt");
        for (String[] user : users) {
            if (userID.equals(user[0])) {
                return;
            }
        }
        throwErr("User ID not found.");
    }
    
    default void validateEmail(String email) {
        email = email.trim();
        if (email.isEmpty()) {
            throwErr("Please enter your email.");
        } else if (!RegexHelper.check(email, "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")) {
            // Regex source: https://www.baeldung.com/java-email-validation-regex
            throwErr("Invalid format of email."); 
        } else {
            String[][] users = RecordReader.readFile("user.txt");
            for (String[] user : users) {
                if (user[1].equals(email)) {
                    throwErr("Email has been taken, please try another one."); 
                }
            }   
        }
    }
    
    default void validatePhoneNum (String phoneNum) {
        phoneNum = phoneNum.trim();
        if (phoneNum.isEmpty()) {
            throwErr("Please enter your phone number.");
        } else if (!RegexHelper.check(phoneNum, "^(\\+?6?01)[0-46-9]-*[0-9]{7,8}$") ||
            phoneNum.contains(" ")) {
            // Regex source: https://stackoverflow.com/a/45406682/13367914
            throwErr("Invalid phone number.");
        }
    }
    
    default void validateUsername(String username) {
        username = username.trim();
        if (username.isEmpty()) {
            throwErr("Please enter your username.");
        } else if (username.length() < 6 || username.length() > 20) {
            throwErr("Username must contain 6 to 20 characters, please retry.");
        } else if (username.contains(" ")) {
            throwErr("Username must not contain spaces, please retry.");
        } else {
            String[][] users = RecordReader.readFile("user.txt");
            for (String[] user : users) {
                if (user[2].equals(username)) {
                    throwErr("Username has been taken, please try another one.");
                }
            }   
        }
    }
    
    default void validatePassword(String password) {
        password = password.trim();
        if (password.isEmpty()) {
            throwErr("Please enter your password.");
        } else if (password.length() < 8 || password.length() > 64) {
            throwErr("Password must contain 8 to 64 characters, please retry.");
        } else if (password.contains(" ")) {
            throwErr("Password must not contain spaces, please retry.");
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
