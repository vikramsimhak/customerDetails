package com.api.customerdetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.api.customerdetails.repository.CustomersRepository;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class CustomerDetailsApplication {


	public static void main(String[] args) {
		SpringApplication.run(com.api.customerdetails.CustomerDetailsApplication.class, args);
	}
	@Autowired
	CustomersRepository customersRepository;


}
