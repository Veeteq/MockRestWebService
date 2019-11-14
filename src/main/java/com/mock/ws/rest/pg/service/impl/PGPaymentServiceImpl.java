package com.mock.ws.rest.pg.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.ws.rest.bso.model.PGExpectedPayment;
import com.mock.ws.rest.pg.repository.PGPaymentRepository;
import com.mock.ws.rest.pg.service.PGPaymentService;

@Service
public class PGPaymentServiceImpl implements PGPaymentService {

    private PGPaymentRepository paymentRespository;
    
    @Autowired
    public PGPaymentServiceImpl(PGPaymentRepository paymentRespository) {
        this.paymentRespository = paymentRespository;
    }
    
    @Override
    public List<PGExpectedPayment> findAll() {
        return paymentRespository.findAll();
    }

    @Override
    public PGExpectedPayment save(PGExpectedPayment payment) {
        return paymentRespository.save(payment);
    }

    @Override
    @Transactional
    public PGExpectedPayment findByPaymentNumer(String paymentNumber) {
        return paymentRespository.findByPaymentNumber(paymentNumber);
    }

}
