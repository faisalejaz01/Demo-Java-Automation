package com.trainingserver.rest;

import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.orasi.api.restServices.RestResponse;
import com.orasi.utils.TestReporter;
import com.trainingserver.rest.actors.objects.Actor;

public class TestActors {

	@Test
	public void testCreateActor() {
		String firstName = "ERNEST";
		String lastName = "BORGNINE";

		Actor actor = new Actor();
		actor.setFirstName(firstName);
		actor.setLastName(lastName);

		RestResponse response = TrainingServerRest.actors().createActor(actor);
		// System.out.print(response.getResponse());
		actor = response.mapJSONToObject(Actor.class);

		TestReporter.logAPI(response.getStatusCode() == 201, "Validating correct response", response);
		AssertJUnit.assertEquals(actor.getFirstName(), firstName);
		AssertJUnit.assertEquals(actor.getLastName(), lastName);

	}

}
