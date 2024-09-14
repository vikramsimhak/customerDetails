package com.api.customerDetails;

import com.api.customerdetails.entity.Customers;
import com.api.customerdetails.repository.CustomersRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class CustomerDetailsApplicationTests {

	@Autowired
	private CustomersRepository customerRepository;

	@Test
	public void testCreateCustomer() {
		Customers customer = new Customers();
		customer.setCustomerName("Test");
		customer.setCustomerMailId("test@gmail.com");
		Customers savedCustomer = customerRepository.save(customer);
		assertNotNull(savedCustomer);
	}



}
