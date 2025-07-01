package com.magadh.farm.goatmanagement.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/*
Logs all health-related activities for each goat including illness diagnosis, treatments, checkups, and vaccinations.
Helps monitor individual goat health history over time.
 */
@Entity
@Table(name = "goat_health_record")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GoatHealthRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "goat_id")
    Goat goat;

    LocalDate checkupDate;

    String symptoms;

    String diagnosis;

    String treatment;

    String vetName;

    String remarks;
}
