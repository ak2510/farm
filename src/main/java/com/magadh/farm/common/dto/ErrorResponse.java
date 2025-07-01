package com.magadh.farm.common.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/*
A general class for error responses. This can be used for 400, 404, 500, and other error status codes.
 */
@Getter
@Setter
@NoArgsConstructor
public class ErrorResponse {

    private String status = "error";
    private String message;

    public ErrorResponse(String message) {
        this.message = message;
    }
}
