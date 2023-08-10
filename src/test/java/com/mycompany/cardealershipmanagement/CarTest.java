package com.mycompany.cardealershipmanagement;

import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Group H
 */
public class CarTest {
    Date date = null;
    Car carInstance = null;
    
    public CarTest() {
        date = new Date();
        carInstance = new GasPoweredCar("1HGB41JXMN109186","Ford","Mustang-GT","5038 cc (307 cu in) V8",2000.50
                ,"Gas-Powered-Car","Dark Matter Gray Metallic",1194000.0,date);
    }
    
    /**
     * Test of getCarCode method, of class Car.
     */
    @Test
    public void testGetCarCode() {
        System.out.println("getCarCode");
        String expResult = "1HGB41JXMN109186";
        String result = carInstance.getCarCode();
        assertEquals(expResult, result);
   }

    /**
     * Test of getBrand method, of class Car.
     */
    @Test
    public void testGetBrand() {
        System.out.println("getBrand");
        String expResult = "Ford";
        String result = carInstance.getBrand();
        assertEquals(expResult, result);
    }

    /**
     * Test of getModel method, of class Car.
     */
    @Test
    public void testGetModel() {
        System.out.println("getModel");
        String expResult = "Mustang-GT";
        String result = carInstance.getModel();
        assertEquals(expResult, result);
   }

    /**
     * Test of getEngineType method, of class Car.
     */
    @Test
    public void testGetEngineType() {
        System.out.println("getEngineType");
        String expResult = "5038 cc (307 cu in) V8";
        String result = carInstance.getEngineType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMileage method, of class Car.
     */
    @Test
    public void testGetMileage() {
        System.out.println("getMileage");
        double expResult = 2000.50;
        double result = carInstance.getMileage();
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of getCarType method, of class Car.
     */
    @Test
    public void testGetCarType() {
        System.out.println("getCarType");
        String expResult = "Gas-Powered-Car";
        String result = carInstance.getCarType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getColor method, of class Car.
     */
    @Test
    public void testGetColor() {
        System.out.println("getColor");
        String expResult = "Dark Matter Gray Metallic";
        String result = carInstance.getColor();
        assertEquals(expResult, result);
   }

    /**
     * Test of getCost method, of class Car.
     */
    @Test
    public void testGetCost() {
        System.out.println("getCost");
        double expResult = 1194000.0;
        double result = carInstance.getCost();
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of getdateBroughtIn method, of class Car.
     */
    @Test
    public void testGetdateBroughtIn() {
        System.out.println("getdateBroughtIn");
        Date expResult = date;
        Date result = carInstance.getdateBroughtIn();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDateSold method, of class Car.
     */
    @Test
    public void testGetDateSold() {
        System.out.println("getDateSold");
        Date expResult = date;
        Date result = carInstance.getDateSold();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDateSold method, of class Car.
     */
    @Test
    public void testSetDateSold() {
        System.out.println("setDateSold");
        Date dateSold = date;
        Date expResult = date;
        Date result = carInstance.setDateSold(dateSold);
        assertEquals(expResult, result);
   }
    
}
