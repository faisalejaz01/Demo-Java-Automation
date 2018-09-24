package com.trainingserver.rest;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;
import com.trainingserver.rest.films.objects.Film;
import com.trainingserver.rest.films.objects.Film2;
import com.trainingserver.rest.films.Films;
import com.orasi.api.restServices.RestService;
import com.cedarsoftware.util.io.JsonWriter;

public class TestFilms {

	//@Test(priority = 1)
	@Test(enabled = false)
	public void createFilmTest() {

		String title = "Rest Api";
		String description = "Rest Api Testing";
		String language = "English";
		String originalLanguage = "English";
		String category = "Horror";
		String rating = "R";
		String specialFeatures = "{Trailers, Deleted Scenes}";

		int releaseYear = 2018;
		int length = 60;
		double replacementCost = 9.99;
		int rentalDuration = 2;

		double rentalRate = 4.99;

		String[] actors = { "1", "2" };

		Film film = new Film();
		Film2 film2 = new Film2();

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
		System.out.println("Payload from object : ");
		System.out.println(RestService.getJsonFromObject(film) + "\n");

//---------------DEBUGGING--------------------
//		film2 = RestService.readJsonFromFile("C:\\Users\\Qualitest\\Desktop\\Practice\\Demo-Java-Automation-api_SOAP\\json.txt", Film.class);
//		System.out.println(film2.getActors());
//		System.out.println(RestService.getJsonFromObject(film2));
//		System.out.println(film2.getRentalRate());
//---------------DEBUGGING--------------------

		System.out.println("Server Response : ");
		System.out.println(JsonWriter.formatJson(response.getResponse()));

		System.out.println("HTTP STATUS: " + response.getStatusCode());

		film2 = response.mapJSONToObject(Film2.class);

		TestReporter.logAPI(response.getStatusCode() == 200, "Validating correct response", response);
		AssertJUnit.assertEquals(film2.getCategory(), category);
		AssertJUnit.assertEquals(film2.getTitle(), title);

	}
	
	@Test(priority = 2)
	public void deleteFilmTest() {
		int count = 999;
		
		//while (count<1050) {
		int filmId = count;
		
		RestResponse response = ((Films) TrainingServerRest.films()).deleteFilm(filmId);
				
		System.out.print("Payload : ");
		System.out.println(response.getURL());		
		
		System.out.print("Server Response : ");
		System.out.print(response.getResponse());

		System.out.println(", HTTP STATUS: " + response.getStatusCode() + "\n");
		count++;
		TestReporter.logAPI(response.getStatusCode() == 200, "Validating correct response", response);

		//}
		
	}

}
