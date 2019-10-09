package com.mock.ws.rest.bso.adapter;

import com.mock.ws.rest.bso.dto.request.Request;
import com.mock.ws.rest.bso.dto.response.Response;

public class BsoProcessingAdapter {

    public BsoProcessingAdapter() {
    }

    public Response process(Request request, BsoProcessingStrategy processingStrategy) {        
        return processingStrategy.process(request);
    }
}
