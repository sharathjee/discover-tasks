package com.discover.deposits.cvd.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerVo {

    Long id;

    String name;
    String lastName;
    String location;
    String designation;
    Integer zip;

    String emailId;

}
