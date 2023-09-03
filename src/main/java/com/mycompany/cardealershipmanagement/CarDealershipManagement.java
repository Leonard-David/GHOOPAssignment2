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
               case 2:
                   cds.sellACar("01CstM2023","01010700607", "Leonard", "David", 'M', "0812883053", "1HGB41JXMN109186", "999999ABC", "C1E", "01/02/2022", "01/02/2026", "Ford", "Mustang-GT");
                    System.out.println(cds.returnCustomerReceipt( "01CstM2023"));
                    System.out.println("Car sold successfully.\n");
                   break;
               case 3:
                   System.out.println(cds.returnCustomerReceipt( "01CstM2023")+"\n");
                   break;
               case 4:
                   cds.removeCar( "4KJDSN786DS512");
                   System.out.println("Car removed successfully.\n");
                   break;
               case 5:
                   System.out.println("There are " + cds.carsInStockNo()+" cars in stock.\n");
                   break;
               case 6:
                   String carWithColor = cds.carWithSpecificColor( "Stratosphere").getBrand() +" "+cds.carWithSpecificColor( "Stratosphere").getModel();
                   System.out.println("Cars with a Stratosphere color is a " + carWithColor+"\n");
                   break;
               case 7:
                    boolean isInStock = cds.isCarInStock( "Ford", "Mustang-GT");
                   if( isInStock == true){
                      System.out.println("Car is in stock.\n");
                   }
                   else{
                       System.out.println("Car is not in stock.\n");
                   }
                   break;
               case 8:
                   String cheapestElectricCar =cds.cheapestElectricCar().getBrand() +" "+cds.cheapestElectricCar().getModel();
                   System.out.println("The cheapest electric-powered car is a " + cheapestElectricCar+"\n");
                   break;
               case 9:
                   String expensiveCar = cds.mostExpensiveCar().getBrand() +" "+cds.mostExpensiveCar().getModel();
                   System.out.println("The most expensive car is a " + expensiveCar+"\n");
                   break;
               case 10:
                   String cheapetCar =cds.cheapestCar().getBrand() +" "+cds.cheapestCar().getModel();
                   System.out.println("The cheapest car is a " + cheapetCar+"\n");
                   break;
               case 11:
                   String costAverage = toCurrency.format( cds.gasPoweredCarCostAverage());
                   System.out.println("The cost average of gas-powered cars is " + costAverage+"\n");
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
