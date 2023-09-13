package com.mycompany.cardealershipapp;
import java.util.Date;
/**
 *
 * @author Leonard M. David
 */
public abstract class Car {
    //creating private fields
    private String carCode;
    private String brand;
    private String model;
    private String engineType;
    private double mileage;
    private String carType;
    private String color;
    private double cost;
    private String dateBroughtIn;
    private String timeBroughtIn;
    private Date dateSold;
    
    // a parameterized constructor 
    public Car(String carCode, String brand, String model, String engineType, double mileage, String carType, String color, double cost, String dateBroughtIn, String timeBroughtIn){
        this.carCode = carCode;
        this.brand = brand;
        this.model = model;
        this.engineType = engineType;
        this.mileage = mileage;
        this.carType = carType;
        this.color = color;
        this.cost = cost;
        this.dateBroughtIn = dateBroughtIn;
        this.timeBroughtIn = timeBroughtIn;
    }
    //methos that returm associated valuees
    public String getCarCode(){
        return carCode;
    }
    public String getBrand(){
        return brand;
    }
    public String getModel(){
        return model;
    }
    public String getEngineType(){
        return engineType;
    }
    public double getMileage(){
        return mileage;
    }
    public String getCarType(){
        return carType;
    }
    public String getColor(){
        return color;
    }
    public abstract double getCost();
    public String getDateBroughtIn(){
        return dateBroughtIn;
    }
     public String getTimeBroughtIn(){
        return timeBroughtIn;
    }
    public Date getDateSold(){
        return dateSold;
    }
    // method to set borrow date
    public Date setDateSold(Date dateSold){
        return this.dateSold = dateSold;
    }  
}
