package com.mycompany.cardealershipmanagement;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mpula
 */
public class CarDealershipTest {
    CarDealership carDealershipInstance = null; 
    
    NumberFormat toCurrency = NumberFormat.getCurrencyInstance();
    public CarDealershipTest() {
        Date date = new Date();
        carDealershipInstance = new CarDealership();
        carDealershipInstance.car.add(0, new GasPoweredCar("1HGB41JXMN109186","Ford","Mustang-GT","5038 cc (307 cu in) V8",2000.50,"Petrol",
               "Gas-Powered-Car","Dark Matter Gray Metallic",1194000.0,date));
        carDealershipInstance.car.add(1,new ElectricPoweredCar("5YJSA1CN8D","Tesla","Roadstar","3-phase, 4-pole, induction electric motor",2000.50,
                "Electric-Powered-Car","Red",3400000.0,date));
        carDealershipInstance.car.add(2, new ElectricPoweredCar("2HGB51JXMN1086","Audi","E-tron-GT","AC synchronous electric motors",2000.50,
                "ElecticPoweredCar", " Ascari Blue metallic",2065712.0,date));
        carDealershipInstance.car.add(3, new GasPoweredCar("5TENL42N94Z436445", "Toyota", "Supra-MK4", "a 2JZ-GTE 3.0-litre twin-turbocharged straight 6 with 280 horsepower", 200.50,
                "Petrol", "GasPoweredCar","Stratosphere",418377.00, date));
         carDealershipInstance.receipt.add(0,new Receipt("01CstM2023", "01010700607","Leoanrd David",
                "Ford", "4KJDSN786DS512", date,1194000.0, "Mustang-GT"));
    }

