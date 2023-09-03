package com.mycompany.cardealershipmanagement;

import java.nio.file.Files;
import java.nio.file.Path;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mpula
 */
public class CarDealershipTest {
    CarDealership carDealershipInstance = null; 
    //local date and time instances
    LocalTime cTime = LocalTime.now();
    LocalDate cDate = LocalDate.now();
      
    //using the  date formatter for to get the time and date only
    DateTimeFormatter toTime = DateTimeFormatter.ofPattern("HH:mm:ss");
    DateTimeFormatter toDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
     
    //fornating the date to suit the below time and date attributes
    String currentTime = toTime.format(cTime);
    String currentDate = toDate.format(cDate);
      
    NumberFormat toCurrency = NumberFormat.getCurrencyInstance();
    public CarDealershipTest() {
        Date date = new Date();
        carDealershipInstance = new CarDealership();
        //car 1
        carDealershipInstance.car.add(0, new GasPoweredCar("1HGB41JXMN109186","Ford","Mustang-GT","5038 cc (307 cu in) V8",2000.50,"Petrol","Gas-Powered-Car","Dark Matter Gray Metallic",1194000.0,currentDate,currentTime));
        //car 2
        carDealershipInstance.car.add(1,new ElectricPoweredCar("5YJSA1CN8D","Tesla","Roadstar","3-phase, 4-pole, induction electric motor",2000.50,"Electric-Powered-Car","Red",3400000.0,currentDate,currentTime));
        //car 3
        carDealershipInstance.car.add(2, new ElectricPoweredCar("2HGB51JXMN1086","Audi","E-tron-GT","AC synchronous electric motors",2000.50, "ElecticPoweredCar", " Ascari Blue metallic",2065712.0,currentDate,currentTime));
        //car 4
        carDealershipInstance.car.add(3, new GasPoweredCar("5TENL42N94Z436445", "Toyota", "Supra-MK4", "a 2JZ-GTE 3.0-litre twin-turbocharged straight 6 with 280 horsepower", 200.50,"Petrol", "GasPoweredCar","Stratosphere",418377.00, currentDate,currentTime));
        //receipt 1
        carDealershipInstance.receipt.add(0,new Receipt("01CstM2023", "01010700607","Leoanrd David","Ford", "1HGB41JXMN109186", date,1194000.0, "Mustang-GT"));
        //customer 1
        carDealershipInstance.customer.add(new Customer("02081900502", "John", "Andreas", 'M', "123456789", new License("L456", "L123", "2022-01-01", "2023-01-01")));
        //customer 2
        carDealershipInstance.customer.add(new Customer("12110203605", "Alice", "Randal", 'F', "987654321", new License("L789", "L456", "2021-01-01", "2022-01-01")));
        
    }

    /**
     * Test of addNewCar method, of class CarDealership.When Adding Two cars.
     * @throws java.lang.Exception
     */
    @Test
    public void testAddNewCar() throws Exception {
        CarDealership cds = new CarDealership();
        System.out.println("Adding a new car"); 
        
        // Addind two cars 
        cds.addNewCar("5TENL42N94Z436445", "Toyota", "Supra-MK4", "a 2JZ-GTE 3.0-litre twin-turbocharged straight 6 with 280 horsepower", 200.50,"Petrol", "GasPoweredCar","Stratosphere",418377.14);
        cds.addNewCar("1HGB41JXMN109186", "Audi", "E-tron-GT", "AC synchronous electric motors", 3500.50,"Petrol","ElectricPoweredCar"," Ascari Blue metallic",2065712.16);
        
        //Testing method to compare outputs
        assertEquals(2, cds.car.size());
    }
    /**
     * Test of addNewCar method, of class CarDealership.When adding a non existing or non related vehicle
     * @throws java.lang.Exception
     */
    @Test
    public void testAddNewCarNonExistingCar() throws Exception {
        try{
        CarDealership cds = new CarDealership();
        System.out.println("Adding a new car");
        // Adding a vehicle of a cartype that is not allowed
        cds.addNewCar("5TENL42N94Z436445", "Toyota", "Supra-MK4", "a 2JZ-GTE 3.0-litre twin-turbocharged straight 6 with 280 horsepower", 200.50,"Petrol","GasPoweredMotorcycle","Stratosphere",418377.14);
        //Testing method to compare outputs
        assertEquals(0, cds.car.size());
        }
        catch(Exception e){
            assertEquals("java.lang.Exception: Unsupported car type.",e.toString());
        }
    }

