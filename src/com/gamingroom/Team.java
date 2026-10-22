package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a team.
 * Derived from the base Entity class.
 * 
 * @author coce@snhu.edu
 */
public class Team extends Entity {

	/**
	 * A list of active players in this team instance.
	 */
	private List<Player> players = new ArrayList<Player>();

	/**
	 * Constructor requiring an id and name. Passes parameters to superclass Entity constructor.
	 * 
	 * @param id   the unique team identifier
	 * @param name the unique team name
	 */
	public Team(long id, String name) {
		super(id, name);
	}

	/**
	 * Adds a player to the team if a player with the same name does not already exist.
	 * Uses the Iterator pattern to search the existing players list.
	 * 
	 * @param name the name of the player to add
	 * @return the existing or newly created Player instance
	 */
	public Player addPlayer(String name) {

		// Local player instance
		Player player = null;

		// Use iterator pattern to scan existing players for duplicate name
		Iterator<Player> iterator = players.iterator();
		while (iterator.hasNext()) {
			Player currentPlayer = iterator.next();
			if (currentPlayer.getName().equalsIgnoreCase(name)) {
				player = currentPlayer;
				break;
			}
		}

		// If player with name was not found, create and add new player instance
		if (player == null) {
			player = new Player(GameService.getInstance().getNextPlayerId(), name);
			players.add(player);
		}

		return player;
	}

	@Override
	public String toString() {
		return "Team [id=" + getId() + ", name=" + getName() + "]";
	}
}