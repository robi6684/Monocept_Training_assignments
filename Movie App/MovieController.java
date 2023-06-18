package com.monocept.movieapp;

import java.util.List;
import java.util.Scanner;

public class MovieController {

	private MovieManager manager;
	Scanner scanner = new Scanner(System.in);

	public MovieController(MovieManager manager) {
		super();
		this.manager = manager;
	}
	
	public void start() {
		displayMenu();
	}

	private void displayMenu() {
		
		int choice = 0;
		
		do {
			System.out.println("Choose the following");
			System.out.println("1. Add Movie");
			System.out.println("2. Clear Movie");
			System.out.println("3. Get Movie");
			System.out.println("4. Get Movie By ID");
			System.out.println("5. Exit");
			choice = scanner.nextInt();
			
			switch(choice) {
			case 1: 
				Movie movie = setMovieDetails();
				manager.addMovie(movie);
				manager.saveMovie();
				break;
			case 2:
				manager.clearMovies();
				manager.saveMovie();
				break;
			case 3:
				List<Movie> movies = manager.getMovies();
				movies.stream().forEach((name) -> System.out.println(name));
				break;
			case 4:
				System.out.println("Enter Movie ID");
				int id = scanner.nextInt();
				manager.getMovieById(id);
				break;
			case 5:
				System.exit(0);
				break;
			default:
				System.exit(0);
			
			}
		
		}
		while(choice != 5);
		
		
	}
	private Movie setMovieDetails() {
		System.out.println("Enter Movie ID");
		int id = scanner.nextInt();
		
		System.out.println("Enter Movie Year");
		int year = scanner.nextInt();
		
		System.out.println("Enter Movie Name");
		String name = scanner.nextLine();
		
		scanner.nextLine();
		
		System.out.println("Enter Movie Genre");
		String genre = scanner.nextLine();
		
		return new Movie(id,name,year,genre);
		
	}

}
