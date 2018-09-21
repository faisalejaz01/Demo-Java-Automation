package com.trainingserver.rest;

import com.trainingserver.rest.actors.Actors;
import com.trainingserver.rest.films.Films;

public class TrainingServerRest {

	public static String baseURL = "https://training-server.herokuapp.com";

	public static Actors actors() {
		return new Actors();
	}

	public static Object films() {
		return new Films();
	}
}
