package logging;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import player.Player;
import team.Team;

public class Logging {
	/**
	 * @method matchLog
	 * This method takes those parameters:
	 * @param team1
	 * @param team2
	 * @param homeowner / It is the result of the toss that is made at the time the match is starting.
	 * If it is 0, then the first team is homeowner, and the second team is the homeowner if it is 1.
	 * @param winner / It is the result of a match
	 * 
	 * The method takes the arguments, and tries to find or create a matchlog.txt. It records
	 * all the match records, at the beginning of the very first execution of this method, unless
	 * it is cleared with a text editor by user. It creates a String, using the timestamp up to the seconds
	 * field and given parameters, and then prints it into the file via PrintWriter.
	 * @throws IOException
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public static void matchLog(Team team1, Team team2, int homeowner, Team winner) throws IOException {
		FileWriter matchLog = new FileWriter("matchlog.txt", true);
		try (PrintWriter matchLogPrinter = new PrintWriter(matchLog)) {
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
			String timestamp = dateFormat.format(date);
			if (homeowner == 0) {
				String logRecord = timestamp + " HOMEOWNER " + team1.getTeamName() + " SCORE:" + team1.getTeamScore() * 1.05 + " " + team2.getTeamName() + " SCORE:" + team2.getTeamScore() + " WINNER:" + winner.getTeamName();
				matchLogPrinter.println(logRecord);
			} else {
				String logRecord = timestamp + " " + team1.getTeamName() + " SCORE:" + team1.getTeamScore() + " HOMEOWNER " + team2.getTeamName() + " SCORE:" + team2.getTeamScore() * 1.05 + winner.getTeamName(); 
				matchLogPrinter.println(logRecord);
			}

		}
	}
	
	/**
	 * @method draftLog
	 * This method takes two parameters:
	 * @param team
	 * @param selectedPlayer
	 * This method tries to find or create a text file draftlog.txt.
	 * Using the parameters, the method creates a String containing the time that the player is drafted,
	 * name of the player, score of the player, and the name of the team that have chosen the player.
	 * It prints the created String to the log file via PrintWriter.
	 * @throws IOException
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public static void draftLog(Team team, Player selectedPlayer) throws IOException {
		FileWriter draftLog = new FileWriter("draftlog.txt", true);
		try (PrintWriter draftLogPrinter = new PrintWriter(draftLog)) {
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
			String timestamp = dateFormat.format(date);
			String logRecord = timestamp + " " + team.getTeamName() + " Drafted Player : " + selectedPlayer.getPlayerName() + " Score : " + selectedPlayer.getPlayerScore();
			draftLogPrinter.println(logRecord);
		}
	}
	
	/**
	 * @method championLog
	 * @param team
	 * This method could be evaluated as an extension of the method Logging.matchLog().
	 * This method specifically logs the Champion of the season and logging time to the matchlog.txt file,
	 * which is used by the method Logging.matchLog() as well. This method is for reducing
	 * the resource use by narrowing the Logging.matchLog().
	 * @throws IOException
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public static void championLog(Team team) throws IOException {
		FileWriter matchLog = new FileWriter("matchlog.txt", true);
		try (PrintWriter matchLogPrinter = new PrintWriter(matchLog)) {
			Date date = new Date();
			SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy h:mm:ss a");
			String timestamp = dateFormat.format(date);
			String logRecord = timestamp + " CHAMPION : " + team.getTeamName();
			matchLogPrinter.println(logRecord);


			
		}	
	}

}
