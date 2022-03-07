package com.example.finalprj.controller;

import com.example.finalprj.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final List<Product> products = new ArrayList<>();

    @GetMapping
    public List<Product> getProducts() {
        return products;
    }

    @PostMapping
    public void createProduct(@RequestBody Product product) {
        products.add(product);
    }

    @DeleteMapping
    public void deleteProduct(@RequestBody Product product) {
        products.remove(product);
    }
}
