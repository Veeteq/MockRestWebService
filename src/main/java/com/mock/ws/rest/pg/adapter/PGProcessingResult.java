package com.mock.ws.rest.pg.adapter;

public enum PGProcessingResult {

    SUCCESS(0, ""),
    NOT_FOUND(2, "Обещанный платеж :expectedPaymentNumber не найден"),
    DELETED(2, "Платеж :expectedPaymentNumber уже был удален ранее");
    
    private final int code;
    private final String description;
    
    private PGProcessingResult(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
