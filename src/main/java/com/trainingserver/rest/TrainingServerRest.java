package com.trainingserver.rest;

import com.trainingserver.rest.actors.Actors;

public class TrainingServerRest {

	public static String baseURL = "https://training-server.herokuapp.com";

	public static Actors actors() {
		return new Actors();
	}
}
