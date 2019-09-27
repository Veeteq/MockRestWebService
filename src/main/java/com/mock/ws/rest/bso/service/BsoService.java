package com.mock.ws.rest.bso.service;

import java.time.LocalDateTime;

import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mock.ws.rest.bso.dto.request.AgentDTO;
import com.mock.ws.rest.bso.dto.request.BsoDTO;
import com.mock.ws.rest.bso.dto.request.Request;
import com.mock.ws.rest.bso.dto.response.BusinessData;
import com.mock.ws.rest.bso.dto.response.Response;
import com.mock.ws.rest.bso.model.Agent;
import com.mock.ws.rest.bso.model.Bso;
import com.mock.ws.rest.bso.model.Status;
import com.mock.ws.rest.bso.repository.impl.AgentRepository;
import com.mock.ws.rest.bso.repository.impl.BsoRepository;
import com.mock.ws.rest.bso.validators.CheckRequestValidator;
import com.mock.ws.rest.utils.DateUtils;

@Service
public class BsoService {

	private AgentRepository agentRepository;
	private BsoRepository bsoRepository;

	@Autowired
	public BsoService(AgentRepository agentRepository, BsoRepository bsoRepository) {
		this.agentRepository = agentRepository;
		this.bsoRepository = bsoRepository;
	}

	@Transactional
	public Long save(BsoDTO bsoDTO) {
		Bso bso = new Bso();
		BeanUtils.copyProperties(bsoDTO, bso);		
		return bsoRepository.save(bso);
	}

	@Transactional
	public void addBsoToAgent(BsoDTO bsoDTO, Agent agent) {
		Bso bso = new Bso();
		BeanUtils.copyProperties(bsoDTO, bso);
		bso.setAgent(agent);
		bso.setStatus(Status.N);
		bsoRepository.save(bso);
	}

	public Response processRequest(Request request) {
		AgentDTO agentDTO = request.getBusinessData().getAgent();
		Agent agent = agentRepository.getByLnrAndSkk(agentDTO.getLnr(), agentDTO.getSkk());
		
		
		BsoDTO bsoDTO = request.getBusinessData().getBso();
		Bso bso = bsoRepository.getBySeriesAndNumberAndType(bsoDTO.getSeries(), bsoDTO.getNumber(), bsoDTO.getType()); 

		LocalDateTime checkDate = DateUtils.parse(request.getBusinessData().getIssueDate());
				
		CheckRequestValidator.validateRequest(agent, bso, checkDate);
		
		Response response = new Response();
		BusinessData data = new BusinessData();
		data.setResult("OK");
		data.setSystem(this.getClass().getCanonicalName());
		response.setBusinessData(data);
		response.setTechData(request.getTechData());
		return response;
	}
}
