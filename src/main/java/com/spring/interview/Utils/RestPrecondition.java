package com.spring.interview.Utils;

import com.spring.interview.Errors.MyResourceNotFoundException;

public final class RestPrecondition {

	private RestPrecondition() {
		throw new AssertionError();
	}

	public static void checkFound(final boolean expression, String message) {
		if (!expression) {
			throw new MyResourceNotFoundException("message");
		}
	}

	public static <T> T checkFound(final T resource) {
		if (resource == null) {
			throw new MyResourceNotFoundException();
		}
		return resource;
	}

	public static <T> T checkFound(final T resource, String message) {
		if (resource == null) {
			throw new MyResourceNotFoundException(message);
		}
		return resource;
	}

}
