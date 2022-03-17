package com.example.finalprj;

import com.example.finalprj.model.Market;
import com.example.finalprj.model.Product;
import com.example.finalprj.repository.MarketRepository;
import com.example.finalprj.service.FakeEmailService;
import com.example.finalprj.service.MarketService;
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
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MarketServiceTest {

    @NonNull
    @Mock
    MarketRepository marketRepository;

    @Captor
    ArgumentCaptor<Market> captor;

    MarketService marketService;

    private final List<Market> fakeMarkets = List.of(
            new Market(1, "eggs", "45", null),
            new Market(2, "cheese", "123", null),
            new Market(3, "milk", "88", null)
    );

    @BeforeEach
    void init() {
        this.marketService = new MarketService(marketRepository, new FakeEmailService());
    }

    @Test
    void saveMarket() {
        Market market = fakeMarkets.get(0);
        marketService.save(market);
        verify(marketRepository).save(captor.capture());
        Market captured = captor.getValue();
        assertEquals(market, captured);
    }

    @Test
    void deleteProduct() {
        Market market = fakeMarkets.get(0);
        marketService.delete(market);
        verify(marketRepository).delete(market);
    }

    @Test
    void getAllProducts() {
        when(marketRepository.findAll()).thenReturn(fakeMarkets);
        var result = marketService.getMarkets();
        assertEquals(fakeMarkets, result);
    }

    @Test
    void getProductById() {
        var market = fakeMarkets.get(0);
        when(marketRepository.findById(market.getId())).thenReturn(Optional.of(market));
        var result = marketService.getMarketById(market.getId());
        assertEquals(market, result);
    }

    @Test
    void getProductsByName() {
        var name = "cheese";
        when(marketRepository.findMarketsByName(name)).thenReturn(List.of(fakeMarkets.get(1)));
        var result = marketService.getMarketsByName(name);
        assertEquals(List.of(fakeMarkets.get(1)), result);
    }

    @Test
    void getProductsByPrice() {
        var price = "123";
        when(marketRepository.findMarketsByAddress(price)).thenReturn(List.of(fakeMarkets.get(1)));
        var result = marketService.getMarketsByAddress(price);
        assertEquals(List.of(fakeMarkets.get(1)), result);
    }
}
