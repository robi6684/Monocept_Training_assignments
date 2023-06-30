package com.monocept.unittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayerTest {
	
	Player player;
	
	@BeforeEach
	void init() {
		player = new Player();
	}

	@Test
	void testMarkCell() {
		Board board = new Board();
		assertEquals(1,player.markCell(board, 4, 1, MarkType.X));
	}

}
