package com.ettarak.microservices.multi.connecteur.web;

import com.ettarak.microservices.multi.connecteur.dto.CustomerRequest;
import com.ettarak.microservices.multi.connecteur.entities.Customer;
import com.ettarak.microservices.multi.connecteur.mapper.CustomerMapper;
import com.ettarak.microservices.multi.connecteur.repositories.CustomerRepository;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
@WebService(name = "CustomerWS")
public class CustomerSoapController {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    @WebMethod
    public List<Customer> allCustomers() {
        return  customerRepository.findAll();
    }

    @WebMethod
    public  Customer getCustomerById(@WebParam(name = "id") Long id) {
        return  customerRepository.findById(id).get();
    }

    @WebMethod
    public  Customer saveCustomer(@WebParam(name = "customer") CustomerRequest customerRequest) {
    Customer customer = customerMapper.from(customerRequest);
    return  customerRepository.save(customer);
    }


}
