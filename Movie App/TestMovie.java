package com.monocept.movieapp;

import java.io.IOException;

public class TestMovie {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		MovieManager manager = new MovieManager();
		MovieController controller = new MovieController(manager);
		
		controller.start();

	}

}
