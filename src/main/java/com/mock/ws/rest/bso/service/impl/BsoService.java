package com.mock.ws.rest.bso.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.ws.rest.bso.adapter.BsoProcessingAdapter;
import com.mock.ws.rest.bso.adapter.BsoProcessingCheckStrategy;
import com.mock.ws.rest.bso.adapter.BsoProcessingUpdateStrategy;
import com.mock.ws.rest.bso.builder.RequestsHistoryBuilder;
import com.mock.ws.rest.bso.dto.request.BsoDTO;
import com.mock.ws.rest.bso.dto.request.Request;
import com.mock.ws.rest.bso.dto.response.Response;
import com.mock.ws.rest.bso.model.Agent;
import com.mock.ws.rest.bso.model.Bso;
import com.mock.ws.rest.bso.model.RequestsHistory;
import com.mock.ws.rest.bso.model.Status;
import com.mock.ws.rest.bso.repository.AgentRepository;
import com.mock.ws.rest.bso.repository.BsoIssuanceRepository;
import com.mock.ws.rest.bso.repository.BsoRepository;
import com.mock.ws.rest.bso.repository.ContractRepository;
import com.mock.ws.rest.bso.repository.RequestsHistoryRepository;
import com.mock.ws.rest.bso.service.IBsoService;

@Service
public class BsoService implements IBsoService {

	private AgentRepository agentRepository;
    private BsoIssuanceRepository bsoIssuanceRepository;
	private BsoRepository bsoRepository;
    private ContractRepository contractRepository;
	private RequestsHistoryRepository requestsHistoryRepository;
	
	@Autowired
	public BsoService(AgentRepository agentRepository, 
	                  BsoRepository bsoRepository, 
	                  BsoIssuanceRepository bsoIssuanceRepository,
	                  ContractRepository contractRepository,
	                  RequestsHistoryRepository requestsHistoryRepository) {
		this.agentRepository = agentRepository;
        this.bsoIssuanceRepository = bsoIssuanceRepository;
		this.bsoRepository = bsoRepository;
		this.contractRepository = contractRepository;
		this.requestsHistoryRepository = requestsHistoryRepository;
	}

	@Override
	@Transactional
	public Bso save(BsoDTO bsoDTO) {
		Bso bso = new Bso();
		BeanUtils.copyProperties(bsoDTO, bso);		
		return bsoRepository.save(bso);
	}

	@Override
	@Transactional
	public void addBsoToAgent(BsoDTO bsoDTO, Agent agent) {
		Bso bso = new Bso();
		BeanUtils.copyProperties(bsoDTO, bso);
		bso.setAgent(agent);
		bso.setStatus(Status.NEW);
		bsoRepository.save(bso);
	}

	@Override
	@Transactional
	public Response processCheckRequest(Request request) {
		logIncomingRequest(request);
		
		//Start processing
		BsoProcessingAdapter processingAdapter = new BsoProcessingAdapter(agentRepository, bsoRepository);
		Response response = processingAdapter.process(request, new BsoProcessingCheckStrategy());
		
		return response;
	}

    @Override
    @Transactional
    public Response processUpdateRequest(Request request) {
        logIncomingRequest(request);

        //Start processing
        BsoProcessingAdapter processingAdapter = new BsoProcessingAdapter(agentRepository, bsoRepository, bsoIssuanceRepository, contractRepository);
        Response response = processingAdapter.process(request, new BsoProcessingUpdateStrategy());
        
        return response;
    }
    
    private void logIncomingRequest(Request request) {
        //Log incoming request
        RequestsHistory requestsHistory = RequestsHistoryBuilder.buildRequestHistory(request);
        requestsHistoryRepository.save(requestsHistory);        
    }
}
