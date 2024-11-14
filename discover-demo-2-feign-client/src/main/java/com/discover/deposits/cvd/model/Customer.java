package com.discover.deposits.cvd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    Long id;

    String name;
    String lastName;
    String location;
    String designation;
    Integer zip;

    String emailId;


}
