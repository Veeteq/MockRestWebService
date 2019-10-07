package com.mock.ws.rest.bso.model;

import java.time.LocalDateTime;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="BSO_ISSUANCES")
@AttributeOverride(name="id", column=@Column(name="BSOISSUANCE_ID"))
@SequenceGenerator(name="default_seq", sequenceName="BSOISSUANCE_SEQ", allocationSize=1)
public class BsoIssuance extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="BSO_ID", nullable=false)
	private Bso bso;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AGENT_ID", nullable=false)
	private Agent agent;
	
	@Column(name="ISSUE_DATE", columnDefinition="DATE", nullable=false)
	@CreationTimestamp	
	private LocalDateTime issueDate;

	@Column(name="STATUS")
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
