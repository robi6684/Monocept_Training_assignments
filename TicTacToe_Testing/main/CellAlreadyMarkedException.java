package com.monocept.tictactoe;

public class CellAlreadyMarkedException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String getMessage() {
		
		return "Cell is already Marked";
	}

}
