package com.mock.ws.rest.bso.model;

import java.time.LocalDateTime;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(schema="REST", name="BSO_ISSUANCES")
@AttributeOverride(name="id", column=@Column(name="bsoissuance_id"))
@SequenceGenerator(name="default_seq", sequenceName="bsoissuance_seq", allocationSize=1)
public class BsoIssuance extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name="bso_id")
	private Bso bso;
	
	@Column(name="agent_id")
	private Agent agent;
	
	@Column(name="issue_date", columnDefinition="DATE", nullable=false)
	@CreationTimestamp	
	private LocalDateTime issueDate;

	@Column(name="status")
	@Enumerated(value = EnumType.STRING)
	private Status status = Status.N;
	
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

	public LocalDateTime getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDateTime issueDate) {
		this.issueDate = issueDate;
	}
}
