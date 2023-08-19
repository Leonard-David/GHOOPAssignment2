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
        carDealershipInstance.car[0] = new GasPoweredCar("1HGB41JXMN109186","Ford","Mustang-GT","5038 cc (307 cu in) V8",2000.50,"Petrol",
               "Gas-Powered-Car","Dark Matter Gray Metallic",1194000.0,date);
        carDealershipInstance.carAmount++;
        carDealershipInstance.car[1] = new ElectricPoweredCar("5YJSA1CN8D","Tesla","Roadstar","3-phase, 4-pole, induction electric motor",2000.50,
                "Electric-Powered-Car","Red",3400000.0,date); 
        carDealershipInstance.carAmount++;
        carDealershipInstance.car[2] = new ElectricPoweredCar("2HGB51JXMN1086","Audi","E-tron-GT","AC synchronous electric motors",2000.50,
                "ElecticPoweredCar", " Ascari Blue metallic",2065712.0,date);
        carDealershipInstance.carAmount++;
        carDealershipInstance.car[3] = new GasPoweredCar("5TENL42N94Z436445", "Toyota", "Supra-MK4", "a 2JZ-GTE 3.0-litre twin-turbocharged straight 6 with 280 horsepower", 200.50,
                "Petrol", "GasPoweredCar","Stratosphere",418377.00, date);
        carDealershipInstance.carAmount++;
        carDealershipInstance.receipt[0] = new Receipt("01CstM2023", "01010700607","Leoanrd David",
                "Ford", "1HGB41JXMN109186", date,1194000.0, "Mustang-GT");
        carDealershipInstance.receiptAmount++;
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
        assertEquals(2, cds.carAmount);
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
        assertEquals(0, cds.carAmount);
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
        assertEquals(1,cds.customerAmount );
        assertEquals(1, cds.receiptAmount);
    }
    /**
     * Test of sellACar method, of class CarDealership. When selling to more than one customer
     */
    @Test
    public void testSellACarTo2people() {
        CarDealership cds = new CarDealership();
        System.out.println("selling a car");
        //instance to sell a car. and a create objects for the Receipt and Customer class
        cds.sellACar("01CstM2023", "01010700607", "Leonard", "David", 'M', "0812883053", 
                "1HGB41JXMN109186", "999999ABC", "C1E", "01/02/2022", "01/02/2026", "Ford", "Mustang-GT");
        cds.sellACar("02CstM2023", "00060500709", "Hellen", "Davidson", 'F', "0812656589", 
                "1HGB41JXMN109186", "999999ABC", "B", "01/02/2023", "01/02/2027", "Tesla", "Roadstar");
        assertEquals(2,cds.customerAmount );
        assertEquals(2, cds.receiptAmount);
    }
     /**
     * Test of sellACar method, of class CarDealership. When making a sell to an non-existing customer
     */
    @Test
    public void testSellACarToNoCustomer() {
        System.out.println("selling a car");
         CarDealership cdsInstance = new CarDealership();
        assertEquals(0,cdsInstance.customerAmount );
        assertEquals(0, cdsInstance.receiptAmount);
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
                            "\nName: " + carDealershipInstance.receipt[0].getFullName()+
                            "\nID NO: " + "01010700607" + "                                   Date: " + dte +"\n"+
                            """
                            _______________________________________________________________________________________
                            Car code                             Brand                             Price 
                            _______________________________________________________________________________________
                            """ + ""+ 
                            "1HGB41JXMN109186"+"                  "+"Ford"+" "+"Mustang-GT"+"                        "+ 1194000.0+
                            """
                            
                            \n                                                             VAT 0%    N$0.00 
                            _______________________________________________________________________________________ 
                                                                                         Total:    N$ """ + 1194000.0;
        String result = carDealershipInstance.returnCustomerReceipt(receiptId);
        assertEquals(expResult, result);
   }
    /**
     * Test of returnCustomerReceipt method, of class CarDealership.When customers receipt is not found.
     */
    @Test
    public void testReturnCustomerReceiptNotFound() {
        System.out.println("Returning customer's Receipt. When customers receipt is not found.");
        String receiptId ="04CstM2023";
        String expResult = "Receipt not found.";
        String result = carDealershipInstance.returnCustomerReceipt(receiptId);
        assertEquals(expResult, result);
   }

    /**
     * Test of removeCar method, of class CarDealership.
     */
    @Test
    public void testRemoveCar() {
        System.out.println("Removing a car.");
        String carCode = "";
        int expResult = 3;
        carDealershipInstance.removeCar(carCode);
        //assertArrayEquals(expResult, result);
        assertEquals(expResult, carDealershipInstance.carAmount);
    }
    
    /**
     * Test of carsInStockNo method, of class CarDealership.
     */
    @Test
    public void testCarsInStockNo() {
        System.out.println("Cars in stock number");
        int expResult = 4;
        int result = carDealershipInstance.carAmount;
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
     * Test of carWithSpecificColor method, of class CarDealership.When no car has the given color.
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
        System.out.println("cheapestElectricCar");
        String expResult = "Audi E-tron-GT";
        String result = carDealershipInstance.cheapestElectricCar();
        assertEquals(expResult, result);
    }
    
    /**
     * Test of mostExpensiveCar method, of class CarDealership.
     */
    @Test
    public void testMostExpensiveCar() {
        System.out.println("mostExpensiveCar");
        String expResult = "Tesla Roadstar";
        String result = carDealershipInstance.mostExpensiveCar();
        assertEquals(expResult, result);
    }

    /**
     * Test of cheapestCar method, of class CarDealership.
     */
    @Test
    public void testCheapestCar() {
        System.out.println("cheapestCar");
        String expResult = "Toyota Supra-MK4";
        String result = carDealershipInstance.cheapestCar();
        assertEquals(expResult, result);
    }
    /**
     * Test of cheapestCar method, of class CarDealership When there is no car in stock
     */
    @Test
    public void testCheapestCar2() {
        System.out.println("cheapestCar");
        CarDealership cds = new CarDealership();
        String expResult = "Cheap car not found.";
        String result = cds.cheapestCar();
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
        cds.car[0] = new GasPoweredCar("1HGB41JXMN109186","Ford","Mustang-GT","5038 cc (307 cu in) V8",2000.50,"Petrol",
               "Gas-Powered-Car","Dark Matter Gray Metallic",1194000.0,date);
        cds.car[0].setDateSold(date);
        cds.carAmount++;
        cds.car[1] = new ElectricPoweredCar("5YJSA1CN8D","Tesla","Roadstar","3-phase, 4-pole, induction electric motor",2000.50,
                "Electric-Powered-Car","Red",3400000.0,date); 
        cds.car[1].setDateSold(date);
        cds.carAmount++;
        cds.car[2] = new ElectricPoweredCar("2HGB51JXMN1086","Audi","E-tron-GT","AC synchronous electric motors",2000.50,
                "ElecticPoweredCar", " Ascari Blue metallic",2065712.0,date);
        cds.car[2].setDateSold(date);
        cds.carAmount++;
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
        cds.car[0] = new GasPoweredCar("1HGB41JXMN109186","Ford","Mustang-GT","5038 cc (307 cu in) V8",2000.50,"Petrol",
               "Gas-Powered-Car","Dark Matter Gray Metallic",1194000.0,date);
        cds.car[0].setDateSold(date);
        cds.carAmount++;
        cds.car[1] = new ElectricPoweredCar("5YJSA1CN8D","Tesla","Roadstar","3-phase, 4-pole, induction electric motor",2000.50,
                "Electric-Powered-Car","Red",3400000.0,date); 
        cds.car[1].setDateSold(date);
        cds.carAmount++;
        cds.car[2] = new ElectricPoweredCar("2HGB51JXMN1086","Audi","E-tron-GT","AC synchronous electric motors",2000.50,
                "ElecticPoweredCar", " Ascari Blue metallic",2065712.0,date);
        cds.car[2].setDateSold(date);
        cds.carAmount++;
        int specificYear = 2023;
        String expResult =toCurrency.format(6639707.00);
        String result = toCurrency.format(cds.moneyMadeInASpecificYear(specificYear));
        assertEquals(expResult, result);
    }
    /**
     * Test of moneyMadeInASpecificYear method, of class CarDealership. when there is no money made in that year.
     * @throws java.text.ParseException
     */
     public void testMoneyMadeInASpecificYear2()throws ParseException {
        System.out.println("Money made in a specific year.");
        CarDealership cds = new CarDealership();
        Date date = new Date();
        System.out.println("Cars sold in a specific year no.");
        cds.car[0] = new GasPoweredCar("1HGB41JXMN109186","Ford","Mustang-GT","5038 cc (307 cu in) V8",2000.50,"Petrol",
               "Gas-Powered-Car","Dark Matter Gray Metallic",1194000.0,date);
        cds.car[0].setDateSold(date);
        cds.carAmount++;
        cds.car[1] = new ElectricPoweredCar("5YJSA1CN8D","Tesla","Roadstar","3-phase, 4-pole, induction electric motor",2000.50,
                "Electric-Powered-Car","Red",3400000.0,date); 
        cds.car[1].setDateSold(date);
        cds.carAmount++;
        cds.car[2] = new ElectricPoweredCar("2HGB51JXMN1086","Audi","E-tron-GT","AC synchronous electric motors",2000.50,
                "ElecticPoweredCar", " Ascari Blue metallic",2065712.0,date);
        cds.car[2].setDateSold(date);
        cds.carAmount++;
        int specificYear = 2022;
        String expResult =toCurrency.format(6643708.00);
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
}