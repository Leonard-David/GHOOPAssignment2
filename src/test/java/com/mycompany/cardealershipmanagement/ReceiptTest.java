package com.mycompany.cardealershipmanagement;

import java.util.Date;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Group H
 */
public class ReceiptTest {
    Date date = null; 
    Receipt receiptInstance = null;
    
    public ReceiptTest() {
        date = new Date();
        receiptInstance = new Receipt("01CstM2023","Leoanrd M. David", "01010700607",
                "Ford", "1HGB41JXMN109186",date,1194000.0, "Mustang-GT");
       
    }
    
    /**
     * Test of getFullName method, of class Receipt..
     */
    @Test
    public void testGetFullName() {
        System.out.println("getFullName");
        String expResult = "Leoanrd M. David";
        String result = receiptInstance.getFullName();
        assertEquals(expResult, result);
     }

    /**
     * Test of getCarBrand method, of class Receipt..
     */
    @Test
    public void testGetCarBrand() {
        System.out.println("getCarBrand");
        String expResult = "Ford";
        String result = receiptInstance.getCarBrand();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCarCode method, of class Receipt.
     */
    @Test
    public void testGetCarCode() {
        System.out.println("getCarCode");
        String expResult = "1HGB41JXMN109186";
        String result = receiptInstance.getCarCode();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDatePurchased method, of class Receipt.
     */
    @Test
    public void testGetDatePurchased() {
        System.out.println("getDatePurchased");
        Date expResult = date;
        Date result = receiptInstance.getDatePurchased();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCost method, of class Receipt.
     */
    @Test
    public void testGetCost() {
        System.out.println("getCost");
        double expResult = 1194000.0;
        double result = receiptInstance.getCost();
        assertEquals(expResult, result, 0);
    }

    /**
     * Test of getIdNumber method, of class Receipt.
     */
    @Test
    public void testGetIdNumber() {
        System.out.println("getIdNumber");
        String expResult = "01010700607";
        String result = receiptInstance.getIdNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getReceiptId method, of class Receipt.
     */
    @Test
    public void testGetReceiptId() {
        System.out.println("getReceiptId");
        String expResult = "01C12023";
        String result = receiptInstance.getReceiptId();
        assertEquals(expResult, result);
   }
   @Test
   public void testGetmodel(){
       System.out.println("getModel");
       String expResult = "Mustang-GT";
       String result = receiptInstance.getModel();
       assertEquals(expResult, result);
   }
    
}
