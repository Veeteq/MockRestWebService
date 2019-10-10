package com.mock.ws.rest.bso.adapter;

import java.util.UUID;

import com.mock.ws.rest.bso.dto.TechData;
import com.mock.ws.rest.bso.dto.response.BusinessData;
import com.mock.ws.rest.bso.dto.response.Response;
import com.mock.ws.rest.bso.repository.AgentRepository;
import com.mock.ws.rest.bso.repository.BsoIssuanceRepository;
import com.mock.ws.rest.bso.repository.BsoRepository;
import com.mock.ws.rest.bso.repository.ContractRepository;

public abstract class BsoProcessingAbstractStrategy implements BsoProcessingStrategy {

    protected AgentRepository agentRepository;
    protected BsoRepository bsoRepository;
    protected BsoIssuanceRepository bsoIssuanceRepository; 
    protected ContractRepository contractRepository;
        
    protected UUID actionId;
    protected UUID correlationId;

    public void setAgentRepository(AgentRepository agentRepository) {
        this.agentRepository = agentRepository;
    }

    public void setBsoRepository(BsoRepository bsoRepository) {
        this.bsoRepository = bsoRepository;
    }

    public void setBsoIssuanceRepository(BsoIssuanceRepository bsoIssuanceRepository) {
        this.bsoIssuanceRepository = bsoIssuanceRepository;
    }

    public void setContractRepository(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    protected Response generateErrorResponse(Response response, String errMsg) {
        TechData techData = new TechData();
        techData.setActionId(actionId.toString());
        techData.setCorrelationId(correlationId.toString());
        techData.setResponseCode("0");
        response.setTechData(techData);
        
        BusinessData bussinessData = new BusinessData();
        bussinessData.setResult(errMsg);
        response.setBusinessData(bussinessData);
        
        return response;
    }

    protected Response generateSuccessResponse(Response response) {
        TechData techData = new TechData();
        techData.setActionId(actionId.toString());
        techData.setCorrelationId(correlationId.toString());
        techData.setResponseCode("0");
        response.setTechData(techData);

        BusinessData data = new BusinessData();
        data.setResult("OK");
        data.setSystem("1");
        response.setBusinessData(data);
        
        return response;
    }
}
