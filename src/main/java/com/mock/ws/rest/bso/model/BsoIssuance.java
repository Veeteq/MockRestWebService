package com.mock.ws.rest.bso.model;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="bso_issuances")
@AttributeOverride(name="id", column=@Column(name="id"))
@SequenceGenerator(name="default_seq", sequenceName="bsoissuance_seq", allocationSize=1)
public class BsoIssuance extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name="bso_id")
	private Bso bso;
	
	@Column(name="agent_id")
	private Agent agent;
	
	@Column(name="issue_date")
	private Date issueDate;

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

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
}
