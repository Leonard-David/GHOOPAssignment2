package com.mycompany.cardealershipmanagement;

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
    public void purchaseACar(int customerIdNumber, String firstName, String lastName, char gender, int cellphoneNo, 
            String carIdNumber, String lIdNumber, String lCode, String lIssueDate, String lExpiryDate){
        License license;
        String fullName = firstName +" "+ lastName;
        for (int i = 0; i < carAmount; i++){
            if (carIdNumber == car[i].getCarCode()){
                license = new License(lIdNumber,lCode,lIssueDate,lExpiryDate);
                car[i].setDateSold(date);
                customer[customerAmount++] = new Customer(customerIdNumber, firstName, lastName, gender, cellphoneNo, license);
                receipt[receiptAmount++] = new Receipt(fullName, customerIdNumber, car[i].getBrand(), carIdNumber, date, car[i].getCost());
            }
        } 
    }
    public String returnCustomerReceipt(int customerIdNumber){
        String toString = "";
        for(int i = 0; i < receiptAmount; i++){
            if(customerIdNumber == receipt[i].getIdNumber()){
                toString =  """
                                                  ------------|  Car Dealership Receipt |------------
                            ***************************************************************************************
                            Name: """ + receipt[i].getFullName() +
                            "ID NO: " + receipt[i].getIdNumber() + "                                   Date:" + receipt[i].getDatePurchased() +
                            """
                            Car code                             Brand                             Price 
                            *************************************************************************************** 
                            """ + "\n"+ 
                            receipt[i].getCarCode()+"                "+receipt[i].getCarBrand()+"                "+ receipt[i].getCost()+
                            """
                                                                                        VAT 0%    N$0.00 
                            *************************************************************************************** 
                                                                                           
                                                                                        Total:    N$ """ + receipt[i].getCost();
            }
        }
        return toString;
    }
    public void  removeCar(String carCode){
        for( int i = 0; i < carAmount - 1; i++){
            if(carCode.equals(car[i].getCarCode())){
                car[i] = car[i +1];
            }
            car[i-1] = null;
        }
        carAmount--;
    }
    public int carsInStockNo(){
        int count = 0;
        for( int i = 0; i < carAmount ; i++){
            count++;
        }
        return count;
    }
    public String carsWithSpecificColor(String color){
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
        for ( int i = 0; i < carAmount; i++ ){
            if(car[0].getCost() > car[i].getCost() && "Electic-Powered-Car".equals(car[i].getCarType())){
                car[i].getCost();
                cheapElectricCar = car[i].getBrand();
            }
        }
        return cheapElectricCar;
    }
    public String mostExpensiveCar(){
        String expensiveCar = "";
        for ( int i = 0; i < carAmount; i++ ){
            if(car[0].getCost() < car[i].getCost()){
                car[i].getCost();
                expensiveCar = car[i].getBrand();
            }
        }
        return expensiveCar;
    }
    public String cheapestCar(){
        String cheapCar = "";
        for ( int i = 0; i < carAmount; i++ ){
            if(car[0].getCost() > car[i].getCost()){
                car[i].getCost();
                cheapCar = car[i].getBrand();
            }
        }
        return cheapCar;
    }
    public double gasPoweredCarCostAverage(){
        double compute = 00.00;
        int count = 0;
        for ( int i = 0; i < carAmount; i++ ){
            if("Gas-Powered-Car".equals(car[i].getCarType())){
                compute = compute + car[i].getCost();
                count++;
            }
        }
        compute = compute/count;
        return compute;
   }
    public int carsSoldInASpecificYearNo(int specificYear){
        int count = 0;
        for ( int i = 0; i < carAmount; i++ ){
            if(specificYear == car[i].getDateSold().getYear()){
                count++;
            }
        }
        return count;
    }
    public double moneyMadeInASpecificYear(int specificYear){
        double sum = 0;
        for ( int i = 0; i < carAmount; i++ ){
            if(specificYear == car[i].getDateSold().getYear()){
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
