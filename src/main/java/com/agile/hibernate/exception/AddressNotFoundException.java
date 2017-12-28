package com.agile.hibernate.exception;

public class AddressNotFoundException extends Exception{

	private static final long serialVersionUID = 304028800925927209L;
	
	public AddressNotFoundException(int id) {
		super("The address with id="+id+" was not found");
	}

}
