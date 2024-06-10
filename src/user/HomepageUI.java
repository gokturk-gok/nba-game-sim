package user;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

import team.TeamCreatorUI;

public class HomepageUI extends JFrame implements ActionListener {
	JFrame homepage;
	JLayeredPane homepagePanel;
	JLabel backgroundLabel;
	ImageIcon backgroundImage;
	JLabel topPanel;
	ImageIcon topPanelImage;
	JLabel helloUser;
	JButton menuButton;
	JLabel logoLabel;
	ImageIcon logoImage;
	JButton playButton;
	
	// MENU PANEL
	JLayeredPane menuPanel;
	JLabel menuPanelBackground;
	ImageIcon menuPanelImage;
	JLabel menuPanelBlur;
	JButton editProfileButton;
	JButton logOutButton;
	JLabel userName;
	JButton backButton;

	// FONT
	Font InterSemibold = Font.createFont(Font.PLAIN, new File("resources/components/fonts/Inter-SemiBold.ttf"));
	Font InterSemibold36 = InterSemibold.deriveFont((float) 36.0);
	Font InterRegular = Font.createFont(Font.PLAIN, new File("resources/components/fonts/Inter-Regular.ttf"));
	Font InterRegular14x4 = InterRegular.deriveFont((float) 14.4);
	Font InterRegular12 = InterRegular.deriveFont((float) 12.0);
	

	/**
	 * This is the constructor of the Homepage, which is shown right after
	 * a user logs in. It has a salutation, a menu button represented as
	 * the profile picture of the user, a menu panel containing options
	 * for editing profile (ProfileUI) and logging out, and a play button
	 * to begin the game.
	 * @throws IOException
	 * @throws FontFormatException
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public HomepageUI() throws IOException, FontFormatException {
		homepage = new JFrame();
		homepagePanel = new JLayeredPane();
		homepagePanel.setSize(1440, 900);
		homepage.setSize(1440, 900);
		homepage.setBackground(new Color(29, 66, 138));
		homepage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		backgroundImage = new ImageIcon("resources/components/homepageui/homepagebg.png");
		backgroundLabel = new JLabel();
		backgroundLabel.setSize(1440, 900);
		backgroundLabel.setIcon(backgroundImage);
		backgroundLabel.setLocation(0, 0);
		
		topPanel = new JLabel();
		topPanel.setSize(1440, 188);
		topPanel.setLocation(0, 0);
		topPanelImage = new ImageIcon("resources/components/homepageui/topbackground.png");
		topPanel.setIcon(topPanelImage);
		
		logoLabel = new JLabel();
		logoImage = new ImageIcon("resources/components/homepageui/logo.png");
		logoLabel.setSize(300, 87);
		logoLabel.setIcon(logoImage);
		logoLabel.setLocation(50, 50);
		
		helloUser = new JLabel();
		helloUser.setFont(InterSemibold36);
		helloUser.setText("Hello, " + Login.currentUser.getName() + "!"); // HERE USER WILL BE CHANGED TO CURRENT USERNAME!!!!!
		helloUser.setLocation(414, 77);
		helloUser.setSize(400, 44);
		
		
		ImageIcon profilePictureIcon = new ImageIcon(Login.currentUser.getProfilePicturePath());
		Image profilePicture = profilePictureIcon.getImage();
		profilePicture = profilePicture.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		profilePictureIcon = new ImageIcon(profilePicture);
		
		menuButton = new JButton();
		menuButton.setSize(100, 100);
		menuButton.setLocation(1296, 44);
		menuButton.setIcon(profilePictureIcon); // HERE IT WILL BE USERS PP PATH
		menuButton.setBorderPainted(false);
		menuButton.setContentAreaFilled(false);
		menuButton.addActionListener(this);
		
		playButton = new JButton();
		playButton.setIcon(new ImageIcon("resources/components/homepageui/playbutton.png"));
		playButton.setSize(450, 450);
		playButton.setLocation(495, 274);
		playButton.addActionListener(this);
		playButton.setContentAreaFilled(false);
		playButton.setBorderPainted(false);
		
		
		/**
		 * JLayeredPane is used for keeping all the components
		 * in layers, instead of directly adding them to the
		 * frame, which necessitates keeping the order of
		 * that operations.
		 * @author Göktürk Gök
		 * @date 03-01-2024
		 */
		homepagePanel.add(playButton, JLayeredPane.MODAL_LAYER);
		homepagePanel.add(menuButton, JLayeredPane.DRAG_LAYER);
		homepagePanel.add(helloUser, JLayeredPane.POPUP_LAYER);
		homepagePanel.add(logoLabel, JLayeredPane.MODAL_LAYER);
		homepagePanel.add(topPanel, JLayeredPane.PALETTE_LAYER);
		homepagePanel.add(backgroundLabel, JLayeredPane.DEFAULT_LAYER);

		
		homepage.add(homepagePanel);
		homepage.setVisible(true);
		
		
		// menu panel
		
