package com.mock.ws.rest.bso.dto;

public class BusinessData {

	private BsoDTO bso;
	private AgentDTO agent;
	private String issueDate;

	public BsoDTO getBso() {
		return bso;
	}

	public void setBso(BsoDTO bso) {
		this.bso = bso;
	}

	public AgentDTO getAgent() {
		return agent;
	}

	public void setAgent(AgentDTO agent) {
		this.agent = agent;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
}
