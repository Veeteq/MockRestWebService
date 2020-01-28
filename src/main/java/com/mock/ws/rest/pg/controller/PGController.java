package com.mock.ws.rest.pg.controller;

import java.time.LocalDateTime;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mock.ws.rest.bso.model.PGExpectedPayment;
import com.mock.ws.rest.bso.model.PGPartialPayment;
import com.mock.ws.rest.bso.service.AgentService;
import com.mock.ws.rest.bso.service.ContractService;
import com.mock.ws.rest.pg.adapter.PGProcessingAdapter;
import com.mock.ws.rest.pg.adapter.PGProcessingCheckStrategy;
import com.mock.ws.rest.pg.adapter.PGProcessingDelStrategy;
import com.mock.ws.rest.pg.adapter.PGProcessingSetStrategy;
import com.mock.ws.rest.pg.dto.request.PGRequest;
import com.mock.ws.rest.pg.dto.response.PGResponse;
import com.mock.ws.rest.pg.service.PGAgentReportService;
import com.mock.ws.rest.pg.service.PGPayerService;
import com.mock.ws.rest.pg.service.PGPaymentService;

@Controller
@RequestMapping(path = "/gw")
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

    @RequestMapping(value = "/pay/check", method = RequestMethod.POST, consumes="application/json", produces="application/json")
    public ResponseEntity<PGResponse> check(@RequestBody PGRequest requestBody, HttpServletRequest request) {
        logger.info(request.toString());
        
        PGProcessingAdapter processingAdapter = new PGProcessingAdapter(paymentService);
        PGResponse response = processingAdapter.process(requestBody, new PGProcessingCheckStrategy());
        return new ResponseEntity<PGResponse>(response, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/pay/set", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON, produces=MediaType.APPLICATION_JSON)
    public ResponseEntity<PGResponse> set(@RequestBody PGRequest requestBody, HttpServletRequest request) {
        logger.info(request.toString());

        PGProcessingAdapter processingAdapter = new PGProcessingAdapter(agentReportService, agentService, contractService, payerService, paymentService);
        PGResponse response = processingAdapter.process(requestBody, new PGProcessingSetStrategy());
        
        return new ResponseEntity<PGResponse>(response, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/pay/del", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON, produces=MediaType.APPLICATION_JSON)
    public ResponseEntity<PGResponse> del(@RequestBody PGRequest requestBody, HttpServletRequest request) {
        logger.info(request.toString());

        PGProcessingAdapter processingAdapter = new PGProcessingAdapter(agentReportService, agentService, contractService, payerService, paymentService);
        PGResponse response = processingAdapter.process(requestBody, new PGProcessingDelStrategy());
        
        return new ResponseEntity<PGResponse>(response, HttpStatus.OK);
    }

    @GetMapping(path = "/expectedpayments")
    public String displayExpectedPaymentsList(Model model) {
        logger.info("PGController: displayExpectedPaymentsList");
        
        model.addAttribute("expectedPayments", paymentService.findAll());
        
        return "listExpectedPayments";
    }
    
    @GetMapping(path = "/expectedpayment/{id}/pay")
    public String displayExpectedPaymentPayForm(@PathVariable String id, Model model) {
        logger.info("PGController: displayExpectedPaymentsList");
        
        
        
        Long longId = Long.parseLong(id);
        PGExpectedPayment expectedPayment = paymentService.findById(longId);
        
        PGPartialPayment partialPayment = null;
        if(expectedPayment.getPayments().size() > 0) {
          partialPayment = expectedPayment.getPayments().iterator().next();
        }
        
        if(partialPayment == null) {
            String rrn = generateRandomNumber(8);
            
            partialPayment = new PGPartialPayment();
            partialPayment.setExpectedPayment(expectedPayment);
            partialPayment.setAmount(expectedPayment.getAmount());
            partialPayment.setPaidDateTime(LocalDateTime.now());
            partialPayment.setSessionID("IPT687000344ID_" + expectedPayment.getPaymentNumber());
            partialPayment.setState("3");
            partialPayment.setStateDescription("Успешно");
            partialPayment.setRrn(rrn);
            expectedPayment.addPartialPayment(partialPayment);
        }
        
        model.addAttribute("partialPayment", partialPayment);
        
        return "payExpectedPaymentForm";
    }

    @PostMapping(path = "/expectedpayment/{id}/pay")
    public String addOrUpdateExpectedPaymentPayFormPost(@PathVariable String id, @ModelAttribute(name = "partialPayment") PGPartialPayment partialPayment, BindingResult result, Model model) {
        logger.info("PGController: addOrUpdateExpectedPaymentPayFormPost");
        
        logger.info(partialPayment.getExpectedPayment().getPaymentNumber());
        
        Long longId = Long.parseLong(id);
        PGExpectedPayment expectedPayment = paymentService.findById(longId);
        expectedPayment.addPartialPayment(partialPayment);
        paymentService.save(expectedPayment);
        
        return "redirect:/rest/gw/expectedpayments";
    }
    
    private String generateRandomNumber(int i) {
        Random rnd = new Random();
        int n1 = 30000 + rnd.nextInt(70000);
        int n2 = rnd.nextInt(100000);
        return n1 + String.format("%05d", n2);
    }    
}
