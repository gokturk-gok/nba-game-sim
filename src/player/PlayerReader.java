package player;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import team.Drafting;

public class PlayerReader {
	// name of the file is changed to stats to keep it consistent for other uses;
	/**
	 * readPlayers method reads a given CSV file for getting player information
	 * ready for instantiating the game. It first reads the file through a Scanner object,
	 * which supports CSV files internally, and then reads the file line by line, converting and assigning
	 * Players' values to Double objects as Scanner reads all these values as Strings.
	 * If it finds a player name that has not been read before, puts it in a HashMap named readPlayers,
	 * which contains player names as keys and Player objects as values.
	 * If Scanner finds a player that is already added to the HashMap readPlayers,
	 * it increases the existence of a Player in CSV file, which is a field of Player class.
	 * Then, sets related Player object's fields to averaged values, which is given in the documentation.
	 * Therefore, the method adds the Players held in the HashMap to an ArrayList called players.
	 * Finally, it calculates the scores of all players in the ArrayList players, ensuring that no player
	 * has 0 points, since it would not be desired for the game flow. The method returns the ArrayList object players.
	 * 

	 * @return players
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public static ArrayList<Player> readPlayers() {

		ArrayList<Player> players = new ArrayList<>();
		HashMap<String, Player> readPlayers = new HashMap<>();

		// read players, put them in hashmaps with their names and objects;
		// if the name exists in hashmap keys, then it is multiple;
		
		try {
			Scanner inputData = new Scanner(Paths.get("resources/stats.csv"));
			inputData.useDelimiter(";");
			inputData.nextLine(); // to pass first line;
			while (inputData.hasNext()) {
				String[] playerInfo = inputData.nextLine().split(";");
				String playerName = playerInfo[1];
				String playerPosition = playerInfo[2];
				double playerTotalRebounds = Double.parseDouble(playerInfo[23]);
				double playerAssists = Double.parseDouble(playerInfo[24]);
				double playerBlocks = Double.parseDouble(playerInfo[26]);
				double playerSteals = Double.parseDouble(playerInfo[25]);
				double playerPoints = Double.parseDouble(playerInfo[29]);
				if (readPlayers.containsKey(playerInfo[1]) == false) {
					if (playerPosition.equals("C")) {
						PlayerC newPlayer = new PlayerC(playerName, playerTotalRebounds, playerAssists, playerBlocks, playerSteals, playerPoints);
						readPlayers.put(playerName, newPlayer);
						Drafting.availablePlayerC.add(newPlayer);
					} else if (playerPosition.equals("PF")) {
						PlayerPF newPlayer = new PlayerPF(playerName, playerTotalRebounds, playerAssists, playerBlocks, playerSteals, playerPoints);
						readPlayers.put(playerName, newPlayer);
						Drafting.availablePlayerPF.add(newPlayer);
					} else if (playerPosition.equals("PG")) {
						PlayerPG newPlayer = new PlayerPG(playerName, playerTotalRebounds, playerAssists, playerBlocks, playerSteals, playerPoints);
						readPlayers.put(playerName, newPlayer);
						Drafting.availablePlayerPG.add(newPlayer);
					} else if (playerPosition.equals("SF")) {
						PlayerSF newPlayer = new PlayerSF(playerName, playerTotalRebounds, playerAssists, playerBlocks, playerSteals, playerPoints);
						readPlayers.put(playerName, newPlayer);
						Drafting.availablePlayerSF.add(newPlayer);
					} else if (playerPosition.equals("SG")) {
						PlayerSG newPlayer = new PlayerSG(playerName, playerTotalRebounds, playerAssists, playerBlocks, playerSteals, playerPoints);
						readPlayers.put(playerName, newPlayer);
						Drafting.availablePlayerSG.add(newPlayer);
					}
					

				} else {
					readPlayers.get(playerName).increaseDataExistence();
					readPlayers.get(playerName).setTotalAssists((readPlayers.get(playerName).getTotalAssists() + playerAssists) / readPlayers.get(playerName).getDataExistence());
					readPlayers.get(playerName).setTotalSteals((readPlayers.get(playerName).getTotalSteals() + playerSteals) / readPlayers.get(playerName).getDataExistence());
					readPlayers.get(playerName).setTotalBlocks((readPlayers.get(playerName).getTotalBlocks() + playerBlocks) / readPlayers.get(playerName).getDataExistence());
					readPlayers.get(playerName).setTotalRebounds((readPlayers.get(playerName).getTotalRebounds() + playerTotalRebounds) / readPlayers.get(playerName).getDataExistence());
					readPlayers.get(playerName).setTotalPoints((readPlayers.get(playerName).getTotalPoints() + playerPoints) / readPlayers.get(playerName).getDataExistence());
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		for (Player player : readPlayers.values()) {
			players.add(player);
		}
		
		for (Player player : players) {
			int playerScore = 0;
			while (playerScore == 0) { 
				playerScore = player.calculatePlayerScore();
			}
			player.setPlayerScore(playerScore);
		}


		return players;
	}
	
	
}
