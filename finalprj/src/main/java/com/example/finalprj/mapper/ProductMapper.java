package com.example.finalprj.mapper;

import com.example.finalprj.model.Product;
import com.example.finalprj.model.ProductEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements DomainDataMapper<Product, ProductEntity> {

    @Override
    public Product mapToDomain(@NonNull ProductEntity productEntity) {
        return new Product(
                productEntity.getId(),
                productEntity.getName(),
                productEntity.getPrice()
        );
    }

    @Override
    public ProductEntity mapToData(@NonNull Product product) {
        return new ProductEntity(
                product.getId(),
                product.getName(),
                product.getPrice()
        );
    }
}
