package com.mycompany.cardealershipmanagement;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 *
 * @author Group H
 */
public class CarDealershipManagement {

    public static void main(String[] args) throws ParseException {
       CarDealership cds = new CarDealership();
        Scanner scan = new Scanner(System.in);
        NumberFormat toCurrency = NumberFormat.getCurrencyInstance();
       while(true){
           System.out.println("""
                              1. Add Car                       8. Cheapest electric car
                              2. Sell car                      9. Expensive car
                              3. Retrive customer receipt      10. Cheapest car
                              4. Remove car                    11. Gas-Powered car cost average
                              5. Car stock number              12. Cars sold in a year 
                              6. car with specific color       13. Money made in a year
                              7. Car in stock available        14. Car price
                                                   0. Exit program
                              """);
           try{
               int x = scan.nextInt();
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
                        cds.sellACar("01CstM2023","01010700607", "Leonard", "David", 'M', "0812883053", "1HGB41JXMN109186", "999999ABC", "C1E", "01/02/2022", "01/02/2026", "Ford", "Mustang-GT");
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
               case 12:
                   int number = cds.carSoldInASpecificYearNo(2023);
                   System.out.println(number +" car sold in the given year where" + number+"\n");
                   break;
               case 13:
                   String amount = toCurrency.format(cds.moneyMadeInASpecificYear(2023));
                   System.out.println("Money made in that year was/is N$ "+ amount+"\n");
                   break;  
               case 14:
                    String price = toCurrency.format(cds.priceOfGivenCar("Toyota", "Supra-MK4"));
                    System.out.println("The price of the car is N$ " +price+"\n");
                   break;
               default: System.exit(0);
           }
           }
           catch(InputMismatchException invalidValueEnterd){
               System.out.println("Error! You have enteres an invalid value\n\nPlease try again");  
           }
        }
    }
}
