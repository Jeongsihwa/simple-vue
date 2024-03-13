package com.example.simplevue.dto;

import lombok.Getter;

@Getter
public class ResponseDto {
    private String code;
    private String message;

    public ResponseDto(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
