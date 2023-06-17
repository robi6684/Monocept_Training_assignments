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
		//loadMovies();
	}

	public void addMovie(Movie movie) {
		movies.add(movie);
		
	}
	public void clearMovies() {
		movies.clear();
	}
	public List<Movie> getMovies(){
		return movies;
		
	}
	public int getMovieId(Movie movie) {
		return movie.getId();
		
	}
	public void loadMovies() throws IOException, ClassNotFoundException {
		
		FileInputStream fileIn = new FileInputStream(filePath);
		ObjectInputStream input = new ObjectInputStream(fileIn);
		
		for(int i=0; i<3; i++) {
			movies.add((Movie) input.readObject());
		}

		input.close();
		fileIn.close();
		
	}
	public void saveMovie() throws IOException {
		FileOutputStream file = new FileOutputStream(filePath);
		ObjectOutputStream out = new ObjectOutputStream(file);
		
		for(Movie movie : movies) {
			out.writeObject(movie);
			out.writeObject(movie);
		}
		out.close();
		System.out.println("Movies saved in file");
	}
	

}
