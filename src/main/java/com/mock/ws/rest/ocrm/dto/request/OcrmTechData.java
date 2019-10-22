package com.mock.ws.rest.ocrm.dto.request;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OcrmTechData {

    @JsonProperty(value = "actionId")
    private UUID actionId;
    
    @JsonProperty(value = "correlationId")
    private UUID carrelationId;
}
