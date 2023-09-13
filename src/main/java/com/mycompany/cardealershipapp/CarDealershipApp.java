package com.mycompany.cardealershipapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author Leonaard M. David
 */
public class CarDealershipApp {

    public static void main(String[] args) throws ParseException {
        CarDealership cds = new CarDealership();
        Scanner scan = new Scanner(System.in);
        NumberFormat toCurrency = NumberFormat.getCurrencyInstance();
        String gasPCFPath = "C:\\Users\\mpula\\OneDrive\\Documents\\GasPoweredCarInventory.txt";
        while(true){
            
            //Menu with a number of options/services
            carDealershipServicesMenu();
            
            int x = 0;
            //chaecking if input is an integer type or not
            if(scan.hasNextInt() == true){
                x = scan.nextInt();//assigning a integer if condition is met
            }
            else{
                //if above condition is not met then an exception is thrown
                System.out.println("\nInvalid value entered! Please enter a number from the list of options.");
                scan.next();//allows for control of the loop when above condition is not met.
                continue; // continues to the switch if condition is met and avoids termination of program.
            }
            
            //using a switch to access the options in the service menu one at a time.
            switch(x){
                //adding cars to the dealrship
                case 1: 
                    try{
                        cds.addNewCar("1HGB41JXMN109186", "Ford", "Mustang-GT", "5038-cc-V8", 2050,"Petrol","GasPoweredCar", "Gray-Metallic", 1194000.0);
                        cds.addNewCar("5YJSA1CN8D", "Tesla", "Roadstar", "4-pole-induction-electric-motor", 958.50,"","ElectricPoweredCar", "Red", 3400000.0);
                        cds.addNewCar("2FUB51PKMN157", "Audi", "E-tron-GT", "AC-synchronous-electric-motors", 400.86,"","ElectricPoweredCar", "Blue-metallic", 2065712.0);
                        cds.addNewCar("4KJDSN786DS512", "Toyota", "Supra-MK4", "2JZ-GTE-3.0-litre", 2436.0,"Petrol","GasPoweredCar", "Stratosphere", 418377);
                        System.out.println("Car added successfully.\n");
                    }
                    catch(ParseException e){
                        System.out.println("Date or Time formating has failed. Please try again. \nIf problem persist please call your system adminstrato.");
                    }
                    catch(Exception e){
                        System.out.println(e+" Please ener valid car type.");
                    }
                    break;
                // in this method the dealership is selling a car to a customer yet at the same time keep record of the customers detalis and generatin a receipt     
                case 2:
                    try{
                        cds.sellACar("01CstM2023","01010700607", "Asteria", "David", 'M', "0812883053", "1HGB41JXMN109186", "999999ABC", "C1E", "01/02/2022", "01/02/2026", "Ford", "Mustang-GT");
                        System.out.println("Car sold successfully.\n");
                    }
                    catch(Exception e){
                            System.out.println(e.toString());
                        }
                    break;
                //Here a customers receipt is returned or retrieved    
                case 3:
                    try{
                        String receipt = cds.returnCustomerReceipt( "01CstM2023").toString();
                        System.out.println(receipt+"\n");
                    }
                    catch(Exception e){
                        System.out.println(e.toString());
                    }
                    break;
                //This case allows for a removal of a car from the program
                case 4:
                    try{
                        cds.removeCar( "4KJDSN786DS512");
                        System.out.println("Car removed successfully.\n");
                        }
                    catch(Exception e){
                        System.out.println(e.toString());
                    }
                    break;
                //This case allows for checking the number of cars in stock    
                case 5:
                    int number = cds.carsInStockNo();
                    System.out.println("There are " + number+" cars in stock.\n");
                    break;
                //Here a car with a given color is returned depending on its availability in stock of if such a car with the given color exists
                case 6:
                    String carWithColor;
                    try{
                        carWithColor = cds.carWithSpecificColor( "Stratosphere").getBrand() +" "+cds.carWithSpecificColor( "Stratosphere").getModel();
                        System.out.println("Cars with a Stratosphere color is a " + carWithColor+"\n");
                    }
                    catch(NullPointerException e){
                        System.out.println("\nCar with given color not found or does not exist! Please try again.\nIf problem persist please call your system adminstrator.");
                    }catch(Exception e){
                        System.out.println(e.toString());
                    }
                    break;
                //This case allows for checking if a given car brand and model is in stock
                case 7:
                    boolean isInStock;
                    isInStock = cds.isCarInStock( "Ford", "Mustang-GT");
                    if( isInStock == true){
                        System.out.println("Car is in stock.\n");
                    }
                    else if (isInStock == true ){
                        System.out.println("Car is not in stock.\n");
                    }
                    break;
                //This case allows for checking the cheapest electric car
                case 8:
                    String cheapestElectricCar;
                    try{
                        cheapestElectricCar =cds.cheapestElectricCar().getBrand() +" "+cds.cheapestElectricCar().getModel();
                        System.out.println("The cheapest electric-powered car is a " + cheapestElectricCar+"\n");
                    }
                    catch(NullPointerException e){
                        System.out.println("\nCar not found or does not exist! Please try again.\nIf problem persist please call your system adminstrator.");
                    }
                    catch(ClassCastException e){
                        System.out.println("\nFalied to cast vehicle elements! Pleaase try again.\nIf problem persist please call your system adminstrator.");
                    }
                    catch(Exception e){
                        System.out.println("\nAn unexpected error has occured! Please contact your system adminstrator.");
                    }
                    break;
                //This case checks for the most expensive car
                case 9:
                    try{
                        String expensiveCar = cds.mostExpensiveCar().getBrand() +" "+cds.mostExpensiveCar().getModel();
                        System.out.println("The most expensive car is a " + expensiveCar+"\n");
                    }
                    catch(NullPointerException e){
                        System.out.println("\nCar not found or does not exist! Please try again.\nIf problem persist please call your system adminstrator.");
                    }catch(Exception e){
                        System.out.println("\nAn unexpected error has occured! Please contact your system adminstrator.");
                    }
                    break;
                //Similarly his cade does the oposite of case 9, basically alowing for checkinfg the cheapest car
                case 10:
                    String cheapetCar;
                    try{
                        cheapetCar =cds.cheapestCar().getBrand() +" "+cds.cheapestCar().getModel();
                        System.out.println("The cheapest car is a " + cheapetCar+"\n");
                    }
                    catch(NullPointerException e){
                        System.out.println("\nCar not found or does not exist! Please try again.\nIf problem persist please call your system adminstrator.");
                    }catch(Exception e){
                        System.out.println("\nAn unexpected error has occured! Please contact your system adminstrator.");
                    }
                    break;
                //Case 11 allows for checking the cost average of the gass powered cars
                case 11:
                    String costAverage;
                    try{
                        costAverage = toCurrency.format( cds.gasPoweredCarCostAverage());
                        System.out.println("The cost average of gas-powered cars is " + costAverage+"\n");
                    }
                    catch(IndexOutOfBoundsException e){
                        System.out.println("Cost Average not found! Please try again!\nIf problem persist please call your system adminstrator.");
                    }
                    catch(ArithmeticException e){
                        System.out.println("Price not found. Please try again! \nIf problem persist please call your system adminstrator.");
                    }
                    catch(Exception e){
                        System.out.println("An unexpected error has occured! Please contact your system adminstrator.");
                    }
                    break;
                //This case allows for checking the number of cars sold in a given year
                case 12:
                    int amount;
                    try{
                        amount = cds.carSoldInASpecificYearNo(2023);
                        System.out.println(amount +" cars were sold in the given year.\n");
                    }
                    catch(ParseException e){
                        System.out.println("Convertion error! failed to convert given value! Please try again!\nIf problem persist please call your system adminstrator.");
                    }
                    catch(Exception e){
                        System.out.println("An unexpected error has occured! Please contact your system adminstrator."+e.getMessage());
                    }
                    break;
                //This case allows for checking the amount of money nmade in a given year
                case 13:
                    String money;
                    try{
                        money = toCurrency.format(cds.moneyMadeInASpecificYear(2023));
                        System.out.println("Money made in that year was/is N$ "+ money+"\n");
                    }
                    catch(NullPointerException e){
                        System.out.println("Ellements not found! Please try again!\nIf problem persist please call your system adminstrator.");
                    }
                    catch(ParseException e){
                        System.out.println("Date convertion error! Failed to convert given value to date! Please try again!\nIf problem persist please call your system adminstrator.");
                    }
                    catch(Exception e){
                        System.out.println("An unexpected error has occured! Please contact your system adminstrator.");
                   }
                    break;
                //This case allows for cheking a given car's price.
                case 14:
                    String price;
                    try{
                        price = toCurrency.format(cds.priceOfGivenCar("Mustang", "Mustang-GT"));
                        System.out.println("The price of the car is N$ " +price+"\n");
                    }
                    catch(IndexOutOfBoundsException e){
                        System.out.println("\nPrice not found or emoty! Please try again!\nIf problem persist please call your system adminstrator.");
                    }
                    catch(NullPointerException e){
                        System.out.println("\nPrice not found or does not exixt!\nIf problem persist please call your system adminstrator.");
                    }
                    catch(ClassCastException e){
                                System.out.println("\nFailed to convert vehicle price! Please check and try again. \nIf problem persist please call your system adminstrator.");
                    }
                    catch(Exception e){
                        System.out.println("\nAn unexpected error has occured! Please contact your system adminstrator.");
                    }
                    break;
                //This case allows for creating a gas-powered car's file (gasPCF).
                case 15:
                    try{
                        cds.createGPCFile(gasPCFPath);
                        System.out.println("File created Successfulley");
                    }
                    catch(Exception e){
                        System.out.println(e.toString());
                    }
                    break;
                //This case allows for saving gas-powered car data to the file created in case 15.
                case 16:
                    try{
                        cds.saveGasPoweredCarDataToFile(gasPCFPath);
                        System.out.println("Gas-powered car data saved Successfulley");
                    }
                    catch(InputMismatchException e){
                        System.out.println("Invalid value enter! Please enter value from given options.");
                    }
                    catch(SecurityException e){
                        System.out.println("File cannot be accessed or written! Please check and try again. \nIf problem persist please call your system adminstrator.");
                    }
                    catch(FileNotFoundException e){
                        System.out.println("File not found or does not exist! Please check and try again. \nIf problem persist please call your system adminstrator.");
                    }
                    catch(IOException e){
                        System.out.println("An input/ouput I/O error has occured! Please try again. \nIf problem persist please call your system adminstrator.");
                    }
                    catch(Exception e){
                        System.out.println("An unexpected error has occured! Please contact your system adminstrator.");
                    }
                   break;
                //This case allows for getting a customers name with two letter As in their last name.
                case 17:
                    String  nameWith2As; 
                    try{
                        nameWith2As = cds.CustWithOnly2AsInSurname();
                        System.out.println(nameWith2As+" has two letter a's in their name.");
                    }
                    catch(IndexOutOfBoundsException e){
                        System.out.println("\nName not found or empty! Please try again. \nIf problem persist please call your system adminstrator.");
                    }
                    catch(Exception e){
                        System.out.println("An unexpected error has occured! Please contact your system adminstrator.");
                    }
                    break;
                //This case allows for reading from data saved in case 16 for the file created in case 16.
                case 18:
                    File path;
                    Scanner read = null;
                    try{
                        path = new File(gasPCFPath);
                        read = new Scanner(path);
                        while(read.hasNext()){
                            System.out.println(read.nextLine());
                        }
                    }
                    catch(NullPointerException e){
                        System.out.println("File is empty!");
                    }
                    catch(SecurityException e){
                                System.out.println("\nFile cannot be accessed or read! Please check and try again. \nIf problem persist please call your system adminstrator.");
                    }
                    catch(FileNotFoundException e){
                                System.out.println("\nFile not found or does not exist! Please check and try again. \nIf problem persist please call your system adminstrator.");
                    }
                    catch(Exception e){
                                System.out.println("\nAn unexpected error has occured! Please contact your system adminstrator.");
                    }
                    finally{
                        read.close();
                    }
                    break;
                //finally this case allows for printing car objects created from the file created in case 15, of which some cars data was writted to the file in case 16
                case 19:
                    try {
                        ArrayList<Car> sortedCars = cds.readFilAndCreateGasPoweredCarObjects(gasPCFPath);
                        for (Car car : sortedCars) {
                            System.out.println("Car Code: " + car.getCarCode());
                            System.out.println("Brand: " + car.getBrand());
                            System.out.println("Model: " + car.getModel());
                            System.out.println("Engine Type: " + car.getEngineType());
                            System.out.println("Mileage: " + car.getMileage());
                            System.out.println("Fuel Type: " + ((GasPoweredCar)car).getFuelType());
                            System.out.println("Car Type: " + car.getCarType());
                            System.out.println("Color: " + car.getColor());
                            System.out.println("Cost: " + car.getCost());
                            System.out.println("Date Brought In: " + car.getDateBroughtIn());
                            System.out.println("Time Brought In: " + car.getTimeBroughtIn());
                            System.out.println();
                        }
                    }
                    catch(NullPointerException e){
                        System.out.println("\nNo data found! Please try again later. \nIf problem persist please call your system adminstrator.");
                    }
                    catch(InputMismatchException e){
                                System.out.println("\nAn invalid value was recoreded as input! Please try again later. \nIf problem persist please call your system adminstrator."+e.getCause()+e.getStackTrace());
                                e.printStackTrace();
                    }
                    catch(SecurityException e){
                                System.out.println("\nAccess denied! Can not get data.Please try again later. \nIf problem persist please call your system adminstrator.");
                    }
                    catch(FileNotFoundException e){
                                System.out.println("\nFile not found! Please check and try again. \nIf problem persist please call your system adminstrator.");
                    }
                    catch(ClassCastException e){
                                System.out.println("\nFailed to convert information! Please check and try again. \nIf problem persist please call your system adminstrator.");
                    }
                    catch(IOException e){
                        System.out.println("\nAn input/output of some sort has occured!");
                    }
                    catch(Exception e){
                                System.out.println("\nAn unexpected error has occured! Please contact your system adminstrator.");
                    }
                    break;
                case 0:
                    System.exit(0);
                    break;
            }
        }
    }
    //This is a method that prints a list of options or services at the begining if the program and through out the duration of it being used
    public static void carDealershipServicesMenu(){
        System.out.println("""
                                                   ------------------------|Car Dealership|------------------------
                               _______________________________________________________________________________________________________________
                               OPTIONS: Please Select an option from the list below:
                               _______________________________________________________________________________________________________________
                               1. Add Car                       8.  Cheapest electric car             15. Create Files
                               2. Sell car                      9.  Expensive car                     16. Save car data
                               3. Retrive customer receipt      10. Cheapest car                      17. Customer with 2 A's in name
                               4. Remove car                    11. Gas-Powered car cost average      18. All gas-powered car information
                               5. Car stock number              12. Cars sold in a year               19. Print created car ofbject from file
                               6. car with specific color       13. Money made in a year              0.  Exit program 
                               7. Check if car is in stock      14. Car price                         
                               _______________________________________________________________________________________________________________
                               Please Enter a value form the list of options: """);
    }
}