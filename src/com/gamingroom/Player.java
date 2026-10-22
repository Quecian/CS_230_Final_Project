package com.gamingroom;

/**
 * A simple class to hold information about a player.
 * Derived from the base Entity class.
 * 
 * @author coce@snhu.edu
 */
public class Player extends Entity {

	/**
	 * Constructor requiring an id and name. Passes parameters to superclass Entity constructor.
	 * 
	 * @param id   the unique player identifier
	 * @param name the unique player name
	 */
	public Player(long id, String name) {
		super(id, name);
	}

	@Override
	public String toString() {
		return "Player [id=" + getId() + ", name=" + getName() + "]";
	}
}