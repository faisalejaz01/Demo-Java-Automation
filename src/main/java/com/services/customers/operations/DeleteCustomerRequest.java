package com.services.customers.operations;

import java.io.File;

import com.orasi.utils.XMLTools;
import com.services.customers.Customers;

public class DeleteCustomerRequest extends Customers {

	public DeleteCustomerRequest() {
		File xml = new File("src/main/resources/xml/services/customers/deleteCustomerRequest.xml");
		setRequestDocument(XMLTools.makeXMLDocument(xml));
		setOperationName("createCustomerRequest");
		removeComments();
		removeWhiteSpace();

	}

	public int getNumberOfResults() {
		return getNumberOfResponseNodesByXPath("/Envelope/Body/deleteCustomerResponse");
	}

	public void setCustomerId(String customerId) {
		setRequestNodeValueByXPath("/Envelope/Body/deleteCustomerRequest/customerId", customerId);
	}

}
