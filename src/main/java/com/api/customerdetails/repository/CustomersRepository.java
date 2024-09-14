package com.api.customerdetails.repository;

import com.api.customerdetails.entity.Customers;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Long> {


    List<Customers> findByCustomerName(String customerName, Pageable pageable);
    List<Customers> findByCustomerId(String customerId);

    Optional<Customers> findById(long Id);



}
