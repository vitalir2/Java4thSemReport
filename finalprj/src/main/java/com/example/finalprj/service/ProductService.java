package com.example.finalprj.service;

import com.example.finalprj.mapper.ProductMapper;
import com.example.finalprj.model.Product;
import com.example.finalprj.model.ProductDto;
import com.example.finalprj.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final EmailService emailService;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper, EmailService emailService) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
        this.emailService = emailService;
    }

    public void save(ProductDto product) {
        var objectWasSavedMessage = "Product " + product + " was saved";
        log.info(objectWasSavedMessage);
        emailService.sendEmailMessage(objectWasSavedMessage);
        var productEntity = productMapper.mapDtoToEntity(product);
        productRepository.save(productEntity);
    }

    public void delete(ProductDto product) {
        log.info("Product " + product + " was deleted");
        var productEntity = productMapper.mapDtoToEntity(product);
        productRepository.delete(productEntity);
    }

    public List<Product> getProducts() {
        log.info("Fetch products");
        return productRepository.findAll();
    }

    public Product getProductById(long id) {
        log.info("Fetch product with id = " + id);
        return productRepository.findById(id).orElseThrow();
    }

    public List<Product> getProductsByName(String name) {
        log.info("Fetch products with name = " + name);
        return productRepository.findProductsByName(name);
    }

    public List<Product> getProductsByPrice(int price) {
        log.info("Fetch products with price = " + price);
        return productRepository.findProductsByPrice(price);
    }
}
