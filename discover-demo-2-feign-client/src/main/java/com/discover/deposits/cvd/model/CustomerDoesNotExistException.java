package com.discover.deposits.cvd.model;

public class CustomerDoesNotExistException extends RuntimeException{

    String msg;
    public CustomerDoesNotExistException(String msg){
        super(msg);
        this.msg = msg;
    }
}
