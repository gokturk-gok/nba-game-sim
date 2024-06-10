package user;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.swing.*;

public class LoginUI extends JFrame implements ActionListener {
	JFrame loginFrame;
	JLabel backgroundLabel;
	JLayeredPane loginPanel;
	JLabel logoLabel;
	JButton loginButton;
	JLabel promptSignIn;
	JLabel promptUsername;
	JLabel promptPassword;
	JTextField textBoxUsername;
	JPasswordField textBoxPassword;
	JLabel doNotHaveAccount;
	JButton goToSignUpButton;
	ImageIcon backgroundImage;
	Image background;
	ImageIcon logInBackgroundImage;
	JLabel logInBackgroundLabel;
	ImageIcon loginButtonIcon;
	JLabel invalidUsername = new JLabel();
	JLabel invalidPassword = new JLabel();
	Color transparent = new Color(0, 0, 0, 0);
	
	// FONT
	Font InterSemibold = Font.createFont(Font.PLAIN, new File("resources/components/fonts/Inter-SemiBold.ttf"));
	Font InterSemibold36 = InterSemibold.deriveFont((float) 36.0);
	Font InterRegular = Font.createFont(Font.PLAIN, new File("resources/components/fonts/Inter-Regular.ttf"));
	Font InterRegular14x4 = InterRegular.deriveFont((float) 14.4);
	Font InterRegular12 = InterRegular.deriveFont((float) 12.0);
	/**
	 * This is the constructor of the login page, which is the first page
	 * that the user sees while running the application. It has the username
	 * field, password field, log in button, the option for going to the
	 * registration page and visual components. It randomly shows one of the
	 * five backgrounds at each initialization.
	 * This method throws FontFormatException and IOException,
	 * which are required to instantiate the custom fonts. Font files
	 * are added to a separate folder in project folder.
	 * @throws FontFormatException
	 * @throws IOException
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public LoginUI() throws FontFormatException, IOException {
		loginFrame = new JFrame();
		loginPanel = new JLayeredPane();
		
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

		
		logInBackgroundImage = new ImageIcon("resources/components/signupui/signupbg.png");
		logInBackgroundLabel = new JLabel();
		logInBackgroundLabel.setIcon(logInBackgroundImage);
		logInBackgroundLabel.setSize(540, 900);
		logInBackgroundLabel.setLocation(900, 0);

		ImageIcon logoImage = new ImageIcon("resources/components/signupui/signuplogo.png");
		logoLabel = new JLabel();
		logoLabel.setIcon(logoImage);
		logoLabel.setSize(400, 115);
		logoLabel.setLocation(970, 93);
		
		promptSignIn = new JLabel();
		promptSignIn.setText("Log in to your account");
		promptSignIn.setFont(InterSemibold36);
		promptSignIn.setSize(400, 44);
		promptSignIn.setPreferredSize(getPreferredSize());
		promptSignIn.setHorizontalAlignment(JLabel.CENTER);
		promptSignIn.setLocation(970, 313);
		
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
		
		loginButtonIcon = new ImageIcon("resources/components/loginui/signinbutton.png");
		loginButton = new JButton();
		loginButton.setSize(150, 40);
		loginButton.setLocation(1095, 600); // y = 543
		loginButton.setIcon(loginButtonIcon);
		loginButton.addActionListener(this);
		
		doNotHaveAccount = new JLabel();
		doNotHaveAccount.setSize(140, 17);
		doNotHaveAccount.setOpaque(false);
		doNotHaveAccount.setIcon(new ImageIcon("resources/components/loginui/donothaveaccount.png"));
		doNotHaveAccount.setLocation(1056, 731);
		
		goToSignUpButton = new JButton();
		goToSignUpButton.setIcon(new ImageIcon("resources/components/loginui/joinnow.png"));
		goToSignUpButton.setOpaque(false);
		goToSignUpButton.setBorderPainted(false);
		goToSignUpButton.setContentAreaFilled(false);
		goToSignUpButton.setSize(80, 17);
		goToSignUpButton.setLocation(1200, 731);
		goToSignUpButton.addActionListener(this);
		
		loginPanel.setSize(1440, 900);
		
		loginPanel.add(goToSignUpButton, JLayeredPane.DRAG_LAYER);
		loginPanel.add(doNotHaveAccount, JLayeredPane.DRAG_LAYER);
		loginPanel.add(loginButton, JLayeredPane.DRAG_LAYER);
		loginPanel.add(promptPassword, JLayeredPane.DRAG_LAYER);
		loginPanel.add(textBoxPassword, JLayeredPane.DRAG_LAYER);
		loginPanel.add(promptUsername, JLayeredPane.DRAG_LAYER);
		loginPanel.add(textBoxUsername, JLayeredPane.DRAG_LAYER);
		loginPanel.add(logoLabel, JLayeredPane.DRAG_LAYER);
		loginPanel.add(promptSignIn, JLayeredPane.DRAG_LAYER);
		loginPanel.add(logInBackgroundLabel, JLayeredPane.PALETTE_LAYER);
		loginPanel.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

		loginFrame.setSize(1440, 900);
		
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setBackground(new Color(29, 66, 138));
		loginFrame.setLayout(null);
		loginFrame.setTitle("NBAsim24");
		loginFrame.add(loginPanel);
		loginFrame.setResizable(false);
		loginFrame.setVisible(true);
		loginFrame.setIconImage((new ImageIcon("resources/components/signupui/appicon.png")).getImage());
	}

	@Override
	/**
	 * This method is overridden from ActionListener interface
	 * to keep track of actions performed to construct the
	 * operations that user chooses.
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		/**
		 * This block is used to redirect user to
		 * sign up page if they would like to create
		 * a new account.
		 * @author Göktürk Gök
		 * @date 03-01-2024
		 */
		if (e.getSource() == goToSignUpButton) {
			try {
				new SignUpUI();
				loginFrame.setVisible(false);
			} catch (FontFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		/**
		 * This block makes the program take the username
		 * given by user and then checks if the user exists
		 * by using the method Login.checkUsername(). If it
		 * exists, it continues to check the password that is
		 * brought by the method Login.bringPassword. If the
		 * password is valid, then it redirects user to the Homepage.
		 * If user does not exist or password is wrong, then
		 * it shows the corresponding warnings to user.
		 * @author Göktürk Gök
		 * @date 03-01-2024
		 */
		} else if (e.getSource() == loginButton) {
			String inputUsername = textBoxUsername.getText();
			if (Login.checkUsername(inputUsername)) {
				invalidUsername.setVisible(false);
				promptUsername.setForeground(Color.black);
				textBoxUsername.setForeground(Color.black);
				if (new String(textBoxPassword.getPassword()).equals(Login.bringPassword(inputUsername))) {
					invalidPassword.setVisible(false);
					invalidUsername.setVisible(false);
					promptUsername.setForeground(Color.black);
					textBoxUsername.setForeground(Color.black);
					promptPassword.setForeground(Color.black);
					textBoxPassword.setForeground(Color.black);
					/**
					 * This is the main login operation.
					 * @author Göktürk Gök
					 * @date 03-01-2024
					 */
					User currentUser = Login.loginUser(inputUsername);
					try {
						new HomepageUI();
						loginFrame.dispose();
					} catch (IOException | FontFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					invalidPassword.setForeground(new Color(0xC8102E));
					invalidPassword.setSize(400, 15);
					invalidPassword.setFont(InterRegular12);
					invalidPassword.setLocation(1034, 506);
					invalidPassword.setVisible(true);
					invalidPassword.setText("The password you entered is wrong.");
					loginPanel.add(invalidPassword, JLayeredPane.DRAG_LAYER);
					promptPassword.setForeground(new Color(0xC8102E));
					textBoxPassword.setForeground(new Color(0xC8102E));
				}
			} else {
				invalidUsername.setForeground(new Color(0xC8102E));
				invalidUsername.setSize(400, 15);
				invalidUsername.setFont(InterRegular12);
				invalidUsername.setLocation(1034, 438);
				invalidUsername.setVisible(true);
				invalidUsername.setText("Uh, oh, we could not find a user with that name :(");
				invalidPassword.setVisible(false);
				promptPassword.setForeground(Color.black);
				textBoxPassword.setForeground(Color.black);
				loginPanel.add(invalidUsername, JLayeredPane.DRAG_LAYER);
				promptUsername.setForeground(new Color(0xC8102E));
				textBoxUsername.setForeground(new Color(0xC8102E));
			}
			
		}
	}
}
