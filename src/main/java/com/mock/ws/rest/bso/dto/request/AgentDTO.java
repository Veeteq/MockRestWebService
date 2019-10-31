package com.mock.ws.rest.bso.dto.request;

public class AgentDTO {

	private long code;
	private long lnr;
	private long skk;
	private String firstName;
	private String middleName;
	private String lastName;

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

	public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
