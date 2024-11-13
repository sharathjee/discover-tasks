package com.discover.deposit.discover_demo_1.model;

import com.discover.deposit.discover_demo_1.dto.CustomerDto;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    @Mapping(source="zip", target = "pincode")
    CustomerDto CustomerToCusterDto(Customer customer);

    @InheritInverseConfiguration
    Customer CustomerDtoToCustomer(CustomerDto customerDto);

}
