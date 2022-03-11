package com.example.finalprj.service;

import com.example.finalprj.model.Market;
import com.example.finalprj.repository.MarketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MarketService {

    private final MarketRepository marketRepository;

    @Autowired
    public MarketService(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    public void create(Market market) {
        log.info("Market " + market + "was saved");
        marketRepository.save(market);
    }

    public void delete(Market market) {
        log.info("Market " + market + "was deleted");
        marketRepository.delete(market);
    }

    public List<Market> getMarkets() {
        log.info("Fetch markets");
        return marketRepository.findAll();
    }

    public Market getMarketById(long id) {
        log.info("Fetch market with id = " + id);
        return marketRepository.findById(id).orElseThrow();
    }

    public List<Market> getMarketsByName(String name) {
        log.info("Fetch markets with name = " + name);
        return marketRepository.findMarketsByName(name);
    }

    public List<Market> getMarketsByAddress(String address) {
        log.info("Fetch markets with address = " + address);
        return marketRepository.findMarketsByAddress(address);
    }
}
