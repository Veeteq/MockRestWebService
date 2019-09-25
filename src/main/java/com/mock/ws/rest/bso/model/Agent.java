package com.mock.ws.rest.bso.model;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="agents")
@AttributeOverride(name="id", column=@Column(name="id"))
public class Agent extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name="lnr")
	private long lnr;
	
	@Column(name="skk")
	private long skk;
	
	@Column(name="name")
	private String name;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
