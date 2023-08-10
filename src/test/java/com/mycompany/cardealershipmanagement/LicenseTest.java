package com.mycompany.cardealershipmanagement;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Group H
 */
public class LicenseTest {
    
    License licenseInstance = null;
    public LicenseTest() {
        licenseInstance = new License("999999ABC","C1E","01/02/2022","01/02/2026");
    }
    
    /**
     * Test of getIdNumber method, of class License.
     */
    @Test
    public void testGetIdNumber() {
        System.out.println("getIdNumber");
        String expResult = "999999ABC";
        String result = licenseInstance.getIdNumber();
        assertEquals(expResult, result);
   }

    /**
     * Test of getCode method, of class License.
     */
    @Test
    public void testGetCode() {
        System.out.println("getCode");
        String expResult = "C1E";
        String result = licenseInstance.getCode();
        assertEquals(expResult, result);
   }

    /**
     * Test of getIssueDate method, of class License.
     */
    @Test
    public void testGetIssueDate() {
        System.out.println("getIssueDate");
        String expResult = "01/02/2022";
        String result = licenseInstance.getIssueDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getExpiryDate method, of class License.
     */
    @Test
    public void testGetExpiryDate() {
        System.out.println("getExpiryDate");
        String expResult = "01/02/2026";
        String result = licenseInstance.getExpiryDate();
        assertEquals(expResult, result);
    }
    
}
