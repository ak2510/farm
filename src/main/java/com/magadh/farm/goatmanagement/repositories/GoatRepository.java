package com.magadh.farm.goatmanagement.repositories;

import com.magadh.farm.goatmanagement.domain.Goat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoatRepository extends JpaRepository<Goat, Long> {
}
