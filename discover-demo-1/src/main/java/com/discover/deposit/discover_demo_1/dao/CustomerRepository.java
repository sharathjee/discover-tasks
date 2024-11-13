package com.discover.deposit.discover_demo_1.dao;

import com.discover.deposit.discover_demo_1.dto.CustomerDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDto, Long> {

    Optional<CustomerDto> findByEmailId(String emailId);
}
