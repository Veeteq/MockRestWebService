package com.mock.ws.rest.bso.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.ws.rest.bso.dto.request.AgentDTO;
import com.mock.ws.rest.bso.dto.request.BsoDTO;
import com.mock.ws.rest.bso.dto.request.Request;
import com.mock.ws.rest.bso.dto.response.BusinessData;
import com.mock.ws.rest.bso.dto.response.Response;
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

	public Response processRequest(Request request) {
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
		
		Response response = new Response();
		BusinessData data = new BusinessData();
		data.setResult("OK");
		data.setSystem(this.getClass().getCanonicalName());
		response.setBusinessData(data);
		response.setTechData(request.getTechData());
		return response;
	}
	
	
}
