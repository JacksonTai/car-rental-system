package com.CarRentalSystem.entity;

import com.CarRentalSystem.UI.menu.GuestMenu;
import com.CarRentalSystem.helper.IdGenerator;
import com.CarRentalSystem.helper.RecordUpdater;
import com.CarRentalSystem.helper.RecordWriter;

public class Guest extends Customer {

    public Guest() {
        super(null);
    }

    @Override
    public void viewMenu() {
        new GuestMenu().setVisible(true);
    }
    
    public Member signUp(String fullName, String email, String phoneNum, String password, 
            String confirmPassword) {
        validate("fullName", fullName);
        validate("email", email);
        validate("phoneNum", phoneNum);
        validate("password", password);
        if (null != userID) {
            throwErr("This user has been signed up");
        } else if (confirmPassword.trim().isEmpty()) { 
             throwErr("Please confirm your password.");
        } else if (!confirmPassword.trim().equals(password.trim())) {
            throwErr("Password do not match.");
        }
        String userID = IdGenerator.generate("ctm-");
        email = email.trim();
        fullName = fullName.trim();
        phoneNum = phoneNum.trim();
        password = password.trim();
        Address address = new Address();
        RecordWriter.write(new String[] {
            userID, email, fullName, phoneNum, password, address.getStreet(), address.getCity(), 
            address.getState(), address.getPostalCode()
        }, "user.txt");
        return new Member(userID);
    }
   
}
