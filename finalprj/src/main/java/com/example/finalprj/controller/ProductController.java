package com.example.finalprj.controller;

import com.example.finalprj.mapper.ProductMapper;
import com.example.finalprj.model.Product;
import com.example.finalprj.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductController(
            @Autowired ProductRepository productRepository,
            @Autowired ProductMapper productMapper
    ) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productRepository.findAll()
                .stream()
                .map(productMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @PostMapping
    public void createProduct(@RequestBody Product product) {
        productRepository.save(productMapper.mapToData(product));
    }

    @DeleteMapping
    public void deleteProduct(@RequestBody Product product) {
        productRepository.delete(productMapper.mapToData(product));
    }
}
