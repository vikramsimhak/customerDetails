package com.api.customerdetails.controller;

import com.api.customerdetails.entity.CustomerAddress;
import com.api.customerdetails.entity.Customers;
import com.api.customerdetails.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    CustomerService customerService;

    @GetMapping("/customers")
    Page<Customers> getAllCustomers(
            @RequestParam Optional<Integer> page
    ) {
        System.out.println("call in controller");


        return customerService.getAllCustomers(PageRequest.of(page.orElse(0),5 ));
    }
   /* @GetMapping("/customers/{customerId}")
    public ResponseEntity<Optional<Customers>> getByCustomerId(@PathVariable("customerId") String  customerId) {

        Optional<Customers> customersData = customerService.getByCustomerId(customerId);
        if (customersData!=null && !customersData.isEmpty()) {

            return new ResponseEntity<>(customersData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/

   /* @GetMapping("/customers/{customerId}")
    public ResponseEntity<List<Customers>> getByCustomerId(@PathVariable("customerId") String customerId) {
      List<Customers> customersData = customerService.getByCustomerId(customerId);
        if (customersData!=null && !customersData.isEmpty()) {

            return new ResponseEntity<>(customersData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }*/



    @GetMapping("/customers/customerName/{customerName}")
    public ResponseEntity<List<Customers>> getCustomerByCustomerName(@PathVariable("customerName") String customerName, @RequestParam Optional<Integer> page) {
        Pageable PageWithFiveElements = PageRequest.of(page.orElse(0),5 );
        List<Customers> transactionData = customerService.getByCustomerName(customerName,PageWithFiveElements);
        if (transactionData!=null && !transactionData.isEmpty()) {

            return new ResponseEntity<>(transactionData, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }





    @GetMapping("/customers/{customerId}")
    public ResponseEntity<Optional<Customers>> getById(@PathVariable("customerId") long customerId) {
        Optional<Customers> customersData = customerService.getById(customerId);
        if (customersData!=null && !customersData.isEmpty()) {
           return new ResponseEntity<>(customersData, HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/customers/{customerId}")
    public ResponseEntity<Customers> updateCustomer(@PathVariable("customerId") long Id, @RequestBody Customers customers) {
        Optional<Customers> customersData = customerService.getById(Id);

        if (customersData.isPresent()) {
            Customers customers1 = customersData.get();
            customers1.setCustomerName(customers.getCustomerName() !=null ? customers.getCustomerName() : customers1.getCustomerName());
            customers1.setCustomerMailId(customers.getCustomerMailId() !=null ?customers.getCustomerMailId() : customers1.getCustomerMailId());
            return new ResponseEntity<>(customerService.updateCustomers(customers1), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/customers")
    public ResponseEntity<Customers> createCustomer(@RequestBody Customers customers) {
        return new ResponseEntity<>(customerService.createCustomers(customers), HttpStatus.OK);

    }

    @DeleteMapping("/customers/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long customerId) {
        customerService.deleteCustomers(customerId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/external")
    public String callExternalApi() {
        return customerService.callExternalApi();
    }
}
