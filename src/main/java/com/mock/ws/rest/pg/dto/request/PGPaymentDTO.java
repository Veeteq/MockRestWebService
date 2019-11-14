package com.mock.ws.rest.pg.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class PGPaymentDTO {
    
    @JsonProperty(value = "id")
    private String paymentNumber;
    
    @JsonProperty(value = "amount")
    private String amount;
    
    @JsonProperty(value = "kind")
    private String kind;
    
    @JsonProperty(value = "operName")
    private String operName;
    
    @JsonProperty(value = "operType")
    private String operType;
    
    @JsonProperty(value = "type")
    private String type;

    public String getPaymentNumber() {
        return paymentNumber;
    }

    public void setId(String paymentNumber) {
        this.paymentNumber = paymentNumber;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }

    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
