package com.mock.ws.rest.pg.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class PGContractDTO {

    @JsonProperty(value = "amount")
    private String contractAmount;
    
    @JsonProperty(value = "date")
    private String contractDate;
    
    @JsonProperty(value = "number")
    private String contractNumber;
    
    @JsonProperty(value = "series")
    private String contractSeries;

    public String getContractAmount() {
        return contractAmount;
    }

    public void setContractAmount(String contractAmount) {
        this.contractAmount = contractAmount;
    }

    public String getContractDate() {
        return contractDate;
    }

    public void setContractDate(String contractDate) {
        this.contractDate = contractDate;
    }

    public String getContractNumber() {
        return contractNumber;
    }

    public void setContractNumber(String contractNumber) {
        this.contractNumber = contractNumber;
    }

    public String getContractSeries() {
        return contractSeries;
    }

    public void setContractSeries(String contractSeries) {
        this.contractSeries = contractSeries;
    }
}
