package com.api.customerdetails.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String customerName;
    private String customerMailId;

    @OneToMany(targetEntity = CustomerAddress.class,cascade = CascadeType.ALL)
    @JoinColumn(name = "customerId",referencedColumnName = "customerId")
    private List<CustomerAddress> customerAddress;


}
