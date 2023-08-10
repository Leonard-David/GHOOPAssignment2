package com.mycompany.cardealershipmanagement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author mpula
 */
public class CustomerTest {
     Customer customerInstance = null;
     License licenseInstance = null;
    public CustomerTest() {
        licenseInstance = new License("999999ABC","C1E","01/02/2022","01/02/2026");
        // customerInstance = new Customer(01010700607, "Leonard","David", 'M',0812883053,license);
    }
    
    /**
     * Test of getIdNumber method, of class Customer.
     */
    @Test
    public void testGetIdNumber() {
        System.out.println("getIdNumber");
        int expResult = 01010700607;
        int result = customerInstance.getIdNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFirstName method, of class Customer.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        String expResult = "Leonard";
        String result = customerInstance.getFirstName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLastName method, of class Customer.
     */
    @Test
    public void testGetLastName() {
        System.out.println("getLastName");
        String expResult = "David";
        String result = customerInstance.getLastName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCellphoneNo method, of class Customer.
     */
    @Test
    public void testGetCellphoneNo() {
        System.out.println("getCellphoneNo");
        int expResult = 812883053;
        int result = customerInstance.getCellphoneNo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    @Test
    public void testGetGender(){
        System.out.println("getGender");
        char expResult = 'M';
        char result = customerInstance.getGender();
         assertEquals(expResult, result);
        //TODO review the generated test code and remove the default call to fail.
        fail("The Test code is a prototype");
    }
    /**
     * Test of getLicense method, of class Customer.
     */
    @Test
    public void testGetLicense() {
        System.out.println("getLicense");
        License expResult = licenseInstance;
        License result = customerInstance.getLicense();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
