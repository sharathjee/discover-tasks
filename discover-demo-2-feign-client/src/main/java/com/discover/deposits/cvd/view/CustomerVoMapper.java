package com.discover.deposits.cvd.view;

import com.discover.deposits.cvd.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerVoMapper {

    CustomerVoMapper INSTANCE = Mappers.getMapper(CustomerVoMapper.class);

    CustomerVo customerToCustomerVo(Customer customer);

}
