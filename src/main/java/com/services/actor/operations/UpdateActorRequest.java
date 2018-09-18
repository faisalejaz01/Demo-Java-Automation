package com.services.actor.operations;

import java.io.File;

import com.orasi.utils.XMLTools;
import com.services.actor.Actors;

public class UpdateActorRequest extends Actors{
	
		public UpdateActorRequest() {
			File xml = new File("src/main/resources/xml/services/actors/updateActorRequest.xml");

			setRequestDocument(XMLTools.makeXMLDocument(xml));
			//System.out.println("XML DOC: " + xml); 
			
			setOperationName("updateActorRequest");
			removeComments();
			removeWhiteSpace();

		}
		
		public int getNumberOfResults() {
			return getNumberOfRequestNodesByXPath("/soapenv:Envelope/soapenv:Body/my:updateActorRequest");
		}
		
		public void setActorId(String actorId) {
			setRequestNodeValueByXPath("/Envelope/Body/updateActorRequest/actor_id", actorId);
		}
		public void setActorFirstName(String firstName) {
			setRequestNodeValueByXPath("/Envelope/Body/updateActorRequest/newFirstName", firstName);
		}
		public void setActorLastName(String lastName) {
			setRequestNodeValueByXPath("/Envelope/Body/updateActorRequest/newLastName", lastName);
		}
	}