    /**
     * Test of addNewCar method, of class CarDealership. When Adding Two cars.
     */
    @Test
    public void testAddNewCar() {
        CarDealership cds = new CarDealership();
        System.out.println("Adding a new car"); 
        // instance to add a car here i added 4 cars. We created objects for the car class of which are also objects of the child classes
        cds.addNewCar("5TENL42N94Z436445", "Toyota", "Supra-MK4", "a 2JZ-GTE 3.0-litre twin-turbocharged straight 6 with 280 horsepower", 200.50,
                "Petrol", "GasPoweredCar","Stratosphere",418377.14);
        cds.addNewCar("1HGB41JXMN109186", "Audi", "E-tron-GT", "AC synchronous electric motors", 3500.50,
                "Petrol","ElecticPoweredCar"," Ascari Blue metallic",2065712.16);
        //Testing method to compare outputs
        assertEquals(2, cds.car.size());
    }
    /**
     * Test of addNewCar method, of class CarDealership. When adding a non existing or non related vehicle
     */
    @Test
    public void testAddNewCarNonExistingCar() {
        CarDealership cds = new CarDealership();
        System.out.println("Adding a new car");
        // instance to add a car here i added 4 cars. We created objects for the car class of which are also objects of the child classes
        cds.addNewCar("5TENL42N94Z436445", "Toyota", "Supra-MK4", "a 2JZ-GTE 3.0-litre twin-turbocharged straight 6 with 280 horsepower", 200.50,
                "Petrol","GasPoweredMotorcycle","Stratosphere",418377.14);
        //Testing method to compare outputs
        assertEquals(0, cds.car.size());
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
     * Test of returnCustomerReceipt method, of class CarDealership.
     */
    @Test
    public void testReturnCustomerReceipt() {
         System.out.println("Returning/retrieving customer's receipt, when its found");
         
        Date dte = new Date();
        String receiptId ="01CstM2023";
        String expResult ="""
                                                ------------|Car Dealership Receipt|------------
                            _______________________________________________________________________________________
                                                                 Receipt ID: """+"01CstM2023"+
                             "\nName: " +"Leonard David"+
                            "\nID NO: " +"01010700607"+ "                                   Date: " +dte+"\n"+
                            """
                            _______________________________________________________________________________________
                            Car code                             Brand                             Price 
                            _______________________________________________________________________________________
                            """ + 
                            "01010700607"+"                  "+"Ford"+" "+"Mustang-GT"+"                        "+1194000.0+
                            """
                            
                            \n                                                             VAT 0%    N$0.00 
                            _______________________________________________________________________________________ 
                                                                                         Total:    N$ """ +1194000.0;
        String result = carDealershipInstance.returnCustomerReceipt(receiptId).toString();
        assertEquals(expResult, result);
   }
    /**
     * Test of returnCustomerReceipt method, of class CarDealership.When customers receipt is not found.
     */
    @Test
    public void testReturnCustomerReceiptNotFound() {
        System.out.println("Returning customer's Receipt. When customers receipt is not found.");
        String receiptId ="04CstM2023";
        Receipt expResult = null;
        Receipt result = carDealershipInstance.returnCustomerReceipt(receiptId);
        assertEquals(expResult, result);
   }

    /**
     * Test of removeCar method, of class CarDealership.
     */
    @Test
    public void testRemoveCar() {
        System.out.println("Removing a car.");
        String carCode = "5YJSA1CN8D";
        int expResult = 3;
        carDealershipInstance.removeCar(carCode);
        //assertArrayEquals(expResult, result);
        assertEquals(expResult, carDealershipInstance.car.size());
    }
    /**
     * Test of removeCar method, of class CarDealership.
     */
    @Test
    public void testRemoveCar2() {
        System.out.println("Removing a car. When there there is no car.");
        CarDealership cdsInstance = new CarDealership();
        String carCode = "5YJSA1CN8D";
        int expResult = 0;
        cdsInstance.removeCar(carCode);
        //assertArrayEquals(expResult, result);
        assertEquals(expResult, cdsInstance.car.size());
    }
     /**
     * Test of indexOf method, of class CarDealership.
     */
    @Test
    public void testIndexOf(){
        String value = "5YJSA1CN8D";
        int expResult = 1;
        int result = carDealershipInstance.indexOf(value);
        assertEquals(expResult, result);
    }
     /**
     * Test of indexOf method, of class CarDealership when there is no value in the array
     */
    @Test
    public void testIndexOf2(){
        CarDealership cdsInstance = new CarDealership();
        String value = "5YJSA1CN8D";
        int expResult = 0;
        int result = cdsInstance.indexOf(value);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of carsInStockNo method, of class CarDealership.
     */
    @Test
    public void testCarsInStockNo() {
        System.out.println("Cars in stock number");
        int expResult = 4;
        int result = carDealershipInstance.car.size();
        assertEquals(expResult, result);
    }
     /**
     * Test of carsInStockNo method, of class CarDealership. when there is no car in stock.
     */
    @Test
    public void testCarsInStockNumber() {
        System.out.println("Cars in stock number. When there are no cars in stock.");
        CarDealership cdsInstance = new CarDealership();
        int expResult = 0;
        int result = cdsInstance.carsInStockNo();
        assertEquals(expResult, result);
    }

    /**
     * Test of carWithSpecificColor method, of class CarDealership.
     */
    @Test
    public void testCarWithSpecificColor() {
        System.out.println("carWithSpecificColor");
        String color = "red";
        String expResult = "Tesla Roadstar";
        String result = carDealershipInstance.carWithSpecificColor(color);
        assertEquals(expResult, result);
   }
     /**
     * Test of carWithSpecificColor method, of class CarDealership. When no car has the given color.
     */
    @Test
    public void testCarWithSpecificColorThatDoesNotExist() {
        System.out.println("carWithSpecificColor");
        String color = "green";
        String expResult = "Car with green colour not found.";
        String result = carDealershipInstance.carWithSpecificColor(color);
        assertEquals(expResult, result);
   }

    /**
     * Test of isCarInStock method, of class CarDealership.
     */
    @Test
    public void testIsCarInStock() {
        System.out.println("isCarInStock");
        String brand = "Ford";
        String model = "Mustang-GT";
        boolean expResult = true;
        boolean result = carDealershipInstance.isCarInStock(brand, model);
        assertEquals(expResult, result);
   }
    /**
     * Test of isCarInStock method, of class CarDealership. when car is not in stock
     */
    @Test
    public void testIsCarInStock2() {
        System.out.println("isCarInStock");
        String brand = "Volkswagen";
        String model = "Golf MK7 GTI";
        boolean expResult = false;
        boolean result = carDealershipInstance.isCarInStock(brand, model);
        assertEquals(expResult, result);
   }
 /**
     * Test of cheapestElectricCar method, of class CarDealership.
     */
    @Test
    public void testCheapestElectricCar() {
        System.out.println("Cheapest electric Car");
        String expResult = "Audi E-tron-GT";
        String result = carDealershipInstance.cheapestElectricCar().getBrand() +" "+carDealershipInstance.cheapestElectricCar().getModel();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of mostExpensiveCar method, of class CarDealership.
     */
    @Test
    public void testMostExpensiveCar() {
        System.out.println("mostExpensive Car");
        String expResult = "Tesla Roadstar";
        String result = carDealershipInstance.mostExpensiveCar().getBrand()+" "+carDealershipInstance.mostExpensiveCar().getModel();
        assertEquals(expResult, result);
    }
    
     /**
     * Test of mostExpensiveCar method, of class CarDealership. When there is no car in stock
     */
    @Test
    public void testMostExpensiveCar2() {
        System.out.println("cheapestCar");
        CarDealership cds = new CarDealership();
        Car expResult = null;
        Car result = cds.mostExpensiveCar();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of cheapestCar method, of class CarDealership.
     */
    @Test
    public void testCheapestCar() {
        System.out.println("Cheapest Car");
        String expResult = "Toyota Supra-MK4";
        String result = carDealershipInstance.cheapestCar().getBrand()+" "+carDealershipInstance.cheapestCar().getModel();
        assertEquals(expResult, result);
    }
    /**
     * Test of cheapestCar method, of class CarDealership When there is no car in stock
     */
    @Test
    public void testCheapestCar2() {
        System.out.println("cheapestCar");
        CarDealership cds = new CarDealership();
        Car expResult = null;
        Car result = cds.cheapestCar();
        assertEquals(expResult, result);
    }

    /**
     * Test of gasPoweredCarCostAverage method, of class CarDealership.
     */
    @Test
    public void testGasPoweredCarCostAverage() {
        System.out.println("gasPoweredCarCostAverage");
        String expResult = toCurrency.format(803987.50);
        String result = toCurrency.format(carDealershipInstance.gasPoweredCarCostAverage());
        assertEquals(expResult, result);
   }
    /**
     * Test of gasPoweredCarCostAverage method, of class CarDealership. When there is no car
     */
    @Test
    public void testGasPoweredCarCostAverage2() {
        System.out.println("gasPoweredCarCostAverage");
        CarDealership cds = new CarDealership();
        String expResult = "NaN";
        String result = toCurrency.format(cds.gasPoweredCarCostAverage());
        assertEquals(expResult, result);
   }

    /**
     * Test of carsSoldInASpecificYearNo method, of class CarDealership.
     * @throws java.text.ParseException
     */
    @Test
    public void testCarsSoldInASpecificYearNo() throws ParseException{
        CarDealership cds = new CarDealership();
        Date date = new Date();
        System.out.println("Cars sold in a specific year no.");
        cds.car.add(0,new GasPoweredCar("1HGB41JXMN109186","Ford","Mustang-GT","5038 cc (307 cu in) V8",2000.50,"Petrol",
               "Gas-Powered-Car","Dark Matter Gray Metallic",1194000.0,date));
        cds.car.get(0).setDateSold(date);
        cds.car.add(1,  new ElectricPoweredCar("5YJSA1CN8D","Tesla","Roadstar","3-phase, 4-pole, induction electric motor",2000.50,
               "Electric-Powered-Car","Red",3400000.0,date));
        cds.car.get(1).setDateSold(date);
        cds.car.add(2,  new ElectricPoweredCar("2HGB51JXMN1086","Audi","E-tron-GT","AC synchronous electric motors",2000.50,
                "ElecticPoweredCar", " Ascari Blue metallic",2065712.0,date));
        cds.car.get(2).setDateSold(date);
        int specificYear = 2023;
        int expResult = 3;
        int result = cds.carSoldInASpecificYearNo(specificYear);
        assertEquals(expResult, result);
    }
     /**
     * Test of carsSoldInASpecificYearNo method, of class CarDealership. When there is no car sold.
     * @throws java.text.ParseException
     */
    @Test
    public void testCarsSoldInASpecificYearNo2() throws ParseException{
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
    public void testMoneyMadeInASpecificYear()throws ParseException {
        System.out.println("Money made in a specific year.");
        CarDealership cds = new CarDealership();
        Date date = new Date();
        System.out.println("Cars sold in a specific year no.");
        cds.car.add(0,new GasPoweredCar("1HGB41JXMN109186","Ford","Mustang-GT","5038 cc (307 cu in) V8",2000.50,"Petrol",
               "Gas-Powered-Car","Dark Matter Gray Metallic",1194000.0,date));
        cds.car.get(0).setDateSold(date);
        cds.car.add(1,  new ElectricPoweredCar("5YJSA1CN8D","Tesla","Roadstar","3-phase, 4-pole, induction electric motor",2000.50,
               "Electric-Powered-Car","Red",3400000.0,date));
        cds.car.get(1).setDateSold(date);
        cds.car.add(2,  new ElectricPoweredCar("2HGB51JXMN1086","Audi","E-tron-GT","AC synchronous electric motors",2000.50,
                "ElecticPoweredCar", " Ascari Blue metallic",2065712.0,date));
        cds.car.get(2).setDateSold(date);
        int specificYear = 2023;
        String expResult =toCurrency.format(6639707.00);
        String result = toCurrency.format(cds.moneyMadeInASpecificYear(specificYear));
        assertEquals(expResult, result);
    }
    /**
     * Test of moneyMadeInASpecificYear method, of class CarDealership. when there is no money made in that year.
     * @throws java.text.ParseException
     */
    @Test
     public void testMoneyMadeInASpecificYear2()throws ParseException {
        System.out.println("Money made in a specific year. Where no money was made in that year");
        CarDealership cds = new CarDealership();
        Date date = new Date();
        cds.car.add(0,new GasPoweredCar("1HGB41JXMN109186","Ford","Mustang-GT","5038 cc (307 cu in) V8",2000.50,"Petrol",
               "Gas-Powered-Car","Dark Matter Gray Metallic",1194000.0,date));
        cds.car.get(0).setDateSold(date);
        cds.car.add(1,  new ElectricPoweredCar("5YJSA1CN8D","Tesla","Roadstar","3-phase, 4-pole, induction electric motor",2000.50,
               "Electric-Powered-Car","Red",3400000.0,date));
        cds.car.get(1).setDateSold(date);
        cds.car.add(2,  new ElectricPoweredCar("2HGB51JXMN1086","Audi","E-tron-GT","AC synchronous electric motors",2000.50,
                "ElecticPoweredCar", " Ascari Blue metallic",2065712.0,date));
        cds.car.get(2).setDateSold(date);
        int specificYear = 2022;
        String expResult =toCurrency.format(0.00);
        String result = toCurrency.format(cds.moneyMadeInASpecificYear(specificYear));
        assertEquals(expResult, result);
    }
    /**
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