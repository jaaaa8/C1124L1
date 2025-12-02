package com.example.customermanagement.service;

import com.example.customermanagement.entity.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void save(Customer customer);

    Customer findById(int id);

    boolean update(int id, Customer customer);

    boolean remove(int id);
}
