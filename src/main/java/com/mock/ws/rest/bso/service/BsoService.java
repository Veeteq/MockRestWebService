package com.mock.ws.rest.bso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.ws.rest.bso.dto.AgentDTO;
import com.mock.ws.rest.bso.dto.BsoDTO;
import com.mock.ws.rest.bso.dto.Notification;
import com.mock.ws.rest.bso.model.Agent;
import com.mock.ws.rest.bso.model.Bso;
import com.mock.ws.rest.bso.repository.impl.AgentRepository;
import com.mock.ws.rest.bso.repository.impl.BsoRepository;

@Service
public class BsoService {

	private AgentRepository agentRepository;
	private BsoRepository bsoRepository;

	@Autowired
	public BsoService(AgentRepository agentRepository, BsoRepository bsoRepository) {
		this.agentRepository = agentRepository;
		this.bsoRepository = bsoRepository;
	}

	public Notification processRequest(Notification request) {
		AgentDTO agentDTO = request.getBusinessData().getAgent();
		Agent agent = agentRepository.getByLnrAndSkk(agentDTO.getLnr(), agentDTO.getSkk());
		
		if(agent == null) {
			agentRepository.save(agentDTO);
		}
		
		BsoDTO bsoDTO = request.getBusinessData().getBso();
		Bso bso = bsoRepository.getBySeriesAndNumberAndType(bsoDTO.getSeries(), bsoDTO.getNumber(), bsoDTO.getType()); 
		if(bso == null) {
			bsoRepository.save(bsoDTO);
		}
		
		Notification response = new Notification();

		response.setBusinessData(request.getBusinessData());
		response.setTechData(request.getTechData());
		return response;
	}
	
	
}
