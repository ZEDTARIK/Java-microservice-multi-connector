package com.ettarak.microservices.multi.connecteur.repositories;

import com.ettarak.microservices.multi.connecteur.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

