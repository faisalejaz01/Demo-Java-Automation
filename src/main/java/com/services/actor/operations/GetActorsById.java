package com.services.actor.operations;

import java.io.File;

import com.orasi.utils.XMLTools;
import com.services.actor.Actors;

public class GetActorsById extends Actors {

	public GetActorsById() {
		File xml = new File("src/main/resources/xml/services/actors/getActorById.xml");

		setRequestDocument(XMLTools.makeXMLDocument(xml));
		// System.out.println("XML DOC: " + xml);

		setOperationName("getActorsByIdRequest");
		removeComments();
		removeWhiteSpace();

	}

	public int getNumberOfResults() {
		return getNumberOfResponseNodesByXPath("/Envelope/Body/getActorsByIdResponse/actor");
	}

	public void setActorId(String actorId) {
		setRequestNodeValueByXPath("/Envelope/Body/getActorsByIdRequest/actor_id", actorId);
	}

}