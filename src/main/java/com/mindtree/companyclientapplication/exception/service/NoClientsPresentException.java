package com.mindtree.companyclientapplication.exception.service;

import com.mindtree.companyclientapplication.exception.ServiceException;

public class NoClientsPresentException extends ServiceException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoClientsPresentException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public NoClientsPresentException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public NoClientsPresentException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public NoClientsPresentException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NoClientsPresentException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
