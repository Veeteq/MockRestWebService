package com.mock.ws.rest.bso.validators;

@FunctionalInterface
public interface IValidationForDouble<T1, T2> {

	CheckValidationResult test(T1 param1, T2 param2);
	
}
