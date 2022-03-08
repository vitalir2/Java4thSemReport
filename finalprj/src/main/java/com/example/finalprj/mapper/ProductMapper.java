package com.example.finalprj.mapper;

import com.example.finalprj.model.Product;
import com.example.finalprj.model.ProductEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public Product mapToDomain(ProductEntity productEntity) {
        return new Product(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getPrice()
        );
    }

    public ProductEntity mapToData(Product product) {
        return new ProductEntity(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }
}
