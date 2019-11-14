package com.mock.ws.soap.service;

import java.util.Optional;

import javax.jws.WebMethod;
import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import com.mock.ws.rest.bso.model.Agent;
import com.mock.ws.rest.bso.service.AgentService;

@WebService
public class SimpleSOAPService extends SpringBeanAutowiringSupport implements ISOAPService {

    private Logger logger = LoggerFactory.getLogger(SimpleSOAPService.class);
    private AgentService agentService;
    
    public SimpleSOAPService() {}
    
    @Autowired
    public void setAgentService(AgentService agentService) {
        this.agentService = agentService;
    }

    @Override
    @WebMethod
    public String getAgentByCode(Long code) {
        if(agentService == null) {
            logger.info("agentService == null");
        }
        logger.info("SimpleSOAPService.getAgentByCode2: " + code);
        Optional<Agent> agent = agentService.getAgentByCode(code);
        return agent.get().getName();
    }
}
