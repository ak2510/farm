package com.magadh.farm.goatmanagement.dto;

import com.magadh.farm.goatmanagement.domain.Gender;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record CreateGoatRequest(
        Gender gender,

        @NotNull(message = "Date of birth is required")
        @Past(message = "Date of birth must be in the past")
        LocalDate dateOfBirth,

        String breed,

        String color,

        Double weight,

        String hornType
) {
}
