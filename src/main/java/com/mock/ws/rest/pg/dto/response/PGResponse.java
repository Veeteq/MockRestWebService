package com.mock.ws.rest.pg.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(value = Include.ALWAYS)
public class PGResponse {

    @JsonProperty(value = "result")
    private boolean result;
    
    @JsonProperty(value = "error")
    private PGErrorDTO pgError;

    @JsonProperty(value = "payID")
    private String payID;
    
    @JsonProperty(value = "amount")
    private String amount;
    
    @JsonProperty(value = "partSum")
    private String partSum;
    
    @JsonProperty(value = "part")
    private PGPartialPaymentDTO[] partialPayments;
    
    @JsonProperty(value = "status")
    private PGStatusDTO status;
    
    public boolean getResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public PGErrorDTO getPgError() {
        return pgError;
    }

    public void setPgError(PGErrorDTO pgError) {
        this.pgError = pgError;
    }

    public String getPayID() {
        return payID;
    }

    public void setPayID(String payID) {
        this.payID = payID;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getPartSum() {
        return partSum;
    }

    public void setPartSum(String partSum) {
        this.partSum = partSum;
    }

    public PGPartialPaymentDTO[] getPartialPayments() {
        return partialPayments;
    }

    public void setPartialPayments(PGPartialPaymentDTO[] partialPayments) {
        this.partialPayments = partialPayments;
    }

    public PGStatusDTO getStatus() {
        return status;
    }

    public void setStatus(PGStatusDTO status) {
        this.status = status;
    }
}
