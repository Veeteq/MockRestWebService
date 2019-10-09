package com.mock.ws.rest.bso.service;

import com.mock.ws.rest.bso.dto.request.BsoDTO;
import com.mock.ws.rest.bso.dto.request.Request;
import com.mock.ws.rest.bso.dto.response.Response;
import com.mock.ws.rest.bso.model.Agent;
import com.mock.ws.rest.bso.model.Bso;

public interface IBsoService {

    Bso save(BsoDTO bsoDTO);

    void addBsoToAgent(BsoDTO bsoDTO, Agent agent);

    Response processRequest(Request request);

}