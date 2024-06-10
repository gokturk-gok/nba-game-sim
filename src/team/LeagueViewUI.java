package team;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import javax.swing.*;

import user.Login;

public class LeagueViewUI extends JFrame implements ActionListener {
	JFrame leagueView;
	JLayeredPane leaguePanel;
	JLabel title;
	JLabel teamName;
	JLabel teamLogo;
	JPanel teams;
	JButton continueButton;
	
	// FONT
	Font InterSemibold = Font.createFont(Font.PLAIN, new File("resources/components/fonts/Inter-SemiBold.ttf"));
	Font InterSemibold36 = InterSemibold.deriveFont((float) 36.0);
	Font InterSemibold12 = InterSemibold.deriveFont((float) 12.0);
	
	/**
	 * This is the constructor of the page that shows the teams
	 * that are playing in the leauge, and the order for
	 * drafting. This page is shown right before the DraftingUI.
	 * @throws IOException
	 * @throws FontFormatException
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public LeagueViewUI() throws IOException, FontFormatException {
		leagueView = new JFrame();
		leagueView.setSize(1440, 900);
		leagueView.setDefaultCloseOperation(EXIT_ON_CLOSE);
		leagueView.setResizable(false);
		
		leaguePanel = new JLayeredPane();
		leaguePanel.setSize(1440, 900);
		leaguePanel.setBackground(Color.black);
		leaguePanel.setLocation(0, 0);
		leaguePanel.setOpaque(true);
		
		title = new JLabel();
		title.setFont(InterSemibold36);
		title.setText("The League");
		title.setSize(700, 44);
		title.setLocation(72, 72);
		title.setForeground(Color.white);
		
		teamName = new JLabel();
		teamName.setSize(576, 100);
		teamName.setFont(InterSemibold36);
		teamName.setText(" " + Login.currentTeam.getTeamName());
		teamName.setLocation(690, 44);
		teamName.setForeground(Color.white);
		teamName.setBackground(Login.currentTeam.getTeamColor());
		teamName.setOpaque(true);
		teamName.setHorizontalTextPosition(SwingConstants.RIGHT);
		
		teamLogo = new JLabel();
		teamLogo.setSize(100, 100);
		teamLogo.setLocation(1296, 44);
		Image teamLogoImage = (new ImageIcon(Login.currentTeam.getTeamLogoPath()).getImage());
		teamLogoImage = teamLogoImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		teamLogo.setIcon(new ImageIcon(teamLogoImage));
		
		teams = new JPanel();
		teams.setSize(1276, 607);
		teams.setLocation(82, 211);
		teams.setLayout(new GridLayout(4, 5));
		teams.setBackground(Color.black);
		
		for (int i = 0 ; i < 20 ; i ++) {
			JLabel team = new JLabel();
			team.setLayout(new BorderLayout());
			
			team.setHorizontalAlignment(JLabel.CENTER);
			team.setSize(200, 100);

			team.setOpaque(true);
			team.setBackground(Drafting.playingTeams.get(i).getTeamColor());
			team.setText((i + 1) + " " + Drafting.playingTeams.get(i).getTeamShortName());
			team.setFont(InterSemibold12);
			team.setVerticalTextPosition(JLabel.CENTER);
			team.setForeground(Color.white);
			Image teamsTeamLogoImage = (new ImageIcon(Drafting.playingTeams.get(i).getTeamLogoPath())).getImage();
			teamsTeamLogoImage = teamsTeamLogoImage.getScaledInstance(150, 100, Image.SCALE_SMOOTH);
			if (Drafting.playingTeams.get(i).getTeamName().equals(Login.currentTeam.getTeamName())) {
				teamsTeamLogoImage = teamsTeamLogoImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
				team.setText("             " + (i + 1) + " " + Drafting.playingTeams.get(i).getTeamShortName());
				
			}
			team.setIcon(new ImageIcon(teamsTeamLogoImage));
			
			teams.add(team);
			
		}
		
		continueButton = new JButton();
		continueButton.setSize(150, 40);
		continueButton.setLocation(510, 74); // y = 543
		continueButton.setIcon(new ImageIcon("resources/components/teamcreatorui/continuebutton.png"));
		continueButton.addActionListener(this);
		
		leaguePanel.add(continueButton, JLayeredPane.DRAG_LAYER);
		leaguePanel.add(teams);
		leaguePanel.add(teamLogo, JLayeredPane.DRAG_LAYER);
		leaguePanel.add(teamName, JLayeredPane.DRAG_LAYER);
		leaguePanel.add(title, JLayeredPane.DRAG_LAYER);
		
		leagueView.add(leaguePanel);
		leagueView.setVisible(true);
		
	}


	@Override
	/**
	 * This overridden method of ActionListener interface
	 * only takes the Continue button on the league view
	 * UI as the source of action, and if that button is
	 * presses, it closes the LeagueViewUI and then
	 * continues to DraftingUI.
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == continueButton) {
			leagueView.dispose();
			try {
				new DraftingUI();
			} catch (IOException | FontFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
