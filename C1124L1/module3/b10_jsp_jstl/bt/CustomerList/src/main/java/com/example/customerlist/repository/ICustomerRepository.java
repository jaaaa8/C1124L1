package com.example.customerlist.repository;

import com.example.customerlist.entity.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> getCustomers();
}
