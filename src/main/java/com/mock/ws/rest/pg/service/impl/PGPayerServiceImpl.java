package com.mock.ws.rest.pg.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.ws.rest.bso.model.PGPayer;
import com.mock.ws.rest.pg.repository.PGPayerRepository;
import com.mock.ws.rest.pg.service.PGPayerService;

@Service
public class PGPayerServiceImpl implements PGPayerService {

    private PGPayerRepository payerRespository;
    
    @Autowired
    public PGPayerServiceImpl(PGPayerRepository payerRespository) {
        this.payerRespository = payerRespository;
    }

    @Override
    public List<PGPayer> findAll() {
        return payerRespository.findAll();
    }

    @Override
    public PGPayer save(PGPayer payer) {
        return payerRespository.save(payer);
    }

    @Override
    public PGPayer findByEmail(String email) {
        return payerRespository.findByEmail(email);
    }
}
