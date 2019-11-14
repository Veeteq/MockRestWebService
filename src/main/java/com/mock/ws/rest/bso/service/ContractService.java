package com.mock.ws.rest.bso.service;

import com.mock.ws.rest.bso.model.Contract;

public interface ContractService {

    Contract save(Contract contract);
    
    Contract findBySeriesAndNumber(String series, String number);
}
