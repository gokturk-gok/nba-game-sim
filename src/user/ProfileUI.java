package user;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.awt.*;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ProfileUI extends JFrame implements ActionListener {
	JFrame profile;
	JLayeredPane mainPanel;
	JButton backButton;
	JLabel profileTitle;
	JButton profilePicture;
	JButton changePicture;
	JLabel labelUsername;
	JLabel labelName;
	JLabel labelAge;
	JLabel labelMail;
	JLabel labelPassword;
	JLabel textUsername;
	JLabel textName;
	JSpinner spinnerAge;
	JTextField textBoxMail;
	JPasswordField textBoxPassword;
	JButton saveButton;
	JButton saveAge;
	JButton saveMail;
	JButton savePassword;
	JButton editAge;
	JButton editMail;
	JButton editPassword;
	
	// ERROR MESSAGES
	JLabel invalidAge = new JLabel();
	JLabel invalidMail = new JLabel();
	JTextArea invalidPassword = new JTextArea();
	
	// FONT
	Font InterSemibold = Font.createFont(Font.PLAIN, new File("resources/components/fonts/Inter-SemiBold.ttf"));
	Font InterSemibold36 = InterSemibold.deriveFont((float) 36.0);
	Font InterRegular = Font.createFont(Font.PLAIN, new File("resources/components/fonts/Inter-Regular.ttf"));
	Font InterRegular14x4 = InterRegular.deriveFont((float) 14.4);
	Font InterRegular12 = InterRegular.deriveFont((float) 12.0);
	
	/**
	 * This is the constructor of the profile editing page, which can be
	 * accessed through the homepage after logging in. It gives the user
	 * the opportunity of changing their age, e-mail address, password,
	 * and profile picture. It allows user to get back to the homepage as
	 * well. If user enters invalid information, UI shows corresponding
	 * warnings, such as used e-mail address or invalid age. It throws
	 * IOException and FontFormatException as it uses custom fonts.
	 * @throws IOException
	 * @throws FontFormatException
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public ProfileUI() throws IOException, FontFormatException {
		profile = new JFrame();
		profile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		profile.setSize(1440, 900);
		profile.setBackground(new Color(29, 66, 138));
		
		mainPanel = new JLayeredPane();
		mainPanel.setSize(1440, 900);
		mainPanel.setBackground(Color.white);
		mainPanel.setLocation(0, 0);
		mainPanel.setVisible(true);
		
		backButton = new JButton();
		backButton.setSize(27, 25);
		backButton.setLocation(82, 82);
		backButton.setIcon(new ImageIcon("resources/components/homepageui/backbutton.png"));
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.addActionListener(this);
		
		profileTitle = new JLabel();
		profileTitle.setSize(300, 44);
		profileTitle.setFont(InterSemibold36);
		profileTitle.setText("Edit your profile");
		profileTitle.setHorizontalTextPosition(JLabel.CENTER);
		profileTitle.setLocation(570, 82);
		
//		ImageIcon profilePictureIcon = new ImageIcon(Login.currentUser.getProfilePicturePath());
		ImageIcon profilePictureIcon = new ImageIcon(Login.currentUser.getProfilePicturePath());
		Image profilePictureImage = profilePictureIcon.getImage();
		profilePictureImage = profilePictureImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		profilePictureIcon = new ImageIcon(profilePictureImage);
		
		profilePicture = new JButton();
		profilePicture.setSize(100, 100);
		profilePicture.setLocation(670, 175);
		profilePicture.setIcon(profilePictureIcon);
		profilePicture.setBorderPainted(false);
		profilePicture.setContentAreaFilled(false);
		profilePicture.addActionListener(this);
		
		changePicture = new JButton();
		changePicture.setIcon(new ImageIcon("resources/components/signupui/selectpp.png"));
		changePicture.setSize(97, 14);
		changePicture.setLocation(671, 285);
		changePicture.setBorderPainted(false);
		changePicture.setContentAreaFilled(false);
		changePicture.addActionListener(this);
		
		labelUsername = new JLabel();
		labelUsername.setSize(70, 17);
		labelUsername.setText("Username");
		labelUsername.setLocation(585, 340);
		labelUsername.setForeground(new Color(146, 146, 146));
		labelUsername.setFont(InterRegular14x4);
		
		labelName = new JLabel();
		labelName.setSize(70, 17);
		labelName.setText("Name");
		labelName.setLocation(585, 370);
		labelName.setForeground(new Color(146, 146, 146));
		labelName.setFont(InterRegular14x4);
		
		labelAge = new JLabel();
		labelAge.setSize(70, 17);
		labelAge.setText("Age");
		labelAge.setLocation(585, 400);
		labelAge.setFont(InterRegular14x4);
		
		labelMail = new JLabel();
		labelMail.setSize(70, 17);
		labelMail.setText("E-mail");
		labelMail.setLocation(585, 430);
		labelMail.setFont(InterRegular14x4);
		
		labelPassword = new JLabel();
		labelPassword.setSize(70, 17);
		labelPassword.setText("Password");
		labelPassword.setLocation(585, 460);
		labelPassword.setFont(InterRegular14x4);
		
		textUsername = new JLabel();
		textUsername.setSize(240, 17);
		textUsername.setText(Login.currentUser.getUsername()); // PERSONALIZE
		textUsername.setLocation(710, 340);
		textUsername.setForeground(new Color(146, 146, 146));
		textUsername.setFont(InterRegular14x4);
		
		textName = new JLabel();
		textName.setSize(240, 17);
		textName.setText(Login.currentUser.getName() + " " + Login.currentUser.getSurname()); // PERSONALIZE
		textName.setLocation(710, 370);
		textName.setForeground(new Color(146, 146, 146));
		textName.setFont(InterRegular14x4);
		
		spinnerAge = new JSpinner();
		spinnerAge.setValue(Integer.valueOf(Login.currentUser.getAge()));
		spinnerAge.setEnabled(false);
		spinnerAge.setSize(150, 20);
		spinnerAge.setLocation(708, 400);
		spinnerAge.setFont(InterRegular12);
		
		textBoxMail = new JTextField();
		textBoxMail.setEnabled(false);
		textBoxMail.setSize(150, 20);
		textBoxMail.setLocation(708, 430);
		textBoxMail.setFont(InterRegular12);
		textBoxMail.setText(Login.currentUser.getMail());
		
		textBoxPassword = new JPasswordField();
		textBoxPassword.setEnabled(false);
		textBoxPassword.setSize(150, 20);
		textBoxPassword.setLocation(708, 460);
		textBoxPassword.setFont(InterRegular12);
		textBoxPassword.setText(Login.currentUser.getPassword());
		
		
		saveAge = new JButton();
		saveAge.setSize(10, 8);
		saveAge.setIcon(new ImageIcon("resources/components/profileui/tick.png"));
		saveAge.setLocation(865, 406);
		saveAge.setBorderPainted(false);
		saveAge.setContentAreaFilled(false);
		saveAge.setVisible(false);
		saveAge.addActionListener(this);
		
		saveMail = new JButton();
		saveMail.setSize(10, 8);
		saveMail.setIcon(new ImageIcon("resources/components/profileui/tick.png"));
		saveMail.setLocation(865, 436);
		saveMail.setBorderPainted(false);
		saveMail.setContentAreaFilled(false);
		saveMail.setVisible(false);
		saveMail.addActionListener(this);
		
		savePassword = new JButton();
		savePassword.setSize(10, 8);
		savePassword.setIcon(new ImageIcon("resources/components/profileui/tick.png"));
		savePassword.setLocation(865, 466);
		savePassword.setBorderPainted(false);
		savePassword.setContentAreaFilled(false);
		savePassword.setVisible(false);
		savePassword.addActionListener(this);
		
		editAge = new JButton();
		editAge.setSize(10, 10);
		editAge.setIcon(new ImageIcon("resources/components/profileui/editicon.png"));
		editAge.setLocation(565, 404);
		editAge.addActionListener(this);
		editAge.setContentAreaFilled(false);
		editAge.setBorderPainted(false);
		
		editMail = new JButton();
		editMail.setSize(10, 10);
		editMail.setIcon(new ImageIcon("resources/components/profileui/editicon.png"));
		editMail.setLocation(565, 434);
		editMail.addActionListener(this);
		editMail.setContentAreaFilled(false);
		editMail.setBorderPainted(false);
		
		editPassword = new JButton();
		editPassword.setSize(10, 10);
		editPassword.setIcon(new ImageIcon("resources/components/profileui/editicon.png"));
		editPassword.setLocation(565, 464);
		editPassword.addActionListener(this);
		editPassword.setContentAreaFilled(false);
		editPassword.setBorderPainted(false);
		
		saveButton = new JButton();
		saveButton.setSize(150, 40);
		saveButton.setLocation(645, 600); // y = 543
		saveButton.setIcon(new ImageIcon("resources/components/profileui/savebutton.png"));
		saveButton.addActionListener(this);
		
		mainPanel.add(invalidPassword, JLayeredPane.DRAG_LAYER);
		mainPanel.add(invalidMail, JLayeredPane.DRAG_LAYER);
		mainPanel.add(invalidAge, JLayeredPane.DRAG_LAYER);
		mainPanel.add(changePicture, JLayeredPane.MODAL_LAYER);
		mainPanel.add(saveButton, JLayeredPane.MODAL_LAYER);
		mainPanel.add(editPassword, JLayeredPane.MODAL_LAYER);
		mainPanel.add(editMail, JLayeredPane.MODAL_LAYER);
		mainPanel.add(editAge, JLayeredPane.MODAL_LAYER);
		mainPanel.add(savePassword, JLayeredPane.MODAL_LAYER);
		mainPanel.add(saveMail, JLayeredPane.MODAL_LAYER);
		mainPanel.add(saveAge, JLayeredPane.MODAL_LAYER);
		mainPanel.add(textBoxPassword, JLayeredPane.MODAL_LAYER);
		mainPanel.add(textBoxMail, JLayeredPane.MODAL_LAYER);
		mainPanel.add(spinnerAge, JLayeredPane.MODAL_LAYER);
		mainPanel.add(textName, JLayeredPane.MODAL_LAYER);
		mainPanel.add(textUsername, JLayeredPane.MODAL_LAYER);
		mainPanel.add(labelPassword, JLayeredPane.MODAL_LAYER);
		mainPanel.add(labelMail, JLayeredPane.MODAL_LAYER);
		mainPanel.add(labelAge, JLayeredPane.MODAL_LAYER);
		mainPanel.add(labelName, JLayeredPane.MODAL_LAYER);
		mainPanel.add(labelUsername, JLayeredPane.MODAL_LAYER);
		mainPanel.add(profilePicture, JLayeredPane.MODAL_LAYER);
		mainPanel.add(profileTitle, JLayeredPane.MODAL_LAYER);
		mainPanel.add(backButton, JLayeredPane.MODAL_LAYER);
		profile.add(mainPanel);
		profile.setVisible(true);
		
	}

	@Override
	/**
	 * This overridden method of ActionListener interface
	 * takes the source of action as parameter and does
	 * the dedicated operations, such as hiding and enabling
	 * fields, or redirecting user.
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == backButton || e.getSource() == saveButton) {
			profile.dispose();
			try {
				new HomepageUI();
			} catch (IOException | FontFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == editAge) {
			editAge.setVisible(false);
			spinnerAge.setEnabled(true);
			saveAge.setVisible(true);
		} else if (e.getSource() == editMail) {
			editMail.setVisible(false);
			textBoxMail.setEnabled(true);
			saveMail.setVisible(true);
		} else if (e.getSource() == editPassword) {
			editPassword.setVisible(false);
			textBoxPassword.setEnabled(true);
			savePassword.setVisible(true);
			/**
			 * Following block is for updating the age.
			 * By default, the Spinner is set to the current
			 * age. If user inputs an invalid age, which is
			 * less than 12, the page shows a warning.
			 * @author Göktürk Gök
			 * @date 03-01-2024
			 */
		} else if (e.getSource() == saveAge) {
			int inputAge = (int) spinnerAge.getValue();
			boolean validInputAge = SignUp.checkAge(inputAge);
			if (validInputAge) {
				EditUser.changeAge(Login.currentUser.getUsername(), inputAge);
				saveAge.setVisible(false);
				invalidAge.setVisible(false);
				editAge.setVisible(true);
				spinnerAge.setEnabled(false);
				labelAge.setForeground(Color.black);
			} else {
				invalidAge.setForeground(new Color(0xC8102E));
				invalidAge.setFont(InterRegular12);
				invalidAge.setText("You must be at least 12 years old.");
				invalidAge.setSize(400, 15);
				invalidAge.setLocation(880, 403);
				invalidAge.setVisible(true);
				labelAge.setForeground(new Color(0xC8102E));
			}
			/**
			 * Following button is for saving the new mail address.
			 * If user enters the same mail address, it does nothing.
			 * If user enters a used or invalid mail address, UI shows
			 * dedicated warning.
			 * @author Göktürk Gök
			 * @date 03-01-2024
			 */
		} else if (e.getSource() == saveMail) {
			String inputMail = textBoxMail.getText();
			int validInputMail = SignUp.checkMail(inputMail);
			
			if (validInputMail == 1 || inputMail.equals(Login.currentUser.getMail())) {
				saveMail.setVisible(false);
				invalidMail.setVisible(false);
				editMail.setVisible(true);
				textBoxMail.setEnabled(false);
				labelMail.setForeground(Color.black);
				EditUser.changeMail(Login.currentUser.getUsername(), inputMail);
			} else {
				invalidMail.setForeground(new Color(0xC8102E));
				invalidMail.setFont(InterRegular12);
				invalidMail.setSize(400, 15);
				invalidMail.setLocation(880, 433);
				invalidMail.setVisible(true);
				labelMail.setForeground(new Color(0xC8102E));
				textBoxMail.setForeground(new Color(0xC8102E));
				if (validInputMail == 2) {
					invalidMail.setText("This mail address is already used.");
				} else {
					invalidMail.setText("This mail address is invalid (hello@world.com)");
				}
			}
		/**
		 * This block is for saving the new password that user have entered.
		 * If it is not valid, there occurs a dedicated warning message.
		 * @author Göktürk Gök
		 * @date 03-01-2024
		 */
		} else if (e.getSource() == savePassword) {
			char[] passwordInputChars = textBoxPassword.getPassword();
			String passwordInput = new String(passwordInputChars);
			
			String passwordCheck = SignUp.checkPassword(passwordInput);
			
			if (passwordCheck.equals("0")) {
				invalidPassword.setVisible(false);
				savePassword.setVisible(false);
				editPassword.setVisible(true);
				textBoxPassword.setForeground(Color.black);
				EditUser.changePassword(Login.currentUser.getUsername(), passwordInput);
			} else {
				labelPassword.setForeground(new Color(0xC8102E));
				invalidPassword.setEnabled(true);
				invalidPassword.setFocusable(false);
				invalidPassword.setForeground(new Color(0xC8102E));
				invalidPassword.setSize(300, 100);
				invalidPassword.setFont(InterRegular12);
				invalidPassword.setLocation(880, 463);
				invalidPassword.setVisible(true);
				invalidPassword.setOpaque(false);
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
			
			/**
			 * This block makes user able to change their profile picture.
			 * It does not check anything, but applies a file format
			 * restriction to user with one of the four chosen image formats.
			 * @author Göktürk Gök
			 * @date 03-01-2024
			 */
		} else if (e.getSource() == changePicture || e.getSource() == profilePicture) {
			JFileChooser profilePictureChooser = new JFileChooser();
			FileFilter imageFilter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "bmp");
			profilePictureChooser.setFileFilter(imageFilter);
			int ppcResponse = profilePictureChooser.showOpenDialog(null);
			if (ppcResponse == JFileChooser.APPROVE_OPTION) {
				String newProfilePicturePath = profilePictureChooser.getSelectedFile().getAbsolutePath();
				ImageIcon profilePictureIcon = new ImageIcon(newProfilePicturePath);
				Image profilePictureImage = profilePictureIcon.getImage();
				profilePictureImage = profilePictureImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
				profilePictureIcon = new ImageIcon(profilePictureImage);
				profilePicture.setIcon(profilePictureIcon);
				EditUser.changeProfilePicturePath(Login.currentUser.getUsername(), newProfilePicturePath);
				
			}
		}
		
		
	}
}
