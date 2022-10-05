/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oodj_assignment;

/**
 *
 * @author KJ
 */
public class Booking 
{
    private String startdate; 
    private String enddate;
    private Car selectedCar;

    public Car getSelectedCar() 
    {
        return selectedCar;
    }

    public void setSelectedCar(Car selectedCar) 
    {
        this.selectedCar = selectedCar;
    }
    
    public String getStartDate()
    {
        return startdate;
    }
    
    public String getEndDate()
    {
        return enddate;
    }
    
    public void setStartDate(String startDate)
    {
        this.startdate = startDate;
    }
    
    public void setEndDate(String endDate)
    {
        this.enddate = endDate;
    }
    
}
