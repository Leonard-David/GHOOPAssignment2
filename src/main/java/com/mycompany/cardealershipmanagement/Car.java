package com.mycompany.cardealershipmanagement;
import java.util.Date;
/**
 *
 * @author Group H
 */
public abstract class Car {
    //creating private fields
    private String carCode;
    private String brand;
    private String model;
    private String engineType;
    private double mileage;
    private String color;
    private double cost;
    private String dateBroughtIn;
    private String dateSold;
    private String carType;
    // a parameterized constructor 
    public Car(String carCode, String brand, String model, String engineType, double mileage,String carType, String color, double cost, String dateBroughtIn){
        this.carCode = carCode;
        this.brand = brand;
        this.model = model;
        this.engineType = engineType;
        this.mileage = mileage;
        this.color = color;
        this.cost = cost;
        this.dateBroughtIn = dateBroughtIn;
        this.carType = carType;
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
    public String getdateBroughtIn(){
        return dateBroughtIn;
    }
    public String getDateSold(){
        return dateSold;
    }
    // method to set borrow date
    public String setDateSold(String dateSold){
        return this.dateSold = dateSold;
    }  
}
