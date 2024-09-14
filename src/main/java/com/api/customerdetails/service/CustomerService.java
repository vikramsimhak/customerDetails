package com.api.customerdetails.service;

import com.api.customerdetails.entity.CustomerAddress;
import com.api.customerdetails.entity.Customers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CustomerService {

    Page<Customers> getAllCustomers(PageRequest pageRequest);


    List<Customers> getByCustomerName(String customerName, Pageable pageable);

    List<Customers> getByCustomerId(String customerId);

    Optional<Customers> getById(long Id);

    Customers updateCustomers(Customers customers);

    Customers createCustomers(Customers customers);

     void deleteCustomers(long Id);

    public String callExternalApi();

}
