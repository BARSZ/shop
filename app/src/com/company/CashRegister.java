package com.company;

public class CashRegister {
    private char name;
    private Worker cashier;

    public CashRegister(char name, Worker cashier){
        this.name = name;
        this.cashier = cashier;
    }
    public Worker GetCashier(){
        return this.cashier;
    }
    public void ChangeCashier(Worker cashier){
        this.cashier = cashier;
    }
    public char GetName(){
        return this.name;
    }
}
