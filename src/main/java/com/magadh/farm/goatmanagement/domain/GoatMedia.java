package com.magadh.farm.goatmanagement.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Manages multimedia content related to goats such as photographs or videos.
 * Useful for record-keeping, marketing, or farmer-facing interfaces that show visuals of goats.
 */
@Entity
@Table(name = "goat_meadia")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GoatMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "goat_id")
    private Goat goat;
    private String mediaUrl;
    private MediaType mediaType; // IMAGE, VIDEO
    private LocalDate uploadedDate;
}
