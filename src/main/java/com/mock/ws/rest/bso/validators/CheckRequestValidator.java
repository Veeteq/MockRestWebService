package com.mock.ws.rest.bso.validators;

import java.time.LocalDateTime;

import com.mock.ws.rest.bso.model.Agent;
import com.mock.ws.rest.bso.model.Bso;

public class CheckRequestValidator {
	
	public static CheckValidationResult validateRequest(Agent agent, Bso bso, LocalDateTime checkDate) {
		CheckValidationResult validationResult; 
		
		validationResult = CheckRequestValidationHelper.agentNotNull.test(agent);
		if(!validationResult.isValid()) {
			return validationResult;
		}
		
		validationResult = CheckRequestValidationHelper.bsoNotNull.test(bso);
		if(!validationResult.isValid()) {
			return validationResult;
		}
		
		validationResult = CheckRequestValidationHelper.bsoAssignedToAgent.test(bso, agent);
		if(!validationResult.isValid()) {
			return validationResult;
		}
		
		validationResult = CheckRequestValidationHelper.bsoDateIsValid.test(bso, checkDate);
		if(!validationResult.isValid()) {
			return validationResult;
		}
		
		return validationResult;
	}
}
