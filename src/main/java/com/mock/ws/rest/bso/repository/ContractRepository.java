package com.mock.ws.rest.bso.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mock.ws.rest.bso.model.Contract;

public interface ContractRepository extends JpaRepository<Contract, Long>{

    Contract findBySeriesAndNumber(String series, String number);

}
