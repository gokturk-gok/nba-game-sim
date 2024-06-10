package team;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.awt.*;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import user.HomepageUI;
import user.Login;

public class TeamCreatorUI extends JFrame implements ActionListener {
	JFrame teamCreator;
	JLayeredPane teamCreatorPanel;
	JLabel fieldTexture;
	JLabel field;
	JButton backButton;
	JLabel prompt;
	JLabel teamColor;
	JButton teamColorFront;
	JButton colorChanger;
	JButton teamLogo;
	JButton teamLogoChanger;
	JTextField teamName;
	JButton continueButton;
	JLabel invalidTeamName = new JLabel();
	
	// FONT
	Font InterSemibold = Font.createFont(Font.PLAIN, new File("resources/components/fonts/Inter-SemiBold.ttf"));
	Font InterSemibold36 = InterSemibold.deriveFont((float) 36.0);
	Font InterSemibold14x4 = InterSemibold.deriveFont((float) 14.4);
	
	/**
	 * This is the constructor of the page where user creates their
	 * own team, providing a custom team name, team logo, and a color.
	 * It gives the opportunity of turning back to the homepage to user.
	 * By default, the page shows the name of the random name, default
	 * team logo and the random color of the team of user that is
	 * created at the login stage. It shows a basic representation
	 * of a basketball field as background image.
	 * @throws IOException
	 * @throws FontFormatException
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public TeamCreatorUI() throws IOException, FontFormatException {
		teamCreator = new JFrame();
		teamCreator.setSize(1440, 900);
		teamCreator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		teamCreator.setBackground(new Color(29, 66, 138));
		teamCreator.setResizable(false);
		
		teamCreatorPanel = new JLayeredPane();
		teamCreatorPanel.setSize(1440, 900);
		teamCreatorPanel.setLocation(0, 0);
		
		fieldTexture = new JLabel();
		fieldTexture.setSize(1440, 900);
		fieldTexture.setLocation(0, 0);
		fieldTexture.setIcon(new ImageIcon("resources/components/teamcreatorui/fieldtexture.png"));
		
		field = new JLabel();
		field.setSize(723, 900);
		field.setLocation(717, 0);
		field.setIcon(new ImageIcon("resources/components/teamcreatorui/fielddesign.png"));
		
		backButton = new JButton();
		backButton.setSize(27, 25);
		backButton.setLocation(82, 82);
		backButton.setIcon(new ImageIcon("resources/components/teamcreatorui/backbutton.png"));
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.addActionListener(this);
		
		teamName = new JTextField();
		teamName.setSize(400, 50);
		teamName.setFont(InterSemibold36);
		teamName.setForeground(Login.currentTeam.getTeamColor());
		teamName.setBackground(new Color(0, 0, 0, 0));
		teamName.setLocation(130, 425);
		teamName.setText(Login.currentTeam.getTeamName());
		
		teamColor = new JLabel();
		teamColor.setBackground(Login.currentTeam.getTeamColor());
		teamColor.setSize(305, 240);
		teamColor.setLocation(1135, 330);
		teamColor.setOpaque(true);
		
		teamColorFront = new JButton();
		teamColorFront.setSize(305, 240);
		teamColorFront.setLocation(1135, 330);
		teamColorFront.addActionListener(this);
		teamColorFront.setOpaque(false);
		teamColorFront.setContentAreaFilled(false);
		teamColorFront.setBorderPainted(false);
		
		prompt = new JLabel();
		prompt.setFont(InterSemibold36);
		prompt.setText("Create your team");
		prompt.setSize(320, 44);
		prompt.setLocation(130, 72);
		
		teamLogo = new JButton();
		teamLogo.setSize(200, 200);	
		ImageIcon teamLogoIcon = new ImageIcon(Login.currentTeam.getTeamLogoPath());
		Image teamLogoImage = teamLogoIcon.getImage();
		teamLogoImage = teamLogoImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		teamLogo.setIcon(new ImageIcon(teamLogoImage));
		teamLogo.setLocation(620, 350);
		teamLogo.setBorderPainted(false);
		teamLogo.setContentAreaFilled(false);
		teamLogo.addActionListener(this);
		
		teamLogoChanger = new JButton();
		teamLogoChanger.setFont(InterSemibold14x4);
		teamLogoChanger.setText("Change logo");
		teamLogoChanger.setHorizontalTextPosition(JButton.CENTER);
		teamLogoChanger.setSize(200, 17);
		teamLogoChanger.setLocation(620, 560);
		teamLogoChanger.setBorderPainted(false);
		teamLogoChanger.setContentAreaFilled(false);
		teamLogoChanger.addActionListener(this);
		
		colorChanger = new JButton();
		colorChanger.setFont(InterSemibold14x4);
		colorChanger.setText("Change color");
		colorChanger.setHorizontalTextPosition(JButton.CENTER);
		colorChanger.setSize(200, 17);
		colorChanger.setLocation(1190, 585);
		colorChanger.setBorderPainted(false);
		colorChanger.setContentAreaFilled(false);
		colorChanger.addActionListener(this);
		
		continueButton = new JButton();
		continueButton.setSize(150, 40);
		continueButton.setLocation(130, 600); // y = 543
		continueButton.setIcon(new ImageIcon("resources/components/teamcreatorui/continuebutton.png"));
		continueButton.addActionListener(this);
		
		invalidTeamName.setText("Your team name must include at least 3 characters.");
		invalidTeamName.setForeground(new Color(0xC8102E));
		invalidTeamName.setSize(400, 17);
		invalidTeamName.setFont(InterSemibold14x4);
		invalidTeamName.setLocation(130, 490);
		invalidTeamName.setVisible(false);
		
		teamCreatorPanel.add(invalidTeamName, JLayeredPane.DRAG_LAYER);
		teamCreatorPanel.add(continueButton, JLayeredPane.DRAG_LAYER);
		teamCreatorPanel.add(colorChanger, JLayeredPane.DRAG_LAYER);
		teamCreatorPanel.add(teamLogoChanger, JLayeredPane.DRAG_LAYER);
		teamCreatorPanel.add(teamLogo, JLayeredPane.DRAG_LAYER);
		teamCreatorPanel.add(prompt, JLayeredPane.DRAG_LAYER);
		teamCreatorPanel.add(teamColorFront, JLayeredPane.DRAG_LAYER);
		teamCreatorPanel.add(teamColor, JLayeredPane.PALETTE_LAYER);
		teamCreatorPanel.add(teamName, JLayeredPane.DRAG_LAYER);
		teamCreatorPanel.add(backButton, JLayeredPane.DRAG_LAYER);
		teamCreatorPanel.add(fieldTexture, JLayeredPane.DEFAULT_LAYER);
		teamCreatorPanel.add(field, JLayeredPane.MODAL_LAYER);
		
		teamCreator.add(teamCreatorPanel);
		teamCreator.setVisible(true);
	}
	
	
	
	@Override
	/**
	 * This overridden method of ActionListener class is used for
	 * getting the source of action performed in the UI and then
	 * constructing corresponding operations. For instance, if the
	 * back button is clicked, it turns the user back to the homepage,
	 * and if the team logo or the dedicated button is clicked,
	 * it opens a pop-up for changing the team logo.
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == backButton) {
			if (teamName.getText().length() < 3 || teamName.getText().matches("^\\s+$")) {
				invalidTeamName.setVisible(true);
			} else {
				invalidTeamName.setVisible(false);
				Login.currentTeam.setTeamName(teamName.getText());

			}
			teamCreator.dispose();
			try {
				new HomepageUI();
			} catch (IOException | FontFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == teamLogoChanger || e.getSource() == teamLogo) {
			JFileChooser teamLogoChooser = new JFileChooser();
			/**
			 * This FileFilter object ensures that user only gives
			 * image files as a team logo.
			 * @author Göktürk Gök
			 * @date 03-01-2024
			 */
			FileFilter imageFilter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "bmp", "gif");
			teamLogoChooser.setFileFilter(imageFilter);
			int tlcResponse = teamLogoChooser.showOpenDialog(null);
			if (tlcResponse == JFileChooser.APPROVE_OPTION) {
				String newTeamLogoPath = teamLogoChooser.getSelectedFile().getAbsolutePath();
				ImageIcon teamLogoIcon = new ImageIcon(newTeamLogoPath);
				Image teamLogoImage = teamLogoIcon.getImage();
				/**
				 * This is the process of scaling the team logo
				 * to make it look more sophisticated on the
				 * page.
				 * @author Göktürk Gök
				 * @date 03-01-2024
				 */
				teamLogoImage = teamLogoImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
				teamLogoIcon = new ImageIcon(teamLogoImage);
				teamLogo.setIcon(teamLogoIcon);
				Login.currentTeam.setTeamLogoPath(newTeamLogoPath);
			}
		} else if (e.getSource() == colorChanger || e.getSource() == teamColorFront) {
			JColorChooser colorChooser = new JColorChooser();
			Color newColor = colorChooser.showDialog(null, "Choose a color", new Color(29, 66, 138));
			teamColor.setBackground(newColor);
			teamName.setForeground(newColor);
			Login.currentTeam.setTeamColor(newColor);
			
		} else if (e.getSource() == continueButton) {
			/**
			 * If this button is clicked, the application
			 * checks whether the team name given is valid
			 * or not. Therefore, it shows a warning
			 * or continues to the Leauge View stage.
			 * @author Göktürk Gök
			 * @date 03-01-2024
			 */
			if (teamName.getText().length() < 3 || teamName.getText().matches("^\\s+$")) {
				invalidTeamName.setVisible(true);
			} else {
				invalidTeamName.setVisible(false);
				Login.currentTeam.setTeamName(teamName.getText());
				Login.currentTeam.setTeamShortName(teamName.getText().substring(0, 3).toUpperCase());
				teamCreator.dispose();
				try {
					new LeagueViewUI();
				} catch (IOException | FontFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		}
		
	}
}
