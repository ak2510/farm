package com.magadh.farm.goatmanagement.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/*
 Represents a specific goat farming unit or location. Contains farm-level metadata such as name, location, and associated farmer.
 All goats are linked to a farm for location-level traceability.
 */
@Entity
@Table(name = "gat_farm")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GoatFarm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private String farmCode;

    @ManyToOne
    @JoinColumn(name = "farmer_id")
    private Farmer owner;

    @OneToMany(mappedBy = "farm")
    private List<Goat> goats;
}
