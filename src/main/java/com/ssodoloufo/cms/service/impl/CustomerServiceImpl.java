package com.ssodoloufo.cms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssodoloufo.cms.dto.CustomerDto;
import com.ssodoloufo.cms.entity.Customer;
import com.ssodoloufo.cms.exception._404;
import com.ssodoloufo.cms.mapper.CustomerMapper;
import com.ssodoloufo.cms.repository.CustomerRepository;
import com.ssodoloufo.cms.service.CustomerService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;

    @Override
    public List<CustomerDto> index() {

        // 1. Recuperer toute les resources
        List<Customer> customerList = customerRepository.findAll();

        // 2. Convertir en objet DTO la collection de données rechergée puis le rendre
        return customerList.stream().map((customer) -> CustomerMapper.mapToCustomerDto(customer)).toList();
    }
    

    @Override
    public CustomerDto create(CustomerDto customerDto) {

        // 1. Convertir la requestBody qui est un DTO en objet Java
        Customer requestData = CustomerMapper.mapToCustomer(customerDto);

        // 2. Enregister les données Java transformés en base
        Customer savedCustomer = customerRepository.save(requestData);

        // 3. Reconvertir en objet DTO les données enregistrés puis les rendre
        return CustomerMapper.mapToCustomerDto(savedCustomer);
    }


    @Override
    public CustomerDto show(Long customerId) {

        // Rechercher par ID puis mettre une erreur si indisponible
        Customer customer = customerRepository.findById(customerId)
            // _404 est une exception customiser
            .orElseThrow(() -> new _404("Customer whith ID: " + customerId + " does not exists."));

        // Convertir en objet DTO la donnée rechergée puis le rendre
        return CustomerMapper.mapToCustomerDto(customer);
    }


    @Override
    public CustomerDto update(Long customerId, CustomerDto customerDto) {
        
        // 1. Rechercher par ID puis mettre une erreur si indisponible
        Customer customer = customerRepository.findById(customerId)
            // _404 est une exception customiser
            .orElseThrow(() -> new _404("Customer whith ID: " + customerId + " does not exists."));

        // 2. S'il existe on le met à jour
        customer.setFirstName(customerDto.getFirstName());
        customer.setLastName(customerDto.getLastName());
        customer.setEmail(customerDto.getEmail());

        // 3. Enregister les modifications en base
        Customer updatedCustomer = customerRepository.save(customer);

        // 4. Convertir en objet DTO la donnée mise à jour puis le rendre
        return CustomerMapper.mapToCustomerDto(updatedCustomer);
    }


    @Override
    public void destroy(Long customerId) {
        
        // 1. Rechercher par ID puis mettre une erreur si indisponible
        customerRepository.findById(customerId).orElseThrow(() -> new _404("Customer does not exists."));

        // 2. Enregister les modifications en base
        customerRepository.deleteById(customerId);

    }
    
}
