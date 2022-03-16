package com.cap.DA.exception;

/*
 * This is the Exception class which handles NoDoctorsFound Exception
 */
public class NoDoctorsFound extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public NoDoctorsFound(String message) {
		super(message);
	}

}
