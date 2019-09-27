package com.mock.ws.rest.bso.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema="REST", name="AGENTS")
@AttributeOverride(name="id", column=@Column(name="agent_id"))
@SequenceGenerator(name="default_seq", sequenceName="agent_seq", allocationSize=1)
public class Agent extends BaseEntity {

	private static final long serialVersionUID = 1L;

	@Column(name="code")
	private long code;

	@Column(name="lnr")
	private long lnr;
	
	@Column(name="skk")
	private long skk;
	
	@Column(name="firstName")
	private String firstName;

	@Column(name="lastName")
	private String lastName;

	@OneToMany(cascade=CascadeType.ALL, mappedBy="agent")
	private Set<Bso> bsoDocuments = new HashSet<>();

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
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

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<Bso> getBsoDocuments() {
		return bsoDocuments;
	}

	public void setBsoDocuments(Set<Bso> bsoDocuments) {
		this.bsoDocuments = bsoDocuments;
	}
	
	public void addBso(Bso bso) {
		bso.setAgent(this);
		bsoDocuments.add(bso);
	}
}
