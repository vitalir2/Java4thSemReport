package com.example.finalprj.controller;

import com.example.finalprj.model.Product;
import com.example.finalprj.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @PostMapping
    public void createProduct(@RequestBody Product product) {
        productRepository.save(product);
    }

    @DeleteMapping
    public void deleteProduct(@RequestBody Product product) {
        productRepository.delete(product);
    }
}
