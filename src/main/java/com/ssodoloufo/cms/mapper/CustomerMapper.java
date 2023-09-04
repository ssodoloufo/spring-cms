package com.ssodoloufo.cms.mapper;

import com.ssodoloufo.cms.dto.CustomerDto;
import com.ssodoloufo.cms.entity.Customer;


public class CustomerMapper {
    /*
     * On prent l'entité qu'on transforme 
     * pour le renvoyer à travers son DTO
     */
    public static CustomerDto mapToCustomerDto(Customer customer) {

        return new CustomerDto(
            customer.getId(), 
            customer.getFirstName(), 
            customer.getLastName(), 
            customer.getEmail()
        );
    }

    /*
     * On prent le DTO qu'on transforme 
     * pour retrouver son entité
     */
    public static Customer mapToCustomer(CustomerDto customerDto) {

        return new Customer(
            customerDto.getId(), 
            customerDto.getFirstName(), 
            customerDto.getLastName(), 
            customerDto.getEmail()
        );
    }
}
