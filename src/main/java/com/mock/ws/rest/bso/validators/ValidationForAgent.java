package com.mock.ws.rest.bso.validators;

import java.util.function.Predicate;

public class ValidationForSingle<T> implements IValidationForSingle<T>{

	private Predicate<T> predicate;
	private String onErrorMessage;
	
	public static <T> ValidationForSingle<T> from(Predicate<T> predicate, String onErrorMessage) {
		return new ValidationForSingle<T>(predicate, onErrorMessage);
	}
	
	private ValidationForSingle(Predicate<T> predicate, String onErrorMessage) {
		this.predicate = predicate;
		this.onErrorMessage = onErrorMessage;
	}
	
	@Override
	public CheckValidationResult test(T param) {
		return predicate.test(param) ? CheckValidationResult.ok() : CheckValidationResult.fail(onErrorMessage);
	}
}
