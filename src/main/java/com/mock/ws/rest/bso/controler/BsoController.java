package com.mock.ws.rest.bso.controler;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.mock.ws.rest.bso.service.AgentService;
import com.mock.ws.rest.bso.service.BsoService;

@RestController
@RequestMapping(path = "/bso")
public class BsoController {

	private BsoService bsoService;
	private AgentService agentService;

	@Autowired
	public BsoController(BsoService bsoService, AgentService agentService) {
		this.bsoService = bsoService;
		this.agentService = agentService;
	}

	@RequestMapping(value = "/check", method = RequestMethod.GET, produces="application/json")
	public String bsoCheck() {
		return "hello";
	}

	@RequestMapping(value = "/check", method = RequestMethod.POST, consumes="application/json", produces="application/json")
	public Response bsoCheckStatus(@RequestBody Request request) {
		Response response = bsoService.processRequest(request);
		return response;
	}

	@RequestMapping(value = "/agent", method = RequestMethod.POST, consumes="application/json", produces="application/json")
	public Response addAgent(@RequestBody AgentDTO agentDTO) {
		Long lnr = agentDTO.getLnr();
		Long skk = agentDTO.getSkk();
		
		BusinessData data = new BusinessData();
		data.setSystem(this.getClass().getName());
		
		Agent agent = agentService.getAgentByLnrAndSkk(lnr, skk);
		if (agent == null) {
			Long agentId = agentService.save(agentDTO);
			String result = String.format("Agent with LNR %1$s, SKK %2$s saved with id %3$s", lnr, skk, agentId);
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
		Agent agent = agentService.getAgentByLnrAndSkk(lnr, skk);
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
