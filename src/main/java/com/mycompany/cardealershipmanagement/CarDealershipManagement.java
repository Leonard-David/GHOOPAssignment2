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
                              1. Add Car                       8. Cheapest electric car\t0. Exit program
                              2. Sell car                      9. Expensive car
                              3. Retrive customer receipt      10. Cheapest car
                              4. Remove car                    11. Gas-Powered car cost average
                              5. Car stock number              12. Cars sold in a year 
                              6. car with specific color       13. Money made in a year
                              7. Car in stock available        14. Car price
                             
                              """);
           try{
               int x = scan.nextInt();
           switch(x){
               case 1:
                   cds.addNewCar("1HGB41JXMN109186", "Ford", "Mustang-GT", "5038 cc (307 cu in) V8", 2000.50,"Petrol","GasPoweredCar", "Dark Matter Gray Metallic", 1194000.0);
                   cds.addNewCar("5YJSA1CN8D", "Tesla", "Roadstar", "-phase, 4-pole, induction electric motor", 958.50,"","ElecticPoweredCar", "Red", 3400000.0);
                   cds.addNewCar("2FUB51PKMN157", "Audi", "E-tron-GT", "AC synchronous electric motors", 400.86,"","ElecticPoweredCar", "Ascari Blue metallic", 2065712.0);
                   cds.addNewCar("4KJDSN786DS512", "Toyota", "Supra-MK4", "2JZ-GTE 3.0-litre", 2436.0,"Petrol","GasPoweredCar", "Stratosphere", 418377);
                   break;
               case 2:
                   cds.sellACar("01CstM2023","01010700607", "Leonard", "David", 'M', "0812883053", "1HGB41JXMN109186", "999999ABC", "C1E", "01/02/2022", "01/02/2026", "Ford", "Mustang-GT");
                    System.out.println(cds.returnCustomerReceipt( "01CstM2023"));
                   break;
               case 3:
                   System.out.println(cds.returnCustomerReceipt( "01CstM2023"));
                   break;
               case 4:
                   cds.removeCar( "4KJDSN786DS512");
                   break;
               case 5:
                   System.out.println("There are " + cds.carsInStockNo()+" cars in stock.");
                   break;
               case 6:
                   System.out.println("Cars with a Stratosphere color\n" + cds.carWithSpecificColor( "Stratosphere"));
                   break;
               case 7:
                    boolean isInStock = cds.isCarInStock( "Ford", "Mustang-GT");
                   if( isInStock == true){
                      System.out.println("Car is in stock.");
                   }
                   else{
                       System.out.println("Car is not in stock.");
                   }
                   break;
               case 8:
                   String cheapestElectricCar =cds.cheapestElectricCar().getBrand() +" "+cds.cheapestElectricCar().getModel();
                   System.out.println("The cheapest electric-powered car is a " + cheapestElectricCar);
                   break;
               case 9:
                   String expensiveCar = cds.mostExpensiveCar().getBrand() +" "+cds.mostExpensiveCar().getModel();
                   System.out.println("The most expensive car is a " + expensiveCar);
                   break;
               case 10:
                   String cheapetCar =cds.cheapestCar().getBrand() +" "+cds.cheapestCar().getModel();
                   System.out.println("The cheapest car is a " + cheapetCar);
                   break;
               case 11:
                   String costAverage = toCurrency.format( cds.gasPoweredCarCostAverage());
                   System.out.println("The cost average of gas-powered cars is " + costAverage );
                   break;
               case 12:
                   int number = cds.carSoldInASpecificYearNo(2023);
                   System.out.println(number +" cars were sold");
                   break;
               case 13:
                   String amount = toCurrency.format(cds.moneyMadeInASpecificYear(2023));
                   System.out.println("Money made in that year was/is N$ "+ amount);
                   break;  
               case 14:
                    String price = toCurrency.format(cds.priceOfGivenCar("Toyota", "Supra-MK4"));
                    System.out.println("The price of the car is N$ " +price);
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
