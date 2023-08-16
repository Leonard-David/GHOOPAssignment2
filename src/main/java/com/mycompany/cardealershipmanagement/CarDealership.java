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
    SimpleDateFormat  sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
    
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
        Date date = new Date();
        if(carType.equals("GasPoweredCar")){
            car[carAmount] = new GasPoweredCar(carCode, brand, model, engineType, mileage, carType, color, cost, sdf.format(date));
        }
        else if(carType.equals("ElecticPoweredCar")){
            car[carAmount] = new ElectricPoweredCar(carCode, brand, model, engineType, mileage, carType, color, cost, sdf.format(date));
        }
        else if(!carType.equals("GasPoweredCar") || !carType.equals("ElecticPoweredCar")){
            carAmount--;
        }
        carAmount++;
    }
    public void sellACar(String receiptId, String customerIdNumber, String firstName, String lastName, char gender, String cellphoneNo, 
            String carIdNumber, String lIdNumber, String lCode, String lIssueDate, String lExpiryDate, String brand, String model){
        License license;
        Date date = new Date();
        SimpleDateFormat  sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
        String fullName = firstName +" "+ lastName;
        for (int i = 0; i < carAmount; i++){
            if (carIdNumber.equals(car[i].getCarCode())){
                license = new License(lIdNumber,lCode,lIssueDate,lExpiryDate);
                car[i].setDateSold(sdf.format(date));
                customer[customerAmount] = new Customer(customerIdNumber, firstName, lastName, gender, cellphoneNo, license);
                receipt[receiptAmount] = new Receipt(receiptId,fullName, customerIdNumber, brand, carIdNumber, sdf.format(date), car[i].getCost(), model);
            }
        } 
        customerAmount++;
        receiptAmount++;
    }
    public String returnCustomerReceipt(String receiptId){
        String toString = "Receipt not found.";
        for(int i = 0; i < receiptAmount; i++){
            if(receiptId.equals(receipt[0].getReceiptId())){
                toString =  """
                                                ------------|Car Dealership Receipt|------------
                            _______________________________________________________________________________________
                                                                 Receipt ID: """+receipt[i].getReceiptId()+
                            "\nName: " +receipt[i].getFullName()+
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
                carAmount--;
            }
        }
        
        return car;
    }
    public int carsInStockNo(){
        return carAmount;
    }
    public String carWithSpecificColor(String color){
        String carName = "Car with "+color+" colour not found";
        
        for( int i = 0; i < carAmount ; i++){
            if(color.equalsIgnoreCase(car[i].getColor())){
                carName = car[i].getBrand() +" "+ car[i].getModel();
                
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
    public ElectricPoweredCar cheapestElectricCar(){
        ElectricPoweredCar cheapElectricCar = null;
        double cheapestAmount = Double.POSITIVE_INFINITY;
        for ( int i = 0; i < carAmount; i++ ){
            if( cheapestAmount > car[i].getCost() && car[i] instanceof ElectricPoweredCar){
                cheapestAmount = car[i].getCost();
                cheapElectricCar = (ElectricPoweredCar) car[i];
            }
        }
        return cheapElectricCar;
    }
    public String mostExpensiveCar(){
        String expensiveCar = "No expensive car found.";
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
        String cheapCar = "No cheap car found.";
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
        SimpleDateFormat formator = new SimpleDateFormat("yyyy");
        int count = 0;
        for ( int i = 0; i < carAmount; i++ ){
            if(formator.format(specificYear).equals(formator.format(car[i].getDateSold()))){
                count++;
            }
        }
        return count;
    }
    public double moneyMadeInASpecificYear(int specificYear){
        SimpleDateFormat formator = new SimpleDateFormat("yyyy");
        double sum = 00.0;
        for ( int i = 0; i < carAmount; i++ ){
            if(formator.format(specificYear).equals(formator.format(car[i].getDateSold()))){
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
