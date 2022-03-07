package com.example.finalprj.controller;

import com.example.finalprj.model.Market;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/market")
public class MarketController {

    private final List<Market> markets = new ArrayList<>();

    @GetMapping
    public List<Market> getMarkets() {
        return markets;
    }

    @PostMapping
    public void createMarket(@RequestBody Market market) {
        markets.add(market);
    }

    @DeleteMapping
    public void deleteMarket(@RequestBody Market market) {
        markets.remove(market);
    }
}
