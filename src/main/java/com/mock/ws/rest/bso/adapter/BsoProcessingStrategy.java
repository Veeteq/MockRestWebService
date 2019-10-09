package com.mock.ws.rest.bso.adapter;

import com.mock.ws.rest.bso.dto.request.Request;
import com.mock.ws.rest.bso.dto.response.Response;

public interface BsoProcessingStrategy {

    public Response process(Request request);
}
