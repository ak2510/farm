package com.magadh.farm.goatmanagement.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/*
 Stores QR or RFID tag details assigned to goats. Ensures that each goat has a unique machine-readable identifier for tracking and management.
 Includes tag status (active, inactive, lost) and tag type (QR or RFID).
 */
@Entity
@Table(name = "goat_tag")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GoatTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tagId; // Unique encoded string
    private TagType tagType; // QR or RFID
    private TagStatus status; // ACTIVE, INACTIVE, LOST
    private LocalDate assignedDate;

    @OneToOne
    @JoinColumn(name = "goat_id")
    private Goat goat;
}
