package com.oodj_assignment;

import com.oodj_assignment.UI.menu.GuestMenu;
import com.oodj_assignment.helper.IdGenerator;
import com.oodj_assignment.helper.RecordWriter;

public class Guest extends Customer {

    @Override
    public void viewMenu() {
        new GuestMenu().setVisible(true);
    }
    
    public void signUp(String fullName, String email, String phoneNum, String password, 
            String confirmPassword) throws Exception {
        try {
            validateFullName(fullName);
            validateEmail(email);
            validatePhoneNum(phoneNum);
            validatePassword(password); 
            if (null != userID) {
                throw new Exception("This user has been signed up");
            } else if (confirmPassword.trim().isEmpty()) { 
                throw new Exception("Please confirm your password.");
            } else if (!confirmPassword.trim().equals(password.trim())) {
                throw new Exception("Password do not match.");
            }
        } catch (Exception e) {
            throw e;
        }
        this.userID = IdGenerator.generate("ctm-");
        this.fullName = fullName;
        this.password = password; 
        RecordWriter.write(new String[] {userID, email, fullName, phoneNum, password,}, "user.txt");
    }
   
}
