package com.mock.ws.rest.bso.validators;

import java.time.LocalDateTime;

import com.mock.ws.rest.bso.model.Agent;
import com.mock.ws.rest.bso.model.Bso;

public class CheckRequestValidationHelper {

	public static ValidationForSingle<Agent> agentNotNull = ValidationForSingle.from((agent) -> agent != null, "Agent does not exist");
	
	public static ValidationForSingle<Bso> bsoNotNull = ValidationForSingle.from((bso) -> bso != null, "Bso does not exist");
	
	public static ValidationForDouble<Bso, Agent> bsoAssignedToAgent = ValidationForDouble.from((bso, agent) -> bso.getAgent() != agent, "Bso not assigned to Agent");
	
	public static ValidationForDouble<Bso, LocalDateTime> bsoDateIsValid = ValidationForDouble.from((bso, date) -> bso.getUpdateDate() != date, "Check date can not be earlier that document date");
}
