package com.magadh.farm.goatmanagement.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/*
Captures events where two goats are bred either naturally or through artificial insemination. Records the breeding date, method, and expected delivery.
Helps in tracking reproductive health and planning future breeding.
 */
@Entity
@Table(name = "breeding_event")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BreedingEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "female_goat_id", nullable = false)
    private Goat femaleGoat;

    @ManyToOne
    @JoinColumn(name = "male_goat_id", nullable = false)
    private Goat maleGoat;

    private LocalDate breedingDate;


    private LocalDate expectedDeliveryDate;


    private String method; // Natural, AI

    private String remarks;
}
