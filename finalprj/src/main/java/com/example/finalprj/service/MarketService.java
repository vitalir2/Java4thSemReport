package com.example.finalprj.service;

import com.example.finalprj.model.Market;
import com.example.finalprj.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketService {

    private final MarketRepository marketRepository;

    @Autowired
    public MarketService(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    public void create(Market market) {
        marketRepository.save(market);
    }

    public void delete(Market market) {
        marketRepository.delete(market);
    }

    public List<Market> getMarkets() {
        return marketRepository.findAll();
    }

    public Market getMarketById(long id) {
        return marketRepository.findById(id).orElseThrow();
    }

    public List<Market> getMarketsByName(String name) {
        return marketRepository.findMarketsByName(name);
    }

    public List<Market> getMarketsByAddress(String address) {
        return marketRepository.findMarketsByAddress(address);
    }
}
