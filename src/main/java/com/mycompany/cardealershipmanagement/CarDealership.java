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
        String currenntTime = toTime.format(cTime);
        String currentDate = toDate.format(cDate);
        
        Car newCar = null;
        
        for(Car exist : car){
            if(carCode.equals(exist.getCarCode())){
                throw new Exception("The car already exist.");
            }
        }
        if (carType.equals("GasPoweredCar")) {
            newCar = new GasPoweredCar(carCode, brand, model, engineType, mileage, fuelType, carType, color, cost, currentDate,currenntTime);
        } else if (carType.equals("ElectricPoweredCar")) {
            newCar = new ElectricPoweredCar(carCode, brand, model, engineType, mileage, carType, color, cost, currentDate,currenntTime);
        } else{
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
                if(car.get(i) instanceof ElectricPoweredCar && ((ElectricPoweredCar)car.get(i)).getCost() < cheapestAmount){
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
    }
    //This method returns the cheapest car of all car types.
    public Car cheapestCar()throws Exception {
        Car cheapCar = null;
        try{
            double cheapestAmount = 40000000.00;
            for ( int i = 0; i < car.size(); i++ ){
                if(cheapestAmount > car.get(i).getCost()){
                    cheapestAmount = car.get(i).getCost();
                    cheapCar = car.get(i);
                }
            }
            return cheapCar;
        }
        catch(Exception e){
            throw e;
        }
    }
    //This car returns the cost average of the gass powered cars.
    public double gasPoweredCarCostAverage()throws Exception{
        int count = 0;
        double costAverage = 00.00;
        try{
            for( int i = 0; i < car.size(); i++ ){
                if(car.get(i) instanceof GasPoweredCar){
                    costAverage = costAverage + car.get(i).getCost();
                    count++;
                }
            }
            costAverage = costAverage/count;
            return costAverage;
        }
        catch(Exception e){
            throw e;
        }
   }
    //This method return the number of cars sold in a specific year.
    public int carSoldInASpecificYearNo(int specificYear)throws Exception {
         SimpleDateFormat sdtf;
         String givenYear;
         String dateSold;
        try{
            sdtf = new SimpleDateFormat("y");
            givenYear = sdtf.format(sdtf.parse(Integer.toString(specificYear)));
            int count = 0;
            for( int i = 0; i < car.size(); i++ ){
                dateSold  = sdtf.format(car.get(i).getDateSold());
                if(givenYear.equals(dateSold)){
                    count++;
                }
            }
            return count;
        }
        catch(Exception e){
            throw e;
        }
    }
    //This method returns the amount of money made in a given year.
    public double moneyMadeInASpecificYear(int specificYear)throws Exception {
        SimpleDateFormat sdtf;
        String givenYear;
        String dateSold;
        double sum = 00.0;
        try{
            sdtf = new SimpleDateFormat("y");
            givenYear = sdtf.format(sdtf.parse(Integer.toString(specificYear)));
            
            for( int i = 0; i < car.size(); i++ ){
                dateSold  = sdtf.format(car.get(i).getDateSold());
                if(givenYear.equals(dateSold)){
                sum = sum + car.get(i).getCost();
                }
            }
            return sum;
        }
        catch(Exception e){
            throw e;
        }
    }
    //This method returns the price of a given car it name and brand.
    public double priceOfGivenCar(String brand, String model)throws Exception {
       Car carPrice = car.get(0);
        try{
            for( int i = 0; i < car.size(); i++ ){
                if(brand.equals(car.get(i).getBrand()) && model.equals(car.get(i).getModel())){
                    carPrice =car.get(i);
                }
            }
            if(carPrice instanceof GasPoweredCar){
                return carPrice.getCost();
            }
            else if(carPrice instanceof ElectricPoweredCar){
                return carPrice.getCost();
            }
            return 0;
        }
        catch(Exception e){
            throw e;
         }
    }
    //Newly Added Methods Assignment 2 on Files and Strings 
    //Wiht this method we are creating a text file for the Electric-powered car
    public void createGPCFile(String filePath) throws Exception{
        File txtGas = new File(filePath);
        if(txtGas.exists() == false){
            txtGas.createNewFile();
        }
        else if(txtGas.exists() == true){
            throw new Exception("The file already exist!");
        }
    }
   
    //this method saved the information of the electric powered car to a  text file.
    public void saveGasPoweredCarDataToFile(String filePath) throws Exception {
        FileWriter buffer = null;
        PrintWriter toGasPoweredCarFile = null;
        try{
             buffer = new FileWriter(filePath, true);
             toGasPoweredCarFile = new PrintWriter(buffer);
            
            for(int i = 0; i < car.size(); i++){
                if(car.get(i) instanceof GasPoweredCar ){
                    toGasPoweredCarFile.write(car.get(i).getCarCode()+
                                              "\n"+car.get(i).getBrand()+
                                              "\n"+car.get(i).getModel()+
                                              "\n"+car.get(i).getEngineType()+
                                              "\n"+car.get(i).getMileage()+
                                              "\n"+((GasPoweredCar)car.get(i)).getFuelType()+
                                              "\n"+car.get(i).getCarType()+
                                              "\n"+car.get(i).getColor()+
                                              "\n"+car.get(i).getCost()+
                                              "\n"+car.get(i).getDateBroughtIn()+
                                              "\n"+car.get(i).getTimeBroughtIn());
                }
            }
        }
        catch(Exception e){
            throw e;
        }
        finally{
            toGasPoweredCarFile.close();
            buffer.close();
        }
    }
   //This method returns the customers name with the only 2As in their surname
    public String CustWithOnly2AsInSurname() throws Exception{
        Customer result = customer.get(0);
        int count = 0;
        try{
            for (int i = 0; i < customer.size(); i++) {
                String lastName = customer.get(i).getLastName().toLowerCase(); 
                for (int x = 0; x < lastName.length(); x++) {
                    if (lastName.charAt(x) == 'a') {
                        count++;
                        result = customer.get(i);
                    }
                }

                if (count == 2) {
                    return result.getLastName();
                }
            }
            return null;
        }
        catch(Exception e){
            throw e;
        }
    }
    //This method is reading car data from a file then creats Car objects and finally calls the sortCarsAlphabeticallyByBrand and returns the sorted cars array list.
    public ArrayList<Car> readFilAndCreateGasPoweredCarObjects(String path) throws Exception {
        ArrayList<Car> sortedCars = new ArrayList<>();
        File file;
        Scanner scanner = null;
       try {
            file = new File(path);
            scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String carCode = scanner.next();
                String brand = scanner.next();
                String model = scanner.next();
                String engineType = scanner.next();
                double mileage = scanner.nextDouble();
                String fuelType = scanner.next();
                String carType = scanner.next();
                String color = scanner.next();
                double cost = scanner.nextDouble();
                String dateBroughtIn = scanner.next();
                String timeBroughtIn = scanner.next();

               Car newObject = new GasPoweredCar(carCode, brand, model, engineType, mileage, fuelType, carType, color, cost, dateBroughtIn,timeBroughtIn);
               sortedCars.add(newObject);
            }

            return sortCarsAlphabeticallyByBrand(sortedCars);
        } 
        catch (Exception e) {
            throw e;
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    // This method sorts cars alphabetically by brand and returns the sorted cars array list.
    public ArrayList<Car> sortCarsAlphabeticallyByBrand(ArrayList<Car> vehicles) {
        ArrayList<Car> sortCars = new ArrayList<>(vehicles);
        boolean swap;
        do {
            swap = false;
            for (int i = 1; i < sortCars.size(); i++) {
                if (sortCars.get(i - 1).getBrand().compareTo(sortCars.get(i).getBrand()) > 0) {
                    Car temp = sortCars.get(i - 1);
                    sortCars.set(i - 1, sortCars.get(i));
                    sortCars.set(i, temp);
                    swap = true;
                }
            }
        } while (swap);

        return sortCars;
    }
}
