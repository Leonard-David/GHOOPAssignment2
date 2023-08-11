package com.mycompany.cardealershipmanagement;

import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Group H
 */
public class ElectricPoweredCarTest {
    Date  date = new Date();
    ElectricPoweredCar electricPoweredCarInstance = null;
    public ElectricPoweredCarTest() {
        electricPoweredCarInstance = new ElectricPoweredCar("5YJSA1CN8D","Tesla","Roadstar","3-phase, 4-pole, induction electric motor",2000.50
                ,"Electric-Powered-Car","Red",3400000.0,date);
    }
    
    /**
     * Test of getCost method, of class ElectricPoweredCar
     */
    @Test
    public void testGetCost() {
        System.out.println("getCost");
        
        double expResult = 6798.300424893777;
        double result = electricPoweredCarInstance.getCost();
        assertEquals(expResult, result, 0);
    }
}
