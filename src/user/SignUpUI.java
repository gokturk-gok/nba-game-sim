package user;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.swing.*;
import javax.swing.filechooser.*;

public class SignUpUI extends JFrame implements ActionListener {
	
	
	// ORDER THEM ALPHABETICALLY
	JFrame signUpFrame;
	JLayeredPane signUpPanel;
	JLabel backgroundLabel;
	JLabel promptUsername;
	JLabel labelTextBoxUsername;
	JTextField textBoxUsername;
	JLabel promptPassword;
	JPasswordField textBoxPassword;
	ImageIcon signUpButtonIcon;
	JButton signUpButton;
	ImageIcon backgroundImage;
	Image background;
	ImageIcon signUpBackgroundImage;
	JLabel signUpBackgroundLabel;
	ImageIcon logoImage;
	JLabel logoLabel;
	JLabel accountPrompt;
	File fontFileInterSemibold;
	JLabel invalidUsername = new JLabel();
	JTextArea invalidPassword = new JTextArea();
	JLabel haveAnAccount;
	JLabel goToSignIn;
	JButton goToSignInButton;
	Color transparent = new Color(0, 0, 0, 0);
	
	// SIGN-UP SECOND STAGE COMPONENTS (i.e. mail, name etc.)
	JLayeredPane signUpDetailsPanel;
	JLabel signUpDetailsPrompt;
	JLabel promptName;
	JLabel promptSurname;
	JLabel promptMail;
	JTextField textBoxName;
	JTextField textBoxSurname;
	JTextField textBoxMail;
	ImageIcon continueButtonIcon;
	JButton continueButton;
	JLabel signUpDetailsFieldBackgroundLabel;
	JLabel signUpDetailsPanelBackgroundLabel;
	JLabel signUpDetailsLogoLabel;
	JLabel invalidName = new JLabel();
	JLabel invalidSurname = new JLabel();
	JLabel invalidMail = new JLabel();
	
	// SIGN UP STAGE 3 (PROFILE CREATOR)
	
	String profilePicturePath = "resources/components/signupui/defaultpp.png";
	JLayeredPane signUpProfilePanel;
	JLabel signUpProfilePanelFieldBackgroundLabel;
	JLabel signUpProfilePanelPanelBackgroundLabel;
	JLabel signUpProfilePrompt;
	JLabel promptAge;
	JSpinner ageSpinner;
	JLabel invalidAge = new JLabel();
	JButton completeButton;
	ImageIcon completeButtonIcon;
	JLabel signUpProfileLogoLabel;
	JLabel signUpProfilePicture;
	JButton changeProfilePicture;
	ImageIcon defaultProfilePicture;
	
	// signing up fields
	
	String username;
	String password;
	String name;
	String surname;
	String mail;
	int age;
	String profilePicturePathname;
	
	// ACCOUNT CREATED JUMPSCREEN
	JLabel accountCreated;
	JButton signInButton;
	
	
	
	
	// FONT
	Font InterSemibold = Font.createFont(Font.PLAIN, new File("resources/components/fonts/Inter-SemiBold.ttf"));
	Font InterSemibold36 = InterSemibold.deriveFont((float) 36.0);
	Font InterRegular = Font.createFont(Font.PLAIN, new File("resources/components/fonts/Inter-Regular.ttf"));
	Font InterRegular14x4 = InterRegular.deriveFont((float) 14.4);
	Font InterRegular12 = InterRegular.deriveFont((float) 12.0);
	
