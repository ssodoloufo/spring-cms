package com.ssodoloufo.cms.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssodoloufo.cms.dto.CustomerDto;
import com.ssodoloufo.cms.service.CustomerService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {
    
    private CustomerService customerService;

    // Liste des customers
    @GetMapping
    public ResponseEntity<CustomerDto> getAllCustomers() {
        
        List<CustomerDto> customers = customerService.index();

        return new ResponseEntity(customers, HttpStatus.OK);
    }


    // Ajout d'un customer
    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto request) {
        
        CustomerDto customer = customerService.create(request);

        return new ResponseEntity<CustomerDto>(customer, HttpStatus.CREATED);
    }

    
    // Detail d'un customer
    @GetMapping("{id}")
    public ResponseEntity<CustomerDto> getCustomerById(@PathVariable("id") Long customerId) {
        
        CustomerDto customer = customerService.show(customerId);

        return new ResponseEntity<CustomerDto>(customer, HttpStatus.OK);
    }

    
    // Mettre à jour un customer
    @PutMapping("{id}")
    public ResponseEntity<CustomerDto> updateCustomer(
        @PathVariable("id") Long customerId,
        @RequestBody CustomerDto request
        ) {
        
        CustomerDto customer = customerService.update(customerId, request);

        return new ResponseEntity<CustomerDto>(customer, HttpStatus.OK);
    }

    
    // Supprier un customer
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("id") Long customerId) {
        
        customerService.destroy(customerId);

        return new ResponseEntity("Customer is deleted successfully!.", HttpStatus.OK);
    }

}