    /**
     * Test of sellACar method, of class CarDealership.
     */
    @Test
    public void testSellACar() {
        CarDealership cds = new CarDealership();
        System.out.println("selling a car");
        //instance to sell a car. and a create objects for the Receipt and Customer class
        cds.sellACar("01CstM2023","01010700607", "Leonard", "David", 'M', "0812883053", 
                "1HGB41JXMN109186", "999999ABC", "C1E", "01/02/2022", "01/02/2026", "Ford", "Mustang-GT");
        assertEquals(1,cds.customer.size());
        assertEquals(1, cds.receipt.size());
    }
   
     /**
     * Test of sellACar method, of class CarDealership. When making a sell to an non-existing customer
     */
    @Test
    public void testSellACarToNoCustomer() {    
        System.out.println("selling a car. when there is nno car in the dealership");
         CarDealership cdsInstance = new CarDealership();
        assertEquals(0,cdsInstance.customer.size() );
        assertEquals(0, cdsInstance.receipt.size());
    }
     /**
     * Test of sellACar method, of class CarDealership.When making a sell to an non-existing customer
     * @throws java.lang.Exception
     */
    @Test
    public void testSellACarToNoCustomer2() throws Exception {    
        System.out.println("selling a car. when there is nno car in the dealership");
        try{
        CarDealership cdsInstance = new CarDealership();
        carDealershipInstance.sellACar("01CstM2023","01010700607", "Leonard", "David", 'M', "0812883053", 
                "hbd109186", "999999ABC", "C1E", "01/02/2022", "01/02/2026", "Ford", "Mustang-GT");
        assertEquals(0,carDealershipInstance.customer.size() );
        assertEquals(0, carDealershipInstance.receipt.size());
        }catch(Exception  e){
            assertEquals("java.lang.Exception: Car not found or incorrect input! Please try again!\nIf problem persist please call your system adminstrator.",e.toString());
        }
    }
     
    /**
     * Test of returnCustomerReceipt method, of class CarDealership.
     * @throws java.lang.Exception
     */
    @Test
    public void testReturnCustomerReceipt() throws Exception {
         System.out.println("Returning/retrieving customer's receipt, when its found");
         
        Date dte = new Date();
        String receiptId ="01CstM2023";
        //GasPoweredCar("1HGB41JXMN109186","Ford","Mustang-GT","5038 cc (307 cu in) V8",2000.50,"Petrol",
        //       "Gas-Powered-Car","Dark Matter Gray Metallic",1194000.0,date)
        String expResult ="""
                                               ------------|Car Dealership Receipt|------------
                          _______________________________________________________________________________________
                                                                               Receipt ID: """+"01CstM2023"+
                          "\nClient Name: "+carDealershipInstance.receipt.get(0).getFullName()+
                          "\nID NO: "+"01010700607"+"                                   "+"Date: "+dte+"\n"+
                          "_______________________________________________________________________________________\n"+
                          " Car code                     Brand            Model                      Price"+
                          "\n_______________________________________________________________________________________\n"+
                          "1HGB41JXMN109186"+"              "+"Ford"+"            "+"Mustang-GT"+"                  "+toCurrency.format(1194000.0)+
                          "\n\n                                                                   VAT 0% $0.00\n"+
                          "_______________________________________________________________________________________\n"+
                          "                                                                   Total: "+toCurrency.format(1194000.0);
        String result = carDealershipInstance.returnCustomerReceipt(receiptId).toString();
        assertEquals(expResult, result);
   }
    /**
     * Test of returnCustomerReceipt method, of class CarDealership.When customers receipt is not found.
     * @throws java.lang.Exception
     */
    @Test
    public void testReturnCustomerReceiptNotFound() throws Exception {
        System.out.println("Returning customer's Receipt. When customers receipt is not found.");
        try{
        Date d = new Date();
        String receiptId ="04CstM2023";
        Receipt expResult = null;
        Receipt result = carDealershipInstance.returnCustomerReceipt(receiptId);
        assertEquals(expResult, result);
        }
        catch(Exception e){
            assertEquals("java.lang.Exception: Receipt not found or incorrect input! Please try again!\nIf problem persist please call your system adminstrator.",e.toString());
        }
   }

