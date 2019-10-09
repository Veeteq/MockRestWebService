package com.mock.ws.rest.bso.validators;

import java.util.function.BiPredicate;

public class ValidationForDouble<T1, T2> implements IValidationForDouble<T1, T2>{

	private BiPredicate<T1, T2> biPredicate;
	private String onErrorMessage;
	
	public static <T1, T2> ValidationForDouble<T1, T2> from(BiPredicate<T1, T2> biPredicate, String onErrorMessage) {
		return new ValidationForDouble<T1, T2>(biPredicate, onErrorMessage);
	}
	
	private ValidationForDouble(BiPredicate<T1, T2> biPredicate, String onErrorMessage) {
		this.biPredicate = biPredicate;
		this.onErrorMessage = onErrorMessage;
	}
	
	@Override
	public CheckValidationResult test(T1 param1, T2 param2) {
		return biPredicate.test(param1, param2) ? CheckValidationResult.ok() : CheckValidationResult.fail(onErrorMessage);

	}
}
