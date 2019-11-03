package com.mock.ws.rest.bso.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class Response {

	private TechDataResponse techData;
	private BusinessData businessData;

	public TechDataResponse getTechData() {
		return techData;
	}

	public void setTechData(TechDataResponse techData) {
		this.techData = techData;
	}

	public BusinessData getBusinessData() {
		return businessData;
	}

	public void setBusinessData(BusinessData businessData) {
		this.businessData = businessData;
	}
}
