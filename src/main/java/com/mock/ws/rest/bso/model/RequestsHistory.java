package com.mock.ws.rest.bso.model;

import java.time.LocalDateTime;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="REQUESTS_HISTORY")
@AttributeOverride(name="id", column=@Column(name="history_id"))
@SequenceGenerator(name="default_seq", sequenceName="HISTORY_SEQ", allocationSize=1)
public class RequestsHistory extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	@Embedded
	private TechData techData;
		
	/*Agent*/
	@Column(name="lnr")
	private long lnr;
	
	@Column(name="skk")
	private long skk;
	
	/*BSO*/
	@Column(name="bso_series")
	private String series;
	
	@Column(name="bso_number")
	private String number;
	
	@Column(name="bso_type")
	private String type;
	
	/*IssueDate*/
	@Column(name="issue_date")
	private LocalDateTime issueDate;

	public TechData getTechData() {
		return techData;
	}

	public void setTechData(TechData techData) {
		this.techData = techData;
	}

	public long getLnr() {
		return lnr;
	}

	public void setLnr(long lnr) {
		this.lnr = lnr;
	}

	public long getSkk() {
		return skk;
	}

	public void setSkk(long skk) {
		this.skk = skk;
	}

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

	public LocalDateTime getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDateTime issueDate) {
		this.issueDate = issueDate;
	}
}
