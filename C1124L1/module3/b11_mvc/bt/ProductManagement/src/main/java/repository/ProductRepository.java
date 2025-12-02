package repository;

import entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private List<Product> products = new ArrayList<>();

    static {

    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public boolean delete(Product product) {
        for (Product p : products) {
            if (p.getId() == product.getId()) {
                return products.remove(p);
            }
        }
        return false;
    }

    @Override
    public boolean update(Product newProduct) {
        for (Product product : products) {
            if (product.getId() == newProduct.getId()) {
                int index = products.indexOf(product);
                products.set(index, newProduct);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(Product product) {
        return products.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }


}
