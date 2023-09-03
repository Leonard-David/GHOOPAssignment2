package com.mycompany.cardealershipmanagement;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author Group H
 */
public class CarDealership {
    // creatiing instances.
    ArrayList<Car> car;
    ArrayList<Customer> customer;
    ArrayList<Receipt> receipt;
    
    //Created a constructor for the Cardealership in which we created object for the different class instances.
    //we as well assigned values to the varaivles.
    public CarDealership(){
        car = new ArrayList<>();
        customer = new ArrayList<>();
        receipt = new ArrayList<>();
    }
    
    //This method adds a new car to the carDealership depending on the type of car as per requirement from the Dealership.
    public void addNewCar(String carCode, String brand, String model, String engineType, double mileage, String fuelType,
        String carType, String color, double cost) throws Exception{
        
       //local date and time instances
        LocalTime cTime = LocalTime.now();
        LocalDate cDate = LocalDate.now();
      
        //using the  date formatter for to get the time and date only
        DateTimeFormatter toTime = DateTimeFormatter.ofPattern("HH:mm:ss");
        DateTimeFormatter toDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
     
        //fornating the date to suit the below time and date attributes
        String currentTime = toTime.format(cTime);
        String currentDate = toDate.format(cDate);
        
        Car newCar = null;
        for(int i = 0; i < car.size(); i++){
            if(carCode.equals(car.get(i).getCarCode())){
                throw new Exception("The car already exist.");
            }
        }
        if (carType.equals("GasPoweredCar")) {
            newCar = new GasPoweredCar(carCode, brand, model, engineType, mileage, fuelType, carType, color, cost, currentDate,currenntTime);
        } else if (carType.equals("ElectricPoweredCar")) {
            newCar = new ElectricPoweredCar(carCode, brand, model, engineType, mileage, carType, color, cost, currentDate,currenntTime);
        } else {
            throw new Exception("Unsupported car type.");
        }
        car.add(newCar);
    }
    // This method record customer details, receipt details and sets date sold as the Dealership sells a car.
    public void sellACar(String receiptId, String customerIdNumber, String firstName, String lastName, char gender, String cellphoneNo,
                     String carIdNumber, String lIdNumber, String lCode, String lIssueDate,
                     String lExpiryDate, String brand, String model) throws Exception {
        
        Car currentCar =null;
        Date dateSold = new Date();
        License license = new License(lIdNumber, lCode, lIssueDate, lExpiryDate);
        String fullName = firstName + " " + lastName;
        for (int i = 0; i < car.size(); i++) {
            currentCar = car.get(i);
            if (carIdNumber.equals(currentCar.getCarCode())) {
            currentCar.setDateSold(dateSold);
                double carCost = 0.00;
                if (currentCar instanceof GasPoweredCar) {
                    carCost = ((GasPoweredCar) currentCar).getCost();
                } else if (currentCar instanceof ElectricPoweredCar) {
                    carCost = ((ElectricPoweredCar) currentCar).getCost();
                }
                customer.add(new Customer(customerIdNumber, firstName, lastName, gender, cellphoneNo, license));
                receipt.add(new Receipt(receiptId, customerIdNumber, fullName, brand, carIdNumber, dateSold, carCost, model));
                break; 
            }
             else{
                throw new Exception("Car not found or incorrect input! Please try again!\nIf problem persist please call your system adminstrator.");
            }
        }
    }
    
    //This method returns a given customers receipt.
    public Receipt returnCustomerReceipt(String receiptId) throws Exception  {
        Receipt toString = null;
        
            for(int i = 0; i < receipt.size(); i++){
                if(!receiptId.equals(receipt.get(i).getReceiptId())){
                    throw new Exception("Receipt not found or incorrect input! Please try again!\nIf problem persist please call your system adminstrator.");
                
                }
                else{
                     toString =  receipt.get(i);
                }
            }
            return toString;
    }
    //This methos removes a car given the vehicle identification number (VIN)/car code.
    public void removeCar(String carCode) throws Exception {                                 
        boolean found = false;
        for (int i = car.size() - 1; i >= 0; i--) {
            if (carCode.equals(car.get(i).getCarCode())) {
                car.remove(i);
                found = true;
            }
        }
        if (!found) {
            throw new Exception("Vehicle verification number not found or incorrect ID! Please try again!\nIf the problem persists, please call your system administrator.");
        }
    }
    
