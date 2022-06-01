package com.company;

import java.util.ArrayList;
import java.util.List;

public class Client {
    private String name;
    private double money;
    private double bill;
    private List<Product> basket;
    private CashRegister cashRegister;

    public Client(String name, double money){
        this.name = name;
        this.money = money;
        this.bill = 0;
        basket = new ArrayList<Product>();
    }
    public double GetMoney(){
        return this.money;
    }
    public List<Product> GetBasket(){
        return this.basket;
    }
    public void AddProduct(Product product){
        basket.add(product);
    }
    public void RemoveProduct(Product product){
        for (Product p : this.basket)
        {
            if(p.GetName() == product.GetName()){
                basket.remove(p);
            }
        }
    }
    public void PrintBasket(){
        System.out.println("Basket for " + this.name);
        for (int i = 0; i < basket.size() ; i++) {
            System.out.println(basket.get(i).toString());
        }
    }
    public String GetName(){
        return this.name;
    }
    public double GetCurrentBill(){
        double roundOff = Math.round(this.bill * 100.0) / 100.0;
        return roundOff;
    }
    public void AddToBill(double bill){
        this.bill += bill;
    }
    public void AssignCashRegister(CashRegister cashRegister){
        this.cashRegister = cashRegister;
    }
    public CashRegister GetCashRegister(){
        return this.cashRegister;
    }
    @Override
    public String toString() {
        return "Client: " + this.name + "\nMoney: " + this.money + "\nCurrent Bill is: " + this.bill;
    }
}
