package com.mock.ws.rest.pg.adapter;

import com.mock.ws.rest.bso.model.PGExpectedPayment;
import com.mock.ws.rest.pg.dto.request.PGPaymentDTO;
import com.mock.ws.rest.pg.dto.request.PGRequest;
import com.mock.ws.rest.pg.dto.response.PGResponse;

public class PGProcessingCheckStrategy extends PGProcessingAbstractStrategy {

    @Override
    public PGResponse process(PGRequest requestBody) {
        
        PGPaymentDTO paymentDTO = requestBody.getPayment();
        
        PGExpectedPayment payment = paymentService.findByPaymentNumer(paymentDTO.getPaymentNumber());
        if(payment == null) {
            return generateErrorResponse(paymentDTO.getPaymentNumber(), PGProcessingResult.NOT_FOUND);
        }
        return generateSuccessResponse(payment);
    }

}
