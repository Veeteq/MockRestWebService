package com.mock.ws.rest.bso.validators;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.mock.ws.rest.bso.model.Agent;
import com.mock.ws.rest.bso.model.Bso;

public class ValidationForBso implements ValidationRule {

	@Override
	public void validate(Optional<Agent> agent, List<Bso> bsoList, LocalDateTime issueDate) {
		if(bsoList.size() == 0) {
			throw new IllegalArgumentException("Bso not found");
		}
		if(bsoList.size() > 1) {
			throw new IllegalArgumentException("Non-unique Bso found");
		}
	}
}
