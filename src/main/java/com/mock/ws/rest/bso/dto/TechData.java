package com.mock.ws.rest.bso.dto;

public class TechData {

	private boolean disableCacheWrites;
	private String actionId;
	private String correlationId;
	private boolean disableCacheReads;

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

	public boolean getDisableCacheReads() {
		return disableCacheReads;
	}

	public void setDisableCacheReads(boolean disableCacheReads) {
		this.disableCacheReads = disableCacheReads;
	}
}
