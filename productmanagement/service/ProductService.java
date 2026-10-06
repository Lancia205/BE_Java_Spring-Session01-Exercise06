package com.example.productmanagement.service;

import com.example.productmanagement.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>(List.of(
            new Product(1, "Laptop", 1500),
            new Product(2, "Phone", 800),
            new Product(3, "Headphone", 100)
    ));

    public List<Product> getAllProducts() {
        return products;
    }

    public Product addProduct(Product product) {
        products.add(product);
        return product;
    }

    public Product updateProduct(int id, Product newProduct) {
        for (Product product : products) {
            if (product.getId() == id) {
                product.setName(newProduct.getName());
                product.setPrice(newProduct.getPrice());
                return product;
            }
        }
        return null;
    }

    public boolean deleteProduct(int id) {
        return products.removeIf(product -> product.getId() == id);
    }
}