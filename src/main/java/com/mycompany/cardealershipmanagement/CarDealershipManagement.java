package com.mycompany.cardealershipmanagement;

import java.util.Scanner;
/**
 *
 * @author Group H
 */
public class CarDealershipManagement {

    public static void main(String[] args) {
       CarDealership cds = new CarDealership();
        Scanner scan = new Scanner(System.in);
       while(true){
           System.out.println("""
                              1. Add Car
                              2. Sell car
                              3. Retrive customer receipt
                              4. Remove car
                              5. Cars in stock amount
                              6. Get cars with specified color
                              7. Check if car in stock
                              8. Cheapest electric car
                              9. Expensive car
                              10. Cheapest car
                              11. Gas-Powered car cost average
                              12. Number of cars sold in a given year 
                              13. Money made in year amount
                              14. Get car price
                              0. Exit program
                              """);
           int x = scan.nextInt();
           
           switch(x){
               case 1:
                   System.out.println("Add Car\nEnter car type (Gas-Powered-Car or Electric-Powered-Car)");
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
                   System.out.println("Enter color:");
                   String color = scan.next();
                   System.out.println("Ener cost:");
                   double cost = scan.nextDouble();
                   cds.addNewCar(carCode, brand, model, engineType, mileage, carType, color, cost);
                   break;
               case 2:
                   System.out.println("Sell Car\n\nEnter customer ID number:");
                   int customerIdNumber = scan.nextInt();
                   System.out.println("Customer's first name:");
                   String firstName = scan.next();
                   System.out.println("Enter last Name:");
                   String lastName = scan.next();
                   System.out.println("Enter gender (M/F):");
                   char gender = scan.next().charAt(0);
                   System.out.println("Enter customers cellphone number:");
                   int cellphoneNo = scan.nextInt();
                   System.out.println("Enter license ID");
                   String lIdNumber = scan.next();
                   System.out.println("Enter license code (B/BE/C1/C1E/C/CE)");
                   String lCode = scan.next();
                   System.out.println("Enter date license was issued:");
                   String lIssueDate = scan.next();
                   System.out.println("Enter license expiry date:");
                   String lExpiryDate = scan.next();
                   System.out.println("Enter car ID No:");
                   String carIdNumber = scan.next();
                   cds.sellACar( customerIdNumber, firstName, lastName, gender, cellphoneNo, carIdNumber, lIdNumber, lCode, lIssueDate, lExpiryDate);
                   break;
               case 3:
                   System.out.println("Retrieving receipt\n\nEnter Customers Enter:");
                   int  cutomerIdNumber = scan.nextInt();
                   System.out.println(cds.returnCustomerReceipt( cutomerIdNumber));
                   break;
               case 4:
                   System.out.println("Retrieving receipt\n\nEnter Customers Enter:");
                   String  cIdNumber = scan.next();
                   cds.removeCar( cIdNumber);
                   break;
               case 5:
                   System.out.println("There are " + cds.carsInStockNo()+" cars in stock.");
                   break;
               case 6:
                   System.out.println("To get cars with a type of color\n\nEnter color:");
                   String carColor = scan.next();
                   System.out.println("Cars with a " + carColor +" color\n" + cds.carsWithSpecificColor( carColor));
                   break;
               case 7:
                   System.out.println("Cars in Stock\n\nEnter car brand:");
                   String cBrand = scan.next();
                    System.out.println("\n\nEnter car model:");
                   String cModel = scan.next();
                   System.out.println( cds.isCarInStock( cBrand, cModel));
                   break;
               case 8:
                   System.out.println("The cheapest electric-powered car is a " + cds.cheapestElectricCar());
                   break;
               case 9:
                   System.out.println("The most expensive car is a " +cds.mostExpensiveCar());
                   break;
               case 10:
                   System.out.println("The cheapest car is a " + cds.cheapestCar());
                   break;
               case 11:
                   System.out.println("The cost average of gas-powered cars is " + cds.gasPoweredCarCostAverage());
                   break;
               case 12:
                   System.out.println("number of cars sold in a specific year:\n\nEnter year only:");
                   int cSISY = scan.nextInt();
                   System.out.println("The following cars were sold in"+ cSISY+"\n\n"+cds.carsSoldInASpecificYearNo(cSISY));
                   break;
               case 13:
                  System.out.println("Money made in a specific year:\n\nEnter year only:");
                   int year = scan.nextInt();
                   System.out.println("Money made in "+ year+" was N$ "+cds.moneyMadeInASpecificYear(year));
                   break;  
               case 14:
                   System.out.println("Cars in Stock\n\nEnter car brand:");
                    String cB = scan.next();
                    System.out.println("Cars in Stock\n\nEnter car brand:");
                    String cM = scan.next();
                    System.out.println("The price of a " + cB + " is N$" +cds. priceOfGivenCar(cB, cM));
                   break;
               default: System.exit(0);
           }
        }

    }
}
