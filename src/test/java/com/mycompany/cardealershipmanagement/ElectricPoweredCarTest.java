package com.mycompany.cardealershipmanagement;

import java.text.NumberFormat;
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
public class GasPoweredCarTest { 
     Date date = new Date();
     NumberFormat toCurrency = NumberFormat.getCurrencyInstance();
     GasPoweredCar gasPoweredCarInstance = null;
     
      LocalTime cTime = LocalTime.now();
      LocalDate cDate = LocalDate.now();
      DateTimeFormatter toTime = DateTimeFormatter.ofPattern("HH:mm:ss");
      DateTimeFormatter toDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      String currentTime = toTime.format(cTime);
      String currentDate = toDate.format(cDate);
      
    public GasPoweredCarTest() {
        gasPoweredCarInstance = new GasPoweredCar("1HGB41JXMN109186","Ford","Mustang-GT","5038 cc (307 cu in) V8",2000.50,
                "Petrol","Gas-Powered-Car","Dark Matter Gray Metallic",1194000.0,currentDate,currentTime);
    }
    
     /**
     * Test of getCost method, of class GasPoweredCar...
     */
    @Test
    public void testGetCost() {
        System.out.println("getCost");
      
        String expResult = toCurrency.format(1189999.00);
        String result = toCurrency.format(gasPoweredCarInstance.getCost());
        assertEquals(expResult, result);
    }

    /**
     * Test of getfuelType method, of class GasPoweredCar.
     */
    @Test
    public void testGetfuelType() {
        System.out.println("getfuelType");
        String expResult = "Petrol";
        String result = gasPoweredCarInstance.getFuelType();
        assertEquals(expResult, result);
   }
    
}
