package com.mock.ws.rest.bso.service;

import java.util.List;
import java.util.Optional;

import com.mock.ws.rest.bso.dto.request.AgentDTO;
import com.mock.ws.rest.bso.model.Agent;

public interface IAgentService {

    List<Agent> findAll();
    
    Agent save(AgentDTO agentDTO);

    Agent updateAgent(Agent agent, AgentDTO agentDTO);
        
    Optional<Agent> getAgentByLnrAndSkk(long lnr, long skk);

    Optional<Agent> getAgentByCode(Long code);

}