package com.spring.interview.Errors;

import java.io.Serializable;

public class ErrorVM implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3207033280287462565L;

	
	private final String message;
	
	private final String description;

	public ErrorVM(String message) {
		this(message,null);
	}

	public ErrorVM(String message, String description) {
		this.message = message;
		this.description = description;
	}

	public String getMessage() {
		return message;
	}

	public String getDescription() {
		return description;
	}
	
	
	
}
