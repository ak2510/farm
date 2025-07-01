package com.magadh.farm.goatmanagement.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

/**
 * Represents an individual goat in the system. Stores all key information such as tag ID, gender, birth date, weight, and lineage (mother and father).
 * It is the central entity connected with health, breeding, feed, and lifecycle data.
 */

@Entity
@Table(name = "goats")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Goat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tagId; // QR or RFID

    private String name;

    @Enumerated(EnumType.STRING)
    private Gender gender; // MALE or FEMALE

    private LocalDate dateOfBirth;

    private String breed; // e.g. Black Bengal

    private String color;

    private Double weight;

    private String hornType;

    @Enumerated(EnumType.STRING)
    private GoatStatus status; // ACTIVE, SOLD, DEAD, LOST, etc.


    private String photoUrl;

    //------------------------- Relationships---------------------

    // Many goats belong to one farm
    @ManyToOne
    @JoinColumn(name = "farm_id")
    private GoatFarm farm;

    // Self-referencing parent relationship
    @ManyToOne
    @JoinColumn(name = "mother_id")
    private Goat mother;

    @ManyToOne
    @JoinColumn(name = "father_id")
    private Goat father;

    // One goat can have multiple health records
    @OneToMany(mappedBy = "goat", cascade = CascadeType.ALL)
    private List<GoatHealthRecord> healthRecords;

    // One goat can have multiple feed records
    @OneToMany(mappedBy = "goat", cascade = CascadeType.ALL)
    private List<FeedRecord> feedRecords;

    // One goat can have multiple breeding events as female
    @OneToMany(mappedBy = "femaleGoat", cascade = CascadeType.ALL)
    private List<BreedingEvent> breedingEventsAsFemale;

    // One goat can have multiple breeding events as male
    @OneToMany(mappedBy = "maleGoat", cascade = CascadeType.ALL)
    private List<BreedingEvent> breedingEventsAsMale;


}