    /**
     * Test of removeCar method, of class CarDealership.
     * @throws java.lang.Exception
     */
    @Test
    public void testRemoveCar() throws Exception {
        System.out.println("Removing a car.");
        String carCode = "5YJSA1CN8D";
        int expResult = 3;
        carDealershipInstance.removeCar(carCode);
        //assertArrayEquals(expResult, result);
        assertEquals(expResult, carDealershipInstance.car.size());
    }
    /**
     * Test of removeCar method, of class CarDealership. when there is no car
     * @throws java.lang.Exception
     */
    @Test
    public void testRemoveCar2() throws Exception {
        try{
        System.out.println("Removing a car. When there there is no car.");
        CarDealership cdsInstance = new CarDealership();
        String carCode = "5YJSA1CN8D";
        int expResult = 0;
        cdsInstance.removeCar(carCode);
        //assertArrayEquals(expResult, result);
        assertEquals(expResult, cdsInstance.car.size());
        }
        catch(Exception e){
            assertEquals("java.lang.Exception: Vehicle verification number not found or incorrect ID! Please try again!\nIf the problem persists, please call your system administrator.",e.toString());
        }
    } 
    
    /**
     * Test of carsInStockNo method, of class CarDealership.
     * @throws java.lang.Exception
     */
    @Test
    public void testCarsInStockNo() throws Exception {
        System.out.println("Cars in stock number");
        int expResult = 4;
        int result = carDealershipInstance.carsInStockNo();
        assertEquals(expResult, result);
    }
     /**
     * Test of carsInStockNo method, of class CarDealership.when there is no car in stock.
     * @throws java.lang.Exception
     */
    @Test
    public void testCarsInStockNumber() throws Exception {
        System.out.println("Cars in stock number. When there are no cars in stock.");
        CarDealership cdsInstance = new CarDealership();
        int expResult = 0;
        int result = cdsInstance.carsInStockNo();
        assertEquals(expResult, result);
    }

    /**
     * Test of carWithSpecificColor method, of class CarDealership.
     * @throws java.lang.Exception
     */
    @Test
    public void testCarWithSpecificColor() throws Exception {
        System.out.println("carWithSpecificColor");
        String color = "red";
        String expResult = "Tesla Roadstar";
        String result = carDealershipInstance.carWithSpecificColor(color).getBrand()+" "+carDealershipInstance.carWithSpecificColor(color).getModel();
        assertEquals(expResult, result);
   }
     /**
     * Test of carWithSpecificColor method, of class CarDealership.When no car has the given color.
     * @throws java.lang.Exception
     */
    @Test
    public void testCarWithSpecificColorThatDoesNotExist() throws Exception {
        System.out.println("carWithSpecificColor");
        try{
        String color = "green";
        String expResult = "";
        Car result = carDealershipInstance.carWithSpecificColor(color);
        assertEquals(expResult, result);
        }
        catch(Exception e){
            assertEquals("java.lang.Exception: Car with green color not found.",e.toString());
        }
   }

    /**
     * Test of isCarInStock method, of class CarDealership.
     * @throws java.lang.Exception
     */
    @Test
    public void testIsCarInStock() throws Exception {
        System.out.println("isCarInStock");
        String brand = "Ford";
        String model = "Mustang-GT";
        boolean expResult = true;
        boolean result = carDealershipInstance.isCarInStock(brand, model);
        assertEquals(expResult, result);
   }
    /**
     * Test of isCarInStock method, of class CarDealership.when car is not in stock
     * @throws java.lang.Exception
     */
    @Test
    public void testIsCarInStock2() throws Exception {
        System.out.println("isCarInStock");
        String brand = "Volkswagen";
        String model = "Golf MK7 GTI";
        boolean expResult = false;
        boolean result = carDealershipInstance.isCarInStock(brand, model);
        assertEquals(expResult, result);
   }
  /**
     * Test of cheapestElectricCar method, of class CarDealership.
     * @throws java.lang.Exception
     */
    @Test
    public void testCheapestElectricCar() throws Exception {
        System.out.println("Cheapest electric Car");
        String expResult = "Audi E-tron-GT";
        Car result = carDealershipInstance.cheapestElectricCar();
        String results = result.getBrand()+" "+result.getModel();
        assertEquals(expResult, results);
    }
    /**
     * Test of cheapestElectricCar method, of class CarDealership.
     * @throws java.lang.Exception
     */
    @Test
    public void testCheapestElectricCar1() throws Exception {
        CarDealership cds = new CarDealership();
        try{
        System.out.println("Cheapest electric Car");
        String expResult = "Audi E-tron-GT";
        Car result = (ElectricPoweredCar) cds.cheapestElectricCar();
        String results = result.getBrand()+" "+result.getModel();
        assertEquals(expResult, results);
        }
        catch(Exception e){
            assertEquals(e.toString(), e.toString());
        }
    }
    
