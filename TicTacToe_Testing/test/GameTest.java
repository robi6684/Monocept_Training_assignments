package com.monocept.unittesting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Scanner;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {
	
	Game game;
	
	@BeforeEach
	void init() {
		game = new Game();
	}

	@Test
	void testPlayGame() {
		Scanner scanner = new Scanner(System.in);
		Player player = new Player();
		ResultAnalyser result = new ResultAnalyser();
		Board board = new Board();
		
		assertEquals(0,game.playGame(scanner, player, board, result, MarkType.O));
	}

}
