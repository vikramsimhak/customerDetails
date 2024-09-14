package com.api.customerdetails.service;

import com.api.customerdetails.entity.CustomerAddress;
import com.api.customerdetails.entity.Customers;
import com.api.customerdetails.repository.CustomerAddressRepository;
import com.api.customerdetails.repository.CustomersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomersRepository customersRepository;

    @Autowired
    private CustomerAddressRepository customerAddressRepository;

    private final RestTemplate restTemplate = new RestTemplate();


    @Override
    public Page<Customers> getAllCustomers(PageRequest pageRequest) {
        return customersRepository.findAll(pageRequest);
    }

    @Override
    public List<Customers> getByCustomerName(String customerName, Pageable pageable) {
        return customersRepository.findByCustomerName(customerName,pageable);
    }

    @Override
    public List<Customers> getByCustomerId(String customerId) {
        return customersRepository.findByCustomerId(customerId);
    }

    @Override
    public Optional<Customers> getById(long Id) {
        return customersRepository.findById(Id);
    }


    @Transactional
    public Customers updateCustomers(Customers customers) {
        return customersRepository.save(customers);
    }

    @Transactional
    public Customers createCustomers(Customers customers) {
        // Ensure addresses are properly set to the customer
        System.out.println("customer address" +customers.getCustomerAddress());
        if(customers.getCustomerAddress() !=null ) {
            customers.setCustomerAddress(customers.getCustomerAddress());

        }

        return customersRepository.save(customers);
    }

    @Override
    public void deleteCustomers(long Id) {
        customersRepository.deleteById(Id);
    }

    public String callExternalApi() {

        return restTemplate.getForObject("https://www.google.com", String.class);
    }

}
