package com.mycompany.cardealershipmanagement;
import java.util.Date;
/**
 *
 * @author Group H
 */
public class Receipt {
    //creating private fields
    private String fullName;
    private String idNumber;
    private String carBrand;
    private String carCode;
    private String datePurchased;
    private double cost;
    private String receiptId;
    private String model;
    //declaring a constructor 
    public Receipt(String receiptId,String idNumber, String fullName, String carBrand, 
            String carCode, String datePurchased, double cost,String model){
        this.fullName = fullName;
        this.carBrand = carBrand;
        this.carCode = carCode;
        this.datePurchased = datePurchased;
        this.cost = cost;
        this.idNumber = idNumber;
        this.receiptId = receiptId;
        this.model = model;
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
    public String getDatePurchased(){
        return datePurchased;
    }
    public double getCost(){
        return cost;
    }
    public String getIdNumber(){
        return idNumber;
    }
    public String getModel(){
        return model;
    }
    @Override
    public String toString(){
        return """
                                                ------------|Car Dealership Receipt|------------
                            _______________________________________________________________________________________
                                                                 Receipt ID: """+receiptId+
                             "\nName: " + fullName+
                            "\nID NO: " + idNumber + "                                   Date: " + datePurchased +"\n"+
                            """
                            _______________________________________________________________________________________
                            Car code                             Brand                             Price 
                            _______________________________________________________________________________________
                            """ + ""+ 
                            carCode+"                  "+carBrand+" "+model+"                        "+ Double.toString(cost)+
                            """
                            
                            \n                                                             VAT 0%    N$0.00 
                            _______________________________________________________________________________________ 
                                                                                         Total:    N$ """ + Double.toString(cost);
    }
}