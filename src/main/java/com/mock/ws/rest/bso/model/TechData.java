package com.mock.ws.rest.bso.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class TechData {

	/*TechData*/
	@Column(name="disable_cache_writes")
	private boolean disableCacheWrites;
	
	@Column(name="action_id", columnDefinition = "uuid")
	private UUID actionId;
	
	@Column(name="correlation_id", columnDefinition = "uuid")
	private UUID correlationId;
	
	@Column(name="disable_cache_reads")
	private boolean disableCacheReads;
	
	@Column(name="response_code")
	private String responseCode;
	
	@Column(name="error_description")
	private String errorDescription;

	public boolean isDisableCacheWrites() {
		return disableCacheWrites;
	}

	public void setDisableCacheWrites(boolean disableCacheWrites) {
		this.disableCacheWrites = disableCacheWrites;
	}

	public UUID getActionId() {
		return actionId;
	}

	public void setActionId(UUID actionId) {
		this.actionId = actionId;
	}

	public void setActionId(String actionId) {
		this.actionId = UUID.fromString(actionId);
	}

	public UUID getCorrelationId() {
		return correlationId;
	}

	public void setCorrelationId(UUID correlationId) {
		this.correlationId = correlationId;
	}

	public void setCorrelationId(String correlationId) {
		this.correlationId = UUID.fromString(correlationId);
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
