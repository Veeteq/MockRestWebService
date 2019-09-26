package com.mock.ws.rest.bso.dto.response;

import com.mock.ws.rest.bso.dto.TechData;

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
