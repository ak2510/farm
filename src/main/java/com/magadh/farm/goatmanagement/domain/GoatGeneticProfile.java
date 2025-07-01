package com.magadh.farm.goatmanagement.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Stores genetic and lineage information about a goat, such as DNA signature or detailed ancestry notes.
 * Helps avoid inbreeding and supports advanced breeding strategies.
 */
@Entity
@Table(name = "gat_genetic_profile")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GoatGeneticProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @OneToOne
    @JoinColumn(name = "goat_id")
    Goat goat;
    String lineageNotes;
    String dnaSequenceHash;
}
