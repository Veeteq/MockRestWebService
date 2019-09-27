package com.mock.ws.rest.bso.model;

public enum Status {
	
	N (1, "Not used"),
	//2("Not used"),
	//3("Not used"),
	U (4, "Used"),
	R (5, "Returned");
		
	private final int code;
	private final String description;
	
	private Status(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}
}
