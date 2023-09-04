package com.ssodoloufo.cms.service;

import java.util.List;

import com.ssodoloufo.cms.dto.CustomerDto;


public interface CustomerService {

    List<CustomerDto> index();
    
    CustomerDto create(CustomerDto customerDto);
    
    CustomerDto show(Long customerId);
    
    CustomerDto update(Long customerId, CustomerDto customerDto);
    
    void destroy(Long customerId);

}
