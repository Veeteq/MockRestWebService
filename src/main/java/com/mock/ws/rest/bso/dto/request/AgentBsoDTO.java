package com.mock.ws.rest.bso.dto.request;

public class AgentBsoDTO {

	private long lnr;
	private long skk;
	private BsoDTO[] bso;

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

	public BsoDTO[] getBso() {
		return bso;
	}

	public void setBso(BsoDTO[] bso) {
		this.bso = bso;
	}
}
