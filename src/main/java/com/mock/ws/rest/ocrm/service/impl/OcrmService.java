package com.mock.ws.rest.ocrm.service.impl;

import org.springframework.stereotype.Service;

import com.mock.ws.rest.ocrm.dto.request.OcrmFeedback;
import com.mock.ws.rest.ocrm.dto.request.OcrmRequest;
import com.mock.ws.rest.ocrm.dto.response.OcrmResponse;
import com.mock.ws.rest.ocrm.service.IOcrmService;

@Service
public class OcrmService implements IOcrmService {

    @Override
    public OcrmResponse processRequest(OcrmRequest request) {
        OcrmResponse ocrmResponse = new OcrmResponse();
        ocrmResponse.setMessageId(request.getBusinessData().getCampaignId());
        ocrmResponse.setResult("OK");
        return ocrmResponse;
    }

    @Override
    public OcrmResponse processRequestArray(OcrmFeedback[] request) {
        OcrmResponse ocrmResponse = new OcrmResponse();
        ocrmResponse.setMessageId(request[0].getMessageId());
        ocrmResponse.setResult("OK");
        return ocrmResponse;
    }
}
