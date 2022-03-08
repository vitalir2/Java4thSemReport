package com.example.finalprj.model;

import javax.persistence.*;

@Entity
@Table(name = "market")
public class MarketEntity {
    private long id;
    private String name;
    private String address;

    public MarketEntity() {

    }

    public MarketEntity(long id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
