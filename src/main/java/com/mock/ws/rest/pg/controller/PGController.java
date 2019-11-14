package com.mock.ws.rest.pg.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mock.ws.rest.bso.service.AgentService;
import com.mock.ws.rest.bso.service.ContractService;
import com.mock.ws.rest.pg.adapter.PGProcessingAdapter;
import com.mock.ws.rest.pg.adapter.PGProcessingCheckStrategy;
import com.mock.ws.rest.pg.adapter.PGProcessingSetStrategy;
import com.mock.ws.rest.pg.dto.request.PGRequest;
import com.mock.ws.rest.pg.dto.response.PGResponse;
import com.mock.ws.rest.pg.service.PGAgentReportService;
import com.mock.ws.rest.pg.service.PGPayerService;
import com.mock.ws.rest.pg.service.PGPaymentService;

@Controller
@RequestMapping(path = "/gw/pay")
public class PGController {
    private static final Logger logger = LoggerFactory.getLogger(PGController.class);

    private PGAgentReportService agentReportService;
    private AgentService agentService;
    private ContractService contractService;
    private PGPayerService payerService;
    private PGPaymentService paymentService;

    @Autowired
    public PGController(PGAgentReportService agentReportService, AgentService agentService, ContractService contractService, PGPayerService payerService, PGPaymentService paymentService) {
        this.agentReportService = agentReportService;
        this.agentService = agentService;
        this.contractService = contractService;
        this.payerService = payerService;
        this.paymentService = paymentService;
    }

    @RequestMapping(value = "/check", method = RequestMethod.POST, consumes="application/json", produces="application/json")
    public ResponseEntity<PGResponse> check(@RequestBody PGRequest requestBody, HttpServletRequest request) {
        logger.info(request.toString());
        
        PGProcessingAdapter processingAdapter = new PGProcessingAdapter(paymentService);
        PGResponse response = processingAdapter.process(requestBody, new PGProcessingCheckStrategy());
        return new ResponseEntity<PGResponse>(response, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/set", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON, produces=MediaType.APPLICATION_JSON)
    public ResponseEntity<PGResponse> set(@RequestBody PGRequest requestBody, HttpServletRequest request) {
        logger.info(request.toString());

        PGProcessingAdapter processingAdapter = new PGProcessingAdapter(agentReportService, agentService, contractService, payerService, paymentService);
        PGResponse response = processingAdapter.process(requestBody, new PGProcessingSetStrategy());
        
        return new ResponseEntity<PGResponse>(response, HttpStatus.OK);
    }
}
