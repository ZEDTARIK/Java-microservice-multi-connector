package com.ettarak.microservices.multi.connecteur.web;

import com.ettarak.microservices.multi.connecteur.dto.CustomerRequest;
import com.ettarak.microservices.multi.connecteur.entities.Customer;
import com.ettarak.microservices.multi.connecteur.mapper.CustomerMapper;
import com.ettarak.microservices.multi.connecteur.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@AllArgsConstructor
public class CustomerGraphQLController {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    @QueryMapping
    public List<Customer> allCustomers() {
        return  customerRepository.findAll();
    }
    @QueryMapping
    public Customer getCustomerById(@Argument Long id) throws Exception {
        Customer customer = customerRepository.findById(id).orElse(null);
        if(customer == null) throw new Exception(String.format("Customer %s not Found", id));
        return customer;
    }
    @MutationMapping
    public  Customer saveCustomer(@Argument CustomerRequest customer) {
        Customer c = customerMapper.from(customer);
        return  customerRepository.save(c);
    }
}
