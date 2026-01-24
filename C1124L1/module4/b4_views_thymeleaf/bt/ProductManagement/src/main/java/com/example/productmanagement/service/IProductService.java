package com.example.productmanagement.service;

import com.example.productmanagement.entity.Product;

import java.util.List;

public interface IProductService {
    boolean addNew(Product product);
    boolean updateProduct(Product product);
    boolean deleteProduct(Product product);
    Product findById(int id);
    List<Product> findByName(String name);
    List<Product> findAll();
    Product detailProduct(int id);
}
