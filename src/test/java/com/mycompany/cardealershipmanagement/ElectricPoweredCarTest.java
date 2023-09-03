package com.mycompany.cardealershipmanagement;

import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Group H
 */
public class ElectricPoweredCarTest {
    
      LocalTime cTime = LocalTime.now();
      LocalDate cDate = LocalDate.now();
      DateTimeFormatter toTime = DateTimeFormatter.ofPattern("HH:mm:ss");
      DateTimeFormatter toDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
      String currenntTime = toTime.format(cTime);
      String currentDate = toDate.format(cDate);
      
    NumberFormat toCurrency = NumberFormat.getCurrencyInstance();
    ElectricPoweredCar electricPoweredCarInstance = null;
    public ElectricPoweredCarTest() {
        electricPoweredCarInstance = new ElectricPoweredCar("5YJSA1CN8D","Tesla","Roadstar","3-phase, 4-pole, induction electric motor",2000.50
                ,"Electric-Powered-Car","Red",3400000.0,currentDate,currenntTime);
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
