package com.mycompany.cardealershipmanagement;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
    
    
      LocalTime cTime = LocalTime.now();
      LocalDate cDate = LocalDate.now();
      DateTimeFormatter toTime = DateTimeFormatter.ofPattern("HH:mm:ss");
      DateTimeFormatter toDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      String currentTime = toTime.format(cTime);
      String currentDate = toDate.format(cDate);
      
    public CarTest() {
        date = new Date();
        carInstance = new GasPoweredCar("1HGB41JXMN109186","Ford","Mustang-GT","5038 cc (307 cu in) V8",2000.50,
                "Petrol","Gas-Powered-Car","Dark Matter Gray Metallic",1194000.0,currentDate,currentTime);
    }
    
    /**
     * Test of getCarCode method, of class Car..
     */
    @Test
    public void testGetCarCode() {
        System.out.println("getCarCode");
        String expResult = "1HGB41JXMN109186";
        String result = carInstance.getCarCode();
        assertEquals(expResult, result);
   }

    /**
     * Test of getBrand method, of class Car..
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
        double expResult = 1189999.0;
        double result = carInstance.getCost();
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of getdateBroughtIn method, of class Car.
     */
    @Test
    public void testGetDateBroughtIn() {
        System.out.println("getdateBroughtIn");
        String expResult = currentDate;
        String result = carInstance.getDateBroughtIn();
        assertEquals(expResult, result);
    }
    /**
     * Test of testGetTimeBroughtIn method, of class Car.
     */
    @Test
    public void testGetTimeBroughtIn() {
        System.out.println("getdateBroughtIn");
        String expResult = currentTime;
        String result = carInstance.getTimeBroughtIn();
        assertEquals(expResult, result);
    }
    /**
     * Test of getDateSold method, of class Car.
     */
    @Test
    public void testGetDateSold() {
        carInstance.setDateSold(date);
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
