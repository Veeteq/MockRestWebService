package com.mock.ws.rest.pg.builder;

import java.util.Optional;

import com.mock.ws.rest.bso.model.Agent;

public class AgentBuilder {

    public static Optional<Agent> buildAgent(Long lnr, Long skk) {
        Agent agent = new Agent();
        agent.setLnr(lnr);
        agent.setSkk(skk);        
        return Optional.of(agent);
    }
}
