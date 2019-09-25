package com.mock.ws.rest.bso.dto;

public class BusinessData {

	private Bso bso;
	private Agent agent;
	private String issueDate;

	public Bso getBso() {
		return bso;
	}

	public void setBso(Bso bso) {
		this.bso = bso;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public String getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(String issueDate) {
		this.issueDate = issueDate;
	}
}
