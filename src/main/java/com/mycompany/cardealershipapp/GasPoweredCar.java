package com.mycompany.cardealershipapp;

/**
 *
 * @author Leonard M. David
 */
public class GasPoweredCar extends Car{
    //creating private attributes
    private double cost;
    private double mileage;
    private String fuelType;
    public GasPoweredCar(String carCode, String brand, String model, String engineType,
            double mileage, String fuelType, String carType, String color, double cost, String dateBroughtIn, String timeBroughtIn){
        
        super(carCode, brand, model, engineType, mileage, carType, color, cost, dateBroughtIn, timeBroughtIn);
        this.cost = cost;
        this.mileage = mileage;
        this.fuelType = fuelType;
    }
    // overriding an inheritted method..
    @Override
    public double getCost(){
        this.cost = cost - (mileage*2);
        return cost;
    }
     public String getFuelType(){
        return fuelType;
    }
}
