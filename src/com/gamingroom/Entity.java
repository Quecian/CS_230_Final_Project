package com.gamingroom;

/**
 * A base class to hold common attributes and behaviors for entities in the game application.
 * 
 * DESIGN PATTERN / OOP PRINCIPLE - INHERITANCE & ENCAPSULATION:
 * The Entity class serves as the superclass for Game, Team, and Player.
 * It encapsulates common fields 'id' and 'name' so that derived classes
 * inherit these properties without duplicating code.
 * 
 * @author coce@snhu.edu
 */
public class Entity {
	private long id;
	private String name;

	/**
	 * Default constructor set to private to force initialization with id and name.
	 */
	private Entity() {
	}

	/**
	 * Constructor with an identifier and name.
	 * 
	 * @param id   the unique identifier
	 * @param name the unique name
	 */
	public Entity(long id, String name) {
		this();
		this.id = id;
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Entity [id=" + id + ", name=" + name + "]";
	}
}