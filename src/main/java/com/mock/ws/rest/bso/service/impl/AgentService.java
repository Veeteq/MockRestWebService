package com.mock.ws.rest.bso.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mock.ws.rest.bso.dto.request.AgentDTO;
import com.mock.ws.rest.bso.model.Agent;
import com.mock.ws.rest.bso.repository.AgentRepository;
import com.mock.ws.rest.bso.service.IAgentService;

@Service
public class AgentService implements IAgentService {

	private AgentRepository agentRepository;

	@Autowired
	public AgentService(AgentRepository agentRepository) {
		this.agentRepository = agentRepository;
	}
	
	@Override
	@Transactional
	public Agent save(AgentDTO agentDTO) {
		Agent agent = new Agent();
		BeanUtils.copyProperties(agentDTO, agent);
		return agentRepository.save(agent);
	}

	@Override
	public Optional<Agent> getAgentByLnrAndSkk(long lnr, long skk) {
		return agentRepository.findByLnrAndSkk(lnr, skk);
	}

	@Override
	public Optional<Agent> getAgentByCode(Long code) {
		System.out.println("AgentService.getAgentByCode: " + code);
		return agentRepository.findByCode(code);
	}
}
