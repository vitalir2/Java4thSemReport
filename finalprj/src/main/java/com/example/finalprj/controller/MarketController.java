package com.example.finalprj.controller;

import com.example.finalprj.mapper.MarketMapper;
import com.example.finalprj.model.Market;
import com.example.finalprj.repository.MarketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/market")
public class MarketController {

    private final MarketRepository marketRepository;
    private final MarketMapper marketMapper;

    public MarketController(
            @Autowired MarketRepository marketRepository,
            @Autowired MarketMapper marketMapper
    ) {
        this.marketRepository = marketRepository;
        this.marketMapper = marketMapper;
    }

    @GetMapping
    public List<Market> getMarkets() {
        return marketRepository.findAll()
                .stream()
                .map(marketMapper::mapToDomain)
                .collect(Collectors.toList());
    }

    @PostMapping
    public void createMarket(@RequestBody Market market) {
        marketRepository.save(marketMapper.mapToData(market));
    }

    @DeleteMapping
    public void deleteMarket(@RequestBody Market market) {
        marketRepository.delete(marketMapper.mapToData(market));
    }
}
