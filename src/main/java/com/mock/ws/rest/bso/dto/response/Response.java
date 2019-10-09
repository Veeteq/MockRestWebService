package com.mock.ws.rest.bso.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.mock.ws.rest.bso.dto.TechData;

@JsonInclude(value = Include.NON_NULL)
public class Response {

	private TechData techData;
	private BusinessData businessData;

	public TechData getTechData() {
		return techData;
	}

	public void setTechData(TechData techData) {
		this.techData = techData;
	}

	public BusinessData getBusinessData() {
		return businessData;
	}

	public void setBusinessData(BusinessData businessData) {
		this.businessData = businessData;
	}
}
