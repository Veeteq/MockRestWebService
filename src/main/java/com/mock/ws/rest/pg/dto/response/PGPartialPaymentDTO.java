package com.mock.ws.rest.pg.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class PGPartialPaymentDTO {

    @JsonProperty(value = "amount")
    private String amount;
    
    @JsonProperty(value = "date")
    private String paidDate;
    
    @JsonProperty(value = "sessionID")
    private String sessionId;
    
    @JsonProperty(value = "state")
    private String state;
    
    @JsonProperty(value = "stateDesc")
    private String stateDescription;
    
    @JsonProperty(value = "rrn")
    private String rrn;

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(String paidDate) {
        this.paidDate = paidDate;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getStateDescription() {
        return stateDescription;
    }

    public void setStateDescription(String stateDescription) {
        this.stateDescription = stateDescription;
    }

    public String getRrn() {
        return rrn;
    }

    public void setRrn(String rrn) {
        this.rrn = rrn;
    }
}
