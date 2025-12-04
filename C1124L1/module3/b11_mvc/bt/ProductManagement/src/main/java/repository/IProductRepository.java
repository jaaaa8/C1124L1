package repository;

import entity.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> findAll();
    boolean delete(Product product);
    boolean update(Product newProduct);
    boolean add(Product product);
    Product findById(int id);
    int size();
}
