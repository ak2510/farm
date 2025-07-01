package com.magadh.farm.goatmanagement.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Tracks feeding data for each goat, including feed type, quantity, and feeding time. Useful for analyzing nutrition, managing costs, and ensuring optimal growth.
 */

@Entity
@Table(name = "feed_record")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FeedRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "goat_id")
    Goat goat;

    LocalDate feedDate;

    String feedType;

    Double quantity; // kg or g

    String feedTime; // Morning, Evening
}
