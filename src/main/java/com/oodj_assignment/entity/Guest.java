package com.oodj_assignment.entity;

import com.oodj_assignment.UI.menu.GuestMenu;
import com.oodj_assignment.helper.IdGenerator;
import com.oodj_assignment.helper.RecordWriter;

public class Guest extends Customer {

    public Guest() {
        super(null);
    }

    @Override
    public void viewMenu() {
        new GuestMenu().setVisible(true);
    }
    
    public Member signUp(String fullName, String email, String phoneNum, String password, 
            String confirmPassword) throws Exception {
        validate("fullName", fullName);
        validate("email", email);
        validate("phoneNum", phoneNum);
        validate("password", password);
        if (null != userID) {
            throw new Exception("This user has been signed up");
        } else if (confirmPassword.trim().isEmpty()) { 
            throw new Exception("Please confirm your password.");
        } else if (!confirmPassword.trim().equals(password.trim())) {
            throw new Exception("Password do not match.");
        }
        String userID = IdGenerator.generate("ctm-");
        email = email.trim();
        fullName = fullName.trim();
        phoneNum = phoneNum.trim();
        password = password.trim();
        RecordWriter.write(new String[] {userID, email, fullName, phoneNum, password}, "user.txt");
        return new Member(userID);
    }
   
}
