package com.geekshow.exception;

public class ApplicationException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ApplicationException() {

	}

	public ApplicationException(String msg) {
		super(msg);
	}

	public ApplicationException(String msg, Throwable t) {
		super(msg, t);
	}
}
