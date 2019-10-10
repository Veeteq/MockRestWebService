package com.mock.ws.rest.bso.adapter;

import com.mock.ws.rest.bso.dto.request.Request;
import com.mock.ws.rest.bso.dto.response.Response;
import com.mock.ws.rest.bso.repository.AgentRepository;
import com.mock.ws.rest.bso.repository.BsoIssuanceRepository;
import com.mock.ws.rest.bso.repository.BsoRepository;
import com.mock.ws.rest.bso.repository.ContractRepository;

public interface BsoProcessingStrategy {

    public void setAgentRepository(AgentRepository agentRepository);
    public void setBsoRepository(BsoRepository bsoRepository);
    public void setBsoIssuanceRepository(BsoIssuanceRepository bsoIssuanceRepository);
    public void setContractRepository(ContractRepository contractRepository);
    public Response process(Request request);
}
