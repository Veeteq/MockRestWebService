package com.mock.ws.rest.bso.validators;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.mock.ws.rest.bso.model.Agent;
import com.mock.ws.rest.bso.model.Bso;

public class CheckRequestValidator {
	
	public static CheckValidationResult validateRequest(Optional<Agent> agent, List<Bso> bsoList, LocalDateTime checkDate) {
		List<ValidationRule> rules = new ArrayList<>();
		 rules.add(new ValidationForAgent());
		 rules.add(new ValidationForBso());
		 rules.add(new ValidationForAgentAndBso());
		 rules.add(new ValidationForCheckDate());
		 rules.add(new ValidationForBsoStatus());
		 
		 for (ValidationRule rule : rules){
		  rule.validate(agent, bsoList, checkDate);
		 }
		 return CheckValidationResult.ok();
	}
}
