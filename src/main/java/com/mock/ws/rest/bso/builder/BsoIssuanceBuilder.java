package com.mock.ws.rest.bso.builder;

import java.util.Optional;

import com.mock.ws.rest.bso.model.Agent;
import com.mock.ws.rest.bso.model.Bso;
import com.mock.ws.rest.bso.model.BsoIssuance;

public class BsoIssuanceBuilder {

    public static BsoIssuance buildBsoIssuance(Optional<Agent> agent, Bso bso) {
        BsoIssuance bsoIssuance = new BsoIssuance();
        bsoIssuance.setAgent(agent.get());
        bsoIssuance.setBso(bso);
        bsoIssuance.setContract(bso.getContract());
        bsoIssuance.setIssueDate(bso.getUpdateDate());
        bsoIssuance.setStatus(bso.getStatus());
        return bsoIssuance;
    }
}
