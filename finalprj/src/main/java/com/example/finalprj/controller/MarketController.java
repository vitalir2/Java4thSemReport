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

    @GetMapping("/{id}")
    public Market getMarketById(@PathVariable("id") long id) {
        return marketRepository.findById(id).orElseThrow();
    }

    @GetMapping(params = {"name"})
    public List<Market> getMarketsByName(@RequestParam String name) {
        return marketRepository.findMarketsByName(name);
    }

    @GetMapping(params = {"address"})
    public List<Market> getMarketsByAddress(@RequestParam String address) {
        return marketRepository.findMarketsByAddress(address);
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
