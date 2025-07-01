package com.magadh.farm.goatmanagement.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Maintains an audit trail of status changes for each goat (e.g., from Active to Sold or Dead).
 * Useful for historical traceability, reporting, and debugging operational issues.
 */
//@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GoatStatusHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    Goat goat;
    GoatStatus oldStatus;
    GoatStatus newStatus;
    LocalDateTime changedAt;
    String changedBy;
}
