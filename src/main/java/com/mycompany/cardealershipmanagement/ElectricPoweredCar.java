package com.mycompany.cardealershipmanagement;
/**
 *
 * @author Group H
 */
public class ElectricPoweredCar extends Car {
    // declaring attributes 
      private double cost;
      private double mileage;
      
     public ElectricPoweredCar(String carCode, String brand, String model, 
             String engineType, double mileage, String carType, String color, double cost, String dateBroughtIn, String timeBroughtIn){
        super(carCode, brand, model, engineType, mileage, carType, color, cost, dateBroughtIn, timeBroughtIn);
        this.cost = cost;
        this.mileage = mileage;
    }
     //overriding an inheritted method
    @Override
    public double getCost(){
        this.cost = cost-(mileage*4);
        return cost;
    }
}
