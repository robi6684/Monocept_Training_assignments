package com.monocept.tictactoe;

public class InvalidLocationException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String getMessage() {
		
		return "Invalid Location";
	}
}
