package com.example.finalprj.model;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class ProductEntity {
    private long id;
    private String name;
    private int price;

    public ProductEntity() {

    }

    public ProductEntity(long id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "price", nullable = false)
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
