package com.discover.deposits.cvd.model;

public class CustomerAlreadyExistsException extends RuntimeException{

    public CustomerAlreadyExistsException(String msg){
        super(msg);
    }
}
