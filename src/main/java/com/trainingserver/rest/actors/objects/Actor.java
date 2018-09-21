package com.trainingserver.rest.actors.objects;

public class Actor {

	protected int actorId;
	protected String firstName;
	protected String lastName;

	public Actor(int actorId, String firstName, String lastName) {
		this.actorId = actorId;
		this.firstName = firstName;
		this.lastName = lastName;

	}

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
