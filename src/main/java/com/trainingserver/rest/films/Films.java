package com.trainingserver.rest.films;

import com.orasi.api.restServices.RestResponse;
import com.orasi.api.restServices.RestService;
import com.orasi.api.restServices.Headers.HeaderType;
import com.trainingserver.rest.TrainingServerRest;
import com.trainingserver.rest.films.objects.Film;

public class Films {

	private RestService restService = new RestService();
	private String path = TrainingServerRest.baseURL + "/rest/films/";

	public RestResponse createFilm(Film film) {
		return restService.sendPostRequest(path, HeaderType.JSON, RestService.getJsonFromObject(film));
	}

	public RestResponse deleteFilm(int filmId) {
		//return restService.sendDeleteRequest((path + filmId), HeaderType.JSON);
		return restService.sendDeleteRequest((path + filmId));
	}
	
	public RestResponse deleteFilm(Film film) {
		return restService.sendDeleteRequest(path, HeaderType.JSON);

	}
	
}
