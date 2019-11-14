package com.mock.ws.rest.pg.adapter;

import com.mock.ws.rest.bso.service.AgentService;
import com.mock.ws.rest.bso.service.ContractService;
import com.mock.ws.rest.pg.dto.request.PGRequest;
import com.mock.ws.rest.pg.dto.response.PGResponse;
import com.mock.ws.rest.pg.service.PGAgentReportService;
import com.mock.ws.rest.pg.service.PGPayerService;
import com.mock.ws.rest.pg.service.PGPaymentService;

public interface PGProcessingStrategy {

    public void setAgentService(AgentService agentService);
    public void setAgentReportService(PGAgentReportService agentReportService);
    public void setContractService(ContractService contractService);
    public void setPayerService(PGPayerService payerService);
    public void setPaymentService(PGPaymentService paymentService);
    public PGResponse process(PGRequest request);    

}
