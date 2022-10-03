/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oodj_assignment;

import com.oodj_assignment.UI.AdminMenu;
import com.oodj_assignment.helper.ArrayUtils;
import com.oodj_assignment.helper.RecordReader;
import com.oodj_assignment.helper.RecordUpdater;
import com.oodj_assignment.helper.RecordWriter;
import com.oodj_assignment.helper.UI.JTableInserter;
import com.oodj_assignment.validation.CarValidator;
import javax.swing.JTable;

/**
 *
 * @author Jackson
 */
public class Admin extends User {

    public Admin(String[] adminInfo) {
        this.email = adminInfo[1];
        this.password = adminInfo[4];
    }
    
    @Override
    public void viewMenu() {
        new AdminMenu(this).setVisible(true);
    }
    
    public void viewRecord(String type) {
        String[] fields = switch (type) {
            case "payment" -> new String[] {
                "Payment ID", "Booking ID", "Customer ID", "Paid"
            };
            case "booking" -> new String[] {
                "Booking ID", "Customer ID", "Car number", "Start date", "Return date", "Duration",
                "Price/day", "Total price"
            };
            case "customer" -> new String[] {
                "Customer ID", "Email", "Username", "Phone Number"
            };
            case "car" -> new String[] {
                "Plate Number", "Model", "Colour", "Price/Day", "Status"
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
    
    public String addCar(String[] carInput) {
        String plateNum = carInput[0].trim();
        String model = carInput[1].trim();
        String colour = carInput[2].trim();
        String pricePerDay = carInput[3].trim();
        String errMsg = CarValidator.validatePlateNum(plateNum);
        if (errMsg == null) {
            errMsg = CarValidator.validateModel(model);
        }
        if (errMsg == null) {
            errMsg = CarValidator.validateColour(colour);
        }
        if (errMsg == null) {
            errMsg = CarValidator.validatePricePerDay(pricePerDay);
        }
        if (errMsg == null) {
            RecordWriter.write(new String[] {
                plateNum, model, colour, pricePerDay, "available"
            }, "car.txt");
        }
        return errMsg;
    }
    
    public String editCar(String[] carInput) {
        String plateNum = carInput[0].trim();
        String model = carInput[1].trim();
        String colour = carInput[2].trim();
        String pricePerDay = carInput[3].trim();
        String errMsg = CarValidator.validatePlateNum(plateNum);
        if (errMsg == null) {
            errMsg = CarValidator.validateModel(model);
        }
        if (errMsg == null) {
            errMsg = CarValidator.validateColour(colour);
        }
        if (errMsg == null) {
            errMsg = CarValidator.validatePricePerDay(pricePerDay);
        }
        if (errMsg == null) {
            RecordUpdater.update(carInput, "car.txt");
        }
        return errMsg;        
    }
    
}
