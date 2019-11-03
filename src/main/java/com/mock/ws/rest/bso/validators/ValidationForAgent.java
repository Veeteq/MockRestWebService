package com.mock.ws.rest.bso.validators;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.mock.ws.rest.bso.model.Agent;
import com.mock.ws.rest.bso.model.Bso;
import com.mock.ws.rest.bso.model.BsoStatus;

public class ValidationForAgent implements ValidationRule{

	@Override
	public void validate(Optional<Agent> agent, List<Bso> bsoList, BsoStatus bsoStatus, LocalDateTime issueDate) {
		if(!agent.isPresent()) {
			throw new IllegalArgumentException("Agent not found");
		}
	}
}
