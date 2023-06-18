package com.monocept.movieapp;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MovieManager {
	
	private List<Movie> movies;
	private static final String filePath="C:\\Users\\robi6\\OneDrive\\Desktop\\Monocept Training\\Assignments\\07-solidprinciples-app\\src\\com\\monocept\\movieapp\\File";
	
	public MovieManager() throws ClassNotFoundException, IOException {
		movies = new ArrayList<>();
		loadMovies();
	}

	public void addMovie(Movie movie) {
		movies.add(movie);
		System.out.println("Movies added successfully");
		
	}
	public void clearMovies() {
		movies.clear();
		System.out.println("Movies Cleared");
	}
	public List<Movie> getMovies(){
		return movies;
		
	}
	public void getMovieById(int id) {
		
		movies.stream().filter((movie) -> movie.getId() == id).forEach((movie) -> System.out.println(movie));;
		
	}
	@SuppressWarnings("unchecked")
	public void loadMovies(){
		
		try {
		FileInputStream fileIn = new FileInputStream(filePath);
		ObjectInputStream input = new ObjectInputStream(fileIn);
		
		movies = (List<Movie>) input.readObject();

		input.close();
		fileIn.close();
		}
		catch(Exception e) {
			System.out.println("Movies Loaded");
		}
		
	}
	public void saveMovie()  {
		try {
			FileOutputStream file = new FileOutputStream(filePath);
			ObjectOutputStream out = new ObjectOutputStream(file);
			
			out.writeObject(movies);
			out.close();
		
		}
		catch(Exception e) {
			System.out.println("Movies saved in file");
		}
	}
	

}
