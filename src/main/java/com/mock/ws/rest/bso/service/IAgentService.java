package com.mock.ws.rest.bso.service;

import java.util.Optional;

import com.mock.ws.rest.bso.dto.request.AgentDTO;
import com.mock.ws.rest.bso.model.Agent;

public interface IAgentService {

	Agent save(AgentDTO agentDTO);

	Optional<Agent> getAgentByLnrAndSkk(long lnr, long skk);

	Optional<Agent> getAgentByCode(Long code);

}