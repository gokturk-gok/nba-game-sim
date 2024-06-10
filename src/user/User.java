package user;

public class User {
	private String name;
	private String surname;
	private String username;
	private String mail;
	private int age;
	private String password;
	private String profilePicturePath;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProfilePicturePath() {
		return profilePicturePath;
	}
	public void setProfilePicturePath(String profilePicturPath) {
		this.profilePicturePath = profilePicturPath;
	}
	/**
	 * This is the constructor of User objects, which is used
	 * while logging a user in. It makes the program show and
	 * use customized information for each user while use.
	 * @param name
	 * @param surname
	 * @param username
	 * @param mail
	 * @param age
	 * @param password
	 * @param profilePicturePath
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public User(String name, String surname, String username, String mail, int age, String password, String profilePicturePath) {
		this.name = name;
		this.surname = surname;
		this.username = username;
		this.mail = mail;
		this.age = age;
		this.password = password;
		this.profilePicturePath = profilePicturePath;
	}
	
}
