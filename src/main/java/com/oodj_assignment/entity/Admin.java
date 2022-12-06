/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oodj_assignment.entity;


import com.oodj_assignment.Logoutable;
import com.oodj_assignment.UI.menu.AdminMenu;
import com.oodj_assignment.UI.CompanyReport;
import com.oodj_assignment.UI.menu.MainMenu;
import com.oodj_assignment.helper.ArrayUtils;
import com.oodj_assignment.helper.RecordReader;
import com.oodj_assignment.helper.RecordUpdater;
import com.oodj_assignment.helper.RecordWriter;
import com.oodj_assignment.helper.UI.JTableInserter;
import javax.swing.JFrame;
import javax.swing.JTable;

/**
 *
 * @author Jackson
 */
public class Admin extends User implements Logoutable {

    public Admin(String userID) {
        super(userID);
    }
    
    @Override
    public void viewMenu() {
        new AdminMenu(this).setVisible(true);
    }
    
    public void viewRecord(String type) {
        String[] fields = switch (type) {
            case "payment" -> new String[] {
                "Payment ID", "Booking ID", "Payment date", "Total paid (RM)"
            };
            case "booking" -> new String[] {
                "Booking ID", "Customer ID", "Plate number", "Pick-up date", "Return date",
            };
            case "customer" -> new String[] {
                "Customer ID", "Email", "Username", "Phone number"
            };
            case "car" -> new String[] {
                "Plate number", "Model", "Colour", "Price/Day", "Status"
            };
            default -> null;
        };
        type = "customer".equals(type) ? "user" : type;  
        String[][] records = RecordReader.readFile(type + ".txt");
        
        // Remove admin from user records to form customer records.
        if ("user".equals(type)) {
            for (String[] record : records) {
                if ("adm".equals(record[0].substring(0, 3))) {
                    records = ArrayUtils.removeElement(records, record);
                }
            }
        }
        if (null != fields && null != records) {
            JTable adminTable = AdminMenu.getTable();
            JTableInserter.insert(fields, records, adminTable);
        }    
    }
    
    public void viewCompanyReport(){
        new CompanyReport(this).setVisible(true);
    }
    
    public void addCar(Car newCar) {
        RecordWriter.write(new String[] {
            newCar.getPlateNum(), 
            newCar.getModel(), 
            newCar.getColour(), 
            String.valueOf(newCar.getPricePerDay()), 
            newCar.getStatus()
        }, "car.txt");
    }

    public void editCar(Car selectedCar) {
        RecordUpdater.update(new String[] {
            selectedCar.getPlateNum(), 
            selectedCar.getModel(), 
            selectedCar.getColour(), 
            String.valueOf(selectedCar.getPricePerDay()), 
            selectedCar.getStatus()
        }, "car.txt");
    }
    
    public void deleteCar(Car selectedCar) {
        String[][] cars = RecordReader.readFile("car.txt");
        for (String[] car : cars) {        
           if (car[0].equals(selectedCar.getPlateNum())) {
                cars = ArrayUtils.removeElement(cars, car);
           }
        } 
        RecordWriter.write(cars, "car.txt", true);
    }
   
    @Override
    public void logout(JFrame adminMenu) {
        adminMenu.dispose();
        new MainMenu().setVisible(true);
    }
    
}
