package com.mock.ws.rest.pg.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class PGRequest {

    @JsonProperty(value = "agentReport")
    private PGAgentReportDTO agentReport;
    
    @JsonProperty(value = "contract")
    private PGContractDTO contract;
    
    @JsonProperty(value = "merchant")
    private PGMerchantDTO merchant;
    
    @JsonProperty(value = "payer")
    private PGPayerDTO payer;
    
    @JsonProperty(value = "payment")
    private PGPaymentDTO payment;

    public PGAgentReportDTO getAgentReport() {
        return agentReport;
    }

    public void setAgentReport(PGAgentReportDTO agentReport) {
        this.agentReport = agentReport;
    }

    public PGContractDTO getContract() {
        return contract;
    }

    public void setContract(PGContractDTO contract) {
        this.contract = contract;
    }

    public PGMerchantDTO getMerchant() {
        return merchant;
    }

    public void setMerchant(PGMerchantDTO merchant) {
        this.merchant = merchant;
    }

    public PGPayerDTO getPayer() {
        return payer;
    }

    public void setPayer(PGPayerDTO payer) {
        this.payer = payer;
    }

    public PGPaymentDTO getPayment() {
        return payment;
    }

    public void setPayment(PGPaymentDTO payment) {
        this.payment = payment;
    }
}
