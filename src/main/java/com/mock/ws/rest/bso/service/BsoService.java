package com.mock.ws.rest.bso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.ws.rest.bso.dto.Agent;
import com.mock.ws.rest.bso.dto.Notification;
import com.mock.ws.rest.bso.repository.impl.AgentRepository;

@Service
public class BsoService {

	private AgentRepository agentRepository;

	@Autowired
	public BsoService(AgentRepository agentRepository) {
		this.agentRepository = agentRepository;
	}

	public Notification processRequest(Notification request) {
		Agent agent = request.getBusinessData().getAgent();
		agentRepository.getByLnrAndSkk(agent.getLnr(), agent.getSkk());
		
		Notification response = new Notification();

		response.setBusinessData(request.getBusinessData());
		response.setTechData(request.getTechData());
		return response;
	}
	
	
}
