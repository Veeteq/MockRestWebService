package com.mock.ws.rest.bso.validators;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.mock.ws.rest.bso.model.Agent;
import com.mock.ws.rest.bso.model.Bso;
import com.mock.ws.rest.bso.model.BsoStatus;

public class ValidationForCheckDate implements ValidationRule {

	@Override
	public void validate(Optional<Agent> agent, List<Bso> bsoList, BsoStatus bsoStatus, LocalDateTime checkDate) {
		Bso bso = bsoList.get(0);
		if(bso.getUpdateDate().toLocalDate().isAfter(checkDate.toLocalDate())) {
			throw new IllegalArgumentException("Дата выдачи БСО не может быть ранее даты смены статуса БСО");
		}
	}
}
