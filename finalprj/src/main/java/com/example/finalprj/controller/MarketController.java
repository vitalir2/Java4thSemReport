package com.example.finalprj.controller;

import com.example.finalprj.model.Market;
import com.example.finalprj.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/market")
public class MarketController {

    private final MarketRepository marketRepository;

    @Autowired
    public MarketController(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    @GetMapping
    public List<Market> getMarkets() {
        return marketRepository.findAll();
    }

    @PostMapping
    public void createMarket(@RequestBody Market market) {
        marketRepository.save(market);
    }

    @DeleteMapping
    public void deleteMarket(@RequestBody Market market) {
        marketRepository.delete(market);
    }
}
