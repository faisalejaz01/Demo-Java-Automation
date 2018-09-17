package com.trainingserver.rest.actors.objects;

public class Actor {

	private int actorId;
	private String firstName;
	private String lastName;

	
	public Actor() {
		
	}
	
	
	public int getActorId() {
		return actorId;
	}

	public void setActorID(int actorId) {
		this.actorId = actorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
