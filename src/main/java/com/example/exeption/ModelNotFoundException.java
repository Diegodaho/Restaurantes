package com.example.exeption;

public class ModelNotFoundException extends RuntimeException {
	
	
	private static final long serialVersionUID = 1L;

	public ModelNotFoundException(String message) {
		super(message);	
	}

}
