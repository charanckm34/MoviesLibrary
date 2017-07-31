package com.movies.demo.rest;

import java.util.ArrayList;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import javax.ws.rs.GET;

import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.web.client.RestTemplate;

@Named
@Path("/")



public class MovieRest {
	
	
	
private static List<Movie> movieList = new ArrayList<Movie>();
	
	static {
		
		Movie m1 = new Movie();
		m1.setMovieTitle("Dunkirk");
		m1.setMovieLanguage("English");
		m1.setMovieYear("2017");
		
		
		Movie m2 = new Movie();
		m2.setMovieTitle("Deadpool");
		m2.setMovieLanguage("English");
		m2.setMovieYear("2016");
		
		Movie m3 = new Movie();
		m3.setMovieTitle("Spotlight");
		m3.setMovieLanguage("English");
		m3.setMovieYear("2015");
		
		Movie m4 = new Movie();
		m4.setMovieTitle("Spiderman - Homecoming");
		m4.setMovieLanguage("English");
		m4.setMovieYear("2017");
		
		Movie m5 = new Movie();
		m5.setMovieTitle("Suicide squard");
		m5.setMovieLanguage("English");
		m5.setMovieYear("2016");
	
		movieList.add(m1);
		movieList.add(m2);
		movieList.add(m3);
		movieList.add(m4);
		movieList.add(m5);
		
		
	}
	

	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> getMovies() {
	return movieList;
	}
	
	
	
	
	@GET
	@Path("Movie")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Movie> getmovieList(@QueryParam("year") String year) {

		List<Movie> movieByYear = new ArrayList<Movie>();

	System.out.println("Year " + year);
	for (Movie m : movieList) {
		System.out.println(m.getMovieYear());
		if (m.getMovieYear().equals(year)) {
			System.out.println("Inside List "+ m.getMovieYear());
			movieByYear.add(m);
		}

		if (movieByYear.isEmpty())
		{
			System.out.println("No Match Found");
		}			
	}
	return movieByYear;
//	movieByYear.add( movieList.get(0));
//	return movieByYear;
	}	
}