package com.mock.ws.rest.bso.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="bso")
@AttributeOverride(name="id", column=@Column(name="id"))
public class Bso extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name="series")
	private String series;
	
	@Column(name="number")
	private int number;
	
	@Column(name="type")
	private int type;
	
	@Column(name="status")
	private int status;

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
