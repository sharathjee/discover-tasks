package com.discover.deposits.cvd.service;

import com.discover.deposits.cvd.view.CustomerVo;

public interface FeignClientService {

    public CustomerVo callRestEndpoint(Long id);
}
