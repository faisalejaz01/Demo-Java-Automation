package com.trainingserver.soapservices;

import org.testng.annotations.Test;

import com.orasi.utils.TestReporter;
import com.services.customers.operations.CreateCustomerRequest;
import com.services.customers.operations.DeleteCustomerRequest;

public class TestSoapService_Customers {

	@Test(priority = 1)
	public void createCustomerRequestTest() {

		String storeId = "1";
		String isActive = "1";
		String firstName = "Iron";
		String lastName = "Man";
		String email = "iron.man@test.com";
		String addressId = "4";

		CreateCustomerRequest customer = new CreateCustomerRequest();
		customer.setStoreId(storeId);
		customer.setActive(isActive);
		customer.setCustomerFirstName(firstName);
		customer.setCustomerLastName(lastName);
		customer.setEmail(email);
		customer.setAddressId(addressId);
		customer.sendRequest();

		// System.out.println("Results: " + customer.getResponse());

		System.out.println("createCustomerRequestTest : Server Response " + customer.getResponseStatusCode());
		System.out.println("createCustomerRequestTest : " + "Customer ["
				+ customer.getResponseNodeValueByXPath("/Envelope/Body/createCustomerResponse/customer/customerId")
				+ "] created.\n");

		TestReporter.logAPI((customer.getResponseStatusCode() == "200"),
				customer.getNumberOfResults() + " results were returned", customer);
		TestReporter.logAPI((customer.getNumberOfResults() != 0),
				customer.getNumberOfResults() + " results were returned", customer);
	}

	@Test(priority = 2)
	public void deleteCustomerRequestTest() {
		String customerId = "609";

		DeleteCustomerRequest customer = new DeleteCustomerRequest();
		customer.setCustomerId(customerId);
		customer.sendRequest();

		System.out.println("deleteCustomerRequestTest : Server Response " + customer.getResponseStatusCode());
		System.out.println("deleteCustomerRequestTest : "
				+ customer.getResponseNodeValueByXPath("/Envelope/Body/deleteCustomerResponse/response") + "\n");

		TestReporter.logAPI((customer.getResponseStatusCode() == "200"),
				customer.getNumberOfResults() + " results were returned", customer);
		TestReporter.logAPI((customer.getNumberOfResults() != 0),
				customer.getNumberOfResults() + " results were returned", customer);
	}
}
