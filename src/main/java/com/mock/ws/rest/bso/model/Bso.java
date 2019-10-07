package com.mock.ws.rest.bso.model;

import java.time.LocalDateTime;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="BSO")
@AttributeOverride(name="id", column=@Column(name="BSO_ID"))
@SequenceGenerator(name="default_seq", sequenceName="BSO_SEQ", allocationSize=1)
public class Bso extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name="BSO_SERIES")
	private String series;
	
	@Column(name="BSO_NUMBER")
	private String number;
	
	@Column(name="TYPE")
	private String type;
	
	@Column(name="STATUS")
	private Status status;

	@Column(name="UPDATE_DATE", columnDefinition="TIMESTAMP", nullable=false)
	@CreationTimestamp
	private LocalDateTime updateDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AGENT_ID", nullable=false)
	private Agent agent;
	
	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
}
