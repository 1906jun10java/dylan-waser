package com.revature.exception;

/*
 * custom exception
 */

public class MaintenanceException extends Exception{ //do this to make your own exceptions

	public MaintenanceException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public MaintenanceException(String message, Throwable cause) {
		super(message, cause);
	}

	public MaintenanceException(String message) {
		super(message);
	}

	public MaintenanceException(Throwable cause) {
		super(cause);
	}

	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
			
	public MaintenanceException()
	{
		
	}
}
