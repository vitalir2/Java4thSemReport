package com.example.finalprj.controller;

import com.example.finalprj.model.Product;
import com.example.finalprj.model.ProductDto;
import com.example.finalprj.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") long id) {
        return productService.getProductById(id);
    }

    @GetMapping(params = {"name"})
    public List<Product> getProductsByName(@RequestParam String name) {
        return productService.getProductsByName(name);
    }

    @GetMapping(params = {"price"})
    public List<Product> getProductsByPrice(@RequestParam int price) {
        return productService.getProductsByPrice(price);
    }

    @PostMapping
    public void createProduct(@RequestBody ProductDto product) {
        productService.save(product);
    }

    @DeleteMapping
    public void deleteProduct(@RequestBody ProductDto product) {
        productService.delete(product);
    }
}
