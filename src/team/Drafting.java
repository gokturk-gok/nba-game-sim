package team;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Set;

import logging.Logging;
import player.*;
import user.Login;

public class Drafting {
	public static ArrayList<PlayerC> availablePlayerC = new ArrayList<>();
	public static ArrayList<PlayerPF> availablePlayerPF = new ArrayList<>();
	public static ArrayList<PlayerPG> availablePlayerPG = new ArrayList<>();
	public static ArrayList<PlayerSF> availablePlayerSF = new ArrayList<>();
	public static ArrayList<PlayerSG> availablePlayerSG = new ArrayList<>();
	public static ArrayList<Team> playingTeams = new ArrayList<>();
	public static ArrayList<Player> availablePlayers = PlayerReader.readPlayers();

	
	/**
	 * This method selects the 19 other team after randomizing the
	 * 30 teams of NBA, and then adds the custom team of user.
	 * Then randomizes again and assigns the static field of Drafting class
	 * playingTeams, which will be used for instantiating the league.
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public static void selectTeams() {
		ArrayList<Team> selectedTeams = new ArrayList<Team>(Login.teamsOfNBA.values());
		Collections.shuffle(selectedTeams);
		for (int i = 29 ; i > 18 ; i--) {
			selectedTeams.remove(i);
		}
		
		selectedTeams.add(Login.currentTeam);
		Collections.shuffle(selectedTeams);
		playingTeams = selectedTeams;
		
		
	}
	
	/**
	 * This method takes a Team object as parameter
	 * and then makes it randomly choose a Player.
	 * And then regarding to its position, removes
	 * the chosen Player from the set of all available
	 * players and of all in its position. Then adds
	 * it to the player set of given team.
	 * 
	 * An important point is that this method is only used
	 * for the teams that are ran by computer, as it
	 * automatically chooses players.
	 * @param team
	 * @return newPlayer
	 * @throws IOException
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public static Player botsChoosePlayer(Team team) throws IOException {
		Random random = new SecureRandom();
		Player newPlayer;
		if (team.getPlayersC().size() == 0) {
			newPlayer = availablePlayerC.get(random.nextInt(availablePlayerC.size()));
			availablePlayerC.remove(newPlayer);
			availablePlayers.remove(newPlayer);
			team.playersC.add(newPlayer);
			team.teamPlayers.add(newPlayer);
		} else if (team.getPlayersPF().size() == 0) {
			newPlayer = availablePlayerPF.get(random.nextInt(availablePlayerPF.size()));
			availablePlayerPF.remove(newPlayer);
			availablePlayers.remove(newPlayer);
			team.playersPF.add(newPlayer);
			team.teamPlayers.add(newPlayer);
		} else if (team.getPlayersPG().size() == 0) {
			newPlayer = availablePlayerPG.get(random.nextInt(availablePlayerPG.size()));
			availablePlayerPG.remove(newPlayer);
			availablePlayers.remove(newPlayer);
			team.playersPG.add(newPlayer);
			team.teamPlayers.add(newPlayer);
		} else if (team.getPlayersSF().size() == 0) {
			newPlayer = availablePlayerSF.get(random.nextInt(availablePlayerSF.size()));
			availablePlayerSF.remove(newPlayer);
			availablePlayers.remove(newPlayer);
			team.playersSF.add(newPlayer);
			team.teamPlayers.add(newPlayer);
		} else if (team.getPlayersSG().size() == 0) {
			newPlayer = availablePlayerSG.get(random.nextInt(availablePlayerSG.size()));
			availablePlayerSG.remove(newPlayer);
			availablePlayers.remove(newPlayer);
			team.playersSG.add(newPlayer);
			team.teamPlayers.add(newPlayer);
		} else {
			newPlayer = availablePlayers.get(random.nextInt(availablePlayers.size()));
			availablePlayers.remove(newPlayer);
			team.teamPlayers.add(newPlayer);
			String playerPosition = newPlayer.getPlayerPosition();
			if (playerPosition.equals("C")) {
				availablePlayerC.remove(newPlayer);
				team.playersC.add(newPlayer);
			} else if (playerPosition.equals("PF")) {
				availablePlayerPF.remove(newPlayer);
				team.playersPF.add(newPlayer);
			} else if (playerPosition.equals("PG")) {
				availablePlayerPG.remove(newPlayer);
				team.playersPG.add(newPlayer);
			} else if (playerPosition.equals("SF")) {
				availablePlayerSF.remove(newPlayer);
				team.playersSF.add(newPlayer);
			} else if (playerPosition.equals("SG")) {
				availablePlayerSG.remove(newPlayer);
				team.playersSG.add(newPlayer);
			}
			
		}
		Logging.draftLog(team, newPlayer);
		return newPlayer;
	}
	
	/**
	 * This method takes a Team and a Player object as parameters,
	 * and assigns the Player to the Team, and then removes it
	 * from corresponding availability sets according to the Player's
	 * position. This method is only used for saving the user's
	 * player choose.
	 * @param team
	 * @param player
	 * @throws IOException
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public static void choosePlayer(Team team, Player player) throws IOException {
		team.teamPlayers.add(player);
		availablePlayers.remove(player);
		String playerPosition = player.getPlayerPosition();
		Logging.draftLog(team, player);
		if (playerPosition.equals("C")) {
			availablePlayerC.remove(player);
			team.playersC.add(player);
		} else if (playerPosition.equals("PF")) {
			availablePlayerPF.remove(player);
			team.playersPF.add(player);
		} else if (playerPosition.equals("PG")) {
			availablePlayerPG.remove(player);
			team.playersPG.add(player);
		} else if (playerPosition.equals("SF")) {
			availablePlayerSF.remove(player);
			team.playersSF.add(player);
		} else if (playerPosition.equals("SG")) {
			availablePlayerSG.remove(player);
			team.playersSG.add(player);
		}


	}
	
	

	
}
