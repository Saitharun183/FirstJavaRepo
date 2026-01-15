package com.st.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse<T> {
	
	private boolean success;
	
	private String message;
	
	private T data;
	
	private String errorCode;
	
	private LocalDateTime timestamp;
	
	//Static because you are creating a new object here not using an existing one
	public static <T> ApiResponse<T> success(T data, String message) {
	    return new ApiResponse<T>(true, message, data, null, LocalDateTime.now());
	}

	public static <T> ApiResponse<T> error(String message, String errorCode) {
	    return new ApiResponse<T>(false, message, null, errorCode, LocalDateTime.now());
	}
	
}
