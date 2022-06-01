package com.company;

public class NotEnoughMoneyException extends Exception{
    public NotEnoughMoneyException(String errorMessage){
        super(errorMessage);
    }
}
