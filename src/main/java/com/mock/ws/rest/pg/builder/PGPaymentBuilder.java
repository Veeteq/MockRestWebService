package com.mock.ws.rest.pg.builder;

import java.math.BigDecimal;

import com.mock.ws.rest.bso.model.PGExpectedPayment;
import com.mock.ws.rest.pg.dto.request.PGPaymentDTO;

public class PGPaymentBuilder {

    public static PGExpectedPayment buildPayment(PGPaymentDTO paymentDTO) {
        PGExpectedPayment payment = new PGExpectedPayment();
        payment.setAmount(new BigDecimal(paymentDTO.getAmount()));
        payment.setPaymentNumber(paymentDTO.getPaymentNumber());
        payment.setKind(paymentDTO.getKind());
        payment.setOperName(paymentDTO.getOperName());
        payment.setOperType(paymentDTO.getOperType());
        payment.setType(paymentDTO.getType());
        return payment;
    }

}
