package com.example.finalprj;

import com.example.finalprj.mapper.ProductMapper;
import com.example.finalprj.model.Market;
import com.example.finalprj.model.Product;
import com.example.finalprj.model.ProductDto;
import com.example.finalprj.repository.MarketRepository;
import com.example.finalprj.repository.ProductRepository;
import com.example.finalprj.service.FakeEmailService;
import com.example.finalprj.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

    @NonNull
    @Mock
    ProductRepository productRepository;

    @NonNull
    @Mock
    ProductMapper productMapper;

    @Captor
    ArgumentCaptor<Product> captor;

    ProductService productService;

    private final List<ProductDto> fakeProductsDto = List.of(
            new ProductDto("eggs", 45, 1L),
            new ProductDto("cheese", 123, 1L),
            new ProductDto("milk", 88, 1L)
    );

    private final List<Product> fakeProducts = List.of(
            new Product(1, "eggs", 45, null),
            new Product(2, "cheese", 123, null),
            new Product(3, "milk", 88, null)
    );

    @BeforeEach
    void init() {
        this.productService = new ProductService(productRepository, productMapper, new FakeEmailService());
    }

    @Test
    void saveProduct() {
        ProductDto product = fakeProductsDto.get(0);
        when(productMapper.mapDtoToEntity(any())).thenReturn(new Product(1, product.getName(), product.getPrice(), null));
        productService.save(product);
        verify(productRepository).save(captor.capture());
        Product captured = captor.getValue();
        assertEquals(product.getName(), captured.getName());
        assertEquals(product.getPrice(), captured.getPrice());
    }

    @Test
    void deleteProduct() {
        ProductDto product = fakeProductsDto.get(0);
        when(productMapper.mapDtoToEntity(any())).thenReturn(new Product(1, product.getName(), product.getPrice(), null));
        productService.delete(product);
        verify(productRepository).delete(fakeProducts.get(0));
    }

    @Test
    void getAllProducts() {
        when(productRepository.findAll()).thenReturn(fakeProducts);
        var result = productService.getProducts();
        for (int i = 0; i < result.size(); ++i) {
            assertEquals(result.get(i).getName(), fakeProducts.get(i).getName());
            assertEquals(result.get(i).getPrice(), fakeProducts.get(i).getPrice());
        }
    }

    @Test
    void getProductById() {
        var product = fakeProducts.get(0);
        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));
        var result = productService.getProductById(product.getId());
        assertEquals(product, result);
    }

    @Test
    void getProductsByName() {
        var name = "cheese";
        when(productRepository.findProductsByName(name)).thenReturn(List.of(fakeProducts.get(1)));
        var result = productService.getProductsByName(name);
        assertEquals(List.of(fakeProducts.get(1)), result);
    }

    @Test
    void getProductsByPrice() {
        var price = 123;
        when(productRepository.findProductsByPrice(price)).thenReturn(List.of(fakeProducts.get(1)));
        var result = productService.getProductsByPrice(price);
        assertEquals(List.of(fakeProducts.get(1)), result);
    }
}
