package match;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

import team.*;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.Random;

import logging.Logging;

public class Match {
	public static Random random = new SecureRandom();
	public static HashMap<Team, Integer> teamsWins = new HashMap<Team, Integer>();
	
	/**
	 * @method matchTeams
	 * This method gets playing teams ready to take place
	 * in the league, by shuffling them using the Collection.shuffle()
	 * method and then puts them in a HashMap named teamsWins to keep
	 * their numbers of wins through the leauge and calculates their
	 * scores.
	 * 
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public static void matchTeams() {
		Collections.shuffle(Drafting.playingTeams);
		for (Team team : Drafting.playingTeams) {
			teamsWins.put(team, 0);
			team.calculateTeamScore();
		}
		
	}
	
	/**
	 * @method matchesPreEight
	 * This method uses Drafting.playingTeams static field, which keeps
	 * the list of teams that plays in the league currently. The method
	 * represents a tour in the league, where every team plays a match
	 * with another team. It first shuffles the teams to make them play
	 * randomly, and makes teams play a match in pairs, determining a 
	 * homeowner and giving it the score advantage of 1.05. Finally, it 
	 * returns the winners of the matches at that tour.
	 * @return ArrayList<Team> winners
	 * @throws InterruptedException
	 * @throws IOException
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public static ArrayList<Team> matchesPreEight() throws InterruptedException, IOException {
		Collections.shuffle(Drafting.playingTeams);
		ArrayList<Team> winners = new ArrayList<>();
		for (int i = 0 ; i < 20 ; i = i + 2) {
			
			int toss = random.nextInt(2);
			Team team1 = Drafting.playingTeams.get(i);
			Team team2 = Drafting.playingTeams.get(i + 1);

			double team1Score = team1.getTeamScore();
			double team2Score = team2.getTeamScore();
			if (toss == 0) {
				team1Score = team1Score * 1.05;
			} else if (toss == 1) {
				team2Score = team2Score * 1.05;
			}
			
			if (team1Score > team2Score) {
				teamsWins.put(Drafting.playingTeams.get(i), teamsWins.get(Drafting.playingTeams.get(i)) + 1);
				winners.add(Drafting.playingTeams.get(i));
				Logging.matchLog(team1, team2, toss, team1);
			} else {
				teamsWins.put(Drafting.playingTeams.get(i + 1), teamsWins.get(Drafting.playingTeams.get(i + 1)) + 1);
				winners.add(Drafting.playingTeams.get(i + 1));
				Logging.matchLog(team1, team2, toss, team2);
			}
		}
		
		return winners;

	}
	
	/**
	 * @method findFinal8
	 * This method takes the results of matches played at the previous stage,
	 * where each team in the league competed to be in the Final Eight (playoff).
	 * Then it finds the first 8 teams with highest scores, and returns them
	 * in an ArrayList named finalEight.
	 * @param results
	 * @return finalEight
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public static ArrayList<Team> findFinal8(HashMap<Team, Integer> results) {
		ArrayList<Team> finalEight = new ArrayList<>();
		for (int i = 0 ; i < 8 ; i++) {
			int max = 0;
			Team winner = null;
			for (Team team : results.keySet()) {
				if (results.get(team) > max) {
					max = results.get(team);
					winner = team;
				}
			}
			finalEight.add(winner);
			results.remove(winner);
			
		}
		return finalEight;
	}
	
	/**
	 * @method matchTwoTeams
	 * This method makes given two specific teams play a match,
	 * giving one of them the homeowner score advantage of 1.05,
	 * which is determined by virtually tossing a coin with faces
	 * 1 or 0. Then it returns the winner of the match.
	 * @param team1
	 * @param team2
	 * @return team1 / team2
	 * @throws IOException
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public static Team matchTwoTeams(Team team1, Team team2) throws IOException {
		int toss = random.nextInt(2);
		double team1Score = team1.getTeamScore();
		double team2Score = team2.getTeamScore();
		if (toss == 0) {
			team1Score = team1Score * 1.05;
		} else {
			team2Score = team2Score * 1.05;
		}

		if (team1Score > team2Score) {
			Logging.matchLog(team1, team2, toss, team1);
			return team1;
		} else {
			Logging.matchLog(team1, team2, toss, team2);
			return team2;
		}

	}
}
