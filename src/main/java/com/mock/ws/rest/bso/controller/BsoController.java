package com.mock.ws.rest.bso.controller;

import java.util.Date;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

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

	private static final Logger logger = LoggerFactory.getLogger(BsoController.class);
	private BsoService bsoService;
	private AgentService agentService;

	@Autowired
	public BsoController(BsoService bsoService, AgentService agentService) {
		this.bsoService = bsoService;
		this.agentService = agentService;
	}

	@RequestMapping(value = "/agents", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
	public ModelAndView getAgents(ModelAndView mv) {
	    mv.addObject("currentDate", new Date());
        mv.addObject("agents", agentService.findAll());
        mv.setViewName("agents");
        return mv;
	}

    @RequestMapping(value = "/bso", method = RequestMethod.GET, produces = "text/html; charset=utf-8")
    public ModelAndView getBso(ModelAndView mv) {
        mv.addObject("currentDate", new Date());
        mv.addObject("bso", bsoService.findAll());
        mv.setViewName("bso");
        return mv;
    }

	@RequestMapping(value = "/check_bso5", method = RequestMethod.POST, consumes="application/json", produces="application/json")
	public ResponseEntity<Response> bsoCheckStatus(@RequestBody Request requestBody, HttpServletRequest request) {
		logger.info(request.toString());
		
		Response response = bsoService.processCheckRequest(requestBody);
				
		return new ResponseEntity<Response>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/status_bso", method = RequestMethod.POST, consumes="application/json", produces="application/json")
	public ResponseEntity<Response> bsoUpdateStatus(@RequestBody Request requestBody, HttpServletRequest request) {
	    
        Response response = bsoService.processUpdateRequest(requestBody);
	    
	    return new ResponseEntity<Response>(response, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/agent", method = RequestMethod.POST, consumes="application/json", produces="application/json")
	public Response addAgent(@RequestBody AgentDTO agentDTO) {
		Long lnr = agentDTO.getLnr();
		Long skk = agentDTO.getSkk();
		
		BusinessData data = new BusinessData();
		data.setSystem(this.getClass().getName());
		
		Optional<Agent> agent = agentService.getAgentByLnrAndSkk(lnr, skk);
		if (!agent.isPresent()) {
			Agent newAgent = agentService.save(agentDTO);
			String result = String.format("Agent with LNR %1$s, SKK %2$s saved with id %3$s", lnr, skk, newAgent);
			data.setResult(result);
		} else {
			String result = String.format("Agent with LNR %1$s, SKK %2$s already exists", lnr, skk);
			agentService.updateAgent(agent.get(), agentDTO);
			data.setResult(result);			
		}
		Response response = new Response();
		response.setBusinessData(data);
		return response;
	}
	
	@RequestMapping(value = "/agents", method = RequestMethod.POST, consumes="application/json")
	public Response addAgents(@RequestBody AgentDTO[] agentsDTO) {
		logger.info("addAgents");
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
