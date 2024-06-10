package user;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.Scanner;

public class SignUp {
	File users;
	/**
	 * This method takes a String and checks if it exists
	 * in users.txt and is valid regarding its format. It
	 * opens the users.txt file first, and then checks if
	 * a user with same name exists. If user exists, it returns
	 * 2. If usename is unique, but not valid by the format,
	 * it returns 3 if it contains characters other than word
	 * characters (Reg-Ex check) or 4 if it has less than 3
	 * characters. If the username is available and valid,
	 * it returns 1.
	 * @param username
	 * @return int (available or why not available)
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public static int checkUsername(String username) {
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
					return 2;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (username.length() >= 3 && username.matches("\\w+")) {
			return 1;
		} else if (username.length() >= 3 && username.matches("\\w+") == false){
			return 3;
		} else {
			return 4;
		}
		
	}
	
	/**
	 * This method checks the given password as a String by using Regular Expressions.
	 * It adds the error String the following values by the unsatisfied condition:
	 * 1 : Password is valid
	 * 2 : Password does not have any letters
	 * 3 : Password does not contain any digits
	 * 4 : Password does not contain any special characters
	 * Then, it returns the String, which will be evaulated in SignUpUI for validating
	 * the password a new user.
	 * @param password
	 * @return String representing unsatisfied requirements of password
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public static String checkPassword(String password) {
		String validation = "0";
		if (password.length() < 8) {
			validation += "1";
		}
		if (password.matches(".*[a-zA-Z]+.*") == false) {
			validation += "2";
		}
		if (password.matches(".*\\d+.*") == false) {
			validation += "3";
		}
		if (password.matches(".*\\p{Punct}.*") == false) { // POSIX matching
			validation += "4";
		}
		
		return validation;
	}
	
	/**
	 * This method is used for checking the name and surname of a new user.
	 * The following are returned at corresponding situations:
	 * 1 : Name/surname is valid
	 * 2 : Name/surname contains non-letter or non-whitespace characters
	 * 3 : Name/surname is less than 3 characters or full of whitespaces
	 * 4 : Name/surname is less than 3 characters and contains non-letter or non-whitespace characters
	 * Return value is treated in account creation page.
	 * @param name
	 * @return int representing the unsatisfied requirement of name or surname
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public static int checkName(String name) { // this method will be used for both name and surname
		if (name.length() >= 3 && name.matches("^[a-zA-ZöğçşüÖĞÇŞÜİı ]+$") && name.matches("^\\s+$") == false) {
			return 1;
		} else if (name.length() >= 3 && name.matches("^[a-zA-ZöğçşüÖĞÇŞÜİı]+$") == false){
			return 2;
		} else if (name.length() < 3 && name.matches("^[a-zA-ZöğçşüÖĞÇŞÜİı]+$") || name.matches("^\\s+$")){
			return 3;
		} else {
			return 4;
		}
	}
	
	/**
	 * This method first checks if a user has the given mail address, by opening
	 * the users.txt file. If it occurs, the method returns 2. Else if the mail address
	 * does not match the format (hello@world.com) the method returns 3. A valid
	 * mail address returns 1.
	 * @param mail
	 * @return int representing the validity of given mail address or the reason that it is not accepted
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public static int checkMail(String mail) {
		try (Scanner inputFile = new Scanner(Paths.get("resources/users.txt"))) {
			while (inputFile.hasNext()) {
				inputFile.useDelimiter("-----|\\n");
				if (inputFile.next().equals(mail)) {
					return 2;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		if (mail.matches("^[a-zA-Z0-9._-]+@[a-z]+\\.[a-z]+$") || mail.matches("^[a-zA-Z0-9]+@[a-z]+\\.[a-z]+\\.[a-z]+$")) {
			return 1;
		} else {
			return 3;
		}
	}

	/**
	 * This method checks if the given age
	 * is less than 12 or not.
	 * @param age
	 * @return true if valid, false if invalid
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public static boolean checkAge(int age) {
		if (age >= 12) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * This method signs a user up by opening a FileWriter for users.txt
	 * and appending it (true parameter) a line containing the information
	 * of new user. This method does not include any validations since all
	 * the parameters are validated before this method is called.
	 * @param username
	 * @param password
	 * @param name
	 * @param surname
	 * @param mail
	 * @param age
	 * @param profilePicturePath
	 * @throws IOException
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public static void signUserUp(String username, String password, String name, String surname, String mail, int age, String profilePicturePath) throws IOException {
		FileWriter users = new FileWriter("resources/users.txt", true);
		try (PrintWriter userPrintWriter = new PrintWriter(users)) {
			String userLine = username + "-----" + password + "-----" + name + "-----" + surname + "-----" + mail + "-----" + age + "-----" + profilePicturePath + "-----";
			userPrintWriter.println(userLine);
		}
	}
	
	
}
