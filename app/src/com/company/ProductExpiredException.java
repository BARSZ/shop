package com.company;

public class ProductExpiredException extends Exception{
    public ProductExpiredException(String errorMessage){
        super(errorMessage);
    }
}
