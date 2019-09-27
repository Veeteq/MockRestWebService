package com.mock.ws.rest.bso.validators;

public class CheckValidationResult {

	private boolean valid;
	private String messsage;

	private CheckValidationResult(boolean valid, String messsage) {
		this.valid = valid;
		this.messsage = messsage;
	}

	public boolean isValid() {
		return valid;
	}

	public String getMesssage() {
		return messsage;
	}

	public static CheckValidationResult ok() {
		return new CheckValidationResult(true, "OK");

	}

	public static CheckValidationResult fail(String message) {
		return new CheckValidationResult(true, message);
	}
	
	public void throwIfInvalid() {
		if(!isValid()) throw new IllegalArgumentException(messsage);
	}
}
