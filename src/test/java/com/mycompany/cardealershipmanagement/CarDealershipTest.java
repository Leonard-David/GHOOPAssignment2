/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.cardealershipmanagement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mpula
 */
public class CarDealershipTest {
    
    public CarDealershipTest() {
    }

    /**
     * Test of addNewCar method, of class CarDealership.
     */
    @Test
    public void testAddNewCar() {
        System.out.println("addNewCar");
        String carCode = "";
        String brand = "";
        String model = "";
        String engineType = "";
        double mileage = 0.0;
        String carType = "";
        String color = "";
        double cost = 0.0;
        CarDealership instance = new CarDealership();
        instance.addNewCar(carCode, brand, model, engineType, mileage, carType, color, cost);
        // TODO review the generated test code and remove the default call to fail.
        assertEquals(1, instance.carAmount);
        fail("The test case is a prototype.");
    }

    /**
     * Test of sellACar method, of class CarDealership.
     */
    @Test
    public void testSellACar() {
        System.out.println("sellACar");
        String receiptId = "";
        int customerIdNumber = 0;
        String firstName = "";
        String lastName = "";
        char gender = ' ';
        int cellphoneNo = 0;
        String carIdNumber = "";
        String lIdNumber = "";
        String lCode = "";
        String lIssueDate = "";
        String lExpiryDate = "";
        String brand = "";
        String model = "";
        CarDealership instance = new CarDealership();
        instance.sellACar(receiptId, customerIdNumber, firstName, lastName, gender, cellphoneNo, carIdNumber, lIdNumber, lCode, lIssueDate, lExpiryDate, brand, model);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnCustomerReceipt method, of class CarDealership.
     */
    @Test
    public void testReturnCustomerReceipt() {
        System.out.println("returnCustomerReceipt");
        String receiptId = "";
        CarDealership instance = new CarDealership();
        String expResult = "";
        String result = instance.returnCustomerReceipt(receiptId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of removeCar method, of class CarDealership.
     */
    @Test
    public void testRemoveCar() {
        System.out.println("removeCar");
        String carCode = "";
        CarDealership instance = new CarDealership();
        Car[] expResult = null;
        Car[] result = instance.removeCar(carCode);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of carsInStockNo method, of class CarDealership.
     */
    @Test
    public void testCarsInStockNo() {
        System.out.println("carsInStockNo");
        CarDealership instance = new CarDealership();
        int expResult = 0;
        int result = instance.carsInStockNo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of carWithSpecificColor method, of class CarDealership.
     */
    @Test
    public void testCarWithSpecificColor() {
        System.out.println("carWithSpecificColor");
        String color = "";
        CarDealership instance = new CarDealership();
        String expResult = "";
        String result = instance.carWithSpecificColor(color);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isCarInStock method, of class CarDealership.
     */
    @Test
    public void testIsCarInStock() {
        System.out.println("isCarInStock");
        String brand = "";
        String model = "";
        CarDealership instance = new CarDealership();
        boolean expResult = false;
        boolean result = instance.isCarInStock(brand, model);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cheapestElectricCar method, of class CarDealership.
     */
    @Test
    public void testCheapestElectricCar() {
        System.out.println("cheapestElectricCar");
        CarDealership instance = new CarDealership();
        ElectricPoweredCar expResult = null;
        ElectricPoweredCar result = instance.cheapestElectricCar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of mostExpensiveCar method, of class CarDealership.
     */
    @Test
    public void testMostExpensiveCar() {
        System.out.println("mostExpensiveCar");
        CarDealership instance = new CarDealership();
        String expResult = "";
        String result = instance.mostExpensiveCar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cheapestCar method, of class CarDealership.
     */
    @Test
    public void testCheapestCar() {
        System.out.println("cheapestCar");
        CarDealership instance = new CarDealership();
        String expResult = "";
        String result = instance.cheapestCar();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of gasPoweredCarCostAverage method, of class CarDealership.
     */
    @Test
    public void testGasPoweredCarCostAverage() {
        System.out.println("gasPoweredCarCostAverage");
        CarDealership instance = new CarDealership();
        double expResult = 0.0;
        double result = instance.gasPoweredCarCostAverage();
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
        CarDealership instance = new CarDealership();
        int expResult = 0;
        int result = instance.carsSoldInASpecificYearNo(specificYear);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of moneyMadeInASpecificYear method, of class CarDealership.
     */
    @Test
    public void testMoneyMadeInASpecificYear() {
        System.out.println("moneyMadeInASpecificYear");
        int specificYear = 0;
        CarDealership instance = new CarDealership();
        double expResult = 0.0;
        double result = instance.moneyMadeInASpecificYear(specificYear);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of priceOfGivenCar method, of class CarDealership.
     */
    @Test
    public void testPriceOfGivenCar() {
        System.out.println("priceOfGivenCar");
        String brand = "";
        String model = "";
        CarDealership instance = new CarDealership();
        double expResult = 0.0;
        double result = instance.priceOfGivenCar(brand, model);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