		menuPanel = new JLayeredPane();
		menuPanel.setSize(1440, 900);
		menuPanel.setLocation(0, 0);
		
		menuPanelBackground = new JLabel();
		menuPanelImage = new ImageIcon("resources/components/homepageui/menupanelbg.png");
		
		menuPanelBackground.setIcon(menuPanelImage);
		menuPanelBackground.setSize(415, 900);
		menuPanelBackground.setLocation(1025, 0);
		
		menuPanelBlur = new JLabel();
		menuPanelBlur.setIcon(new ImageIcon("resources/components/homepageui/menupanelblur.png"));
		menuPanelBlur.setSize(1440, 900);
		menuPanelBlur.setLocation(0, 0);
		
		editProfileButton = new JButton();
		editProfileButton.setSize(185, 36);
		editProfileButton.setLocation(1070, 295);
		editProfileButton.setIcon(new ImageIcon("resources/components/homepageui/button_editprofile.png"));
		editProfileButton.setBorderPainted(false);
		editProfileButton.setContentAreaFilled(false);
		editProfileButton.addActionListener(this);
		
		logOutButton = new JButton();
		logOutButton.setSize(129, 35);
		logOutButton.setLocation(1070, 353);
		logOutButton.setIcon(new ImageIcon("resources/components/homepageui/button_logout.png"));
		logOutButton.setBorderPainted(false);
		logOutButton.setContentAreaFilled(false);
		logOutButton.addActionListener(this);
		
		userName = new JLabel();
		userName.setSize(400, 44);
		userName.setFont(InterSemibold36);
		userName.setText(Login.currentUser.getUsername());
		userName.setLocation(1068, 171);
		
		backButton = new JButton();
		backButton.setSize(27, 25);
		backButton.setLocation(1070, 82);
		backButton.setIcon(new ImageIcon("resources/components/homepageui/backbutton.png"));
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.addActionListener(this);
		
		menuPanel.add(backButton, JLayeredPane.DRAG_LAYER);
		menuPanel.add(userName, JLayeredPane.DRAG_LAYER);
		menuPanel.add(logOutButton, JLayeredPane.DRAG_LAYER);
		menuPanel.add(editProfileButton, JLayeredPane.DRAG_LAYER);
		menuPanel.add(menuPanelBackground, JLayeredPane.PALETTE_LAYER);
		menuPanel.add(menuPanelBlur, JLayeredPane.DEFAULT_LAYER);

	}
	
	
	@Override
	/**
	 * This overridden method of ActionListener interface takes the
	 * sources of actions performed in homepage. If the profile
	 * picture (menu button) is pressed, it makes the menu panel
	 * visible and adds a slight blur to the background. Else if
	 * the play button is pressed, it closes the homepage using
	 * the method dispose() and opens a TeamCreatorUI. If the edit
	 * profile button is pressed, it opens the ProfileUI. If user
	 * presses the logout button, it constructs the related operations
	 * and then, redirects user to the login page.
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == menuButton) {
			menuPanel.setVisible(true);
			/**
			 * If menuButton (profile picture) is pressed,
			 * menu panel is added to the frame. Methods
			 * revalidate() and repaint() are used to apply
			 * that change.
			 * @author Göktürk Gök
			 * @date 03-01-2024
			 */
			homepagePanel.add(menuPanel, JLayeredPane.DRAG_LAYER);
			homepagePanel.revalidate();
			homepagePanel.repaint();
		} else if (e.getSource() == backButton) {
			menuPanel.setVisible(false);
			homepagePanel.remove(menuPanel);
			homepagePanel.revalidate();
			homepagePanel.repaint();
		} else if (e.getSource() == editProfileButton) {
			// redirect to ProfileUI;
			homepage.dispose();
			try {
				new ProfileUI();
			} catch (IOException | FontFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == logOutButton) {
			Login.logoutUser();
			homepage.dispose();
			try {
				new LoginUI();
			} catch (FontFormatException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == playButton) {
			homepage.dispose();
			try {
				new TeamCreatorUI();
			} catch (IOException | FontFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	
	
}
