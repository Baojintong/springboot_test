package com.example.demo.resp;

import lombok.Data;

@Data
public class RespObject {
    private String code;
    private String message;

    public RespObject(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public RespObject() {
    }
}
