package com.capgemini.stockmanagement.exception;

public class InvestorException extends RuntimeException {

	String message;

	public InvestorException(String message) {
		this.message = message;

	}

	public String getMessage() {
		return this.message;
	}
}
