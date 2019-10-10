package com.mock.ws.rest.bso.validators;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.mock.ws.rest.bso.model.Agent;
import com.mock.ws.rest.bso.model.Bso;
import com.mock.ws.rest.bso.model.Status;

@FunctionalInterface
public interface ValidationRule {
    void validate(Optional<Agent> agent, List<Bso> bsoList, Status bsoStatus, LocalDateTime issueDate);
}
