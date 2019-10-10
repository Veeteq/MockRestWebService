package com.mock.ws.rest.bso.builder;

import com.mock.ws.rest.bso.dto.request.ContractDTO;
import com.mock.ws.rest.bso.model.Contract;

public class ContractBuilder {

    public static Contract buildContract(ContractDTO contractDTO) {
        Contract contract = new Contract();
        contract.setNumber(contractDTO.getNumber());
        contract.setSeries(contractDTO.getSeries());
        return contract;
    }

}
