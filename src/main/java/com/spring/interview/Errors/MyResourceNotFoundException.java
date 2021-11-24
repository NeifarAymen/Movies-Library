package com.spring.interview.Errors;

public final class MyResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8353413476942819467L;

	public MyResourceNotFoundException() {
		super();
	}

	public MyResourceNotFoundException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public MyResourceNotFoundException(final String message) {
		super(message);
	}

	public MyResourceNotFoundException(final Throwable cause) {
		super(cause);
	}

}
