package com.ettarak.microservices.multi.connecteur.web;

import com.ettarak.microservices.multi.connecteur.entities.Customer;
import com.ettarak.microservices.multi.connecteur.repositories.CustomerRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//injection with constructor
@AllArgsConstructor
public class CustomerRestController {
    private CustomerRepository customerRepository;

    @GetMapping("/customers")
    public List<Customer> allCustomers() {
        return  customerRepository.findAll();
    }

    @GetMapping("/customers/{id}")
    public  Customer getCustomerById(@PathVariable Long id) {
        return customerRepository.findById(id).get();
    }

    @PostMapping("/customers")
    public  Customer saveCustomer(@RequestBody Customer customer) {
        return  customerRepository.save(customer);
    }
}
