package com.example.finalprj.service;

import com.example.finalprj.model.Product;
import com.example.finalprj.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void create(Product product) {
        productRepository.save(product);
    }

    public void delete(Product product) {
        productRepository.delete(product);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public List<Product> getProductsByName(String name) {
        return productRepository.findProductsByName(name);
    }

    public List<Product> getProductsByPrice(int price) {
        return productRepository.findProductsByPrice(price);
    }
}
