package com.services.actor;

import com.orasi.api.soapServices.SoapService;

public class Actors extends SoapService{

	public Actors() {
		setServiceName("ActorsService");
		setServiceURL("https://training-server.herokuapp.com:443/soap/");
	}
	
}
