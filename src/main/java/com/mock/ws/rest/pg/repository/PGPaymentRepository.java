package com.mock.ws.rest.pg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mock.ws.rest.bso.model.PGExpectedPayment;

public interface PGPaymentRepository extends JpaRepository<PGExpectedPayment, Long>{

    PGExpectedPayment findByPaymentNumber(String paymentNumber);

    PGExpectedPayment findById(Long id);

}
