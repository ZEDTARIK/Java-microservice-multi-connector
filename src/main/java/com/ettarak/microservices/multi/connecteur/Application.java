package com.ettarak.microservices.multi.connecteur;

import com.ettarak.microservices.multi.connecteur.entities.Customer;
import com.ettarak.microservices.multi.connecteur.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerRepository customerRepository) {
		return  args -> {
			customerRepository.save(Customer.builder().name("ZOUHAIR").email("zouhair@gmail.com").build());
			customerRepository.save(Customer.builder().name("HAFSSA").email("hafssa@gmail.com").build());
			customerRepository.save(Customer.builder().name("TAGHRID").email("taghrid@gmail.com").build());
		};
	}
}
