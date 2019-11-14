package com.mock.ws.rest.pg.adapter;

import java.util.Optional;

import com.mock.ws.rest.bso.builder.ContractBuilder;
import com.mock.ws.rest.bso.model.Agent;
import com.mock.ws.rest.bso.model.Contract;
import com.mock.ws.rest.bso.model.PGAgentReport;
import com.mock.ws.rest.bso.model.PGPayer;
import com.mock.ws.rest.bso.model.PGExpectedPayment;
import com.mock.ws.rest.pg.builder.AgentBuilder;
import com.mock.ws.rest.pg.builder.AgentReportBuilder;
import com.mock.ws.rest.pg.builder.PGPayerBuilder;
import com.mock.ws.rest.pg.builder.PGPaymentBuilder;
import com.mock.ws.rest.pg.dto.request.PGAgentReportDTO;
import com.mock.ws.rest.pg.dto.request.PGContractDTO;
import com.mock.ws.rest.pg.dto.request.PGMerchantDTO;
import com.mock.ws.rest.pg.dto.request.PGPayerDTO;
import com.mock.ws.rest.pg.dto.request.PGPaymentDTO;
import com.mock.ws.rest.pg.dto.request.PGRequest;
import com.mock.ws.rest.pg.dto.response.PGResponse;

public class PGProcessingSetStrategy extends PGProcessingAbstractStrategy {

    @Override
    public PGResponse process(PGRequest requestBody) {
        PGAgentReportDTO agentReportDTO = requestBody.getAgentReport();
        PGContractDTO contractDTO = requestBody.getContract();
        PGMerchantDTO merchantDTO = requestBody.getMerchant();
        PGPayerDTO payerDTO = requestBody.getPayer();
        PGPaymentDTO paymentDTO = requestBody.getPayment();
        
        Long lnr = Long.parseLong(merchantDTO.getInn());
        Long skk = Long.parseLong(merchantDTO.getCkk());

        Optional<Agent> agent = agentService.getAgentByLnrAndSkk(lnr, skk);
        if(!agent.isPresent()) {
            agent = AgentBuilder.buildAgent(lnr, skk);
            agent = agentService.save(agent.get());
        }
        
        Contract contract = null;
        if(contractDTO != null) {
            contract = contractService.findBySeriesAndNumber(contractDTO.getContractSeries(), contractDTO.getContractNumber());
            if(contract == null) {
                contract = ContractBuilder.buildContract(contractDTO);
                contract = contractService.save(contract);
            }
        }
        
        PGAgentReport agentReport = agentReportService.findByReportNumber(agentReportDTO.getNumber());
        if(agentReport == null) {
            agentReport = AgentReportBuilder.buildAgentReport(agentReportDTO);
            agentReport = agentReportService.save(agentReport);
        }

        PGPayer payer = payerService.findByEmail(payerDTO.getEmail());
        if(payer == null) {
            payer = PGPayerBuilder.buildPayer(payerDTO);
            payer = payerService.save(payer);
        }
        
        PGExpectedPayment payment = paymentService.findByPaymentNumer(paymentDTO.getPaymentNumber());
        if(payment == null) {
            payment = PGPaymentBuilder.buildPayment(paymentDTO);
            payment.setAgentReport(agentReport);
            payment.setAgent(agent.get());
            payment.setContract(contract);
            payment.setPayer(payer);
            payment = paymentService.save(payment);
        }

        return generateSetResponse();
    }

}
