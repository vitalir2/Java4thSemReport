package com.example.finalprj.repository;

import com.example.finalprj.model.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MarketRepository extends JpaRepository<Market, Long>, JpaSpecificationExecutor<Market> {
    List<Market> findMarketsByName(String name);
    List<Market> findMarketsByAddress(String address);
}
