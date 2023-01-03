package com.CarRentalSystem.entity;

import com.CarRentalSystem.Logoutable;
import com.CarRentalSystem.UI.menu.AdminMenu;
import com.CarRentalSystem.UI.CompanyReport;
import com.CarRentalSystem.UI.menu.MainMenu;
import com.CarRentalSystem.entity.Booking.BookingStatus;
import com.CarRentalSystem.helper.RecordReader;
import com.CarRentalSystem.helper.RecordUpdater;
import com.CarRentalSystem.helper.RecordWriter;
import com.CarRentalSystem.helper.UI.JTableInserter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JTable;

public class Admin extends User implements Logoutable {

    public Admin(String userID) {
        super(userID);
    }
    
    @Override
    public void viewMenu() {
        new AdminMenu(this).setVisible(true);
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
        String[][] cars = Arrays.stream(RecordReader.readFile("car.txt"))
                .filter(car -> !car[0].equals(selectedCar.getPlateNum()))
                .toArray(String[][]::new);
        RecordWriter.write(cars, "car.txt", true);
    }
    
    @Override
    public void searchCar(String searchKeyword) {
        final String keyword = searchKeyword.trim().toLowerCase();
        String[] carFields = {"Plate Number", "Model", "Colour", "Price/Day", "Status"};
        String[][] carsInfo = Arrays.stream(RecordReader.readFile("car.txt"))
                .filter(carInfo -> !"e.g. axia/(plate number)".equals(keyword) ? 
                                    carInfo[0].toLowerCase().contains(keyword) || 
                                    carInfo[1].toLowerCase().contains(keyword) : true)
                .toArray(String[][]::new);
        JTable adminTable = AdminMenu.getTable();
        JTableInserter.insert(carFields, carsInfo, adminTable);
    }
    
    public void viewBookingRequest() {
        String[] field = {"Booking ID", "Plate number", "Pick-up date", "Return date", 
            "Duration(Day)", "Price/Day", "Total price", "Status"};
        String[][] bookingRecords = RecordReader.readFile("booking.txt");
        List<String[]> bookingRequests = new ArrayList();
        if (bookingRecords.length > 0) {
            for (String[] bookingRecord : bookingRecords) {
                if (bookingRecord[5].equals(Booking.BookingStatus.PENDING.name())) {
                    Booking booking = new Booking(bookingRecord[0]);
                    bookingRequests.add(new String[] {
                        booking.getBookingID(),
                        booking.getSelectedCar().getPlateNum(),
                        booking.getPickupDate().toString(),
                        booking.getReturnDate().toString(),
                        String.valueOf(booking.getRentDuration()),
                        String.valueOf(booking.getSelectedCar().getPricePerDay()),
                        String.valueOf(booking.getTotalPrice()),
                        booking.getStatus().name()
                    });
                }
            }    
        }
        JTable adminTable = AdminMenu.getTable();
        JTableInserter.insert(field, bookingRequests.toArray(new String[0][]), adminTable); 
    }
   
    public void updateBookingRequest(Booking booking) {
        String bookingID = booking.getBookingID();
        String customerID = booking.getMember().getUserID();
        String plateNum = booking.getSelectedCar().getPlateNum();
        String pickupDate = booking.getPickupDate().toString();
        String returnDate = booking.getReturnDate().toString();
        String bookingStatus = booking.getStatus().name();
        String[] bookingRecord = new String[] {bookingID, customerID, plateNum, pickupDate, 
            returnDate, bookingStatus};
        RecordUpdater.update(bookingRecord, "booking.txt");
    }
    
    public void viewRecord(String type) {
        String[] fields = switch (type) {
            case "payment" -> new String[] {
                "Payment ID", "Booking ID", "Payment date", "Total paid (RM)"
            };
            case "booking" -> new String[] {
                "Booking ID", "Customer ID", "Plate number", "Pick-up date", "Return date", "Status"
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
        
        if ("user".equals(type)) {
            // Exclude admin to obtain customer only.
            records = Arrays.stream(records)
                    .filter(record -> "ctm".equals(record[0].substring(0, 3)))
                    .toArray(String[][]::new);
        }
        if ("booking".equals(type)) {
            // Exclude pending records from booking records.
            records = Arrays.stream(records)
                    .filter(record -> !BookingStatus.PENDING.name().equals(record[5]))
                    .toArray(String[][]::new);
        }
        if (null != fields && null != records) {
            JTable adminTable = AdminMenu.getTable();
            JTableInserter.insert(fields, records, adminTable);
        }    
    }
    
    public void viewCompanyReport() {
        new CompanyReport(this).setVisible(true);
    }
    
    @Override
    public void logout(JFrame adminMenu) {
        adminMenu.dispose();
        new MainMenu().setVisible(true);
    }
    
}
