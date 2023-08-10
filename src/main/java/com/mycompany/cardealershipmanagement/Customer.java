package com.mycompany.cardealershipmanagement;
/**
 *
 * @author Group H
 */
public class Customer {
    private int idNumber;
    private String firstName;
    private String lastName;
    private char gender;
    private int cellphoneNo;
    private License license;
    
    public  Customer(int idNumber, String firstName, String lastName, char gender, int cellphoneNo, License license){
        this.idNumber = idNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.cellphoneNo = cellphoneNo;
        this.license = license;
    }
    public int getIdNumber(){
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
    public int getCellphoneNo(){
        return cellphoneNo;
    }
    public License getLicense(){
        return license;
    }
    }
