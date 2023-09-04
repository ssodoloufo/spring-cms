package com.ssodoloufo.cms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssodoloufo.cms.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
    
    
}
