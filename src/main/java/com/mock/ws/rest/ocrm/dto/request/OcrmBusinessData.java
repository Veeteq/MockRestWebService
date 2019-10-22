package com.mock.ws.rest.ocrm.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonPropertyOrder(alphabetic = true, value = { "campaignId", "feedback" })
public class OcrmBusinessData {

    @JsonProperty(value = "campaignId")
    private String campaignId;

    @JsonProperty(value = "feedback")
    private OcrmFeedback[] feedback;

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public OcrmFeedback[] getFeedback() {
        return feedback;
    }

    public void setFeedback(OcrmFeedback[] feedback) {
        this.feedback = feedback;
    }
}