      // This method returns the number of cars in Stock.
    public int carsInStockNo(){
        return car.size();
    }
    //This method returns a car with a specific color
    public Car carWithSpecificColor(String color) throws Exception {
        Car carName = null;
        boolean found = false;
        for( int i = 0; i < car.size() ; i++){
            if(color.equalsIgnoreCase(car.get(i).getColor())){
                carName = car.get(i);
                found = true;
            }
        }
        if(!found){
            throw new Exception("Car with "+color+" color not found.");
        }
        return carName;
    }
    //This method returns if a give car is in stock or not (true/false).
    public boolean isCarInStock(String brand, String model) {
        boolean carIsInStock = false;
        for ( int i = 0; i < car.size(); i++ ){
            if(brand.equals(car.get(i).getBrand()) && model.equals(car.get(i).getModel())){
                carIsInStock = true;
            }
        }         
        return carIsInStock;
    }
    //This method Returns the Cheapest Electric Car of all electric cars.
    public ElectricPoweredCar cheapestElectricCar()throws Exception {
        ElectricPoweredCar  cheapElectricCar = null;
        double cheapestAmount = 40000000.00;
        try{
            for ( int i = 0; i < car.size(); i++ ){
                if(!(car.get(i) instanceof ElectricPoweredCar && ((ElectricPoweredCar)car.get(i)).getCost() < cheapestAmount)){
                     cheapestAmount = car.get(i).getCost();
                    cheapElectricCar = (ElectricPoweredCar) car.get(i);
                }
            }
            return cheapElectricCar;
        }
        catch(Exception e){
            throw e;
        }
    }
    //This meethod returns the mos expensive cars of all car types.
    public Car mostExpensiveCar()throws Exception {
        Car expensiveCar = null;
        double expAmount = 15000.00;
        try{
            for(int i = 0; i < car.size(); i++ ){
                if(expAmount < car.get(i).getCost()){
                    expAmount = car.get(i).getCost();
                    expensiveCar = car.get(i);
                }
            }
            return expensiveCar;
        }
        catch(Exception e){
           throw e;
        }
    }    //This method returns the cheapest car of all car types.
    public Car cheapestCar(){
        Car cheapCar = null;
        double cheapestAmount = 40000000.00;
        for ( int i = 0; i < car.size(); i++ ){
            if(cheapestAmount > car.get(i).getCost()){
                cheapestAmount = car.get(i).getCost();
                cheapCar = car.get(i);
            }
        }
        return cheapCar;
    }
    //This car returns the cost average of the gass powered cars.
    public double gasPoweredCarCostAverage(){
        double costAverage = 00.00;
        int count = 0;
        for ( int i = 0; i < car.size(); i++ ){
            if(car.get(i) instanceof GasPoweredCar){
                costAverage = costAverage + car.get(i).getCost();
                count++;
            }
        }
        costAverage = costAverage/count;
        return costAverage;
   }
    //This method return the number of cars sold in a specific year.
    public int carSoldInASpecificYearNo(int specificYear)throws ParseException {
        SimpleDateFormat sdtf = new SimpleDateFormat("y");
        String givenYear = sdtf.format(sdtf.parse(Integer.toString(specificYear)));
        String dateSold;
        int count = 0;
        for ( int i = 0; i < car.size(); i++ ){
            dateSold  = sdtf.format(car.get(i).getDateSold());
            if(givenYear.equals(dateSold)){
                count++;
            }
        }
        return count;
    }
    //This method returns the amount of money made in a given year.
    public double moneyMadeInASpecificYear(int specificYear)throws ParseException{
        SimpleDateFormat sdtf = new SimpleDateFormat("y");
        String givenYear = sdtf.format(sdtf.parse(Integer.toString(specificYear)));
        String dateSold;
        double sum = 00.0;
        for ( int i = 0; i < car.size(); i++ ){
            dateSold  = sdtf.format(car.get(i).getDateSold());
            if(givenYear.equals(dateSold)){
                sum = sum + car.get(i).getCost();
            }
        }
        return sum;
    }
    //This method returns the price of a given car it name and brand.
    public double priceOfGivenCar(String brand, String model){
        double givenCarPrice = 00.00;
        for ( int i = 0; i < car.size(); i++ ){
            if(brand.equals(car.get(i).getBrand()) && model.equals(car.get(i).getModel())){
                givenCarPrice =car.get(i).getCost();
            }
        }
        return givenCarPrice;
    }
}
