package service;

import entity.Product;

import java.util.List;

public interface IProductService {
    void addProduct(Product product);
    void updateProduct(Product product);
    void deleteProduct(Product product);
    List<Product> findAllProducts();
    Product findProductById(int id);
    int size();
}
