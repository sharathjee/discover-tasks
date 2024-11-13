package com.discover.deposit.discover_demo_1.model;

public class CustomerAlreadyExistsException extends RuntimeException{

    public CustomerAlreadyExistsException(String msg){
        super(msg);
    }
}
