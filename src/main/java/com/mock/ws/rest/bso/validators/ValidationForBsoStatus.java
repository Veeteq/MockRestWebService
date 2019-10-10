package com.mock.ws.rest.bso.validators;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.mock.ws.rest.bso.model.Agent;
import com.mock.ws.rest.bso.model.Bso;
import com.mock.ws.rest.bso.model.Status;

public class ValidationForBsoStatus implements ValidationRule {

    @Override
    public void validate(Optional<Agent> agent, List<Bso> bsoList, Status bsoStatus, LocalDateTime issueDate) {
        Bso bso = bsoList.get(0);
        Status currentStatus = bso.getStatus();
        
        ValidationResult result = currentStatus.checkIfValid(bsoStatus);
        if(!result.isValid()) {
            throw new IllegalArgumentException(result.getMesssage());
        }
    }
}
