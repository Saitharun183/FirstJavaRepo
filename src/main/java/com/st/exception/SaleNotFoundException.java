package com.st.exception;

@SuppressWarnings("serial")
public class SaleNotFoundException extends RuntimeException {
	
	public SaleNotFoundException(String message) {
		super(message);
	}
	
}
