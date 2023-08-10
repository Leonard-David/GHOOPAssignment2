package com.mycompany.cardealershipmanagement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Group H
 */
public class CarDealershipTest {
     CarDealership carDealerShipInstance = null; 
    public CarDealershipTest() {
        carDealerShipInstance = new CarDealership();
    }
    
    /**
     * Test of addNewCar method, of class CarDealership.
     */
    @Test
    public void testAddNewCar() {
        System.out.println("addNewCar");
        String carCode = "1HGB41JXMN109186";
        String brand = "Ford";
        String model = "Mustang-GT";
        String engineType = "5038 cc (307 cu in) V8";
        double mileage = 2000.50;
        String carType = "Gas-Powered-Car";
        String color = "Dark Matter Gray Metallic";
        double cost = 1194000.0;
        carDealerShipInstance.addNewCar(carCode, brand, model, engineType, mileage, carType, color, cost);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of purchaseACar method, of class CarDealership.
     */
    @Test
    public void testPurchaseACar() {
        System.out.println("purchaseACar");
        int customerIdNumber = 01010700607;
        String firstName = "Leonard";
        String lastName = "David";
        char gender = 'M';
        int cellphoneNo1 = 812883053;
        String carIdNumber = "1HGB41JXMN109186";
        //"999999ABC","C1E","01/02/2022","01/02/2026"
        String lIdNumber = "999999ABC";
        String lCode = "C1E";
        String lIssueDate = "01/02/2022";
        String lExpiryDate = "01/02/2026";
        carDealerShipInstance.purchaseACar(customerIdNumber, firstName, lastName, gender, cellphoneNo1, carIdNumber, lIdNumber, lCode, lIssueDate, lExpiryDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of returnCustomerReceipt method, of class CarDealership.
     */
    @Test
    public void testReturnCustomerReceipt() {
        System.out.println("returnCustomerReceipt");
        int customerIdNumber = 01010700607;
        String expResult = "";
        String result = carDealerShipInstance.returnCustomerReceipt(customerIdNumber);
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
        String carCode = "1HGB41JXMN109186";
        carDealerShipInstance.removeCar(carCode);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of carsInStockNo method, of class CarDealership.
     */
    @Test
    public void testCarsInStockNo() {
        System.out.println("carsInStockNo");
        int expResult = 1;
        int result = carDealerShipInstance.carsInStockNo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of carsWithSpecificColor method, of class CarDealership.
     */
    @Test
    public void testCarsWithSpecificColor() {
        System.out.println("carsWithSpecificColor");
        String color = "";
        String expResult = "";
        String result = carDealerShipInstance.carsWithSpecificColor(color);
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
        String brand = "Toyota";
        String model = "Etios";
        boolean expResult = false;
        boolean result = carDealerShipInstance.isCarInStock(brand, model);
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
        String expResult = "";
        String result = carDealerShipInstance.cheapestElectricCar();
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
        String expResult = "Ford";
        String result = carDealerShipInstance.mostExpensiveCar();
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
        String expResult = "Ford";
        String result = carDealerShipInstance.cheapestCar();
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
        double expResult = 0.0;
        double result = carDealerShipInstance.gasPoweredCarCostAverage();
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
        int specificYear = 2023;
        int expResult = 1;
        int result = carDealerShipInstance.carsSoldInASpecificYearNo(specificYear);
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
        int specificYear = 2023;
        double expResult = 1194000.0;
        double result = carDealerShipInstance.moneyMadeInASpecificYear(specificYear);
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
        String brand = "Ford";
        String model = "Mustang-GT";
        double expResult = 1194000.0;
        double result = carDealerShipInstance.priceOfGivenCar(brand, model);
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
