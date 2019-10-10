package com.mock.ws.rest.bso.dto.request;

public class BusinessData {

	private BsoDTO bso;
	private AgentDTO agent;
	private ContractDTO contract;
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

    public ContractDTO getContract() {
        return contract;
    }

    public void setContract(ContractDTO contract) {
        this.contract = contract;
    }
}
