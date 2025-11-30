package com.example.customerlist.repository;

import com.example.customerlist.entity.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements  ICustomerRepository {
    private static List<Customer> customerList = new ArrayList<>();
    static {
        customerList.add(new Customer(true, 1, "Nguyen Van A", 8.5f));
        customerList.add(new Customer(false, 2, "Tran Thi B", 9.0f));
        customerList.add(new Customer(true, 3, "Le Van C", 7.5f));
        customerList.add(new Customer(false, 4, "Pham Thi D", 8.0f));
        customerList.add(new Customer(true, 5, "Hoang Van E", 6.5f));
    }
    @Override
    public List<Customer> getCustomers() {
        return customerList;
    }
}
