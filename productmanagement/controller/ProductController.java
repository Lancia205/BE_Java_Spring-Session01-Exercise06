package com.example.productmanagement.controller;

import com.example.productmanagement.model.Product;
import com.example.productmanagement.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/api/products")
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/api/products/{id}")
    public Product updateProduct(
            @PathVariable int id,
            @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/api/products/{id}")
    public String deleteProduct(@PathVariable int id) {
        boolean deleted = productService.deleteProduct(id);

        if (deleted) {
            return "Xóa sản phẩm thành công";
        }

        return "Không tìm thấy sản phẩm";
    }
}