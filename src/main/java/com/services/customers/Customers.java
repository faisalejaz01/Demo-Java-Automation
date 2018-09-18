package com.services.customers;

import com.orasi.api.soapServices.SoapService;

public class Customers extends SoapService{

	public Customers() {
		setServiceName("CustomersService");
		setServiceURL("https://training-server.herokuapp.com:443/soap/");
	}
	
}
