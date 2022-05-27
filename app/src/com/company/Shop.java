package com.company;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Product> products;
    private List<Worker> workers;
    private List<CashRegister> cashRegisters;
    

    private String name;
    private double foodSurplus;
    private double nonFoodSurplus;
    private int remainingDaysForDiscount;
    private double percentDiscount;

    public Shop(String name, double foodSurplus, double nonFoodSurplus, int remainingDaysForDiscount, double percentDiscount) {
        this.name = name;
        this.foodSurplus = foodSurplus;
        this.nonFoodSurplus = nonFoodSurplus;
        this.remainingDaysForDiscount = remainingDaysForDiscount;
        this.percentDiscount = percentDiscount;

        products = new ArrayList<Product>();
        workers = new ArrayList<Worker>();
        cashRegisters = new ArrayList<CashRegister>();
    }
    public Shop(){}

    public String toString(){
        return "Name: " + this.name + "\nFood Surplus " + this.foodSurplus + "\nNonFood Surplus: " + this.nonFoodSurplus + "\nRemaining Days Until Discount: " + this.remainingDaysForDiscount + "\nPercent Discount " + this.percentDiscount;
    }
    public void AddProduct(Product product) {
        products.add(product);
    }
    public void AddWorker(Worker worker) {
        workers.add(worker);
    }
    public void AddCashRegister(CashRegister cashRegister){
        this.cashRegisters.add(cashRegister);
    }
    public String getName(){
        return this.name;
    }
    public List<Product> GetProducts(){
        return this.products;
    }
    public List<Worker> GetWorkers(){
        return this.workers;
    }
    public List<CashRegister> GetCashRegisters(){
        return this.cashRegisters;
    }

    public Double CalculateProductPrice(Product product){
        double result;
        double initialPrice = product.GetPrice();
        long daysBetween = ChronoUnit.DAYS.between(LocalDate.now(), product.GetProductExpirationDate());
        if(product.GetProductCategory() == Category.FOOD){
            result = initialPrice + (initialPrice * this.foodSurplus / 100);
        } else if(product.GetProductCategory() == Category.NONFOOD){
            result = initialPrice + (initialPrice * this.nonFoodSurplus / 100);
        } else {
            result = 0;
        }
        if(daysBetween <= this.remainingDaysForDiscount){
            result += result * this.percentDiscount / 100;
        }
        return result;
    }
}
