package com.mock.ws.rest.pg.builder;

import com.mock.ws.rest.bso.model.PGPayer;
import com.mock.ws.rest.pg.dto.request.PGPayerDTO;

public class PGPayerBuilder {

    public static PGPayer buildPayer(PGPayerDTO payerDTO) {
        
        PGPayer payer = new PGPayer();
        payer.setEmail(payerDTO.getEmail());
        payer.setName(payerDTO.getName());
        payer.setPhone(payerDTO.getPhone());

        return payer;
    }

}
