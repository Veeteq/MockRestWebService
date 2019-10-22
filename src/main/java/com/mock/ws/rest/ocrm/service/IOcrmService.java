package com.mock.ws.rest.ocrm.service;

import com.mock.ws.rest.ocrm.dto.request.OcrmFeedback;
import com.mock.ws.rest.ocrm.dto.request.OcrmRequest;
import com.mock.ws.rest.ocrm.dto.response.OcrmResponse;

public interface IOcrmService {

    OcrmResponse processRequest(OcrmRequest requestBody);
    OcrmResponse processRequestArray(OcrmFeedback[] request);
}
