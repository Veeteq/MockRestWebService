package com.mock.ws.rest.bso.adapter;

import com.mock.ws.rest.bso.dto.request.Request;
import com.mock.ws.rest.bso.dto.response.Response;
import com.mock.ws.rest.bso.repository.AgentRepository;
import com.mock.ws.rest.bso.repository.BsoIssuanceRepository;
import com.mock.ws.rest.bso.repository.BsoRepository;
import com.mock.ws.rest.bso.repository.ContractRepository;

public class BsoProcessingAdapter {

    private AgentRepository agentRepository;
    private BsoRepository bsoRepository;
    private BsoIssuanceRepository bsoIssuanceRepository;
    private ContractRepository contractRepository;
    
    public BsoProcessingAdapter(AgentRepository agentRepository, BsoRepository bsoRepository) {
        this.agentRepository = agentRepository;
        this.bsoRepository = bsoRepository;
    }

    public BsoProcessingAdapter(AgentRepository agentRepository, 
                                BsoRepository bsoRepository, 
                                BsoIssuanceRepository bsoIssuanceRepository, 
                                ContractRepository contractRepository) {
        this.agentRepository = agentRepository;
        this.bsoRepository = bsoRepository;
        this.bsoIssuanceRepository = bsoIssuanceRepository;
        this.contractRepository = contractRepository;
    }

    public Response process(Request request, BsoProcessingStrategy processingStrategy) {
        processingStrategy.setAgentRepository(agentRepository);
        processingStrategy.setBsoRepository(bsoRepository);
        processingStrategy.setBsoIssuanceRepository(bsoIssuanceRepository);
        processingStrategy.setContractRepository(contractRepository);
        return processingStrategy.process(request);
    }
}
