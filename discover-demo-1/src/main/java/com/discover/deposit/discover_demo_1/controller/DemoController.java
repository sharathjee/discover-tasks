package com.discover.deposit.discover_demo_1.controller;


import com.discover.deposit.discover_demo_1.model.Customer;
import com.discover.deposit.discover_demo_1.model.CustomerAlreadyExistsException;
import com.discover.deposit.discover_demo_1.model.CustomerDoesNotExistException;
import com.discover.deposit.discover_demo_1.service.CustomerService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Validated
public class DemoController {

    Logger logger = LoggerFactory.getLogger(DemoController.class);
    @Autowired
    CustomerService customerService;


    @PostMapping("/customer")
    public ResponseEntity<Customer> createCustomer( @Valid @RequestBody Customer customer) {

        logger.debug("DemoController::createCustomer");
        return ResponseEntity.ok().body(customerService.createCustomer(customer));

    }

    @GetMapping("/getCustomer/{id}")
    public ResponseEntity<Customer> getCustomer(@Valid @PathVariable Long id) {


        return ResponseEntity.ok().body(customerService.getCustomer(id));
    }

    @GetMapping("/getAllCustomers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> customers = customerService.getAllCustomers();

        return ResponseEntity.ok().body(customers);
    }

}
