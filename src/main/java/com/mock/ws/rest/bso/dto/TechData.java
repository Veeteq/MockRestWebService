package com.mock.ws.rest.bso.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(value = Include.NON_NULL)
public class TechData {

	private boolean disableCacheWrites;
	private String actionId;
	private String correlationId;
	private boolean disableCacheReads;
	private String responseCode;
	private String errorDescription;

	public boolean isDisableCacheWrites() {
		return disableCacheWrites;
	}

	public void setDisableCacheWrites(boolean disableCacheWrites) {
		this.disableCacheWrites = disableCacheWrites;
	}

	public String getActionId() {
		return actionId;
	}

	public void setActionId(String actionId) {
		this.actionId = actionId;
	}

	public String getCorrelationId() {
		return correlationId;
	}

	public void setCorrelationId(String correlationId) {
		this.correlationId = correlationId;
	}

	public boolean isDisableCacheReads() {
		return disableCacheReads;
	}

	public void setDisableCacheReads(boolean disableCacheReads) {
		this.disableCacheReads = disableCacheReads;
	}

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}
}
