package com.example.finalprj.mapper;

import com.example.finalprj.model.Market;
import com.example.finalprj.model.MarketEntity;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

@Component
public class MarketMapper implements DomainDataMapper<Market, MarketEntity> {

    @Override
    public Market mapToDomain(@NonNull MarketEntity dataModel) {
        return new Market(
                dataModel.getId(),
                dataModel.getName(),
                dataModel.getAddress()
        );
    }

    @Override
    public MarketEntity mapToData(@NonNull Market domainModel) {
        return new MarketEntity(
                domainModel.getId(),
                domainModel.getName(),
                domainModel.getAddress()
        );
    }
}
