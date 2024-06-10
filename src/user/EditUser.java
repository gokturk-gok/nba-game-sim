package user;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class EditUser {
	/**
	 * An important note about users.txt:
	 * In this project, the used separator for users.txt
	 * is a String of five  hyphens ("-----"). It makes
	 * the assumption of a user will not include that
	 * separator in any of their infos. However. there could
	 * have been a more complicated and unique separator
	 * for making it more user friendly.
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	
	/**
	 * This method is for editing the age field in the users.txt file.
	 * Method takes the username of the User that is logged in and
	 * the age value provided from the corresponding component in
	 * ProfileUI, and then opens the users.txt file. Finds the
	 * line that holds the information of the current user, and separates
	 * that line to an Array, holding other users' information in an
	 * ArrayList to be able to print them again to users.txt file at the end.
	 * Then, the method creates a new String, containing
	 * the new age, and prints the whole users.txt file again since
	 * there is no option to only change corresponding characters of
	 * the file.
	 * This method needs no validation of age since it is called if and
	 * only if the given age is valid, which is that being at least 12.
	 * @param username
	 * @param newAge
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public static void changeAge(String username, int newAge) {
		ArrayList<String> datafile = new ArrayList<String>();
		File users = new File("resources/users.txt");
		try (Scanner inputFile = new Scanner(Paths.get("resources/users.txt"))) {
			inputFile.useDelimiter("-----|\\n");
			String newLine = "";
			while (inputFile.hasNext()) {
				String nextLine = inputFile.nextLine();
				if (nextLine.split("-----")[0].equals(username)) {
					Login.currentUser.setAge(newAge);
					newLine = username + "-----" + Login.currentUser.getPassword() + "-----" + Login.currentUser.getName() + "-----" + Login.currentUser.getSurname() + "-----" + Login.currentUser.getMail() + "-----" + newAge + "-----" + Login.currentUser.getProfilePicturePath();
					datafile.add(newLine);
				} else {
					datafile.add(nextLine);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			FileWriter userWriter = new FileWriter("resources/users.txt");
			try (PrintWriter userPrintWriter = new PrintWriter(userWriter)) {
				for (String line : datafile) {
					userPrintWriter.println(line);
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This method works similar to the one above. It takes two parameters,
	 * which are the username of the current user and the new mail addres
	 * It opens the users.txt file, finds the line dedicated to the current
	 * user, and splits it into an Array, holding other users information
	 * in an ArrayList to be able to print them after the changing process is
	 * completed. Then, creates a new String containing the new mail address
	 * and other information. Finally, it prints all the information on the
	 * ArrayList and the new String to users.txt from scratch.
	 * This method requires no validation inside it since it is called
	 * after the validation is done at the UI page.
	 * @param username
	 * @param newMail
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public static void changeMail(String username, String newMail) {
		ArrayList<String> datafile = new ArrayList<String>();
		File users = new File("resources/users.txt");
		try (Scanner inputFile = new Scanner(Paths.get("resources/users.txt"))) {
			inputFile.useDelimiter("-----|\\n");
			String newLine = "";
			while (inputFile.hasNext()) {
				String nextLine = inputFile.nextLine();
				if (nextLine.split("-----")[0].equals(username)) {
					Login.currentUser.setMail(newMail);
					newLine = username + "-----" + Login.currentUser.getPassword() + "-----" + Login.currentUser.getName() + "-----" + Login.currentUser.getSurname() + "-----" + newMail + "-----" + Login.currentUser.getAge() + "-----" + Login.currentUser.getProfilePicturePath();
					datafile.add(newLine);
				} else {
					datafile.add(nextLine);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			FileWriter userWriter = new FileWriter("resources/users.txt");
			try (PrintWriter userPrintWriter = new PrintWriter(userWriter)) {
				for (String line : datafile) {
					userPrintWriter.println(line);
				}
			
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This method takes two parameters, username of the current user and the
	 * new password that user wants to change theirs to. This method first opens
	 * the users.txt file, and takes all other lines except the one containing
	 * current user's information to an ArrayList to print at the end, and then
	 * creates a new String that contains new password. Finally, it prints all the
	 * saved lines and new String of current user's information to users.txt.
	 * This method does not have a validator since it is called if and only if
	 * a valid password is given in the profile editing page.
	 * @param username
	 * @param newPassword
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public static void changePassword(String username, String newPassword) {
		ArrayList<String> datafile = new ArrayList<String>();
		File users = new File("resources/users.txt");
		try (Scanner inputFile = new Scanner(Paths.get("resources/users.txt"))) {
			inputFile.useDelimiter("-----|\\n");
			String newLine = "";
			while (inputFile.hasNext()) {
				String nextLine = inputFile.nextLine();
				if (nextLine.split("-----")[0].equals(username)) {
					Login.currentUser.setPassword(newPassword);
					newLine = username + "-----" + newPassword + "-----" + Login.currentUser.getName() + "-----" + Login.currentUser.getSurname() + "-----" + Login.currentUser.getMail() + "-----" + Login.currentUser.getAge() + "-----" + Login.currentUser.getProfilePicturePath();
					datafile.add(newLine);
				} else {
					datafile.add(nextLine);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		try {
			FileWriter userWriter = new FileWriter("resources/users.txt");
			try (PrintWriter userPrintWriter = new PrintWriter(userWriter)) {
				for (String line : datafile) {
					userPrintWriter.println(line);
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * This method takes the current user's username and path of the new profile
	 * picture that user wants to use. It opens the users.txt file, and saves
	 * the unrelated lines, which are all of the file except the one line that
	 * contains current user's information, and keeps current user's information
	 * in an array. Then, it creates a new String containing the new profile
	 * picture path, and finally prints all of the information in the ArrayList
	 * and new String to the file users.txt.
	 * @param username
	 * @param newProfilePicturePath
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public static void changeProfilePicturePath(String username, String newProfilePicturePath) {
		ArrayList<String> datafile = new ArrayList<String>();
		File users = new File("resources/users.txt");
		try (Scanner inputFile = new Scanner(Paths.get("resources/users.txt"))) {
			inputFile.useDelimiter("-----|\\n");
			String newLine = "";
			while (inputFile.hasNext()) {
				String nextLine = inputFile.nextLine();
				if (nextLine.split("-----")[0].equals(username)) {
					Login.currentUser.setProfilePicturePath(newProfilePicturePath);
					newLine = username + "-----" + Login.currentUser.getPassword() + "-----" + Login.currentUser.getName() + "-----" + Login.currentUser.getSurname() + "-----" + Login.currentUser.getMail() + "-----" + Login.currentUser.getAge() + "-----" + newProfilePicturePath;
					datafile.add(newLine);
				} else {
					datafile.add(nextLine);
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		try {
			FileWriter userWriter = new FileWriter("resources/users.txt");
			try (PrintWriter userPrintWriter = new PrintWriter(userWriter)) {
				for (String line : datafile) {
					userPrintWriter.println(line);
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