	/**
	 * This is the constructor of the Sign Up page, where a user can
	 * create a new account. It has four panels which are shown respectively
	 * and if the process runs correctly.
	 * It first shows fields for username and password, and a button for
	 * going to login page. After that panel, there are fields for name,
	 * surname, and mail address. Third, it shows options to set the age
	 * and profile picture, with a default profile picture. Finally,
	 * it shows a success message and option to go to the login page.
	 * Those fields all show warning messages if there is a problem
	 * with the validity of provided information.
	 * This constructor throws the following exception since it uses
	 * custom fonts.
	 * @throws FontFormatException
	 * @throws IOException
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public SignUpUI() throws FontFormatException, IOException {

		
		// random background selector
		Random random = new Random();
		int backgroundIndex = random.nextInt(5) + 1;
		String backgroundPath = "resources/backgrounds/bg" + backgroundIndex + ".jpg";
		backgroundImage = new ImageIcon(backgroundPath);
		background = backgroundImage.getImage();
		background = background.getScaledInstance(1440, 900, Image.SCALE_SMOOTH);
		backgroundImage = new ImageIcon(background);
		backgroundLabel = new JLabel();
		backgroundLabel.setSize(1440, 900);
		backgroundLabel.setIcon(backgroundImage);

		
		signUpBackgroundImage = new ImageIcon("resources/components/signupui/signupbg.png");
		signUpBackgroundLabel = new JLabel();
		signUpBackgroundLabel.setIcon(signUpBackgroundImage);
		signUpBackgroundLabel.setSize(540, 900);
		signUpBackgroundLabel.setLocation(900, 0);
		
		logoImage = new ImageIcon("resources/components/signupui/signuplogo.png");
		logoLabel = new JLabel();
		logoLabel.setIcon(logoImage);
		logoLabel.setSize(400, 115);
		logoLabel.setLocation(970, 93);
		

		accountPrompt = new JLabel();
		accountPrompt.setText("Create an account");
		accountPrompt.setFont(InterSemibold36);
		accountPrompt.setSize(400, 44);
		accountPrompt.setPreferredSize(getPreferredSize());
		accountPrompt.setHorizontalAlignment(JLabel.CENTER);
		accountPrompt.setLocation(970, 313);

		signUpButtonIcon = new ImageIcon("resources/components/signupui/signupbutton.png");
		signUpButton = new JButton();
		signUpButton.setSize(150, 40);
		signUpButton.setLocation(1095, 600); // y = 543
		signUpButton.setIcon(signUpButtonIcon);
		signUpButton.addActionListener(this);
		
		textBoxUsername = new JTextField();
		textBoxUsername.setOpaque(false);
		textBoxUsername.setSize(274, 35);
		textBoxUsername.setFont(InterRegular14x4);
		textBoxUsername.setLocation(1033, 405);
		textBoxUsername.setBackground(transparent);
		
		textBoxPassword = new JPasswordField();
		textBoxPassword.setOpaque(false);
		textBoxPassword.setSize(274, 35);
		textBoxPassword.setFont(InterRegular14x4);
		textBoxPassword.setLocation(1033, 473);
		textBoxPassword.setBackground(transparent);
		
		promptUsername = new JLabel();
		promptUsername.setFont(InterRegular14x4);
		promptUsername.setText("Username");
		promptUsername.setLocation(1037, 388);
		promptUsername.setSize(70, 17);
		promptUsername.setOpaque(false);
		
		promptPassword = new JLabel();
		promptPassword.setFont(InterRegular14x4);
		promptPassword.setText("Password");
		promptPassword.setLocation(1037, 456);
		promptPassword.setSize(70, 17);
		promptPassword.setOpaque(false);
		
		haveAnAccount = new JLabel();
		haveAnAccount.setSize(207, 14);
		haveAnAccount.setOpaque(false);
		haveAnAccount.setIcon(new ImageIcon("resources/components/signupui/haveaccount.png"));
		haveAnAccount.setLocation(1031, 733);
		
		goToSignInButton = new JButton();
		goToSignInButton.setIcon(new ImageIcon("resources/components/signupui/gotosignin.png"));
		goToSignInButton.setOpaque(false);
		goToSignInButton.setBorderPainted(false);
		goToSignInButton.setContentAreaFilled(false);
		goToSignInButton.setSize(64, 17);
		goToSignInButton.setLocation(1241, 732);
		goToSignInButton.addActionListener(this);
		
		signUpPanel = new JLayeredPane();
		signUpPanel.setSize(1440, 900);
		signUpPanel.add(goToSignInButton, JLayeredPane.MODAL_LAYER);
		signUpPanel.add(haveAnAccount, JLayeredPane.MODAL_LAYER);
		signUpPanel.add(promptPassword, JLayeredPane.MODAL_LAYER);
		signUpPanel.add(promptUsername, JLayeredPane.MODAL_LAYER);
		signUpPanel.add(textBoxPassword, JLayeredPane.MODAL_LAYER);
		signUpPanel.add(textBoxUsername, JLayeredPane.MODAL_LAYER);
		signUpPanel.add(signUpButton, JLayeredPane.MODAL_LAYER);
		signUpPanel.add(accountPrompt, JLayeredPane.MODAL_LAYER);
		signUpPanel.add(logoLabel, JLayeredPane.MODAL_LAYER);
		signUpPanel.add(signUpBackgroundLabel, JLayeredPane.PALETTE_LAYER);
		signUpPanel.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER); // ADD THAT MORE GENERAL
		
		// construct frame
		signUpFrame = new JFrame();
		signUpFrame.setSize(1440, 900);
		signUpFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		signUpFrame.setBackground(new Color(29, 66, 138));
		signUpFrame.setLayout(null);
		signUpFrame.setTitle("NBAsim24");
		signUpFrame.add(signUpPanel);
		signUpFrame.setResizable(false);
		signUpFrame.setVisible(true);
		signUpFrame.setIconImage((new ImageIcon("resources/components/signupui/appicon.png")).getImage()); // why don't work :(
		
		
		
		
		// SIGN UP SECOND STAGE
		
		Image signUpDetailsPanelBackground = backgroundImage.getImage();
		ImageIcon signUpDetailsPanelBackgroundIcon = new ImageIcon(signUpDetailsPanelBackground);
		signUpDetailsPanelBackgroundLabel = new JLabel();
		signUpDetailsPanel = new JLayeredPane();
		signUpDetailsFieldBackgroundLabel = new JLabel();
		signUpDetailsLogoLabel = new JLabel();
		signUpProfilePicture = new JLabel();
		
		signUpDetailsLogoLabel.setIcon(logoImage);
		signUpDetailsLogoLabel.setSize(400, 115);
		signUpDetailsLogoLabel.setLocation(970, 93);

		signUpDetailsPanelBackgroundLabel.setOpaque(false);
		signUpDetailsPanelBackgroundLabel.setSize(1440, 900);
		signUpDetailsPanelBackgroundLabel.setIcon(signUpDetailsPanelBackgroundIcon);
		
		signUpDetailsFieldBackgroundLabel.setOpaque(false);
		signUpDetailsFieldBackgroundLabel.setIcon(new ImageIcon("resources/components/signupui/signupbg.png"));
		signUpDetailsFieldBackgroundLabel.setSize(540, 900);
		signUpDetailsFieldBackgroundLabel.setLocation(900, 0);

		
		
		
		signUpDetailsPanel.setSize(1440, 900);

		
		signUpDetailsPrompt = new JLabel();
		signUpDetailsPrompt.setOpaque(false);
		signUpDetailsPrompt.setFont(InterSemibold36);
		signUpDetailsPrompt.setSize(400, 44);
		signUpDetailsPrompt.setText("Give details");
		signUpDetailsPrompt.setHorizontalAlignment(JLabel.CENTER);
		signUpDetailsPrompt.setLocation(970, 313);
		
		
		promptName = new JLabel();
		promptName.setFont(InterRegular14x4);
		promptName.setText("Name");
		promptName.setLocation(1037, 388);
		promptName.setSize(70, 17);
		promptName.setOpaque(false);
		
		promptSurname = new JLabel();
		promptSurname.setFont(InterRegular14x4);
		promptSurname.setText("Surname");
		promptSurname.setLocation(1037, 456);
		promptSurname.setSize(70, 17);
		promptSurname.setOpaque(false);
		
		promptMail = new JLabel();
		promptMail.setFont(InterRegular14x4);
		promptMail.setText("E-mail address");
		promptMail.setLocation(1037, 524);
		promptMail.setSize(200, 17);
		promptMail.setOpaque(false);
		
		textBoxName = new JTextField();
		textBoxName.setOpaque(false);
		textBoxName.setSize(274, 35);
		textBoxName.setFont(InterRegular14x4);
		textBoxName.setLocation(1033, 405);
		textBoxName.setBackground(transparent);
		
		textBoxSurname = new JTextField();
		textBoxSurname.setOpaque(false);
		textBoxSurname.setSize(274, 35);
		textBoxSurname.setFont(InterRegular14x4);
		textBoxSurname.setLocation(1033, 473);
		textBoxSurname.setBackground(transparent);
		
		textBoxMail = new JTextField();
		textBoxMail.setOpaque(false);
		textBoxMail.setSize(274, 35);
		textBoxMail.setFont(InterRegular14x4);
		textBoxMail.setLocation(1033, 541);
		textBoxMail.setBackground(transparent);
		
		continueButtonIcon = new ImageIcon("resources/components/signupui/continuebutton.png");
		continueButton = new JButton();
		continueButton.setSize(150, 40);
		continueButton.setLocation(1095, 600); // y = 543
		continueButton.setIcon(continueButtonIcon);
		continueButton.addActionListener(this);
		
		signUpDetailsPanel.add(signUpDetailsLogoLabel, JLayeredPane.MODAL_LAYER);
		signUpDetailsPanel.add(continueButton, JLayeredPane.MODAL_LAYER);
		signUpDetailsPanel.add(textBoxMail, JLayeredPane.MODAL_LAYER);
		signUpDetailsPanel.add(promptMail, JLayeredPane.MODAL_LAYER);
		signUpDetailsPanel.add(textBoxSurname, JLayeredPane.MODAL_LAYER);
		signUpDetailsPanel.add(promptSurname, JLayeredPane.MODAL_LAYER);
		signUpDetailsPanel.add(textBoxName, JLayeredPane.MODAL_LAYER);
		signUpDetailsPanel.add(promptName, JLayeredPane.MODAL_LAYER);
		signUpDetailsPanel.add(signUpDetailsPrompt, JLayeredPane.MODAL_LAYER);
		signUpDetailsPanel.add(signUpDetailsFieldBackgroundLabel, JLayeredPane.PALETTE_LAYER);
		signUpDetailsPanel.add(signUpDetailsPanelBackgroundLabel, JLayeredPane.DEFAULT_LAYER);
		
		// SIGN UP STAGE 3 (PROFILE CREATION)
		
		
		signUpProfilePanel = new JLayeredPane();
		signUpProfilePanelFieldBackgroundLabel = new JLabel();
		signUpProfilePanelPanelBackgroundLabel = new JLabel();
		signUpProfileLogoLabel = new JLabel();
		signUpProfilePrompt = new JLabel();
		promptAge = new JLabel();
		completeButton = new JButton();
		completeButtonIcon = new ImageIcon("resources/components/signupui/completebutton.png");
		changeProfilePicture = new JButton();
		ageSpinner = new JSpinner();
		
		signUpProfilePanelFieldBackgroundLabel.setIcon(new ImageIcon("resources/components/signupui/signupbg.png"));
		signUpProfilePanelFieldBackgroundLabel.setSize(540, 900);
		signUpProfilePanelFieldBackgroundLabel.setLocation(900, 0);
		
		signUpProfilePanelPanelBackgroundLabel.setIcon(backgroundImage);
		signUpProfilePanelPanelBackgroundLabel.setSize(1440, 900);
		signUpProfileLogoLabel.setIcon(logoImage);
		
		signUpProfilePanel.setSize(1440, 900);
		
		signUpProfilePrompt = new JLabel();
		signUpProfilePrompt.setOpaque(false);
		signUpProfilePrompt.setFont(InterSemibold36);
		signUpProfilePrompt.setSize(400, 44);
		signUpProfilePrompt.setText("Complete your profile");
		signUpProfilePrompt.setHorizontalAlignment(JLabel.CENTER);
		signUpProfilePrompt.setLocation(970, 313);
		
		ageSpinner.setLocation(1037,640);
		ageSpinner.setSize(274, 35);
		ageSpinner.setFont(InterRegular14x4);
		ageSpinner.setLocation(1033, 541);
		ageSpinner.setAlignmentX(JSpinner.LEFT_ALIGNMENT);
		ageSpinner.setBackground(transparent);
		
		promptAge.setFont(InterRegular14x4);
		promptAge.setText("Age");
		promptAge.setLocation(1037, 524);
		promptAge.setSize(200, 17);
		promptAge.setOpaque(false);
		
		completeButton.setSize(150, 40);
		completeButton.setLocation(1095, 600); // y = 543
		completeButton.setIcon(completeButtonIcon);
		completeButton.addActionListener(this);
		
		signUpProfilePicture.setIcon(new ImageIcon("resources/components/signupui/defaultpp.png"));
		signUpProfilePicture.setSize(100, 100);
		signUpProfilePicture.setLocation(1120, 379);
		
		changeProfilePicture.setIcon(new ImageIcon("resources/components/signupui/selectpp.png"));
		changeProfilePicture.setSize(97, 14);
		changeProfilePicture.setLocation(1120, 492);
		changeProfilePicture.setBorderPainted(false);
		changeProfilePicture.setContentAreaFilled(false);
		changeProfilePicture.addActionListener(this);
		
		signUpProfilePanel.add(signUpProfilePanelPanelBackgroundLabel, JLayeredPane.DEFAULT_LAYER);
		signUpProfilePanel.add(signUpProfilePanelFieldBackgroundLabel, JLayeredPane.PALETTE_LAYER);
		signUpProfilePanel.add(signUpProfilePrompt, JLayeredPane.MODAL_LAYER);
		signUpProfilePanel.add(promptAge, JLayeredPane.MODAL_LAYER);
		signUpProfilePanel.add(signUpProfilePicture, JLayeredPane.MODAL_LAYER);
		signUpProfilePanel.add(completeButton, JLayeredPane.MODAL_LAYER);
		signUpProfilePanel.add(changeProfilePicture, JLayeredPane.MODAL_LAYER);
		signUpProfilePanel.add(ageSpinner, JLayeredPane.MODAL_LAYER);
	}
	
	@Override
	/**
	 * This overridden method of ActionListener interface is used for
	 * keeping track of the operations done by user on the page. For
	 * instance, it takes the corresponding information after a button
	 * is pressed, and continues the operation after validity checks.
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == signUpButton) {
			String usernameInput = textBoxUsername.getText();
			int usernameCheck = SignUp.checkUsername(usernameInput);
			if (usernameCheck == 1) {
				promptUsername.setForeground(Color.black);
				invalidUsername.setVisible(false);
				textBoxUsername.setForeground(Color.black);
			} else if (usernameCheck != 1) {
				invalidUsername.setForeground(new Color(0xC8102E));
				invalidUsername.setSize(400, 15);
				invalidUsername.setFont(InterRegular12);
				invalidUsername.setLocation(1034, 438);
				invalidUsername.setVisible(true);
				signUpPanel.add(invalidUsername, JLayeredPane.DRAG_LAYER);
				promptUsername.setForeground(new Color(0xC8102E));
				textBoxUsername.setForeground(new Color(0xC8102E));
				if (usernameCheck == 2) {
					invalidUsername.setText("This username is already taken.");
				} else if (usernameCheck == 3) {
					invalidUsername.setText("Your username can have only letters and numbers.");
				} else if (usernameCheck == 4) {
					invalidUsername.setText("Your username must have at least 3 characters.");
				}
			}
			
			char[] passwordInputChars = textBoxPassword.getPassword(); // not using getText() since it is deprecated
			String passwordInput = new String(passwordInputChars);
			
			String passwordCheck = SignUp.checkPassword(passwordInput);
			if (passwordCheck.equals("0")) {
				promptPassword.setForeground(Color.black);
				invalidPassword.setVisible(false);
				textBoxPassword.setForeground(Color.black);
				// VALIDATION VALUE AND THEN SIGN UP
			} else {
				invalidPassword.setEditable(false);
				invalidPassword.setFocusable(false);
				invalidPassword.setForeground(new Color(0xC8102E));
				invalidPassword.setSize(300, 100);
				invalidPassword.setFont(InterRegular12);
				invalidPassword.setLocation(1034, 506);
				invalidPassword.setVisible(true);
				invalidPassword.setOpaque(false);
				signUpPanel.add(invalidPassword, JLayeredPane.DRAG_LAYER);
				promptPassword.setForeground(new Color(0xC8102E));
				textBoxPassword.setForeground(new Color(0xC8102E));
				String invalidPasswordText = "";
				if (passwordCheck.contains("1")) {
					invalidPasswordText += ("At least 8 characters\n");
				}
				if (passwordCheck.contains("2")) {
					invalidPasswordText += ("A letter\n");
				}
				if (passwordCheck.contains("3")) {
					invalidPasswordText += ("A digit\n");
				}
				if (passwordCheck.contains("4")) {
					invalidPasswordText += ("A special character\n");
				}
				invalidPasswordText = "Your password must have\n" + invalidPasswordText;
				invalidPassword.setText(invalidPasswordText);
			}
			
			if (usernameCheck == 1 && passwordCheck.equals("0")) {
				signUpPanel.setVisible(false);
				signUpFrame.add(signUpDetailsPanel);
				signUpDetailsPanel.setVisible(true);
				username = textBoxUsername.getText();
				password = new String(passwordInput);
			}
		} else if (e.getSource() == goToSignInButton) {
			try {
				new LoginUI();
			} catch (FontFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			signUpFrame.setVisible(false);
		} else if (e.getSource() == continueButton) {
			int checkedName = SignUp.checkName(textBoxName.getText());
			int checkedSurname = SignUp.checkName(textBoxSurname.getText());
			int checkedMail = SignUp.checkMail(textBoxMail.getText());
			
			if (checkedName == 1) {
				promptName.setForeground(Color.black);
				invalidName.setVisible(false);
				textBoxName.setForeground(Color.black);
			} else {
				invalidName.setForeground(new Color(0xC8102E));
				invalidName.setSize(400, 15);
				invalidName.setFont(InterRegular12);
				invalidName.setLocation(1034, 438);
				invalidName.setVisible(true);
				signUpDetailsPanel.add(invalidName, JLayeredPane.DRAG_LAYER);
				promptName.setForeground(new Color(0xC8102E));
				textBoxName.setForeground(new Color(0xC8102E));
				if (checkedName == 2) {
					invalidName.setText("Your name can only include letters.");
				} else {
					invalidName.setText("Your name must have at least 3 letters.");
				}
			}
			
			if (checkedSurname == 1) {
				promptSurname.setForeground(Color.black);
				invalidSurname.setVisible(false);
				textBoxSurname.setForeground(Color.black);
			} else {
				invalidSurname.setForeground(new Color(0xC8102E));
				invalidSurname.setSize(400, 15);
				invalidSurname.setFont(InterRegular12);
				invalidSurname.setLocation(1034, 506);
				invalidSurname.setVisible(true);
				signUpDetailsPanel.add(invalidSurname, JLayeredPane.DRAG_LAYER);
				promptSurname.setForeground(new Color(0xC8102E));
				textBoxSurname.setForeground(new Color(0xC8102E));
				if (checkedSurname == 2) {
					invalidSurname.setText("Your surname can only include letters.");
				} else {
					invalidSurname.setText("Your surname must have at least 3 letters.");
				}
			}
			
			if (checkedMail == 1) {
				promptMail.setForeground(Color.black);
				invalidMail.setVisible(false);
				textBoxMail.setForeground(Color.black);
			} else {
				invalidMail.setForeground(new Color(0xC8102E));
				invalidMail.setSize(800, 15);
				invalidMail.setFont(InterRegular12);
				invalidMail.setLocation(1034, 574);
				invalidMail.setVisible(true);
				signUpDetailsPanel.add(invalidMail, JLayeredPane.DRAG_LAYER);
				promptMail.setForeground(new Color(0xC8102E));
				textBoxMail.setForeground(new Color(0xC8102E));
				if (checkedMail == 2) {
					invalidMail.setText("This mail is already used.");
				} else if (checkedMail == 3) {
					invalidMail.setText("Your mail address is invalid. (hello@world.com)");
				}
			}
			
			if (checkedName == 1 && checkedSurname == 1 && checkedMail == 1) {
				signUpDetailsPanel.setVisible(false);
				signUpFrame.add(signUpProfilePanel);
				signUpDetailsPanel.remove(logoLabel);
				signUpProfilePanel.add(logoLabel);
				signUpProfilePanel.setVisible(true);
				name = textBoxName.getText();
				surname = textBoxSurname.getText();
				mail = textBoxMail.getText();
			}
			

		} else if (e.getSource() == completeButton) {
			boolean checkedAge = SignUp.checkAge((Integer) ageSpinner.getValue());
			if (checkedAge) {
				invalidAge.setVisible(false);
				promptAge.setForeground(Color.black);
				ageSpinner.setForeground(Color.black);
				age = (Integer) ageSpinner.getValue();
				profilePicturePathname = new String(profilePicturePath);
				try {
					SignUp.signUserUp(username, password, name, surname, mail, age, profilePicturePath);
					signUpProfilePanel.remove(promptAge);
					signUpProfilePanel.remove(signUpProfilePicture);
					signUpProfilePanel.remove(completeButton);
					signUpProfilePanel.remove(changeProfilePicture);
					signUpProfilePanel.remove(ageSpinner);
					signUpProfilePrompt.setText("You are good to go!");
					signUpProfilePrompt.setSize(650, 44);
					signUpProfilePrompt.setLocation(850, 313);
					signInButton = new JButton();
					signInButton.setSize(150, 40);
					signInButton.setLocation(1095, 600); // y = 543
					signInButton.setIcon(new ImageIcon("resources/components/signupui/signinredirect.png"));
					signInButton.addActionListener(this);
					signInButton.setContentAreaFilled(false);
					signInButton.setBorderPainted(false);
					signUpProfilePanel.add(signInButton, JLayeredPane.DRAG_LAYER);
					signUpProfilePanel.revalidate();
					signUpProfilePanel.repaint();
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			} else {
				invalidAge.setForeground(new Color(0xC8102E));
				invalidAge.setSize(400, 15);
				invalidAge.setFont(InterRegular12);
				invalidAge.setLocation(1029, 574);
				invalidAge.setVisible(true);
				signUpProfilePanel.add(invalidAge);
				promptAge.setForeground(new Color(0xC8102E));
				ageSpinner.setForeground(new Color(0xC8102E));
				invalidAge.setText("You must be at least 12 years old to play.");
				signUpProfilePanel.add(invalidAge, JLayeredPane.DRAG_LAYER);
			}
			
//			System.out.println(profilePicturePath);
		} else if (e.getSource() == changeProfilePicture) {
			JFileChooser profilePictureChooser = new JFileChooser();
			FileFilter imageFilter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "bmp");
			profilePictureChooser.setFileFilter(imageFilter);
			int ppcResponse = profilePictureChooser.showOpenDialog(null);
			if (ppcResponse == JFileChooser.APPROVE_OPTION) {
				String newProfilePicturePath = profilePictureChooser.getSelectedFile().getAbsolutePath();
				ImageIcon profilePicture = new ImageIcon(newProfilePicturePath);
				Image profilePictureImage = profilePicture.getImage();
				profilePictureImage = profilePictureImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
				profilePicture = new ImageIcon(profilePictureImage);
				signUpProfilePicture.setIcon(profilePicture);
				profilePicturePath = newProfilePicturePath;
				
			}
		} else if (e.getSource() == signInButton) {
			signUpFrame.setVisible(false);
			try {
				new LoginUI();
			} catch (FontFormatException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}

		
	}

}
