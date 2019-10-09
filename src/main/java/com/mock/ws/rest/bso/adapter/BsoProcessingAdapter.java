package com.mock.ws.rest.bso.adapter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.mock.ws.rest.bso.dto.TechData;
import com.mock.ws.rest.bso.dto.request.AgentDTO;
import com.mock.ws.rest.bso.dto.request.BsoDTO;
import com.mock.ws.rest.bso.dto.request.Request;
import com.mock.ws.rest.bso.dto.response.BusinessData;
import com.mock.ws.rest.bso.dto.response.Response;
import com.mock.ws.rest.bso.model.Agent;
import com.mock.ws.rest.bso.model.Bso;
import com.mock.ws.rest.bso.repository.AgentRepository;
import com.mock.ws.rest.bso.repository.BsoRepository;
import com.mock.ws.rest.bso.validators.CheckRequestValidator;
import com.mock.ws.rest.utils.DateUtils;

public class BsoProcessingAdapter {

	private AgentRepository agentRepository;
	private BsoRepository bsoRepository;

	private UUID actionId;
	private UUID correlationId;
	
	public BsoProcessingAdapter(AgentRepository agentRepository, BsoRepository bsoRepository) {
		this.agentRepository = agentRepository;
		this.bsoRepository = bsoRepository;
	}

	public Response process(Request request) {
		Response response = new Response();

		actionId = UUID.fromString(request.getTechData().getActionId());
		correlationId = UUID.fromString(request.getTechData().getCorrelationId());
		
		AgentDTO agentDTO = request.getBusinessData().getAgent();
		BsoDTO bsoDTO = request.getBusinessData().getBso();
		
		Optional<Agent> agent = agentRepository.findByLnrAndSkk(agentDTO.getLnr(), agentDTO.getSkk());
		List<Bso> bsoList = bsoRepository.findBySeriesAndNumberAndType(bsoDTO.getSeries(), bsoDTO.getNumber(), bsoDTO.getType());
		LocalDateTime checkDate = DateUtils.parse(request.getBusinessData().getIssueDate());
		
		try {		
		    CheckRequestValidator.validateRequest(agent, bsoList, checkDate);
		} catch (IllegalArgumentException exc) {
			return generateErrorResponse(response, exc.getMessage());
		}
		
		
		BusinessData data = new BusinessData();
		data.setResult("OK");
		data.setSystem(this.getClass().getCanonicalName());
		response.setBusinessData(data);
		response.setTechData(request.getTechData());
		
		return response;
	}

	private Response generateErrorResponse(Response response, String errMsg) {
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

}
