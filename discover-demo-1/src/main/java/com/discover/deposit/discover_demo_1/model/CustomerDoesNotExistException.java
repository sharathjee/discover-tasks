package com.discover.deposit.discover_demo_1.model;

public class CustomerDoesNotExistException extends RuntimeException{

    String msg;
    public CustomerDoesNotExistException(String msg){
        super(msg);
        this.msg = msg;
    }
}
