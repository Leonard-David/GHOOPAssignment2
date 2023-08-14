package com.mycompany.cardealershipmanagement;
import java.util.Date;
/**
 *
 * @author Group H
 */
public class Receipt {
    //creating private fields
    private String fullName;
    private int idNumber;
    private String carBrand;
    private String carCode;
    private Date datePurchased;
    private double cost;
    private String receiptId;
    //declaring a constructor 
    public Receipt(String receiptId,String fullName,int idNumber, String carBrand, String carCode, Date datePurchased, double cost){
        this.fullName = fullName;
        this.carBrand = carBrand;
        this.carCode = carCode;
        this.datePurchased = datePurchased;
        this.cost = cost;
        this.idNumber = idNumber;
        this.receiptId = receiptId;
    }
     //methos that returm associated valuees
    public String getReceiptId(){
        return receiptId;
    }
    public String getFullName(){
        return fullName;
    }
    public String getCarBrand(){
        return carBrand;
    }
    public String getCarCode(){
        return carCode;
    }
    public Date getDatePurchased(){
        return datePurchased;
    }
    public double getCost(){
        return cost;
    }
    public int getIdNumber(){
        return idNumber;
    }
}