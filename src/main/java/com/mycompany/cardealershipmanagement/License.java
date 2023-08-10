package com.mycompany.cardealershipmanagement;
import java.util.Date;
/**
 *
 * @author Group H
 */
public class License {
    
    private String idNumber;
    private String code;
    private String issueDate;
    private String expiryDate;
    
    public License(String idNumber, String code, String issueDate, String expiryDate){
        this.idNumber = idNumber;
        this.code = code;
        this.issueDate = issueDate;
        this.expiryDate = expiryDate;
    }
    public String getIdNumber(){
        return idNumber;
    }
    public String getCode(){
        return code;
    }
    public String getIssueDate(){
        return issueDate;
    }
    public String getExpiryDate(){
        return expiryDate;
    }
}