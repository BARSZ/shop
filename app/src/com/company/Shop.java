package com.company;

import java.util.ArrayList;
import java.util.List;

public class Shop {
    private List<Product> products;
    private List<Worker> workers;

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
    public String getName(){
        return this.name;
    }
    public List<Product> GetProducts(){
        return this.products;
    }
    public List<Worker> GetWorkers(){
        return this.workers;
    }
}
