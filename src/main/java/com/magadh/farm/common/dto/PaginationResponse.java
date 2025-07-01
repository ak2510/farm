package com.magadh.farm.common.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PaginationResponse<T> {
    private String status = "success";
    private String message;
    private T data;
    private PaginationMetaData paginationMetaData;

    public PaginationResponse(String message, T data, PaginationMetaData paginationMetaData) {
        this.message = message;
        this.data = data;
        this.paginationMetaData = paginationMetaData;
    }

}
