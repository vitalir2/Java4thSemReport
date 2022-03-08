package com.example.finalprj.mapper;

public interface DomainDataMapper<Domain, Data> {
    Domain mapToDomain(Data dataModel);
    Data mapToData(Domain domainModel);
}
