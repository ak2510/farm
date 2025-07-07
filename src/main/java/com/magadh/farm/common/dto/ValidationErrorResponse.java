package com.magadh.farm.common.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/*
A specific class for representing validation errors when input data fails. Used with @Valid and @Validated.
 */
@Getter
@Setter
@NoArgsConstructor
public class ValidationErrorResponse {
    private String status = "error";
    private int code;
    private List<ErrorDetail> errors;

    public ValidationErrorResponse(int code, List<ErrorDetail> errors) {
        this.code = code;
        this.errors = errors;
    }

}
