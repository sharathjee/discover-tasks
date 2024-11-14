package com.discover.deposits.cvd.service;

import com.discover.deposits.cvd.model.Customer;
import com.discover.deposits.cvd.view.CustomerVo;
import com.discover.deposits.cvd.view.CustomerVoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class FeignClientServiceImpl implements FeignClientService {

    @Autowired
    CustomerService customerService;
    @Override
    public CustomerVo callRestEndpoint(Long id) {

        ResponseEntity<Customer> customer = customerService.getCustomerById(id);
        return CustomerVoMapper.INSTANCE.customerToCustomerVo( customer.getBody() );
    }
}
