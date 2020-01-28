package com.mock.ws.rest.pg.adapter;

import com.mock.ws.rest.bso.model.PGExpectedPayment;
import com.mock.ws.rest.pg.dto.request.PGPaymentDTO;
import com.mock.ws.rest.pg.dto.request.PGRequest;
import com.mock.ws.rest.pg.dto.response.PGResponse;

public class PGProcessingDelStrategy extends PGProcessingAbstractStrategy {

    @Override
    public PGResponse process(PGRequest requestBody) {
        PGPaymentDTO paymentDTO = requestBody.getPayment();

        PGExpectedPayment expectedPayment = paymentService.findByPaymentNumer(paymentDTO.getPaymentNumber());
        if(expectedPayment == null) {
            return generateErrorResponse(paymentDTO.getPaymentNumber(), PGProcessingResult.NOT_FOUND);
        }

        if(expectedPayment.isCancelled()) {
            return generateErrorResponse(expectedPayment.getPaymentNumber(), PGProcessingResult.DELETED);
        }

        expectedPayment.setCancelled(true);
        paymentService.save(expectedPayment);
        return generateSuccessResponse(expectedPayment);
    }
}
