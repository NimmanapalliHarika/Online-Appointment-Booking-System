package com.twg.sprg.rest.Exception;

public class UserNotFoundException extends RuntimeException {
	
	public UserNotFoundException(long id) {
		super("User with ID " + id + " not found.");
	}
	

}
