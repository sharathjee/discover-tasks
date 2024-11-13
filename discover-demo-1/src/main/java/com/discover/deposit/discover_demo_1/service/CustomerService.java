package com.discover.deposit.discover_demo_1.service;

import com.discover.deposit.discover_demo_1.model.Customer;
import com.discover.deposit.discover_demo_1.model.CustomerAlreadyExistsException;
import com.discover.deposit.discover_demo_1.model.CustomerDoesNotExistException;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {

    Customer createCustomer(Customer customer)throws CustomerAlreadyExistsException;
    Customer getCustomer(Long Id)throws CustomerDoesNotExistException;
    List<Customer> getAllCustomers();

}
