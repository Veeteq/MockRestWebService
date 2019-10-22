package com.mock.ws.rest.ocrm.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OcrmFeedback {

    @JsonProperty(value = "message_id")
    private String messageId;
    private String state;
    private String status_id;
    private String owner_card_id;
    private String branch_skk_code;
    private String completedat;

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStatus_id() {
        return status_id;
    }

    public void setStatus_id(String status_id) {
        this.status_id = status_id;
    }

    public String getOwner_card_id() {
        return owner_card_id;
    }

    public void setOwner_card_id(String owner_card_id) {
        this.owner_card_id = owner_card_id;
    }

    public String getBranch_skk_code() {
        return branch_skk_code;
    }

    public void setBranch_skk_code(String branch_skk_code) {
        this.branch_skk_code = branch_skk_code;
    }

    public String getCompletedat() {
        return completedat;
    }

    public void setCompletedat(String completedat) {
        this.completedat = completedat;
    }
}
