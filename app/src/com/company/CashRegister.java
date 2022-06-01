package com.company;

public class CashRegister {
    private String name;
    private Worker cashier;

    public CashRegister(String name, Worker cashier){
        this.name = name;
        this.cashier = cashier;
    }
    public Worker GetCashier(){
        return this.cashier;
    }
    public void ChangeCashier(Worker cashier){
        this.cashier = cashier;
    }
    public String GetName(){
        return this.name;
    }
}
