package com.mock.ws.rest.bso.validators;

@FunctionalInterface
public interface IValidationForSingle<T> {

	CheckValidationResult test(T param);
	
	default IValidationForSingle<T> and (IValidationForSingle<T> other) {
	     return (param) -> {
	    	 CheckValidationResult firstResult = this.test(param);
	       return !firstResult.isValid() ? firstResult : other.test(param);
	     };
	   }

}
