package com.mycompany.cardealershipmanagement;
/**
 *
 * @author Group H
 */
public class Customer {
    // creating private attributes
    private String idNumber;
    private String firstName;
    private String lastName;
    private char gender;
    private String cellphoneNo;
    private License license;
    // constructor with parameters for the custotmer class
    public  Customer(String idNumber, String firstName, String lastName, char gender, String cellphoneNo, License license){
        this.idNumber = idNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.cellphoneNo = cellphoneNo;
        this.license = license;
    }
     //methos that returm associated valuees
    public String getIdNumber(){
        return idNumber;
    }
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public char getGender(){
        return gender;
    }
    public String getCellphoneNo(){
        return cellphoneNo;
    }
    public License getLicense(){
        return license;
    }
    }
