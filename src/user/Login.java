package user;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import player.PlayerReader;
import team.Drafting;
import team.Team;

public class Login {
	public static User currentUser;
	public static Team currentTeam;
	public static HashMap<String, Team> teamsOfNBA = new HashMap<>();
	/**
	 * These objects are the existing teams of NBA,
	 * what 15 of them will be chosen while instantiating
	 * the game.
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public static Team AtlantaHawks = new Team("Atlanta Hawks", "resources/components/teams/ATL.png", "ATL", new Color(225, 68, 52));
	public static Team BrooklynNets = new Team("Brooklyn Nets", "resources/components/teams/BKN.png", "BKN", new Color(0, 0, 0));
	public static Team BostonCeltics = new Team("Boston Celtics", "resources/components/teams/BOS.png", "BOS", new Color(0, 122, 51));
	public static Team CharlotteHornets = new Team("Charlotte Hornets", "resources/components/teams/CHA.png", "CHA", new Color(29, 17, 96));
	public static Team ChicagoBulls = new Team("Chicago Bulls", "resources/components/teams/CHI.png", "CHI", new Color(206, 17, 65));
	public static Team ClevelandCavaliers = new Team("Cleveland Cavaliers", "resources/components/teams/CLE.png", "CLE", new Color(134, 0, 56));
	public static Team DallasMavericks = new Team("Dallas Mavericks", "resources/components/teams/DAL.png", "DAL", new Color(0, 83, 188));
	public static Team DenverNuggets = new Team("Denver Nuggets", "resources/components/teams/DEN.png", "DEN", new Color(13, 34, 64));
	public static Team DetroitPistons = new Team("Detroit Pistons", "resources/components/teams/DET.png", "DET", new Color(200, 16, 46));
	public static Team GoldenStateWarriors = new Team("Golden State Warriors", "resources/components/teams/GSW.png", "GSW", new Color(29, 66, 138));
	public static Team HoustonRockets = new Team("Houston Rockets", "resources/components/teams/HOU.png", "HOU", new Color(206, 17, 65));
	public static Team IndianaPacers = new Team("Indiana Pacers", "resources/components/teams/IND.png", "IND", new Color(0, 45, 98));
	public static Team LosAngelesClippers = new Team("Los Angeles Clippers", "resources/components/teams/LAC.png", "LAC", new Color(200, 16, 46));
	public static Team LosAngelesLakers = new Team("Los Angeles Lakers", "resources/components/teams/LAL.png", "LAL", new Color(85, 37, 130));
	public static Team MemphisGrizzlies = new Team("Memphis Grizzlies", "resources/components/teams/MEM.png", "MEM", new Color(93, 118, 169));
	public static Team MiamiHeat = new Team("Miami Heat", "resources/components/teams/MIA.png", "MIA", new Color(152, 0, 46));
	public static Team MilwaukeeBucks = new Team("Milwaukee Bucks", "resources/components/teams/MIL.png", "MIL", new Color(0, 71, 27));
	public static Team MinnesotaTimberwolves = new Team("Minnesota Timberwolwes", "resources/components/teams/MIN.png", "MIN", new Color(12, 35, 64));
	public static Team NewOrleansPelicans = new Team("New Orleans Pelicans", "resources/components/teams/NOP.png", "NOP", new Color(0, 22, 65));
	public static Team NewYorkKnicks = new Team("New York Knicks", "resources/components/teams/NYK.png", "NYK", new Color(0, 107, 182));
	public static Team OklahomaCityThunder = new Team("Oklahoma City Thunder", "resources/components/teams/OKC.png", "OKC", new Color(0, 125, 195));
	public static Team OrlandoMagic = new Team("Orlando Magic", "resources/components/teams/ORL.png", "ORL", new Color(0, 125, 197));
	public static Team Philadelphia76ers = new Team("Philadelphia 76ers", "resources/components/teams/PHI.png", "PHI", new Color(0, 107, 182));
	public static Team PhoenixSuns = new Team("Phoenix Suns", "resources/components/teams/PHO.png", "PHO", new Color(29, 17, 96));
	public static Team PortlandTrailBlazers = new Team("Portland Trail Blazers", "resources/components/teams/POR.png", "POR", new Color(224, 58, 62));
	public static Team SacramentoKings = new Team("Sacramento Kings", "resources/components/teams/SAC.png", "SAC", new Color(91, 43, 130));
	public static Team SanAntonioSpurs = new Team("San Antonio Spurs", "resources/components/teams/SAS.png", "SAS", new Color(196, 206, 211));
	public static Team TorontoRaptors = new Team("Toronto Raptors", "resources/components/teams/TOR.png", "TOR", new Color(206, 17, 65));
	public static Team UtahJazz = new Team("Utah Jazz", "resources/components/teams/UTH.png", "UTH", new Color(0, 71, 27));
	public static Team WashingtonWizards = new Team("Washington Wizards", "resources/components/teams/WAS.png", "WAS", new Color(0, 43, 92));
	
	
	/**
	 * This method gets a String, which will be used as a username,
	 * and checks if the file users.txt has it inside. It checks the
	 * file line by line, and then looks at the first String until
	 * the delimiter is reached. It returns a boolean; true for
	 * existing username, and false for not used one. This method
	 * is used for checking if a user exists, and not for validating
	 * a username for sign-up process.
	 * @param username
	 * @return boolean
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public static boolean checkUsername(String username) {
		File users = new File("resources/users.txt");
		try {
			users.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (Scanner inputFile = new Scanner(Paths.get("resources/users.txt"))) {
			inputFile.useDelimiter("-----|\\n");
			while (inputFile.hasNext()) {
				if (inputFile.next().equals(username)) {
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}
	
	/**
	 * This method is for bringing the password of a user.
	 * It opens the file users.txt and then checks it line by line.
	 * It finds the given username in the file and then takes
	 * the next string, which is the password of the user according
	 * to the format of the file. It returns the password of the user,
	 * which will be used for checking the password in LoginUI.
	 * This method does not include a check for user existence since
	 * it is called if and only if the username exists in the file.
	 * @param username
	 * @return password
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public static String bringPassword(String username) {
		File users = new File("resources/users.txt");
		try {
			users.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (Scanner inputFile = new Scanner(Paths.get("resources/users.txt"))) {
			inputFile.useDelimiter("-----|\\n");
			while (inputFile.hasNext()) {
				if (inputFile.next().equals(username)) {
					String password = inputFile.next();
					return password;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		/**
		 * This method will never return null, since
		 * this method is called if and only if a
		 * user exists.
		 * @author Göktürk Gök
		 * @date 03-01-2024
		 */
	}
	
	/**
	 * This method is used for login process. If a consistent pair of username
	 * and password is given by user, this method is ran. It opens the users.txt
	 * file, and finds the line that holds the information of the same username
	 * of given. Then, it creates a new User object, which is used for keeping
	 * the information of current user, using the information such as age, profile
	 * picture path and mail address. Then, it creates a Team object with which
	 * the user will play. Then, it calls the method for putting the existing
	 * NBA teams into a HashMap for keeping them more organized, with their names.
	 * After that, it calls the Drafting.selectTeams() method to choose which teams
	 * will play in this session. Therefore, it calls PlayerReader.readPlayers()
	 * to make player informations ready for the game. Finally, it shuffles the
	 * playing teams for making them randomized for one more time, and returns
	 * the created User object.
	 * @param username
	 * @return User currentUser
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public static User loginUser(String username) {
		File users = new File("resources/users.txt");
		try {
			users.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try (Scanner inputFile = new Scanner(Paths.get("resources/users.txt"))) {
			inputFile.useDelimiter("-----|\\n");
			while (inputFile.hasNext()) {
				if (inputFile.next().equals(username)) {
					String password = inputFile.next();
					String name = inputFile.next();
					String surname = inputFile.next();
					String mail = inputFile.next();
					int age = inputFile.nextInt();
					String profilePicturePath = inputFile.next();
					
					currentUser = new User(name, surname, username, mail, age, password, profilePicturePath);
					instantiateTeam();
					getTeamsReady();
					Drafting.selectTeams();
					PlayerReader.readPlayers();
					Collections.shuffle(Drafting.playingTeams);
					return currentUser;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * This method creates the team that the user will play with,
	 * choosing a random name from the set of 18 preset names (team
	 * name can be changed by user) and a random RGB color, and returns
	 * the team created.
	 * @return Team currentTeam
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public static Team instantiateTeam() {
		Random random = new Random();
		String[] teamNames = {"Sunset Valley Goats", "Potcastle Bassfishes", "Rosehill Roses", "Steelhill Warriors", "Birdhill Falcons", "Eagle Eagles", "Tourhill Lions", "Copperville Cables", "Blackcustoms Conquerors", "Yellowtown Seagulls", "Largedrawer Drawers", "Littledrawer Drawers", "Paperhouse Stamps", "Newcity Chimneys", "Blacksea Warriors", "Greenspring Bulls", "Judgetown Bulls", "Cradlestone Eagles"};
		String placeholderTeamName = teamNames[random.nextInt(18)];
		int randomColorR = random.nextInt(256);
		int randomColorG = random.nextInt(256);
		int randomColorB = random.nextInt(256);
		
		currentTeam = new Team(placeholderTeamName, new Color(randomColorR, randomColorG, randomColorB));
		
		return currentTeam;
		
	}
	
	/**
	 * This method sets Login.currentUser to null to
	 * log the current user out.
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public static void logoutUser() {
		Login.currentUser = null;
	}
	
	/**
	 * This method puts all the current real NBA teams to a
	 * HashMap to keep them more organized, using their names
	 * as their keys.
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public static void getTeamsReady() {
		teamsOfNBA.put("Atlanta Hawks", AtlantaHawks);
		teamsOfNBA.put("Brooklyn Nets", BrooklynNets);
		teamsOfNBA.put("Boston Celtics", BostonCeltics);
		teamsOfNBA.put("Charlotte Hornets", CharlotteHornets);
		teamsOfNBA.put("Chicago Bulls", ChicagoBulls);
		teamsOfNBA.put("Cleveland Cavaliers", ClevelandCavaliers);
		teamsOfNBA.put("Dallas Mavericks", DallasMavericks);
		teamsOfNBA.put("Denver Nuggets", DenverNuggets);
		teamsOfNBA.put("Detroit Pistons", DetroitPistons);
		teamsOfNBA.put("Golden State Warriors", GoldenStateWarriors);
		teamsOfNBA.put("Houston Rockets", HoustonRockets);
		teamsOfNBA.put("Indiana Pacers", IndianaPacers);
		teamsOfNBA.put("Los Angeles Clippers", LosAngelesClippers);
		teamsOfNBA.put("Los Angeles Lakers", LosAngelesLakers);
		teamsOfNBA.put("Memphis Grizzlies", MemphisGrizzlies);
		teamsOfNBA.put("Miami Heat", MiamiHeat);
		teamsOfNBA.put("Milwaukee Bucks", MilwaukeeBucks);
		teamsOfNBA.put("Minnesota Timberwolves", MinnesotaTimberwolves);
		teamsOfNBA.put("New Orleans Pelicans", NewOrleansPelicans);
		teamsOfNBA.put("New York Knicks", NewYorkKnicks);
		teamsOfNBA.put("Oklahoma City Thunder", OklahomaCityThunder);
		teamsOfNBA.put("Orlando Magic", OrlandoMagic);
		teamsOfNBA.put("Philadelphia 76ers", Philadelphia76ers);
		teamsOfNBA.put("Phoenix Suns", PhoenixSuns);
		teamsOfNBA.put("Portland Trail Blazers", PortlandTrailBlazers);
		teamsOfNBA.put("Sacramento Kings", SacramentoKings);
		teamsOfNBA.put("San Antonio Spurs", SanAntonioSpurs);
		teamsOfNBA.put("Toronto Raptors", TorontoRaptors);
		teamsOfNBA.put("Utah Jazz", UtahJazz);
		teamsOfNBA.put("Washington Wizards", WashingtonWizards);
		
	}	
}
