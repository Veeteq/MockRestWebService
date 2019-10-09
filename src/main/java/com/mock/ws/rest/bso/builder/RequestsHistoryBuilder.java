package com.mock.ws.rest.bso.builder;

import org.springframework.beans.BeanUtils;

import com.mock.ws.rest.bso.dto.request.Request;
import com.mock.ws.rest.bso.model.RequestsHistory;
import com.mock.ws.rest.bso.model.TechData;
import com.mock.ws.rest.utils.DateUtils;

public class RequestsHistoryBuilder {

	public static RequestsHistory buildRequestHistory(Request request) {
		RequestsHistory requestsHistory = new RequestsHistory();
		
		TechData techData = new TechData();		
		BeanUtils.copyProperties(request.getTechData(), techData, "actionId", "correlationId");
		techData.setActionId(request.getTechData().getActionId());
		techData.setCorrelationId(request.getTechData().getCorrelationId());
		requestsHistory.setTechData(techData);
		
		BeanUtils.copyProperties(request.getBusinessData().getAgent(), requestsHistory);
		BeanUtils.copyProperties(request.getBusinessData().getBso(), requestsHistory);
		
		requestsHistory.setIssueDate(DateUtils.parse(request.getBusinessData().getIssueDate()));
		return requestsHistory;
	}

}
