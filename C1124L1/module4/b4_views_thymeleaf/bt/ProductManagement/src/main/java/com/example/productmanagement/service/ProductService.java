package com.example.productmanagement.service;

import com.example.productmanagement.entity.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    private static final List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Laptop Dell", 1500, "Electronics", 10));
        productList.add(new Product(2, "iPhone 15", 1200, "Electronics", 20));
        productList.add(new Product(3, "Bàn gỗ", 300, "Furniture", 5));
    }

    @Override
    public boolean addNew(Product product) {
        return productList.add(product);
    }

    @Override
    public boolean updateProduct(Product product) {
        Product oldProduct = findById(product.getProductId());
        if (oldProduct == null) {
            return false;
        }

        oldProduct.setProductName(product.getProductName());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setCategory(product.getCategory());
        oldProduct.setQuantity(product.getQuantity());

        return true;
    }

    @Override
    public boolean deleteProduct(Product product) {
        return productList.removeIf(p -> p.getProductId() == product.getProductId());
    }

    @Override
    public Product findById(int id) {
        for (Product p : productList) {
            if (p.getProductId() == id) {
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Product> findByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            return findAll();
        }
        String keyword = name.toLowerCase();
        List<Product> result = findAll();
        result.removeIf(p ->
                p.getProductName() == null ||
                        !p.getProductName().toLowerCase().contains(keyword)
        );
        return result;
    }


    @Override
    public List<Product> findAll() {
        List<Product> result = new ArrayList<>();
        for (Product p : productList) {
            result.add(new Product(
                    p.getProductId(),
                    p.getProductName(),
                    p.getPrice(),
                    p.getCategory(),
                    p.getQuantity()
            ));
        }
        return result;
    }

    @Override
    public Product detailProduct(int id) {
        return findById(id);
    }


}
