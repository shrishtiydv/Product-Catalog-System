package com.kiet.product_catalog.service;

import com.kiet.product_catalog.model.Product;
import com.kiet.product_catalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public Optional<Product> getProductById(Long id) {
        return repository.findById(id);
    }

    public List<Product> getProductsByCategory(String category) {
        return repository.findByCategory(category);
    }

    public void deleteProductById(Long id) {
        repository.deleteById(id);
    }
}