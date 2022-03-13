package com.example.finalprj.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "market")
@Getter
@Setter
@ToString
public class Market {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "market")
    @ToString.Exclude
    private List<Product> productEntityList = new ArrayList<>();
}
