package repository;

import entity.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "iPhone 15 Pro", 999.99, "Electronics", 10, 0.05f));
        products.add(new Product(2, "Samsung Galaxy S24", 899.50, "Electronics", 15, 0.10f));
        products.add(new Product(3, "MacBook Air M2", 1299.00, "Laptop", 8, 0.07f));
        products.add(new Product(4, "Asus ROG Strix G16", 1599.00, "Laptop", 5, 0.12f));
        products.add(new Product(5, "Sony WH-1000XM5", 349.99, "Audio", 20, 0.08f));
        products.add(new Product(6, "Logitech MX Master 3S", 119.99, "Accessories", 25, 0.15f));
        products.add(new Product(7, "Dell Ultrasharp 27\"", 499.99, "Monitor", 12, 0.09f));
        products.add(new Product(8, "Apple Watch Series 9", 399.99, "Wearable", 30, 0.05f));
        products.add(new Product(9, "Canon EOS R50", 699.99, "Camera", 7, 0.11f));
        products.add(new Product(10, "Nintendo Switch OLED", 349.00, "Gaming", 18, 0.06f));
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

    @Override
    public int size() {
        return products.size();
    }
}
