package com.trainingserver.soapservices;

import org.testng.annotations.Test;

import com.orasi.utils.TestReporter;
import com.services.actor.operations.GetActorsById;
import com.services.actor.operations.UpdateActorRequest;

public class TestSoapService_Actors {

	private String excelFileLocation;

	@Test(priority = 1)
	public void testGetActorsById() {
		excelFileLocation = "src/main/resources/excelsheets/getActorsById.xlsx";

		// Enter an actor id to test.
		String testID = "5";

		System.out.println("Actor ID: " + testID);

		GetActorsById classd = new GetActorsById();
		classd.setActorId(testID);
		classd.sendRequest();
		System.out.println("Results: " + classd.getResponse());

		System.out.println("Server Response: " + classd.getResponseStatusCode());

		TestReporter.logAPI((classd.getResponseStatusCode() == "200"),
				classd.getNumberOfResults() + " results were returned", classd);

		TestReporter.assertTrue(classd.validateResponse(excelFileLocation, "Main"),
				"Validate Response for testGetActorsById");

		// TestReporter.logAPI((classd.getNumberOfResults() != 0),
		// classd.getNumberOfResults() + " results were returned", classd);
	}

	@Test(priority = 2)
	public void updateActorRequestTest() {

		String actorID = "3";
		String firstName = "Tom";
		String lastName = "Hardy";

		System.out.println("Actor ID: " + actorID);
		System.out.println("First Name: " + firstName);
		System.out.println("Last Name: " + lastName);

		UpdateActorRequest classd = new UpdateActorRequest();

		classd.setActorId(actorID);
		classd.setActorFirstName(firstName);
		classd.setActorLastName(lastName);

		classd.sendRequest();

		System.out.println("\n" + "Response: \n" + classd.getResponse());

		System.out.println("Server Response: " + classd.getResponseStatusCode());

		TestReporter.logAPI((classd.getResponseStatusCode() == "200"),
				classd.getNumberOfResults() + " results were returned", classd);
	}

}
