package com.mock.ws.rest.bso.adapter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import com.mock.ws.rest.bso.builder.BsoIssuanceBuilder;
import com.mock.ws.rest.bso.builder.ContractBuilder;
import com.mock.ws.rest.bso.dto.request.AgentDTO;
import com.mock.ws.rest.bso.dto.request.BsoDTO;
import com.mock.ws.rest.bso.dto.request.ContractDTO;
import com.mock.ws.rest.bso.dto.request.Request;
import com.mock.ws.rest.bso.dto.response.Response;
import com.mock.ws.rest.bso.model.Agent;
import com.mock.ws.rest.bso.model.Bso;
import com.mock.ws.rest.bso.model.BsoIssuance;
import com.mock.ws.rest.bso.model.BsoStatus;
import com.mock.ws.rest.bso.model.Contract;
import com.mock.ws.rest.bso.validators.CheckRequestValidator;
import com.mock.ws.rest.utils.DateUtils;

public class BsoProcessingUpdateStrategy extends BsoProcessingAbstractStrategy {

    @Override
    @Transactional
    public Response process(Request request) {
        Response response = new Response();

        actionId = UUID.fromString(request.getTechData().getActionId());
        correlationId = UUID.fromString(request.getTechData().getCorrelationId());
        
        AgentDTO agentDTO = request.getBusinessData().getAgent();
        BsoDTO bsoDTO = request.getBusinessData().getBso();
        ContractDTO contractDTO = request.getBusinessData().getContract();
        
        Optional<Agent> agent = agentRepository.findByLnrAndSkk(agentDTO.getLnr(), agentDTO.getSkk());
        List<Bso> bsoList = bsoRepository.findBySeriesAndNumberAndType(bsoDTO.getSeries(), bsoDTO.getNumber(), bsoDTO.getType());
        BsoStatus newStatus = BsoStatus.getByCode(Integer.parseInt(bsoDTO.getStatus()));
        
        LocalDateTime checkDate = DateUtils.parse(request.getBusinessData().getIssueDate());

        try {       
            CheckRequestValidator.validateRequest(agent, bsoList, newStatus, checkDate);

            Contract contract = null;
            LocalDateTime issueDate = LocalDateTime.now();
            Bso bso = bsoList.get(0);
            bso.setStatus(newStatus);
            bso.setUpdateDate(issueDate);
            if(newStatus == BsoStatus.USED) {
                contract = contractRepository.findBySeriesAndNumber(contractDTO.getSeries(), contractDTO.getNumber());
                if(contract == null) {
                    contract = ContractBuilder.buildContract(contractDTO);
                }
                bso.setContract(contract);
            } else {
                bso.setContract(null);
            }
            Bso savedBso = bsoRepository.save(bso);

            BsoIssuance bsoIssuance = BsoIssuanceBuilder.buildBsoIssuance(agent, savedBso);
            bsoIssuanceRepository.save(bsoIssuance);
        } catch (RuntimeException exc) {
            return generateErrorResponse(response, exc.getMessage());
        }
        
        return generateSuccessResponse(response);
    }
}
