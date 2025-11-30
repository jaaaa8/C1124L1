package com.example.customerlist.service;

import com.example.customerlist.entity.Customer;
import com.example.customerlist.repository.CustomerRepository;
import com.example.customerlist.repository.ICustomerRepository;

import java.util.List;

public class CustomerService implements ICustomerService {
    private ICustomerRepository customerRepository = new CustomerRepository();
    @Override
    public List<Customer> customerList() {
        return customerRepository.getCustomers();
    }
}