    /**
     * Test of mostExpensiveCar method, of class CarDealership.
     * @throws java.lang.Exception
     */
    @Test
    public void testMostExpensiveCar() throws Exception {
        System.out.println("mostExpensive Car");
        String expResult = "Tesla Roadstar";
        String result = carDealershipInstance.mostExpensiveCar().getBrand()+" "+carDealershipInstance.mostExpensiveCar().getModel();
        assertEquals(expResult, result);
    }
    
     /**
     * Test of mostExpensiveCar method, of class CarDealership.When there is no car in stock
     * @throws java.lang.Exception
     */
    @Test
    public void testMostExpensiveCar2() throws Exception {
        System.out.println("cheapestCar");
        CarDealership cds = new CarDealership();
        try{
        Car expResult = null;
        Car result = cds.mostExpensiveCar();
        String results = result.getBrand() + "" +result.getModel();
        assertEquals(expResult, result);
        }catch(Exception e){
            assertEquals(e.toString(),e.toString());
        }
    }
    
   /**
     * Test of cheapestCar method, of class CarDealership.
     * @throws java.lang.Exception
     */
    @Test
    public void testCheapestCar() throws Exception {
        System.out.println("Cheapest Car");
        String expResult = "Toyota Supra-MK4";
        String result = carDealershipInstance.cheapestCar().getBrand()+" "+carDealershipInstance.cheapestCar().getModel();
        assertEquals(expResult, result);
    }
    /**
     * Test of cheapestCar method, of class CarDealership When there is no car in stock
     * @throws java.lang.Exception
     */
    @Test
    public void testCheapestCar2() throws Exception {
        System.out.println("cheapestCar");
        CarDealership cds = new CarDealership();
        Car expResult = null;
        Car result = cds.cheapestCar();
        assertEquals(expResult, result);
    }

    /**
     * Test of gasPoweredCarCostAverage method, of class CarDealership.
     * @throws java.lang.Exception
     */
    @Test
    public void testGasPoweredCarCostAverage() throws Exception {
        System.out.println("gasPoweredCarCostAverage");
        String expResult = toCurrency.format(803987.50);
        String result = toCurrency.format(carDealershipInstance.gasPoweredCarCostAverage());
        assertEquals(expResult, result);
   }
    /**
     * Test of gasPoweredCarCostAverage method, of class CarDealership.When there is no car
     * @throws java.lang.Exception
     */
    @Test
    public void testGasPoweredCarCostAverage2() throws Exception {
        System.out.println("gasPoweredCarCostAverage");
        CarDealership cds = new CarDealership();
        String expResult = "NaN";
        String result = toCurrency.format(cds.gasPoweredCarCostAverage());
        assertEquals(expResult, result);
   }
    /**
     * Test of CarSoldInASpecificYearNo method, of class CarDealership.
     * @throws java.text.ParseException
     */
    @Test
    public void testCarSoldInASpecificYearNo() throws ParseException, Exception{
        CarDealership cds = new CarDealership();
        Date date = new Date();
        System.out.println("Cars sold in a specific year no.");
       //setting date for 3 suppossed sold cars
        //car 1
        cds.car.add(0, new GasPoweredCar("1HGB41JXMN109186","Ford","Mustang-GT","5038 cc (307 cu in) V8",2000.50,"Petrol","Gas-Powered-Car","Dark Matter Gray Metallic",1194000.0,currentDate,currentTime));
        cds.car.get(0).setDateSold(date);//car1
        //car 2
        cds.car.add(1,new ElectricPoweredCar("5YJSA1CN8D","Tesla","Roadstar","3-phase, 4-pole, induction electric motor",2000.50,"Electric-Powered-Car","Red",3400000.0,currentDate,currentTime));
         cds.car.get(1).setDateSold(date);//car2
        //car 3
        cds.car.add(2, new ElectricPoweredCar("2HGB51JXMN1086","Audi","E-tron-GT","AC synchronous electric motors",2000.50, "ElecticPoweredCar", " Ascari Blue metallic",2065712.0,currentDate,currentTime));
        cds.car.get(2).setDateSold(date);//car3q
        int specificYear = 2023;
        int expResult = 3;
        int result = cds.carSoldInASpecificYearNo(specificYear);
        assertEquals(expResult, result);
    }
     /**
     * Test of CarSoldInASpecificYearNo method, of class CarDealership. When there is no car sold.
     * @throws java.text.ParseException
     */
    @Test
    public void testCarSoldInASpecificYearNo2() throws ParseException, Exception{
        CarDealership cds = new CarDealership();
        int specificYear = 2023;
        int expResult = 0;
        int result = cds.carSoldInASpecificYearNo(specificYear);
        assertEquals(expResult, result);
    }

