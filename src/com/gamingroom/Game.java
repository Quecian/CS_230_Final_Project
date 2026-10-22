package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a game.
 * Derived from the base Entity class.
 * 
 * @author coce@snhu.edu
 */
public class Game extends Entity {

	/**
	 * A list of active teams in this game instance.
	 */
	private List<Team> teams = new ArrayList<Team>();

	/**
	 * Constructor requiring an id and name. Passes parameters to superclass Entity constructor.
	 * 
	 * @param id   the unique game identifier
	 * @param name the unique game name
	 */
	public Game(long id, String name) {
		super(id, name);
	}

	/**
	 * Adds a team to the game if a team with the same name does not already exist.
	 * Uses the Iterator pattern to search the existing teams list.
	 * 
	 * @param name the name of the team to add
	 * @return the existing or newly created Team instance
	 */
	public Team addTeam(String name) {

		// Local team instance
		Team team = null;

		// Use iterator pattern to scan existing teams for duplicate name
		Iterator<Team> iterator = teams.iterator();
		while (iterator.hasNext()) {
			Team currentTeam = iterator.next();
			if (currentTeam.getName().equalsIgnoreCase(name)) {
				team = currentTeam;
				break;
			}
		}

		// If team with name was not found, create and add new team instance
		if (team == null) {
			team = new Team(GameService.getInstance().getNextTeamId(), name);
			teams.add(team);
		}

		return team;
	}

	@Override
	public String toString() {
		return "Game [id=" + getId() + ", name=" + getName() + "]";
	}
}