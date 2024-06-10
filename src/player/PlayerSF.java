package player;

import java.security.SecureRandom;
import java.util.Random;

public class PlayerSF extends Player {
	/**
	 * This is the constructor of the object PlayerPG, which represents the position "Small Forward".
	 * @param playerName
	 * @param totalRebounds
	 * @param totalAssists
	 * @param totalBlocks
	 * @param totalSteals
	 * @param totalPoints
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public PlayerSF(String playerName, double totalRebounds, double totalAssists, double totalBlocks, double totalSteals, double totalPoints) {
		super(playerName, "SF", totalRebounds, totalAssists, totalBlocks, totalSteals, totalPoints);
	}
	
	/**
	 * This method calculates the score of related Player object,
	 * using the assigned point weights to the position "Small Forward".
	 * For all the statistics which are contained by an array,
	 * it chooses a random integer, at most 4 units far than the value
	 * and then multiplies that integer with the corresponding weight.
	 * After completing the process for each statistic, it sums the
	 * selected values up, and then rounds it to the nearest integer
	 * to obtain a score which is a whole number.
	 * Weights are chosen for this position as the following:
	 * Total rebounds : 0.12
	 * Total assists : 0.15
	 * Total blocks : 0.25
	 * Total steals : 0.16
	 * Total points : 0.32
	 * @return score
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public int calculatePlayerScore() {
		Random random = new SecureRandom();
		int score = 0;
		double[] playerStats = {totalRebounds, totalAssists, totalBlocks, totalSteals, totalPoints};

		for (int i = 0 ; i < 5 ; i++) {
			int value = -1; // intiated as -1;
			
			while (value < 0) {
				value = (int) random.nextDouble(playerStats[i] - 4, playerStats[i] + 5);
			} 

			if (i == 0) {
				score += (value * 0.12);
			} else if (i == 1) {
				score += (value * 0.15);
			} else if (i == 2) {
				score += (value * 0.25);
			} else if (i == 3) {
				score += (value * 0.16);
			} else if (i == 4) {
				score += (value * 0.32);
			}
		}
		
		score = (int) score;
		
		return score;
	
	}
	
}