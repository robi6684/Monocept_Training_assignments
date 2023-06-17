package com.monocept.movieapp;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class MovieController {

	private MovieManager manager;

	public MovieController(MovieManager manager) {
		super();
		this.manager = manager;
	}
	
	public void start() {
		displayMenu();
	}

	private void displayMenu() {
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		
		do {
			System.out.println("Choose the following");
			System.out.println("1. Add Movie");
			System.out.println("2. Clear Movie");
			System.out.println("3. Get Movie");
			System.out.println("4. Get Movie ID");
			System.out.println("5. Load Movie");
			System.out.println("6. Save Movie");
			System.out.println("7. Exit");
			choice = scanner.nextInt();
			
			switch(choice) {
			case 1: 
				manager.addMovie(new Movie(1,"Matrix",1999,"Science Fiction"));
				break;
			case 2:
				manager.clearMovies();
				break;
			case 3:
				List<Movie> movies = manager.getMovies();
				movies.stream().forEach((movie) -> System.out.println(movie));
				break;
			case 4:
				System.out.println(manager.getMovieId(new Movie(1,"Matrix",1999,"Science Fiction")));
				break;
			case 5:
				try {
					manager.loadMovies();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				break;
			case 6:
				try {
					manager.saveMovie();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
			case 7:
				System.exit(0);
				break;
			default:
				System.exit(0);
			
			}
		
		}
		while(choice != 7);
		scanner.close();
		
	}
//	private void setMovieDetails() {
//		
//	}

}
