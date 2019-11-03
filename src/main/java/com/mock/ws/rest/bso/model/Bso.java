package com.mock.ws.rest.bso.model;

import java.time.LocalDateTime;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.CreationTimestamp;

import com.mock.ws.rest.utils.BsoStatusConverter;

@Entity
@Table(name="BSO", uniqueConstraints = {@UniqueConstraint(columnNames = {"BSO_SERIES", "BSO_NUMBER"}, name = "UK_BSO_SERIES_NUMBER_INDEX_1")})
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
	@Convert(converter = BsoStatusConverter.class)
	private BsoStatus status;

	@Column(name="UPDATE_DATE", columnDefinition="TIMESTAMP", nullable=false)
	@CreationTimestamp
	private LocalDateTime updateDate;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AGENT_ID", nullable=false)
	private Agent agent;

	@ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name="POLICY_ID", nullable=true)
	private Contract contract;
	
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

	public BsoStatus getStatus() {
		return status;
	}

	public void setStatus(BsoStatus status) {
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

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }
}
