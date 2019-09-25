package com.mock.ws.rest.bso.dto;

public class Notification {

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
