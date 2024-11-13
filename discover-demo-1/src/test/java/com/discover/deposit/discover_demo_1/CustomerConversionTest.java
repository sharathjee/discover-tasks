package com.discover.deposit.discover_demo_1;

import com.discover.deposit.discover_demo_1.dto.CustomerDto;
import com.discover.deposit.discover_demo_1.model.Customer;
import com.discover.deposit.discover_demo_1.model.CustomerMapper;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;

public class CustomerConversionTest {

    @Test
    public void shouldApplyConversions() {

        Customer customer = new Customer();
        customer.setId(10L);
        customer.setZip(500070);
        customer.setName("testName");
        customer.setEmailId("abc@xyz.com");
        CustomerDto customerDto = CustomerMapper.INSTANCE.CustomerToCusterDto(customer);
        assertThat(customerDto).isNotNull();
        assertThat(customerDto.getId()).isEqualTo(10L);
        assertThat(customerDto.getName()).isEqualTo("testName");
        assertThat(customerDto.getPincode()).isEqualTo("500070");
        assertThat(customerDto.getEmailId()).isEqualTo("abc@xyz.com");
    }
}