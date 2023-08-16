package com.mycompany.cardealershipmanagement;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mpula
 */
public class CarDealershipTest {
    CarDealership carDealershipInstance = null; 
    Date date = null;
    SimpleDateFormat  sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
    Car[] car = null;
    public CarDealershipTest() {
        date = new Date();
       carDealershipInstance = new CarDealership();
       car = new Car[2];
       carDealershipInstance.car[0] = new GasPoweredCar("1HGB41JXMN109186","Ford","Mustang-GT","5038 cc (307 cu in) V8",2000.50,
               "Gas-Powered-Car","Dark Matter Gray Metallic",1194000.0,date);
        carDealershipInstance.carAmount++;
        carDealershipInstance.car[1] = new ElectricPoweredCar("5YJSA1CN8D","Tesla","Roadstar","3-phase, 4-pole, induction electric motor",2000.50,
                "Electric-Powered-Car","Red",3400000.0,date); 
        carDealershipInstance.carAmount++;
        carDealershipInstance.car[2] = new ElectricPoweredCar("2HGB51JXMN1086","Audi","E-tron-GT","AC synchronous electric motors",2000.50,
                "ElecticPoweredCar", " Ascari Blue metallic",2065712.16,date);
         carDealershipInstance.carAmount++;
         carDealershipInstance.car[3] = new GasPoweredCar("5TENL42N94Z436445", "Toyota", "Supra-MK4", "a 2JZ-GTE 3.0-litre twin-turbocharged straight 6 with 280 horsepower", 200.50,
                "GasPoweredCar","Stratosphere",418377.14, date);
         carDealershipInstance.receipt[0] = new Receipt("01CstM2023","Leoanrd David", "01010700607",
                "Ford", "1HGB41JXMN109186",sdf.format(date),1194000.0, "Mustang-GT");
          carDealershipInstance.receiptAmount++;
    }

    /**
     * Test of addNewCar method, of class CarDealership. When Adding Two cars.
     */
    @Test
    public void testAddNewCar() {
        System.out.println("Adding a new car"); 
        // instance to add a car here i added 4 cars. We created objects for the car class of which are also objects of the child classes
        carDealershipInstance.addNewCar("5TENL42N94Z436445", "Toyota", "Supra-MK4", "a 2JZ-GTE 3.0-litre twin-turbocharged straight 6 with 280 horsepower", 200.50,
                "GasPoweredCar","Stratosphere",418377.14);
        carDealershipInstance.addNewCar("1HGB41JXMN109186", "Audi", "E-tron-GT", "AC synchronous electric motors", 3500.50,
                "ElecticPoweredCar"," Ascari Blue metallic",2065712.16);
        //Testing method to compare outputs
        assertEquals(2, carDealershipInstance.carAmount);
    }
    /**
     * Test of addNewCar method, of class CarDealership. When adding a non existing or non related vehicle
     */
    @Test
    public void testAddNewCarNonExistingCar() {
        System.out.println("Adding a new car");
        // instance to add a car here i added 4 cars. We created objects for the car class of which are also objects of the child classes
        carDealershipInstance.addNewCar("5TENL42N94Z436445", "Toyota", "Supra-MK4", "a 2JZ-GTE 3.0-litre twin-turbocharged straight 6 with 280 horsepower", 200.50,
                "GasPoweredMotorcycle","Stratosphere",418377.14);
        //Testing method to compare outputs
        assertEquals(0, carDealershipInstance.carAmount);
    }


    /**
     * Test of sellACar method, of class CarDealership.
     */
    @Test
    public void testSellACar() {
        System.out.println("selling a car");
        //instance to sell a car. and a create objects for the Receipt and Customer class
        carDealershipInstance.sellACar("01CstM2023","01010700607", "Leonard", "David", 'M', "0812883053", 
                "1HGB41JXMN109186", "999999ABC", "C1E", "01/02/2022", "01/02/2026", "Ford", "Mustang-GT");
        assertEquals(1,carDealershipInstance.customerAmount );
        assertEquals(1, carDealershipInstance.receiptAmount);
    }
    /**
     * Test of sellACar method, of class CarDealership. When selling to more than one customer
     */
    @Test
    public void testSellACarTo2people() {
        System.out.println("selling a car");
        //instance to sell a car. and a create objects for the Receipt and Customer class
        carDealershipInstance.sellACar("01CstM2023", "01010700607", "Leonard", "David", 'M', "0812883053", 
                "1HGB41JXMN109186", "999999ABC", "C1E", "01/02/2022", "01/02/2026", "Ford", "Mustang-GT");
        carDealershipInstance.sellACar("02CstM2023", "00060500709", "Hellen", "Davidson", 'F', "0812656589", 
                "1HGB41JXMN109186", "999999ABC", "B", "01/02/2023", "01/02/2027", "Tesla", "Roadstar");
        assertEquals(2,carDealershipInstance.customerAmount );
        assertEquals(2, carDealershipInstance.receiptAmount);
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
                            "\nName: " + "Leonard David"+
                            "\nID NO: " + "01010700607" + "                                   Date: " + sdf.format(dte) +"\n"+
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
        String carCode = "1HGB41JXMN109186";
        int expResult = 1;
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
        int expResult = 3;
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
        String expResult ="Audi E-tron-GT" ;
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
        String specificYear = "2023";
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
        String specificYear = "2023";
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
        String brand = "Ford";
        String model = "Mustang-GT";
        double expResult = 1193.7015746063485;
        double result = carDealershipInstance.priceOfGivenCar(brand, model);
        assertEquals(expResult, result, 0);
    }
    
}
