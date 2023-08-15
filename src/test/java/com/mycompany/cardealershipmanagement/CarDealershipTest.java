/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.cardealershipmanagement;

import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mpula
 */
public class CarDealershipTest {
    CarDealership carDealershipInstance = null; 
    public CarDealershipTest() {
       carDealershipInstance = new CarDealership();
    }

    /**
     * Test of addNewCar method, of class CarDealership.
     */
    @Test
    public void testAddNewCar() {
        System.out.println("addNewCar");
        carDealershipInstance.addNewCar("1HGB41JXMN109186", "Ford", "Mustang-GT", "5038 cc (307 cu in) V8", 2000.50,
                "Gas-Powered-Car","Dark Matter Gray Metallic",1194000.0);
        
        carDealershipInstance.addNewCar("5YJSA1CN8D", "Tesla", "Roadstar", "5038 cc (307 cu in) V8", 2000.50,
                "Electric-Powered-Car","Red",3400000.0);
        
        carDealershipInstance.addNewCar("5TENL42N94Z436445", "Toyota", "Supra-MK4", "a 2JZ-GTE 3.0-litre twin-turbocharged straight 6 with 280 horsepower", 200.50,
                "Gas-Powered-Car","Stratosphere",418377.14);
        
        carDealershipInstance.addNewCar("1HGB41JXMN109186", "Audi", "E-tron-GT", "AC synchronous electric motors", 3500.50,
                "Electric-Powered-Car"," Ascari Blue metallic",2065712.16);
        assertEquals(4, carDealershipInstance.carAmount);
    }

    /**
     * Test of sellACar method, of class CarDealership.
     */
    @Test
    public void testSellACar() {
        System.out.println("sellACar");
        carDealershipInstance.sellACar("01CstM2023", 01010700607, "Leonard", "David", 'M', 812883053, 
                "1HGB41JXMN109186", "999999ABC", "C1E", "01/02/2022", "01/02/2026", "Ford", "Mustang-GT");
        assertEquals(1, carDealershipInstance.customerAmount);
        assertEquals(1, carDealershipInstance.receiptAmount);
    }

    /**
     * Test of returnCustomerReceipt method, of class CarDealership.
     */
    @Test
    public void testReturnCustomerReceipt() {
        Date date = new Date();
        System.out.println("returnCustomerReceipt");
        String receiptId ="01CstM2023";
        String expResult = """
                                               ------------|Car Dealership Receipt|------------
                           _______________________________________________________________________________________
                                                                Receipt ID: 01CstM2023
                           Name: Leonard David
                           ID NO: """ +01010700607+ "                                   Date: " + date +"\n"+
                            """
                            _______________________________________________________________________________________
                            Car code                             Brand                             Price 
                            _______________________________________________________________________________________
                            """ + ""+ 
                            "1HGB41JXMN109186"+"                  "+"Ford"+" "+"Mustang-GT"+"                        "+1194000.0+
                            """
                            
                            \n                                                             VAT 0%    N$0.00 
                            _______________________________________________________________________________________ 
                                                                                         Total:    N$ """ + 1194000.0;
        String result = carDealershipInstance.returnCustomerReceipt(receiptId);
        assertEquals(expResult, result);
   }

    /**
     * Test of removeCar method, of class CarDealership.
     */
    @Test
    public void testRemoveCar() {
        System.out.println("removeCar");
        String carCode = "1HGB41JXMN109186";
        Car[] expResult = null;
        Car[] result = carDealershipInstance.removeCar(carCode);
        assertArrayEquals(expResult, result);
    }

    /**
     * Test of carsInStockNo method, of class CarDealership.
     */
    @Test
    public void testCarsInStockNo() {
        System.out.println("carsInStockNo");
        int expResult = 0;
        int result = carDealershipInstance.carsInStockNo();
        assertEquals(expResult, result);
    }

    /**
     * Test of carWithSpecificColor method, of class CarDealership.
     */
    @Test
    public void testCarWithSpecificColor() {
        System.out.println("carWithSpecificColor");
        String color = "";
        String expResult = "";
        String result = carDealershipInstance.carWithSpecificColor(color);
        assertEquals(expResult, result);
   }

    /**
     * Test of isCarInStock method, of class CarDealership.
     */
    @Test
    public void testIsCarInStock() {
        System.out.println("isCarInStock");
        String brand = "";
        String model = "";
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
        ElectricPoweredCar expResult = null;
        ElectricPoweredCar result = carDealershipInstance.cheapestElectricCar();
        assertEquals(expResult, result);
   }

    /**
     * Test of mostExpensiveCar method, of class CarDealership.
     */
    @Test
    public void testMostExpensiveCar() {
        System.out.println("mostExpensiveCar");
        String expResult = "";
        String result = carDealershipInstance.mostExpensiveCar();
        assertEquals(expResult, result);
    }

    /**
     * Test of cheapestCar method, of class CarDealership.
     */
    @Test
    public void testCheapestCar() {
        System.out.println("cheapestCar");
        String expResult = "";
        String result = carDealershipInstance.cheapestCar();
        assertEquals(expResult, result);
    }

    /**
     * Test of gasPoweredCarCostAverage method, of class CarDealership.
     */
    @Test
    public void testGasPoweredCarCostAverage() {
        System.out.println("gasPoweredCarCostAverage");
        double expResult = 0.0;
        double result = carDealershipInstance.gasPoweredCarCostAverage();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of carsSoldInASpecificYearNo method, of class CarDealership.
     */
    @Test
    public void testCarsSoldInASpecificYearNo() {
        System.out.println("carsSoldInASpecificYearNo");
        int specificYear = 0;
        int expResult = 0;
        int result = carDealershipInstance.carsSoldInASpecificYearNo(specificYear);
        assertEquals(expResult, result);
    }

    /**
     * Test of moneyMadeInASpecificYear method, of class CarDealership.
     */
    @Test
    public void testMoneyMadeInASpecificYear() {
        System.out.println("moneyMadeInASpecificYear");
        int specificYear = 0;
        double expResult = 0.0;
        double result = carDealershipInstance.moneyMadeInASpecificYear(specificYear);
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of priceOfGivenCar method, of class CarDealership.
     */
    @Test
    public void testPriceOfGivenCar() {
        System.out.println("priceOfGivenCar");
        String brand = "";
        String model = "";
        double expResult = 0.0;
        double result = carDealershipInstance.priceOfGivenCar(brand, model);
        assertEquals(expResult, result, 0);
    }
    
}
