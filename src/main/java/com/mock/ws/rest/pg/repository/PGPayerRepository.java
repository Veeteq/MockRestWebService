package com.mock.ws.rest.pg.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mock.ws.rest.bso.model.PGPayer;

@Repository
@Transactional
public interface PGPayerRepository  extends JpaRepository<PGPayer, Long>{

    PGPayer findByEmail(String email);
}
