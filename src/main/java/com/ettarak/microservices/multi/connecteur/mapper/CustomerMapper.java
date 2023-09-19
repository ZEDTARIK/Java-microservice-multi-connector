package com.ettarak.microservices.multi.connecteur.mapper;

import com.ettarak.microservices.multi.connecteur.dto.CustomerRequest;
import com.ettarak.microservices.multi.connecteur.entities.Customer;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {
    public Customer from(CustomerRequest customerRequest) {
       /* *
        Customer customer = new Customer();
        customer.setName(customerRequest.name());
        customer.setEmail(customerRequest.email());
        return customer;
        */

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(customerRequest, Customer.class);
    }
}
