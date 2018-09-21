package com.trainingserver.rest;

import java.util.ArrayList;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;
import com.trainingserver.rest.films.objects.Film;
import com.trainingserver.rest.films.Films;

public class TestFilms {

	@Test
	public void createFilmTest() {

		String title = "Rest Api";
		String description = "Rest Api Testing";
		String language = "English";
		String originalLanguage = "English";
		String category = "Horror";
		String rating = "R";

		int releaseYear = 2018;
		int length = 60;
		double replacementCost = 9.99;
		int rentalDuration = 2;

		double rentalRate = 4.99;

		String specialFeatures = "{Trailers, Deleted Scenes}" ;
		ArrayList<String> actors = new ArrayList<String>();

		Film film = new Film();

		film.setTitle(title);
		film.setDescription(description);
		film.setLanguage(language);
		film.setOriginalLanguage(originalLanguage);
		film.setCategory(category);
		film.setRating(rating);
		film.setReleaseYear(releaseYear);
		film.setLength(length);
		film.setReplacementCost(replacementCost);
		film.setRentalDuration(rentalDuration);
		film.setRentalRate(rentalRate);
		film.setSpecialFeatures(specialFeatures);
		film.setActors(actors);

		RestResponse response = ((Films) TrainingServerRest.films()).createFilm(film);

		//System.out.println(response.getResponse());
		System.out.println("Server Response : " + response.getStatusCode());
		
		film = response.mapJSONToObject(Film.class);

		TestReporter.logAPI(response.getStatusCode() == 200, "Validating correct response", response);
		
		 AssertJUnit.assertEquals(film.getCategory(), category);
		 AssertJUnit.assertEquals(film.getTitle(), title);

	}
}
