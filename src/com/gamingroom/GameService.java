package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A singleton service for the game engine.
 * 
 * DESIGN PATTERN EXPLANATION - SINGLETON PATTERN:
 * The Singleton pattern ensures that only one instance of the GameService class
 * exists in memory at any given time. This guarantees unified management of active
 * game state and unique ID tracking across games, teams, and players.
 * 
 * DESIGN PATTERN EXPLANATION - ITERATOR PATTERN:
 * The Iterator pattern provides a standard way to sequentially traverse collections 
 * (List<Game>) without exposing underlying data structures. Used here to enforce 
 * entity name uniqueness during creation and lookup operations.
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Next available identifiers for entities
	 */
	private static long nextGameId = 1;
	private static long nextPlayerId = 1;
	private static long nextTeamId = 1;

	// Single instance variable for Singleton pattern
	private static GameService service = null;

	/**
	 * Private constructor prevents external instantiation
	 */
	private GameService() {
	}

	/**
	 * Provides global access to the single GameService instance (Lazy Initialization)
	 * 
	 * @return single GameService instance
	 */
	public static GameService getInstance() {
		if (service == null) {
			service = new GameService();
		}
		return service;
	}

	/**
	 * Construct a new game instance or return existing instance if name matches.
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		Game game = null;

		// Use iterator to look for existing game with same name
		Iterator<Game> iterator = games.iterator();
		while (iterator.hasNext()) {
			Game currentGame = iterator.next();
			if (currentGame.getName().equalsIgnoreCase(name)) {
				game = currentGame;
				break;
			}
		}

		// If not found, create new game instance and append to list
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		return game;
	}

	/**
	 * Returns the game instance at the specified list index.
	 * 
	 * @param index index position in list
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}

	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		Game game = null;

		Iterator<Game> iterator = games.iterator();
		while (iterator.hasNext()) {
			Game currentGame = iterator.next();
			if (currentGame.getId() == id) {
				game = currentGame;
				break;
			}
		}

		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		Game game = null;

		Iterator<Game> iterator = games.iterator();
		while (iterator.hasNext()) {
			Game currentGame = iterator.next();
			if (currentGame.getName().equalsIgnoreCase(name)) {
				game = currentGame;
				break;
			}
		}

		return game;
	}

	/**
	 * Returns the number of games currently active.
	 * 
	 * @return total game count
	 */
	public int getGameCount() {
		return games.size();
	}

	/**
	 * Returns the next available player ID and increments the counter.
	 * 
	 * @return next player ID
	 */
	public long getNextPlayerId() {
		return nextPlayerId++;
	}

	/**
	 * Returns the next available team ID and increments the counter.
	 * 
	 * @return next team ID
	 */
	public long getNextTeamId() {
		return nextTeamId++;
	}
}