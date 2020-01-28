package com.mock.ws.rest.pg.adapter;

public enum PGProcessingResult {

    SUCCESS(0, ""),
    PROCESSING(1, "В обработке"),
    NOT_FOUND(2, "Обещанный платеж :expectedPaymentNumber не найден"),
    DELETED(2, "Платеж :expectedPaymentNumber уже был удален ранее"),
    PAID(3, "Успешно"),
    EXPIRED(4, "У платежа [:expectedPaymentNumber] вышел срок действия"),
    ERROR6(6, "Ошибка на уровне MPI: UndefinedError"),
    DUPLICATE(7, "Payment already exists in the database (Платеж [:expectedPaymentNumber] уже зарегистрирован в базе данных)");
    
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
