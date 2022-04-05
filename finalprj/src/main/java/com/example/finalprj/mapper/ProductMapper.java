package com.example.finalprj.mapper;

import com.example.finalprj.model.Product;
import com.example.finalprj.model.ProductDto;
import com.example.finalprj.repository.MarketRepository;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    private final MarketRepository marketRepository;

    public ProductMapper(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    public Product mapDtoToEntity(ProductDto productDto) {
        var market = marketRepository.findById(productDto.getMarketId()).orElseThrow();
        return new Product(0, productDto.getName(), productDto.getPrice(), market);
    }
}
