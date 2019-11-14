package com.mock.ws.rest.pg.service;

import java.util.List;

import com.mock.ws.rest.bso.model.PGPayer;

public interface PGPayerService {

    List<PGPayer> findAll();
    
    PGPayer save(PGPayer payer);
    
    PGPayer findByEmail(String email);
}
