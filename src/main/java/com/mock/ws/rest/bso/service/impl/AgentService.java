package com.mock.ws.rest.bso.service.impl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

	private Logger logger = LoggerFactory.getLogger(AgentService.class);
	private AgentRepository agentRepository;

	@Autowired
	public AgentService(AgentRepository agentRepository) {
		this.agentRepository = agentRepository;
	}

	@Override
	public List<Agent> findAll() {
	    return agentRepository.findAll();
	}
	
	public Agent updateAgent(Agent agent, AgentDTO agentDTO) {
	    agentRepository.findById(agent.getId());
	    agent.setMiddleName(agentDTO.getMiddleName());
	    return agentRepository.save(agent);
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
		logger.info("AgentService.getAgentByCode: " + code);
		return agentRepository.findByCode(code);
	}
}
