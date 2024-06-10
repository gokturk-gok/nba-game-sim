package team;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;

import player.Player;

public class Team {
	private String teamName;
	private String teamLogoPath;
	public ArrayList<Player> teamPlayers = new ArrayList<Player>();
	public ArrayList<Player> playersC = new ArrayList<Player>();
	public ArrayList<Player> playersPF = new ArrayList<Player>();
	public ArrayList<Player> playersPG = new ArrayList<Player>();
	public ArrayList<Player> playersSF = new ArrayList<Player>();
	public ArrayList<Player> playersSG = new ArrayList<Player>();
	private String teamShortName;
	private Color teamColor;
	private int teamScore;
	
	/**
	 * This is the constructor of a default team. This constructor
	 * takes two parameters; teamName and teamColor. It is called
	 * at the Login stage to make an initial team ready, with a
	 * random name from a predetermined set and a color with
	 * random RGB values. It sets the team name abbreviation to
	 * the first 3 letters of the given team name as well. This
	 * constructor is only used for initial user team, not for
	 * initializing default teams.
	 * @param teamName
	 * @param teamColor
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public Team(String teamName, Color teamColor) {
		this.teamName = teamName;
		this.teamLogoPath = "resources/components/teamcreatorui/defaultteamlogo.png";
		this.teamShortName = teamName.substring(0, 3).toUpperCase();
		this.teamColor = teamColor;
		this.teamScore = 0;
	}
	
	/**
	 * This constructor, different than the two-parametered one,
	 * takes the path of team logo image and short name of the team,
	 * as it is used for instantiating the real teams which take
	 * place in NBA. It is only used for intiailizing default teams,
	 * not for user's custom team.
	 * @param teamName
	 * @param teamLogoPath
	 * @param teamShortName
	 * @param teamColor
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public Team(String teamName, String teamLogoPath, String teamShortName, Color teamColor) {
		this.teamName = teamName;
		this.teamLogoPath = teamLogoPath;
		this.teamShortName = teamShortName;
		this.teamColor = teamColor;
		this.teamScore = 0;
	}
	
	/**
	 * This method calculates the team score
	 * by adding up all the team's players
	 * scores to the the current team score
	 * which is initialized as 0. This method
	 * is called after the drafting process
	 * is completed.
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public void calculateTeamScore() {
		for (Player player : teamPlayers) {
			this.teamScore += player.getPlayerScore();
		}
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getTeamLogoPath() {
		return teamLogoPath;
	}

	public void setTeamLogoPath(String teamLogoPath) {
		this.teamLogoPath = teamLogoPath;
	}

	public String getTeamShortName() {
		return teamShortName;
	}

	public void setTeamShortName(String teamShortName) {
		this.teamShortName = teamShortName;
	}

	public Color getTeamColor() {
		return teamColor;
	}

	public void setTeamColor(Color teamColor) {
		this.teamColor = teamColor;
	}

	public ArrayList<Player> getPlayersC() {
		return playersC;
	}

	public void setPlayersC(ArrayList<Player> playersC) {
		this.playersC = playersC;
	}

	public ArrayList<Player> getPlayersPF() {
		return playersPF;
	}

	public void setPlayersPF(ArrayList<Player> playersPF) {
		this.playersPF = playersPF;
	}

	public ArrayList<Player> getPlayersPG() {
		return playersPG;
	}

	public void setPlayersPG(ArrayList<Player> playersPG) {
		this.playersPG = playersPG;
	}

	public ArrayList<Player> getPlayersSF() {
		return playersSF;
	}

	public void setPlayersSF(ArrayList<Player> playersSF) {
		this.playersSF = playersSF;
	}

	public ArrayList<Player> getPlayersSG() {
		return playersSG;
	}

	public void setPlayersSG(ArrayList<Player> playersSG) {
		this.playersSG = playersSG;
	}

	public ArrayList<Player> getTeamPlayers() {
		return teamPlayers;
	}

	public void setTeamPlayers(ArrayList<Player> teamPlayers) {
		this.teamPlayers = teamPlayers;
	}
	
	public int getTeamScore() {
		return teamScore;
	}
	
	public void setTeamScore(int TeamScore) {
		this.teamScore = teamScore;
	}
	

	
}
