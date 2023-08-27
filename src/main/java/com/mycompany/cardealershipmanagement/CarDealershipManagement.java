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
                              1. Add Car
                              2. Sell car
                              3. Retrive customer receipt
                              4. Remove car
                              5. Car stock number
                              6. car with specific color
                              7. Car in stock available
                              8. Cheapest electric car
                              9. Expensive car
                              10. Cheapest car
                              11. Gas-Powered car cost average
                              12. Cars sold in a year 
                              13. Money made in a year
                              14. Car price
                              0. Exit program
                              """);
           try{
               int x = scan.nextInt();
           switch(x){
               case 1:
                   System.out.println("Add Car\nEnter car type (GasPoweredCar or ElectricPoweredCar)");
                   String carType = scan.next();
                   System.out.println("Enter code:");
                   String carCode = scan.next();
                   System.out.println("Enter brand:");
                   String brand = scan.next();
                   System.out.println("Enter model:");
                   String model = scan.next();
                   System.out.println("Enter engine type:");
                   String engineType = scan.next();
                   System.out.println("Enter mileage:");
                   double mileage = scan.nextDouble();
                   String fuelType = "";
                   if("GasPoweredCar".equals(carType)){
                       System.out.println("Enter fuel type:");
                       fuelType = scan.next();
                   }
                   System.out.println("Enter color:");
                   String color = scan.next();
                   System.out.println("Ener cost:");
                   double cost = scan.nextDouble();
                   cds.addNewCar(carCode, brand, model, engineType, mileage,fuelType,carType, color, cost);
                   break;
               case 2:
                   System.out.println("Sell Car\n\nEnter customer ID number:");
                   String customerIdNumber = scan.next();
                   System.out.println("Customer's first name:");
                   String firstName = scan.next();
                   System.out.println("Enter last Name:");
                   String lastName = scan.next();
                   System.out.println("Enter gender (M/F):");
                   char gender = scan.next().charAt(0);
                   System.out.println("Enter customers cellphone number:");
                   String cellphoneNo = scan.next();
                   System.out.println("Enter license ID");
                   String lIdNumber = scan.next();
                   System.out.println("Enter license code (B/BE/C1/C1E/C/CE)");
                   String lCode = scan.next();
                   System.out.println("Enter date license was issued:");
                   String lIssueDate = scan.next();
                   System.out.println("Enter license expiry date:");
                   String lExpiryDate = scan.next();
                   System.out.println("Enter car Brand:");
                   String brnd = scan.next();
                   System.out.println("Enter car Model:");
                   String modl = scan.next();
                   System.out.println("Enter car ID No:");
                   String carIdNumber = scan.next();
                   System.out.println("Enter receipt ID No:");
                   String rcptId = scan.next();
                   cds.sellACar( rcptId,customerIdNumber, firstName, lastName, gender, cellphoneNo, carIdNumber, lIdNumber, lCode, lIssueDate, lExpiryDate,brnd,modl);
                   System.out.println(cds.returnCustomerReceipt(rcptId));
                   break;
               case 3:
                   System.out.println("Retrieving receipt\nEnter Customers Enter:");
                   String receiptId = scan.next();
                   System.out.println(cds.returnCustomerReceipt( receiptId));
                   break;
               case 4:
                   System.out.println("Retrieving receipt\nEnter Customers Enter:");
                   String  cIdNumber = scan.next();
                   cds.removeCar( cIdNumber);
                   break;
               case 5:
                   System.out.println("There are " + cds.carsInStockNo()+" cars in stock.");
                   break;
               case 6:
                   System.out.println("To get cars with a type of color\nEnter color:");
                   String carColor = scan.next();
                   System.out.println("Cars with a " + carColor +" color\n" + cds.carWithSpecificColor( carColor));
                   break;
               case 7:
                   System.out.println("Cars in Stock\nEnter car brand:");
                   String cBrand = scan.next();
                    System.out.println("\nEnter car model:");
                   String cModel = scan.next();
                   System.out.println( cds.isCarInStock( cBrand, cModel));
                   break;
               case 8:
                   System.out.println("The cheapest electric-powered car is a " + cds.cheapestElectricCar().getBrand() +" "+cds.cheapestElectricCar().getModel());
                   break;
               case 9:
                   System.out.println("The most expensive car is a " +cds.mostExpensiveCar().getBrand() +" "+cds.mostExpensiveCar().getModel());
                   break;
               case 10:
                   System.out.println("The cheapest car is a " + cds.cheapestCar().getBrand() +" "+cds.cheapestCar().getModel());
                   break;
               case 11:
                   System.out.println("The cost average of gas-powered cars is " + toCurrency.format( cds.gasPoweredCarCostAverage()));
                   break;
               case 12:
                   System.out.println("number of cars sold in a specific year:\nEnter year only:");
                   int cSISY = scan.nextInt();
                   System.out.println("The following is the number of cars that were sold in "+ cSISY+"\n"+cds.carSoldInASpecificYearNo(cSISY)+" were sold in "+cSISY);
                   break;
               case 13:
                  System.out.println("Money made in a specific year:\nEnter year only:");
                   int year = scan.nextInt();
                   System.out.println("Money made in "+ year+" was N$ "+toCurrency.format(cds.moneyMadeInASpecificYear(year)));
                   break;  
               case 14:
                   System.out.println("Cars in Stock\nEnter car brand:");
                    String cB = scan.next();
                    System.out.println("Cars in Stock\nEnter car brand:");
                    String cM = scan.next();
                    System.out.println("The price of a " + cB + " is N$" +toCurrency.format(cds.priceOfGivenCar(cB, cM)));
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
