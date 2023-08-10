package com.mycompany.cardealershipmanagement;

import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Group H
 */
public class GasPoweredCarTest { 
     Date date = new Date();
     GasPoweredCar gasPoweredCarInstance = null;
    public GasPoweredCarTest() {
        gasPoweredCarInstance = new GasPoweredCar("1HGB41JXMN109186","Ford","Mustang-GT","5038 cc (307 cu in) V8",2000.50
                ,"Gas-Powered-Car","Dark Matter Gray Metallic",1194000.0,date);
    }
    
     /**
     * Test of getCost method, of class GasPoweredCar.
     */
    @Test
    public void testGetCost() {
        System.out.println("getCost");
      
        double expResult = 1194000.0;
        double result = gasPoweredCarInstance.getCost();
        assertEquals(expResult, result, 0);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
