package com.mycompany.cardealershipmanagement;

import java.text.NumberFormat;
import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Group H
 */
public class ElectricPoweredCarTest {
    Date  date = new Date();
    NumberFormat toCurrency = NumberFormat.getCurrencyInstance();
    ElectricPoweredCar electricPoweredCarInstance = null;
    public ElectricPoweredCarTest() {
        electricPoweredCarInstance = new ElectricPoweredCar("5YJSA1CN8D","Tesla","Roadstar","3-phase, 4-pole, induction electric motor",2000.50
                ,"Electric-Powered-Car","Red",3400000.0,date);
    }
    
    /**
     * Test of getCost method, of class ElectricPoweredCar...
     */
    @Test
    public void testGetCost() {
        System.out.println("getCost");
        
        String expResult = toCurrency.format(3391998.00);
        String result = toCurrency.format(electricPoweredCarInstance.getCost());
        assertEquals(expResult, result);
    }
}
