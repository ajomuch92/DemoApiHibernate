package com.agile.hibernate.exception;

public class PersonNotFoundException extends Exception{
	
	private static final long serialVersionUID = -6027920450941198645L;

	public PersonNotFoundException(int id) {
		super("Person with id = " + id + " was not found");
	}
}
