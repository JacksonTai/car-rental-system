package com.CarRentalSystem.entity;

import com.CarRentalSystem.helper.IdGenerator;
import com.CarRentalSystem.helper.RecordReader;
import com.CarRentalSystem.Validatable;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;

public class Booking implements Validatable {
    
    private String bookingID;
    private Member member;
    private Car selectedCar;
    private LocalDate pickupDate; 
    private LocalDate returnDate;
    private BookingStatus status;
    
    public enum BookingStatus {
        PENDING,
        APPROVED,
        REJECTED,
        PAID
    }
    
    public Booking(Member member, Car selectedCar) {
        if (selectedCar == null) {
            throw new NullPointerException("\"selectedCar\" cannot be null.");
        }
        if (member == null) {
            throw new NullPointerException("\"member\" cannot be null.");
        }
        this.bookingID = IdGenerator.generate("bkg-");
        this.member = member;
        this.selectedCar = selectedCar;
        this.status = BookingStatus.PENDING;
    }
    
    public Booking (String bookingID) {
        String[][] bookings = RecordReader.readFile("booking.txt");
        for (String[] booking : bookings) {
            if (bookingID.equals(booking[0])) {
                this.bookingID = booking[0];
                member = new Member(booking[1]);
                selectedCar = new Car(booking[2]);
                pickupDate = LocalDate.parse(booking[3]);
                returnDate = LocalDate.parse(booking[4]);
                status = BookingStatus.valueOf(booking[5]);
                break;
            }
        }
    }
           
    public String getBookingID() {
        return bookingID;
    }
    
    public Member getMember() {
        return member;
    }
    
    public Car getSelectedCar() {
        return selectedCar;
    }
    
    public void setPickupDate(String pickupDate) { 
        try {
            validate("pickupDate", pickupDate);
        } catch (DateTimeParseException e) {
            throwErr("Invalid format of pick-up date.");
        } catch (IllegalArgumentException e) {
            throw e;
        }
        this.pickupDate = LocalDate.parse(pickupDate, dateTimeFormatter);
    }
    
    public LocalDate getPickupDate() {
        return pickupDate;
    }
    
    public void setReturnDate(String returnDate) {
        try {
            validate("returnDate", returnDate);
        } catch (DateTimeParseException e) {
            throwErr("Invalid format of return date.");
        } catch (IllegalArgumentException e) {
            throw e;
        }
        this.returnDate = LocalDate.parse(returnDate, dateTimeFormatter);
    }
    
    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

    public BookingStatus getStatus() {
        return status;
    }
    
    public int getRentDuration() {
        return (int) ChronoUnit.DAYS.between(pickupDate, returnDate) + 1;
    }
    
    public float getTotalPrice(){
        return selectedCar.getPricePerDay() * getRentDuration();
    }

    @Override
    public void validate(String field, String value) {
        switch (field) {
            case "pickupDate" -> {
                String pickupDate = value.trim();
                LocalDate pickupDateObj = LocalDate.parse(pickupDate, dateTimeFormatter);
                if (ChronoUnit.DAYS.between(LocalDate.now(), pickupDateObj) < 0) {
                    throwErr("Pick-up date must be no earlier than today.");
                }                      
            }
            case "returnDate" -> {
                String returnDate = value.trim();
                LocalDate returnDateObj = LocalDate.parse(returnDate, dateTimeFormatter);
                if (ChronoUnit.DAYS.between(pickupDate, returnDateObj) < 0) {
                    throwErr("Return date must be no earlier than pick-up date.");
                }
            }
            default -> throwFieldErr(field);
        }
    }
    
}
