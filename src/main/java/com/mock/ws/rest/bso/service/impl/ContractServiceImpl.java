package com.mock.ws.rest.bso.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.ws.rest.bso.model.Contract;
import com.mock.ws.rest.bso.repository.ContractRepository;
import com.mock.ws.rest.bso.service.ContractService;

@Service
public class ContractServiceImpl implements ContractService {

    private ContractRepository contractRepository;
    
    @Autowired
    public ContractServiceImpl(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    @Override
    public Contract save(Contract contract) {
        return contractRepository.save(contract);
    }

    @Override
    public Contract findBySeriesAndNumber(String series, String number) {
        return contractRepository.findBySeriesAndNumber(series, number);
    }

}
