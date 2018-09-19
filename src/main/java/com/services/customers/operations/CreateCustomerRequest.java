package com.services.customers.operations;

import java.io.File;

import com.orasi.utils.XMLTools;
import com.services.customers.Customers;

public class CreateCustomerRequest extends Customers {
	public CreateCustomerRequest() {
		File xml = new File("src/main/resources/xml/services/customers/createCustomerRequest.xml");
		setRequestDocument(XMLTools.makeXMLDocument(xml));
		setOperationName("createCustomerRequest");
		removeComments();
		removeWhiteSpace();

	}

	public int getNumberOfResults() {
		return getNumberOfRequestNodesByXPath("/Envelope/Body/createCustomerRequest");
	}

	public void setAddressId(String addressId) {
		setRequestNodeValueByXPath("/Envelope/Body/createCustomerRequest/addressId", addressId);
	}

	public void setStoreId(String addressId) {
		setRequestNodeValueByXPath("/Envelope/Body/createCustomerRequest/storeId", addressId);
	}

	public void setCustomerFirstName(String firstName) {
		setRequestNodeValueByXPath("/Envelope/Body/createCustomerRequest/firstName", firstName);
	}

	public void setCustomerLastName(String lastName) {
		setRequestNodeValueByXPath("/Envelope/Body/createCustomerRequest/lastName", lastName);
	}

	public void setEmail(String email) {
		setRequestNodeValueByXPath("/Envelope/Body/createCustomerRequest/email", email);
	}

	public void setActive(String active) {
		setRequestNodeValueByXPath("/Envelope/Body/createCustomerRequest/active", active);
	}

}
