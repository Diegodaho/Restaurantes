package com.example.exeption;

public class NoHandlerFoundException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoHandlerFoundException(String message) {
		super(message);	
	}


}
