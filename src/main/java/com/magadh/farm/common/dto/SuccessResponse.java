package com.magadh.farm.common.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SuccessResponse<T> {

    private String status = "success";
    private String message;
    private T data;

    public SuccessResponse(String message, T data) {
        this.message = message;
        this.data = data;
    }
}
