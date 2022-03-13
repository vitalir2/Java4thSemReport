package com.example.finalprj.controller;

import com.example.finalprj.model.Market;
import com.example.finalprj.service.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/market")
public class MarketController {

    private final MarketService marketService;

    @Autowired
    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @GetMapping
    public List<Market> getMarkets() {
        return marketService.getMarkets();
    }

    @GetMapping("/{id}")
    public Market getMarketById(@PathVariable("id") long id) {
        return marketService.getMarketById(id);
    }

    @GetMapping(params = {"name"})
    public List<Market> getMarketsByName(@RequestParam String name) {
        return marketService.getMarketsByName(name);
    }

    @GetMapping(params = {"address"})
    public List<Market> getMarketsByAddress(@RequestParam String address) {
        return marketService.getMarketsByAddress(address);
    }

    @PostMapping
    public void createMarket(@RequestBody Market market) {
        marketService.save(market);
    }

    @DeleteMapping
    public void deleteMarket(@RequestBody Market market) {
        marketService.delete(market);
    }
}