    /**
     * Test of moneyMadeInASpecificYear method, of class CarDealership.
     * @throws java.text.ParseException
     */
    @Test
    public void testMoneyMadeInASpecificYear()throws ParseException, Exception {
        System.out.println("Money made in a specific year.");
        CarDealership cds = new CarDealership();
        Date date = new Date();
        //setting date for 3 suppossed sold cars
        //car 1
        cds.car.add(0, new GasPoweredCar("1HGB41JXMN109186","Ford","Mustang-GT","5038 cc (307 cu in) V8",2000.50,"Petrol","Gas-Powered-Car","Dark Matter Gray Metallic",1194000.0,currentDate,currentTime));
        cds.car.get(0).setDateSold(date);//car1
        //car 2
        cds.car.add(1,new ElectricPoweredCar("5YJSA1CN8D","Tesla","Roadstar","3-phase, 4-pole, induction electric motor",2000.50,"Electric-Powered-Car","Red",3400000.0,currentDate,currentTime));
         cds.car.get(1).setDateSold(date);//car2
        //car 3
        cds.car.add(2, new ElectricPoweredCar("2HGB51JXMN1086","Audi","E-tron-GT","AC synchronous electric motors",2000.50, "ElecticPoweredCar", " Ascari Blue metallic",2065712.0,currentDate,currentTime));
        cds.car.get(2).setDateSold(date);//car3
        
        int specificYear = 2023;
        String expResult =toCurrency.format(6639707.00);
        String result = toCurrency.format(cds.moneyMadeInASpecificYear(specificYear));
        assertEquals(expResult, result);
    }
    /**
     * Test of moneyMadeInASpecificYear method, of class CarDealership. when there is no date(null).
     * @throws java.text.ParseException
     */
    @Test
     public void testMoneyMadeInASpecificYear2()throws Exception {
        try{
        System.out.println("Money made in a specific year. Where no money was made in that year");
        int specificYear = 2022;
        String expResult =toCurrency.format(0.00);
        String result = toCurrency.format(carDealershipInstance.moneyMadeInASpecificYear(specificYear));
        assertEquals(expResult, result);
        }catch(Exception e){
            assertEquals("java.lang.NullPointerException: date must not be null",e.toString());
        }
    }    /**
     * Test of priceOfGivenCar method, of class CarDealership.
     */
    @Test
    public void testPriceOfGivenCar() {
        System.out.println("Price of a given car.");
        String brand = "Ford";
        String model = "Mustang-GT";
        String expResult = toCurrency.format(1189999.00);
        String result = toCurrency.format(carDealershipInstance.priceOfGivenCar(brand, model));
        assertEquals(expResult, result);
    }
     /**
     * Test of priceOfGivenCar method, of class CarDealership.
     */
    @Test
    public void testPriceOfGivenCar2() {
        System.out.println("Price of a given car. Where no car is in the dealership");
        CarDealership cds = new CarDealership();
        String brand = "Ford";
        String model = "Mustang-GT";
        String expResult = toCurrency.format(0.00);
        String result = toCurrency.format(cds.priceOfGivenCar(brand, model));
        assertEquals(expResult, result);
    }
}
