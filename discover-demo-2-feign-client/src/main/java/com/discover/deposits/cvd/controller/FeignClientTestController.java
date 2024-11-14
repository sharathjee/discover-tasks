package com.discover.deposits.cvd.controller;

import com.discover.deposits.cvd.service.FeignClientService;
import com.discover.deposits.cvd.view.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class FeignClientTestController {

    @Autowired
    FeignClientService customerService;
    @GetMapping("/getCustomer/{id}")
    ResponseEntity<CustomerVo> getCustomer(@PathVariable("id") Long id ){

        return ResponseEntity.ok().body(customerService.callRestEndpoint(id));
    }

}
