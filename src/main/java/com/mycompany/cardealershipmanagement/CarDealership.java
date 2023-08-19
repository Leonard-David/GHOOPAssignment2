package com.mycompany.cardealershipmanagement;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Group H
 */
public class CarDealership {
    Car[] car;
    Customer[] customer;
    Receipt[] receipt;
    
    int carAmount;
    int customerAmount;
    int receiptAmount;
    
    public CarDealership(){
        car = new Car[10];
        customer = new Customer[30];
        receipt = new Receipt[100];
        carAmount = 0;
        customerAmount = 0;
        receiptAmount = 0;
    }
    public void addNewCar(String carCode, String brand, String model, String engineType, double mileage, String fuelType,
            String carType, String color, double cost){
        Date date = new Date();
        if(carType.equals("GasPoweredCar")){
            car[carAmount] = new GasPoweredCar(carCode, brand, model, engineType, mileage,fuelType, carType, color, cost, date);
        }
        else if(carType.equals("ElecticPoweredCar")){
            car[carAmount] = new ElectricPoweredCar(carCode, brand, model, engineType, mileage, carType, color, cost, date);
        }
        else if(!carType.equals("GasPoweredCar") || !carType.equals("ElecticPoweredCar")){
            carAmount--;
        }
        carAmount++;
    }
    public void sellACar(String receiptId, String customerIdNumber, String firstName, String lastName, char gender, String cellphoneNo, 
            String carIdNumber, String lIdNumber, String lCode, String lIssueDate, String lExpiryDate, String brand, String model){
        
        License license;
        Date date = new Date();
        
        String fName = firstName +" "+ lastName;
        
        for (int i = 0; i < carAmount; i++){
            if (carIdNumber.equals(car[i].getCarCode())){
                license = new License(lIdNumber,lCode,lIssueDate,lExpiryDate);
                car[i].setDateSold(date);
                customer[customerAmount] = new Customer(customerIdNumber, firstName, lastName, gender, cellphoneNo, license);
                receipt[receiptAmount] = new Receipt( receiptId, customerIdNumber, fName, brand, carIdNumber,
                        date, car[i].getCost(), model);
            }
        } 
        customerAmount++;
        receiptAmount++;
    }
    public String returnCustomerReceipt(String receiptId){
        String toString = "Receipt not found.";
        for(int i = 0; i < receiptAmount; i++){
            if(receiptId.equals(receipt[i].getReceiptId())){
                toString =  receipt[i].toString();
            }
        }
        return toString;
    }
    
    public void removeCar(String carCode){
        int index = indexOf(car, carCode);
        for( int i = index; i < carAmount; i++){
            car[i] = car[i + 1];
        }
         carAmount--;
    }
    public int carsInStockNo(){
        return carAmount;
    }
    public String carWithSpecificColor(String color){
        String carName = "Car with "+color+" colour not found.";
        
        for( int i = 0; i < carAmount ; i++){
            if(color.equalsIgnoreCase(car[i].getColor())){
                carName = car[i].getBrand() +" "+ car[i].getModel();
                
            }
        }
        return carName;
    }
    public boolean isCarInStock(String brand, String model){
        boolean carIsInStock = false;
        for ( int i = 0; i < carAmount; i++ ){
            if(brand.equals(car[i].getBrand()) && model.equals(car[i].getModel())){
                carIsInStock = true;
            }
        }
        return carIsInStock;
    }
    public String cheapestElectricCar(){
        String cheapElectricCar = "Chepest electric car not found.";
        double cheapestAmount = 35000000.00;
        for ( int i = 0; i < carAmount; i++ ){
            if(car[i] instanceof ElectricPoweredCar && cheapestAmount > car[i].getCost()){
                cheapestAmount = car[i].getCost();
                cheapElectricCar =  car[i].getBrand()+" "+ car[i].getModel();
            }
        }
        return cheapElectricCar;
    }
    
    public String mostExpensiveCar(){
        String expensiveCar = "Expensive car not found.";
        double expAmount = 15000.00;
        for ( int i = 0; i < carAmount; i++ ){
            if(expAmount < car[i].getCost()){
               expAmount = car[i].getCost();
                expensiveCar = car[i].getBrand()+" "+ car[i].getModel();
            }
        }
        return expensiveCar;
    }
    public String cheapestCar(){
        String cheapCar = "Cheap car not found.";
        double cheapestAmount = 30000000.00;
        for ( int i = 0; i < carAmount; i++ ){
            if(cheapestAmount > car[i].getCost()){
                cheapestAmount = car[i].getCost();
                cheapCar = car[i].getBrand()+" "+ car[i].getModel();
            }
        }
        return cheapCar;
    }
    public double gasPoweredCarCostAverage(){
        double costAverage = 00.00;
        int count = 0;
        for ( int i = 0; i < carAmount; i++ ){
            if(car[i] instanceof GasPoweredCar){
                costAverage = costAverage + car[i].getCost();
                count++;
            }
        }
        costAverage = costAverage/count;
        return costAverage;
   }
    public int carSoldInASpecificYearNo(int specificYear)throws ParseException {
        SimpleDateFormat sdtf = new SimpleDateFormat("y");
        String givenYear = sdtf.format(sdtf.parse(Integer.toString(specificYear)));
        String dateSold;
        int count = 0;
        for ( int i = 0; i < carAmount; i++ ){
            dateSold  = sdtf.format(car[i].getDateSold());
            if(givenYear.equals(dateSold)){
                count++;
            }
        }
        return count;
    }
    public double moneyMadeInASpecificYear(int specificYear)throws ParseException{
        SimpleDateFormat sdtf = new SimpleDateFormat("y");
        String givenYear = sdtf.format(sdtf.parse(Integer.toString(specificYear)));
        String dateSold;
        double sum = 00.0;
        for ( int i = 0; i < carAmount; i++ ){
            dateSold  = sdtf.format(car[i].getDateSold());
            if(givenYear.equals(dateSold)){
                sum = sum + car[i].getCost();
            }
        }
        return sum;
    }
    public double priceOfGivenCar(String brand, String model){
        double givenCarPrice = 00.00;
        for ( int i = 0; i < carAmount; i++ ){
            if(brand.equals(car[i].getBrand()) && model.equals(car[i].getModel())){
                givenCarPrice =car[i].getCost();
            }
        }
        return givenCarPrice;
    }
     public int indexOf(Car[] c, String value){
       int index = 0;
       for(int i = 0; i < carAmount; i++){
           if (value.equals(c[i].getCarCode())){
               index = i;
           } else {
               return -1;
           }
       }
       return index;
   }
}
