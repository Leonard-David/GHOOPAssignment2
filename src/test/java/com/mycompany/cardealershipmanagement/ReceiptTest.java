package com.mycompany.cardealershipmanagement;

import java.text.SimpleDateFormat;
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
    SimpleDateFormat  sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
    public ReceiptTest() {
        date = new Date();
        receiptInstance = new Receipt("01CstM2023", "01010700607","Leoanrd David",
                "Ford", "1HGB41JXMN109186",sdf.format(date),1194000.0, "Mustang-GT");
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
        Date dte = new Date();
        System.out.println("getDatePurchased");
        String expResult = sdf.format(dte);
        String result = receiptInstance.getDatePurchased();
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
        String expResult = "01CstM2023";
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

    /**
     * Test of getModel method, of class Receipt.
     */
    @Test
    public void testGetModel() {
        System.out.println("getModel");
        String expResult = "Mustang-GT";
        String result = receiptInstance.getModel();
        assertEquals(expResult, result);
    }

    /**
     * Test of toString method, of class Receipt.
     */
    @Test
    public void testToString() {
        Date dte = new Date();
        System.out.println("toString");
        String expResult =  """
                                                ------------|Car Dealership Receipt|------------
                            _______________________________________________________________________________________
                                                                 Receipt ID: """+"01CstM2023"+
                            "\nName: " + receiptInstance.getFullName()+
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
        String result = receiptInstance.toString();
        assertEquals(expResult, result);
   }
    
}
