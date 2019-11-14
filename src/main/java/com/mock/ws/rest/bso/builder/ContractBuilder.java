package com.mock.ws.rest.bso.builder;

import java.math.BigDecimal;

import com.mock.ws.rest.bso.dto.request.ContractDTO;
import com.mock.ws.rest.bso.model.Contract;
import com.mock.ws.rest.pg.dto.request.PGContractDTO;
import com.mock.ws.rest.utils.DateUtils;

public class ContractBuilder {

    public static Contract buildContract(ContractDTO contractDTO) {
        Contract contract = new Contract();
        contract.setNumber(contractDTO.getNumber());
        contract.setSeries(contractDTO.getSeries());
        return contract;
    }

    public static Contract buildContract(PGContractDTO contractDTO) {
        Contract contract = new Contract();
        contract.setNumber(contractDTO.getContractNumber());
        contract.setSeries(contractDTO.getContractSeries());
        contract.setPremium(new BigDecimal(contractDTO.getContractAmount()));
        contract.setDueDate(DateUtils.parse(contractDTO.getContractDate()));
        return contract;
    }

}
