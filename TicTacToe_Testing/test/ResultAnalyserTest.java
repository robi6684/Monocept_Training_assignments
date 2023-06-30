package com.monocept.unittesting;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ResultAnalyserTest {
	
	ResultAnalyser result;
	
	@BeforeEach
	void init() {
		result = new ResultAnalyser();
	}

	@Test
	void testCheckWinPlayer1() {
		Board board = new Board();
		Cell[][] cell = board.getCell();
		
		cell[0][0].setMark(MarkType.O);
		cell[1][1].setMark(MarkType.O);
		cell[2][2].setMark(MarkType.O);
		
		assertTrue(result.checkWinPlayer1(cell));
	}

	@Test
	void testCheckWinPlayer2() {
		Board board = new Board();
		Cell[][] cell = board.getCell();
		
		cell[0][0].setMark(MarkType.X);
		cell[1][1].setMark(MarkType.X);
		cell[2][2].setMark(MarkType.X);
		
		assertTrue(result.checkWinPlayer2(cell));
	}

}
