package com.magadh.farm.goatmanagement.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Records the exit of a goat from the system due to death, sale, or loss. Stores details such as date of exit, cause, and sale price or buyer info (if applicable).
 * Helps maintain population accuracy and financial records.
 */
@Entity
@Table(name = "goat_exit_record")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GoatExitRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @OneToOne
    @JoinColumn(name = "goat_id", nullable = false, unique = true)
    Goat goat;

    GoatExitType exitType; // SOLD, DEAD, LOST
    LocalDate exitDate;
    String reason; // Disease, Accident, Sold to buyer
    Double salePrice;
    String buyerName;
}
