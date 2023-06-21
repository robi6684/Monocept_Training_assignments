package com.monocept.tictactoe;

public class Cell {
	@SuppressWarnings("unused")
	private MarkType mark;
	
	public Cell(){
		mark = MarkType.EMPTY;
	}
	
	public boolean isEmpty() {
		if(mark == MarkType.EMPTY)
			return true;
		return false;
	}
	public MarkType getMark() {
		return mark;
	}
	public void setMark(MarkType mark) {
		this.mark = mark;
	}
}
