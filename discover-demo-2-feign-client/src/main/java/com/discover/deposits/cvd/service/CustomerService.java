package com.discover.deposits.cvd.service;

import com.discover.deposits.cvd.model.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "customerfeignClient",url="http://localhost:9091/api/v1")
public interface CustomerService {

    @GetMapping("/getCustomer/{id}")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") Long id);
}
