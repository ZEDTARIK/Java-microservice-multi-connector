package com.ettarak.microservices.multi.connecteur.web;

import com.ettarak.microservices.multi.connecteur.entities.Customer;
import com.ettarak.microservices.multi.connecteur.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class CustomerGraphQLController {

    private CustomerRepository customerRepository;

    @QueryMapping
    public List<Customer> allCustomers() {
        return  customerRepository.findAll();
    }
    @QueryMapping
    public Customer getCustomerById(@Argument Long id) {
        return customerRepository.findById(id).get();
    }
}
