package player;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Random;

public abstract class Player {
	private String playerName;
	private String playerPosition;
	
	protected double totalRebounds;
	protected double totalAssists;
	protected double totalBlocks;
	protected double totalSteals;
	protected double totalPoints;
	private int playerScore;
	private int dataExistence;
	
	/**
	 * This is the constructor of creating a Player object.
	 * This method is called by the constructors of its
	 * subclasses.
	 * @param playerName
	 * @param playerPosition
	 * @param totalRebounds
	 * @param totalAssists
	 * @param totalBlocks
	 * @param totalSteals
	 * @param totalPoints
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public Player(String playerName, String playerPosition, double totalRebounds, double totalAssists, double totalBlocks, double totalSteals, double totalPoints) {
		this.playerName = playerName;
		this.playerPosition = playerPosition;
		this.totalRebounds = totalRebounds;
		this.totalAssists = totalAssists;
		this.totalBlocks = totalBlocks;
		this.totalSteals = totalSteals;
		this.totalPoints = totalPoints;
		this.dataExistence = 1;
	}
	
	/**
	 * This method is an abstract method, which is implemented
	 * by the concrete subclasses of Player, to make the method
	 * utilize each position's weights for calculating player
	 * scores.
	 * @return Player's score
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public abstract int calculatePlayerScore();
	
	/**
	 * This toString() method is for making the JComboBox component
	 * in DraftingUI represent the list of players properly with their
	 * names.
	 * @return String playerName
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public String toString() {
		return playerName;
	}

	
	public String getPlayerName() {
		return playerName;
	}



	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}



	public String getPlayerPosition() {
		return playerPosition;
	}



	public void setPlayerPosition(String playerPosition) {
		this.playerPosition = playerPosition;
	}
	
	



	public double getTotalRebounds() {
		return totalRebounds;
	}



	public void setTotalRebounds(double totalRebounds) {
		this.totalRebounds = totalRebounds;
	}



	public double getTotalAssists() {
		return totalAssists;
	}



	public void setTotalAssists(double totalAssists) {
		this.totalAssists = totalAssists;
	}



	public double getTotalBlocks() {
		return totalBlocks;
	}



	public void setTotalBlocks(double totalBlocks) {
		this.totalBlocks = totalBlocks;
	}



	public double getTotalSteals() {
		return totalSteals;
	}



	public void setTotalSteals(double totalSteals) {
		this.totalSteals = totalSteals;
	}



	public double getTotalPoints() {
		return totalPoints;
	}



	public void setTotalPoints(double totalPoints) {
		this.totalPoints = totalPoints;
	}



	public int getPlayerScore() {
		return playerScore;
	}



	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}



	public int getDataExistence() {
		return dataExistence;
	}
	
	public void setDataExistence(int dataExistence) {
		this.dataExistence = dataExistence;
	}

	public void increaseDataExistence() {
		this.dataExistence += 1;
	}

}
