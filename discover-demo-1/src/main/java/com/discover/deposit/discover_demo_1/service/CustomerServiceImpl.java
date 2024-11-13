package com.discover.deposit.discover_demo_1.service;

import com.discover.deposit.discover_demo_1.dao.CustomerRepository;
import com.discover.deposit.discover_demo_1.dto.CustomerDto;
import com.discover.deposit.discover_demo_1.model.Customer;
import com.discover.deposit.discover_demo_1.model.CustomerAlreadyExistsException;
import com.discover.deposit.discover_demo_1.model.CustomerDoesNotExistException;
import com.discover.deposit.discover_demo_1.model.CustomerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    CustomerRepository customerRepository;

    CustomerMapper mapper = CustomerMapper.INSTANCE;

    Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);
    @Override
    public Customer createCustomer(Customer customer)throws CustomerAlreadyExistsException{

        logger.info("CustomerServiceImpl::createCustomer");
        CustomerDto dto = mapper.CustomerToCusterDto(customer);
        customerRepository.findByEmailId(dto.getEmailId())
                .ifPresent((customer1)-> {
                    logger.error("CustomerServiceImpl::createCustomer: customer already exist with email Id {}", customer1.getEmailId());
                    throw new CustomerAlreadyExistsException("Customer already exists with email Id :"+customer1.getEmailId());

                });
        return mapper.CustomerDtoToCustomer(customerRepository.save(dto));
    }

    @Override
    public Customer getCustomer(Long Id) throws CustomerDoesNotExistException{

        logger.info("CustomerServiceImpl::getCustomer");
        Optional<CustomerDto> dto = customerRepository.findById(Id);
        return dto.map(
                (customerDto) ->
                    mapper.CustomerDtoToCustomer(
                            customerDto
                    )

        ).orElseThrow(()->{
            logger.error("CustomerServiceImpl::getCustomer: customer doesn't exist with  Id {}", Id);
            throw new CustomerDoesNotExistException("customer does not exist:"+Id);
        });


    }

    @Override
    public List<Customer> getAllCustomers() {

        return customerRepository.findAll()
                                .stream()
                                .map( mapper::CustomerDtoToCustomer )
                                .collect(Collectors.toList());
    }
}
