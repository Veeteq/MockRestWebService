package com.mock.ws.rest.bso.service;

import java.util.List;

import com.mock.ws.rest.bso.dto.request.BsoDTO;
import com.mock.ws.rest.bso.dto.request.Request;
import com.mock.ws.rest.bso.dto.response.Response;
import com.mock.ws.rest.bso.model.Agent;
import com.mock.ws.rest.bso.model.Bso;

public interface BsoService {

    List<Bso> findAll();
    
    Bso save(BsoDTO bsoDTO);

    void addBsoToAgent(BsoDTO bsoDTO, Agent agent);

    Response processCheckRequest(Request request);

    Response processUpdateRequest(Request request);
}