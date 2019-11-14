package com.mock.ws.rest.pg.service;

import java.util.List;

import com.mock.ws.rest.bso.model.PGExpectedPayment;

public interface PGPaymentService {

    List<PGExpectedPayment> findAll();
    
    PGExpectedPayment save(PGExpectedPayment payment);

    PGExpectedPayment findByPaymentNumer(String paymentNumber);
}
