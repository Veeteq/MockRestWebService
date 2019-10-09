package com.mock.ws.rest.bso.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mock.ws.rest.bso.dto.request.AgentBsoDTO;
import com.mock.ws.rest.bso.dto.request.AgentDTO;
import com.mock.ws.rest.bso.dto.request.BsoDTO;
import com.mock.ws.rest.bso.dto.request.Request;
import com.mock.ws.rest.bso.dto.response.BusinessData;
import com.mock.ws.rest.bso.dto.response.Response;
import com.mock.ws.rest.bso.model.Agent;
import com.mock.ws.rest.bso.service.IAgentService;
import com.mock.ws.rest.bso.service.IBsoService;

@RestController
@RequestMapping(path = "/bso")
public class BsoController {

	private IBsoService bsoService;
	private IAgentService agentService;

	@Autowired
	public BsoController(IBsoService bsoService, IAgentService agentService) {
		this.bsoService = bsoService;
		this.agentService = agentService;
	}

	@RequestMapping(value = "/check", method = RequestMethod.GET, produces="application/json")
	public String bsoCheck() {
		return "hello";
	}

	@RequestMapping(value = "/check_bso5", method = RequestMethod.POST, consumes="application/json", produces="application/json")
	public ResponseEntity<Response> bsoCheckStatus(@RequestBody Request requestBody, HttpServletRequest request) {
		System.out.println(request);
		
		Response response = bsoService.processRequest(requestBody);
				
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/agent", method = RequestMethod.POST, consumes="application/json", produces="application/json")
	public Response addAgent(@RequestBody AgentDTO agentDTO) {
		Long lnr = agentDTO.getLnr();
		Long skk = agentDTO.getSkk();
		
		BusinessData data = new BusinessData();
		data.setSystem(this.getClass().getName());
		
		Agent agent = agentService.getAgentByLnrAndSkk(lnr, skk).get();
		if (agent == null) {
			Agent newAgent = agentService.save(agentDTO);
			String result = String.format("Agent with LNR %1$s, SKK %2$s saved with id %3$s", lnr, skk, newAgent);
			data.setResult(result);
		} else {
			String result = String.format("Agent with LNR %1$s, SKK %2$s already exists", lnr, skk);			
			data.setResult(result);			
		}
		Response response = new Response();
		response.setBusinessData(data);
		return response;
	}
	
	@RequestMapping(value = "/agents", method = RequestMethod.POST, consumes="application/json")
	public Response addAgents(@RequestBody AgentDTO[] agentsDTO) {
		System.out.println("addAgents");
		BusinessData data = new BusinessData();
		data.setSystem(this.getClass().getName());
		
		StringBuilder resultBuilder = new StringBuilder();
		for(AgentDTO agentDTO : agentsDTO) {
			Response response = addAgent(agentDTO);
			resultBuilder.append(response.getBusinessData().getResult()).append(System.lineSeparator());			
		}
		data.setResult(resultBuilder.toString());
		Response response = new Response();
		response.setBusinessData(data);
		return response;
	}

	@RequestMapping(value = "/agent_bso", method = RequestMethod.POST, consumes="application/json", produces="application/json")
	public Response addBsoForAgent(@RequestBody AgentBsoDTO agentBsoDTO) {
		BusinessData data = new BusinessData();
		data.setSystem(this.getClass().getName());

		Long lnr = agentBsoDTO.getLnr();
		Long skk = agentBsoDTO.getSkk();
		Agent agent = agentService.getAgentByLnrAndSkk(lnr, skk).get();
		if (agent == null) {
			String result = String.format("Agent with LNR %1$s, SKK %2$s does not exist", lnr, skk);
			data.setResult(result);
		}
		
		for(BsoDTO bsoDTO : agentBsoDTO.getBso()) {
			bsoService.addBsoToAgent(bsoDTO, agent);
		}
		Response response = new Response();
		response.setBusinessData(data);
		return response;
	}
}
