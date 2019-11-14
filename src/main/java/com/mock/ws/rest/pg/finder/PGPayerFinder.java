package com.mock.ws.rest.pg.finder;

import com.mock.ws.rest.bso.model.PGPayer;
import com.mock.ws.rest.pg.repository.PGPayerRepository;

public class PGPayerFinder {

    public static PGPayer findByEmail(PGPayerRepository payerRepository, String email) {        
        return payerRepository.findByEmail(email);
    }

}
