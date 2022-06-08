package com.company;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public void AddProduct(Product product, Double productPrice){
        try{
            Thread.sleep(1000);
            if(product.isExpired()){
                throw new ProductExpiredException(this.name + " cannot buy " + product.GetName() + " because product is expired!");
            }
            if(this.money - productPrice >= 0){
                basket.add(product);
                this.money -= productPrice;
                product.RemoveFromStock();
                this.AddToBill(productPrice);
            }else{
                throw new NotEnoughMoneyException("You don't have enough money bro");
            }
        }catch (NotEnoughMoneyException notEnoughMoneyException){
            System.out.println(this.GetName() + " doesn't have enough money to buy " + product.GetName());
            System.out.println();
        }catch (ProductExpiredException productExpiredException) {
            System.out.println(productExpiredException.getMessage());
            System.out.println();
        }catch(InterruptedException interruptedException){
            System.out.println("Interrupted Exception");
        }
    }
    public void RemoveProduct(Product product){
        this.basket.removeIf(p -> Objects.equals(p.GetName(), product.GetName()));
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
        return "Client: " + this.name + "\nMoney: " + (Math.round(this.money * 100.0) / 100.0) + "\nCurrent Bill is: " + (Math.round(this.bill * 100.0) / 100.0);
    }
    public String GetReceiptInfo(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String result = this.GetName() + "\n--------" + "\nCashier: " + this.GetCashRegister().GetCashier().GetName() +  "\nDate and Time: " + dtf.format(now) + "\n--------\n" + "Products purchased\n";
        for (int i = 0; i < basket.size() ; i++) {
            result += basket.get(i).GetName() + "\n";
        }
        result += "Total: " + this.GetCurrentBill() + " leva";

        return result;
    }
}
