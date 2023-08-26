package com.mycompany.cardealershipmanagement;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
            String carType, String color, double cost){
        Date date = new Date();
        if(carType.equals("GasPoweredCar")){
            car.add(new GasPoweredCar(carCode, brand, model, engineType, mileage,fuelType, carType, color, cost, date));
        }
        else if(carType.equals("ElecticPoweredCar")){
            car.add(new ElectricPoweredCar(carCode, brand, model, engineType, mileage, carType, color, cost, date));
        }
        else if(!carType.equals("GasPoweredCar") || !carType.equals("ElecticPoweredCar")){
        }
    }
    // This methos record customer details, receipt details and sets date sold as the Dealership sells a car.
    public void sellACar(String receiptId, String customerIdNumber, String firstName, String lastName, char gender, String cellphoneNo, 
            String carIdNumber, String lIdNumber, String lCode, String lIssueDate, String lExpiryDate, String brand, String model){
        
        License license;
        Date date = new Date();
        
        String fName = firstName +" "+ lastName;
        
        for (int i = 0; i <= car.size(); i++){
            if (carIdNumber.equals(car.get(i).getCarCode())){
                license = new License(lIdNumber,lCode,lIssueDate,lExpiryDate);
                car.get(i).setDateSold(date);
                customer.add(new Customer(customerIdNumber, firstName, lastName, gender, cellphoneNo, license));
                receipt.add(new Receipt( receiptId, customerIdNumber, fName, brand, carIdNumber, date, car.get(i).getCost(), model)) ;
            }
        }
    }
    
    //This method returns a given customers receipt.
    public Receipt returnCustomerReceipt(String receiptId){
        Receipt toString = null;
        for(int i = 0; i < receipt.size(); i++){
            if(receiptId.equals(receipt.get(i).getReceiptId())){
                toString =  receipt.get(i);
            }
        }
        return toString;
    }
    //This methos removes a car given the vehicle identification number (VIN)/car code.
    // here we as well called the method indexOf to be able to get the value.
    public void removeCar(String carCode){                                 
        int index = indexOf(carCode);
        for( int i = index; i < car.size(); i++){
            
        }
    }
    //This method get the index of a car given its car code.
     public int indexOf(String value){
       int index = 0;
       for(int i = 0; i < car.size(); i++){
           if (value.equals(car.get(i).getCarCode())){
               index = i;
           }
       }
       return index;
   } 
     // This method returns the number of cars in Stock.
    public int carsInStockNo(){
        return car.size();
    }
    //This method returns a car with a specific color
    public String carWithSpecificColor(String color){
        String carName = "Car with "+color+" colour not found.";
        
        for( int i = 0; i < car.size() ; i++){
            if(color.equalsIgnoreCase(car.get(i).getColor())){
                carName = car.get(i).getBrand() +" "+ car.get(i).getModel();
            }
        }
        return carName;
    }
    //This method returns if a give car is in stock or not (true/false).
    public boolean isCarInStock(String brand, String model){
        boolean carIsInStock = false;
        for ( int i = 0; i < car.size(); i++ ){
            if(brand.equals(car.get(i).getBrand()) && model.equals(car.get(i).getModel())){
                carIsInStock = true;
            }
        }
        return carIsInStock;
    }
    //This method Returns the Cheapest Electric Car of all electric cars.
    public ElectricPoweredCar cheapestElectricCar(){
        ElectricPoweredCar cheapElectricCar = null;
        double cheapestAmount = 40000000.00;
        for ( int i = 0; i < car.size(); i++ ){
            if(car.get(i) instanceof ElectricPoweredCar && ((ElectricPoweredCar)car.get(i)).getCost() < cheapestAmount){
                cheapestAmount = car.get(i).getCost();
                cheapElectricCar = (ElectricPoweredCar) car.get(i);
            }
        }
        return cheapElectricCar;
    }
    //This meethod returns the mos expensive cars of all car types.
    public Car mostExpensiveCar(){
        Car expensiveCar = null;
        double expAmount = 15000.00;
        for ( int i = 0; i < car.size(); i++ ){
            if(expAmount < car.get(i).getCost()){
               expAmount = car.get(i).getCost();
               expensiveCar = car.get(i);
            }
        }
        return expensiveCar;
    }
    //This method returns the cheapest car of all car types.
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
