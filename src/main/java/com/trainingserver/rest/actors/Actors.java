package com.trainingserver.rest.actors;

import com.orasi.api.restServices.Headers.HeaderType;
import com.orasi.api.restServices.RestResponse;
import com.orasi.api.restServices.RestService;
import com.trainingserver.rest.TrainingServerRest;
import com.trainingserver.rest.actors.objects.Actor;

public class Actors {

	private RestService restService = new RestService();
	private String path = TrainingServerRest.baseURL + "/rest/actors";

	public RestResponse createActor(Actor actor) {
		return restService.sendPostRequest(path, HeaderType.JSON, RestService.getJsonFromObject(actor));
	}
}

//	public RestResponse getAllActors(Actor actor) {
//		return restService.sendGetRequest(path + "/", HeaderType.JSON);
//
//	}
//
//	public RestResponse getActorsByFirstname(Actor actor) {
//		return restService.sendGetRequest(path + "/first_name" + actor.getFirstName(), HeaderType.JSON);
//
//	}
//
//	public RestResponse deleteActor(Actor actor) {
//		return restService.sendGetRequest(path + "/first_name" + actor.getActorID(), HeaderType.JSON);
//
//	}
//
//	public RestResponse updateActor(Actor actor) {
//
//		return restService.sendGetRequest(path + "/first_name" + actor.getActorID(), HeaderType.JSON ,
//				RestService.getJsonFromObject(actor));
//		//return restService.sendGetRequest(path + "/first_name" + actor.getActorID(), HeaderType.JSON);
//
//	}
