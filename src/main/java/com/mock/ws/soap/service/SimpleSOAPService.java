package com.mock.ws.soap.service;

import java.util.Optional;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.mock.ws.rest.bso.model.Agent;
import com.mock.ws.rest.bso.service.IAgentService;

@WebService
public class SimpleSOAPService extends SpringBeanAutowiringSupport implements ISOAPService {

	private IAgentService agentService;
	
	public SimpleSOAPService() {}
	
	@Autowired
	public void setAgentService(IAgentService agentService) {
		this.agentService = agentService;
	}

	@Override
	@WebMethod
	public String getAgentByCode(Long code) {
		if(agentService == null) {
			System.out.println("agentService == null");
		}
		System.out.println("SimpleSOAPService.getAgentByCode2: " + code);
		Optional<Agent> agent = agentService.getAgentByCode(code);
		return agent.get().getName();
	}
}
