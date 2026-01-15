package com.st.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.st.exception.SaleNotFoundException;
import com.st.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(SaleNotFoundException.class)
	public ResponseEntity<ApiResponse<Void>> handleSaleNotFound(SaleNotFoundException ex){
		
		ApiResponse<Void> response = ApiResponse.error(ex.getMessage(), "SALE_NOT_FOUND");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
	
}
