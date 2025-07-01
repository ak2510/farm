package com.magadh.farm.goatmanagement.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/*
 Represents the person responsible for one or more goat farms. Includes contact details and metadata.
 Useful for authentication, access control, and accountability in the system.
 */
@Entity
@Table(name = "farmer")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Farmer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String phone;
    private String email;
    private String language;

    @OneToMany(mappedBy = "owner")
    private List<GoatFarm> farms;
}
