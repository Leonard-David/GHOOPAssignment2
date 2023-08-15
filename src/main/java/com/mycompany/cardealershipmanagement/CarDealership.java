package com.mycompany.cardealershipmanagement;

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Group H
 */
public class CarDealership {
    Car[] car;
    Customer[] customer;
    Receipt[] receipt;
    
    int carAmount;
    int customerAmount;
    int receiptAmount;
    Date date = new Date();
    
    public CarDealership(){
        car = new Car[100];
        customer = new Customer[30];
        receipt = new Receipt[100];
        carAmount = 0;
        customerAmount = 0;
        receiptAmount = 0;
    }
    public void addNewCar(String carCode, String brand, String model, String engineType, double mileage, 
            String carType, String color, double cost){
        
        if(carType.equals("Gas-Powered-Car")){
            car[carAmount] = new GasPoweredCar(carCode, brand, model, engineType, mileage, carType, color, cost, date);
        }
        else if(carType.equals("Electic-Powered-Car")){
            car[carAmount] = new ElectricPoweredCar(carCode, brand, model, engineType, mileage, carType, color, cost, date);
        }
        carAmount++;
    }
    public void sellACar(String receiptId, int customerIdNumber, String firstName, String lastName, char gender, int cellphoneNo, 
            String carIdNumber, String lIdNumber, String lCode, String lIssueDate, String lExpiryDate, String brand, String model){
        License license;
        String fullName = firstName +" "+ lastName;
        for (int i = 0; i < carAmount; i++){
            if (carIdNumber == car[i].getCarCode()){
                license = new License(lIdNumber,lCode,lIssueDate,lExpiryDate);
                car[i].setDateSold(date);
                customer[customerAmount++] = new Customer(customerIdNumber, firstName, lastName, gender, cellphoneNo, license);
                receipt[receiptAmount++] = new Receipt(receiptId,fullName, customerIdNumber, brand, carIdNumber, date, car[i].getCost(), model);
            }
        } 
    }
    public String returnCustomerReceipt(String receiptId){
        String toString = "";
        for(int i = 0; i < receiptAmount; i++){
            if(receiptId == receipt[i].getReceiptId()){
                toString =  """
                                                ------------|Car Dealership Receipt|------------
                            _______________________________________________________________________________________
                            """ +
                            "                                     Receipt ID: "+receipt[i].getReceiptId()+
                            "\nName: " + receipt[i].getFullName()+
                            "\nID NO: " + receipt[i].getIdNumber() + "                                   Date: " + receipt[i].getDatePurchased() +"\n"+
                            """
                            _______________________________________________________________________________________
                            Car code                             Brand                             Price 
                            _______________________________________________________________________________________
                            """ + ""+ 
                            receipt[i].getCarCode()+"                  "+receipt[i].getCarBrand()+" "+receipt[i].getModel()+"                        "+ receipt[i].getCost()+
                            """
                            
                            \n                                                             VAT 0%    N$0.00 
                            _______________________________________________________________________________________ 
                                                                                         Total:    N$ """ + receipt[i].getCost();
            }
        }
        return toString;
    }
    public Car[] removeCar(String carCode){
        int newCarAmount = 0;
        for( int i = 0; i < carAmount - 1; i++){
            if(!(carCode.equals(car[i].getCarCode()))){
                car[newCarAmount++] = car[i];
            }
        }
        return car;
    }
    public int carsInStockNo(){
        int count = 0;
        for( int i = 0; i < carAmount ; i++){
            count++;
        }
        return count;
    }
    public String carWithSpecificColor(String color){
        String carName = "";
        for( int i = 0; i < carAmount ; i++){
            if(car[i].getColor().equals(color)){
                carName = car[i].getBrand();
            }
        }
        return carName;
    }
    public boolean isCarInStock(String brand, String model){
        boolean carIsInStock = false;
        for ( int i = 0; i < carAmount; i++ ){
            if(brand.equals(car[i].getBrand()) && model.equals(car[i].getModel())){
                carIsInStock = true;
            }
        }
        return carIsInStock;
    }
    public String cheapestElectricCar(){
        String cheapElectricCar = "";
        double cheapestAmount = 0;
        for ( int i = 0; i < carAmount; i++ ){
            if(car[0].getCost() > car[i].getCost() && car[i] instanceof ElectricPoweredCar){
                cheapestAmount = car[i].getCost();
                cheapElectricCar = car[i].getBrand();
            }
        }
        return cheapElectricCar;
    }
    public String mostExpensiveCar(){
        String expensiveCar = "";
        double expAmount = 0;
        for ( int i = 0; i < carAmount; i++ ){
            if(car[0].getCost() < car[i].getCost()){
               expAmount = car[i].getCost();
                expensiveCar = car[i].getBrand();
            }
        }
        return expensiveCar;
    }
    public String cheapestCar(){
        String cheapCar = "";
        double cheapestAmount = 0;
        for ( int i = 0; i < carAmount; i++ ){
            if(car[0].getCost() > car[i].getCost()){
                cheapestAmount = car[i].getCost();
                cheapCar = car[i].getBrand();
            }
        }
        return cheapCar;
    }
    public double gasPoweredCarCostAverage(){
        double compute = 00.00;
        int count = 0;
        for ( int i = 0; i < carAmount; i++ ){
            if(car[i] instanceof GasPoweredCar){
                compute = compute + car[i].getCost();
                count++;
            }
        }
        compute = compute/count;
        return compute;
   }
    public int carsSoldInASpecificYearNo(int specificYear){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        int count = 0;
        for ( int i = 0; i < carAmount; i++ ){
            if(sdf.format(specificYear).equals(sdf.format(car[i].getDateSold()))){
                count++;
            }
        }
        return count;
    }
    public double moneyMadeInASpecificYear(int specificYear){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        double sum = 0;
        for ( int i = 0; i < carAmount; i++ ){
            if(sdf.format(car[i].getDateSold()).equals(sdf.format(specificYear))){
                sum = sum + car[i].getCost();
            }
        }
        return sum;
    }
    public double priceOfGivenCar(String brand, String model){
        double givenCarPrice = 00.00;
        for ( int i = 0; i < carAmount; i++ ){
            if(brand.equals(car[i].getBrand()) && model.equals(car[i].getModel())){
                givenCarPrice =car[i].getCost();
            }
        }
        return givenCarPrice;
    }
    
}
