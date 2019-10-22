package com.mock.ws.rest.ocrm.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OcrmRequest {

    @JsonProperty(value = "businessData")
    OcrmBusinessData businessData;

    @JsonProperty(value = "techData")
    OcrmTechData techData;

    public OcrmBusinessData getBusinessData() {
        return businessData;
    }

    public void setBusinessData(OcrmBusinessData businessData) {
        this.businessData = businessData;
    }

    public OcrmTechData getTechData() {
        return techData;
    }

    public void setTechData(OcrmTechData techData) {
        this.techData = techData;
    }
}
