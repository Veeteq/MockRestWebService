package com.mock.ws.rest.bso.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.AttributeOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="AGENTS")
@AttributeOverride(name="id", column=@Column(name="AGENT_ID"))
@SequenceGenerator(name="default_seq", sequenceName="AGENT_SEQ", allocationSize=1)
public class Agent extends BaseEntity {

	private static final long serialVersionUID = 1L;
	private static final String DELIMITER = " ";

	@Column(name="CODE")
	private Long code;

	@Column(name="LNR")
	private Long lnr;
	
	@Column(name="SKK")
	private Long skk;
	
	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	@OneToMany(cascade=CascadeType.ALL, mappedBy="agent")
	private Set<Bso> bsoDocuments = new HashSet<>();

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public Long getLnr() {
		return lnr;
	}

	public void setLnr(Long lnr) {
		this.lnr = lnr;
	}

	public Long getSkk() {
		return skk;
	}

	public void setSkk(Long skk) {
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

	public String getName() {
		return Arrays.asList(this.firstName, this.lastName)
		.stream()
		.filter(el -> el != null).collect(Collectors.joining(DELIMITER));
	}
}
