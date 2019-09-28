package com.mock.ws.rest.bso.model;

import java.time.LocalDateTime;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="REQUESTS_HISTORY")
@AttributeOverride(name="id", column=@Column(name="history_id"))
@SequenceGenerator(name="default_seq", sequenceName="HISTORY_SEQ", allocationSize=1)
public class RequestsHistory extends BaseEntity {

	private static final long serialVersionUID = 1L;
	
	/*TechData*/
	@Column(name="disableCacheWrites")
	private boolean disableCacheWrites;
	
	@Column(name="actionId")
	private String actionId;
	
	@Column(name="correlationId")
	private String correlationId;
	
	@Column(name="disableCacheReads")
	private boolean disableCacheReads;
	
	@Column(name="response_code")
	private String responseCode;
	
	@Column(name="errorDescription")
	private String errorDescription;
	
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
	@Column(name="issueDate")
	private LocalDateTime issueDate;
}
