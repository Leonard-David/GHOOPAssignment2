package com.mycompany.cardealershipmanagement;
import java.util.Date;

/**
 *
 * @author Group H
 */
public class GasPoweredCar extends Car{
    private double cost;
    private double mileage;
    public GasPoweredCar(String carCode, String brand, String model, String engineType,
            double mileage, String carType, String color, double cost, Date dateBroughtIn){
        
        super(carCode, brand, model, engineType, mileage, carType, color, cost, dateBroughtIn);
        this.cost = cost;
        this.mileage = mileage;
    }
    
    @Override
    public double getCost(){
        this.cost = cost/mileage*2;
        return cost;
    }
}
