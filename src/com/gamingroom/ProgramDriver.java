package com.gamingroom;

/**
 * Application start-up program
 * 
 * @author coce@snhu.edu
 */
public class ProgramDriver {

	public static void main(String[] args) {

		// Obtain single reference to GameService Singleton
		GameService service = GameService.getInstance();

		System.out.println("\nAbout to test initializing game data...");

		// Initialize game data
		Game game1 = service.addGame("Game #1");
		System.out.println(game1);

		Game game2 = service.addGame("Game #2");
		System.out.println(game2);

		// Test Team and Player creation
		Team team1 = game1.addTeam("Team Alpha");
		System.out.println(team1);

		Player player1 = team1.addPlayer("Player One");
		System.out.println(player1);

		// Execute Singleton test
		SingletonTester tester = new SingletonTester();
		tester.testSingleton();
	}
}