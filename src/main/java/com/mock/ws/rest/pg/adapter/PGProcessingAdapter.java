package com.mock.ws.rest.pg.adapter;

import com.mock.ws.rest.bso.service.AgentService;
import com.mock.ws.rest.bso.service.ContractService;
import com.mock.ws.rest.pg.dto.request.PGRequest;
import com.mock.ws.rest.pg.dto.response.PGResponse;
import com.mock.ws.rest.pg.service.PGAgentReportService;
import com.mock.ws.rest.pg.service.PGPayerService;
import com.mock.ws.rest.pg.service.PGPaymentService;

public class PGProcessingAdapter {

    private PGAgentReportService agentReportService;
    private AgentService agentService;
    private ContractService contractService;
    private PGPayerService payerService;
    private PGPaymentService paymentService;

    public PGProcessingAdapter(PGAgentReportService agentReportService, AgentService agentService, ContractService contractService, PGPayerService payerService, PGPaymentService paymentService) {
        this.agentReportService = agentReportService;
        this.agentService = agentService;
        this.contractService = contractService;
        this.payerService = payerService;
        this.paymentService = paymentService;
    }

    public PGProcessingAdapter(PGPaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public PGResponse process(PGRequest request, PGProcessingStrategy processingStrategy) {
        processingStrategy.setAgentReportService(agentReportService);
        processingStrategy.setAgentService(agentService);
        processingStrategy.setContractService(contractService);
        processingStrategy.setPayerService(payerService);
        processingStrategy.setPaymentService(paymentService);
        return processingStrategy.process(request);
    }
}
