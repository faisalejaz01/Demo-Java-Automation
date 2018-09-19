package com.trainingserver.soapservices;

import org.testng.annotations.Test;

import com.orasi.utils.TestReporter;
import com.services.actor.operations.GetActorsById;
import com.services.actor.operations.UpdateActorRequest;

public class TestSoapService_Actors {

	private String excelFileLocation;

	@Test(priority = 1)
	public void getActorsByIdTest() {
		excelFileLocation = "src/main/resources/excelsheets/getActorsById.xlsx";

		// Enter an actor id to test.
		String testID = "5";
		System.out.println("getActorsByIdTest : Actor ID " + testID);

		GetActorsById classd = new GetActorsById();
		classd.setActorId(testID);
		classd.sendRequest();

		// -------------<Used for debugging>------------
		// System.out.println("Results: " + classd.getResponse());
		// System.out.println("getResponseNodeValueByXPath: " +
		// classd.getResponseNodeValueByXPath("/Envelope/Body/getActorsByIdResponse/actor/actor_id"));
		// System.out.println("Excel assertTrue: " +
		// classd.validateResponse(excelFileLocation, "Main"));
		// -------------<Used for debugging>------------

		System.out.println("getActorsByIdTest : Server Response " + classd.getResponseStatusCode());

		TestReporter.logAPI((classd.getResponseStatusCode() == "200"),
				classd.getNumberOfResults() + " results were returned", classd);
		TestReporter.assertTrue(classd.validateResponse(excelFileLocation, "Main"),
				"Validate Response for testGetActorsById");
		TestReporter.logAPI((classd.getNumberOfResults() != 0), classd.getNumberOfResults() + " results were returned",
				classd);
	}

	@Test(priority = 2)
	public void updateActorRequestTest() {

		String actorID = "3";
		String firstName = "Tom";
		String lastName = "Hardy";

		System.out.println("\n" + "updateActorRequestTest : " + "Actor ID " + actorID);
		System.out.println("updateActorRequestTest : " + "First Name: " + firstName);
		System.out.println("updateActorRequestTest : " + "Last Name: " + lastName);

		UpdateActorRequest classd = new UpdateActorRequest();

		classd.setActorId(actorID);
		classd.setActorFirstName(firstName);
		classd.setActorLastName(lastName);

		classd.sendRequest();

		// System.out.println("\n" + "Response: \n" + classd.getResponse());

		System.out.println("updateActorRequestTest : " + "Server Response " + classd.getResponseStatusCode() + "\n");

		TestReporter.logAPI((classd.getResponseStatusCode() == "200"),
				classd.getNumberOfResults() + " results were returned", classd);
	}

}
