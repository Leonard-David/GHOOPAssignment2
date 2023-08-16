package com.mycompany.cardealershipmanagement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mpula
 */
public class CustomerTest {
     Customer[] customerInstance = null;
     License licenseInstance = null;
    public CustomerTest() {
        licenseInstance = new License("999999ABC","C1E","01/02/2022","01/02/2026");
        customerInstance[0] = new Customer(01010700607, "Leonard","David", 'M',812883053,licenseInstance);
    }
    
    /**
     * Test of getIdNumber method, of class Customer...
     */
    @Test
    public void testGetIdNumber() {
        System.out.println("getIdNumber");
        int expResult = 01010700607;
        int result = customerInstance[0].getIdNumber();
        assertEquals(expResult, result);
   }

    /**
     * Test of getFirstName method, of class Customer.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        String expResult = "Leonard";
        String result = customerInstance[0].getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getLastName method, of class Customer.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        String expResult = "David";
        String result = customerInstance[0].getLastName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCellphoneNo method, of class Customer.
     */
    @Test
    public void testGetCellphoneNo() {
        System.out.println("getCellphoneNo");
        int expResult = 812883053;
        int result = customerInstance[0].getCellphoneNo();
        assertEquals(expResult, result);
     }
    @Test
    public void testGetGender(){
        System.out.println("getGender");
        char expResult = 'M';
        char result = customerInstance[0].getGender();
         assertEquals(expResult, result);
     }
    /**
     * Test of getLicense method, of class Customer.
     */
    @Test
    public void testGetLicense() {
        System.out.println("getLicense");
        License expResult = licenseInstance;
        License result = customerInstance[0].getLicense();
        assertEquals(expResult, result);
    }
    
}
