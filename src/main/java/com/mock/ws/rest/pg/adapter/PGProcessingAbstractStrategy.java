package com.mock.ws.rest.pg.adapter;

import com.mock.ws.rest.bso.model.PGExpectedPayment;
import com.mock.ws.rest.bso.service.AgentService;
import com.mock.ws.rest.bso.service.ContractService;
import com.mock.ws.rest.pg.builder.PGResponseBuilder;
import com.mock.ws.rest.pg.dto.response.PGResponse;
import com.mock.ws.rest.pg.service.PGAgentReportService;
import com.mock.ws.rest.pg.service.PGPayerService;
import com.mock.ws.rest.pg.service.PGPaymentService;

public abstract class PGProcessingAbstractStrategy implements PGProcessingStrategy {

    protected AgentService agentService;
    protected ContractService contractService;
    protected PGAgentReportService agentReportService;
    protected PGPayerService payerService;
    protected PGPaymentService paymentService;

    @Override
    public void setAgentService(AgentService agentService) {
        this.agentService = agentService;
    }

    @Override
    public void setAgentReportService(PGAgentReportService agentReportService) {
        this.agentReportService = agentReportService;
    }

    @Override
    public void setContractService(ContractService contractService) {
        this.contractService = contractService;
    }

    @Override
    public void setPayerService(PGPayerService payerService) {
        this.payerService = payerService;
    }

    @Override
    public void setPaymentService(PGPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    protected PGResponse generateErrorResponse(String expectedPaymentNumber, PGProcessingResult result) {
        String errDescription = result.getDescription().replace(":expectedPaymentNumber", expectedPaymentNumber);
        return PGResponseBuilder.build()
                .withResult(false)
                .withError(errDescription, result.getCode())
                .withPart(null)
                .buildResponse();
    }
    
    protected PGResponse generateSuccessResponse(PGExpectedPayment expectedPayment) {
        return PGResponseBuilder.build()
                .withResult(expectedPayment.isFullyPaid())
                .withError("", 0)
                .withPayID(expectedPayment.getPaymentNumber())
                .withAmount(expectedPayment.getAmount())
                .withPartSum(expectedPayment.sumOfPartialPayments())
                .withPart(expectedPayment.getPayments())
                .withStatus()
                .buildResponse();
    }
    
    protected PGResponse generateSetResponse() {
        return PGResponseBuilder.build()
                .withError("Correct", 0)
                .buildResponse();
    }
}
