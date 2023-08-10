package com.mycompany.cardealershipmanagement;
import java.util.Date;
/**
 *
 * @author Group H
 */
public class Receipt {
    private String fullName;
    private int idNumber;
    private String carBrand;
    private String carCode;
    private Date datePurchased;
    private double cost;
    public Receipt(String fullName,int idNumber, String carBrand, String carCode, Date datePurchased, double cost){
        this.fullName = fullName;
        this.carBrand = carBrand;
        this.carCode = carCode;
        this.datePurchased = datePurchased;
        this.cost = cost;
        this.idNumber = idNumber;
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