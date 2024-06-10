package match;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.awt.*;

import javax.swing.*;

import logging.Logging;
import team.Drafting;
import team.Team;
import user.HomepageUI;

public class MatchFinalEightUI extends JFrame implements ActionListener {
	
	JFrame matchView;
	JLayeredPane componentPanel;
	JLabel title;
	JLabel team1;
	JLabel team2;
	JLabel team3;
	JLabel team4;
	JLabel team5;
	JLabel team6;
	JLabel team7;
	JLabel team8;
	
	JLabel team21;
	JLabel team22;
	JLabel team23;
	JLabel team24;
	
	JLabel team31;
	JLabel team32;
	
	JLabel championTeam;
	JLabel championTitle;
	JLabel championLogo;
	JLabel championName;
	
	
	JLabel connector21;
	JLabel connector22;
	JLabel connector23;
	JLabel connector24;
	JLabel connector31;
	JLabel connector32;
	JLabel connector4;
	
	JButton playButton;
	JButton pauseButton;
	JButton startButton;
	JButton homepageButton;
	
	ArrayList<Team> semiFinalPlayers = new ArrayList<>();
	ArrayList<Team> finalPlayers = new ArrayList<>();
	
	Timer lastRunning;

	
	
	
	
	// FONT
	Font InterSemibold = Font.createFont(Font.PLAIN, new File("resources/components/fonts/Inter-SemiBold.ttf"));
	Font InterSemibold36 = InterSemibold.deriveFont((float) 36.0);
	Font InterSemibold20 = InterSemibold.deriveFont((float) 20.0);
	Font InterSemibold14x4 = InterSemibold.deriveFont((float) 14.4);
	
	Timer timerFirstStage = new Timer(1000, new ActionListener() {
		int firstStageMatchCount = 0;
		@Override
		/**
		 * This part runs the first stage of the Playoff, where
		 * all 8 teams are randomly paired. It is the part of a Swing Timer
		 * to make it run matches one-by-one with a delay of 1 second
		 * to make user able to pause the process.
		 * @author Göktürk Gök
		 * @date 03-01-2024
		 */
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub

			
			
			Team winnerStageOne = null;
			try {
				winnerStageOne = Match.matchTwoTeams(MatchUI.teams.get(firstStageMatchCount), MatchUI.teams.get(firstStageMatchCount + 1));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			semiFinalPlayers.add(winnerStageOne);
			
			if (firstStageMatchCount == 0) {
				team21.setBackground(winnerStageOne.getTeamColor());
				team21.setText("  " + winnerStageOne.getTeamShortName());
				team21.setVisible(true);
				connector21.setVisible(true);
			} else if (firstStageMatchCount == 2) {
				team22.setBackground(winnerStageOne.getTeamColor());
				team22.setText("  " + winnerStageOne.getTeamShortName());
				team22.setVisible(true);
				connector22.setVisible(true);
			} else if (firstStageMatchCount == 4) {
				team23.setBackground(winnerStageOne.getTeamColor());
				team23.setText("  " + winnerStageOne.getTeamShortName());
				team23.setVisible(true);
				connector23.setVisible(true);
			} else if (firstStageMatchCount == 6) {
				team24.setBackground(winnerStageOne.getTeamColor());
				team24.setText("  " + winnerStageOne.getTeamShortName());
				team24.setVisible(true);
				connector24.setVisible(true);
			}
			firstStageMatchCount = firstStageMatchCount + 2;
			if (firstStageMatchCount == 8) {
				timerSecondStage.start();
				((Timer)e.getSource()).stop();
			}
			
			
		}
		
	});
	
	Timer timerSecondStage = new Timer(1000, new ActionListener() {
		int secondStageMatchCount = 0;
		

		@Override
		/**
		 * This is the second stage of season Playoff. Similar to the stage one,
		 * it makes remaining four teams play matches with 1 second breaks, making
		 * the user able to pause and play.
		 * @author Göktürk Gök
		 * @date 03-01-2024
		 */
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Team winnerStageTwo = null;
			try {
				winnerStageTwo = Match.matchTwoTeams(semiFinalPlayers.get(secondStageMatchCount), semiFinalPlayers.get(secondStageMatchCount + 1));
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			finalPlayers.add(winnerStageTwo);
			if (secondStageMatchCount == 0) {
				team31.setBackground(winnerStageTwo.getTeamColor());
				team31.setText("  " + winnerStageTwo.getTeamShortName());
				team31.setVisible(true);
				connector31.setVisible(true);
			} else if (secondStageMatchCount == 2) {
				team32.setBackground(winnerStageTwo.getTeamColor());
				team32.setText("  " + winnerStageTwo.getTeamShortName());
				team32.setVisible(true);
				connector32.setVisible(true);
			}
			secondStageMatchCount = secondStageMatchCount + 2;
			if (secondStageMatchCount == 4) {
				finalMatch.start();
				((Timer)e.getSource()).stop();
				
			}
			
		}
		
	});
	
	Timer finalMatch = new Timer(3000, new ActionListener() {

		@Override
		/**
		 * This is the final stage of the Playoff. It runs only the final
		 * match, with a delay of 3 seconds to make the wait for the champion
		 * more exciting.
		 * @author Göktürk Gök
		 * @date 03-01-2024
		 */
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Team champion = null;
			try {
				champion = Match.matchTwoTeams(finalPlayers.get(0), finalPlayers.get(1));
				championTeam.setBackground(champion.getTeamColor());
				championTeam.setVisible(true);
				championTitle.setVisible(true);
				championLogo.setIcon(new ImageIcon(champion.getTeamLogoPath()));
				championLogo.setVisible(true);
				championName.setText(champion.getTeamName());
				connector4.setVisible(true);
				championName.setVisible(true);
				pauseButton.setVisible(false);
				homepageButton.setVisible(true);
				Logging.championLog(champion);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

			//championPoints.setText(((Integer)(Match.teamsWins.get(champion) + 3)).toString() + " wins");
			//championPoints.setVisible(true);
			((Timer)e.getSource()).stop();
		}
		
	});
	
	
	/**
	 * @method MatchFinalEightUI()
	 * This is the constructor of the UI of the season Playoff.
	 * It instantiates the necessary components and gather them,
	 * showing the final 8 teams to play at the instance that it
	 * is made visible. It allows user to start the process and
	 * pause, by using ActionListeners added to the components.
	 * It represents a tree view of the results of the final matches
	 * in its final situation.
	 * @throws IOException
	 * @throws FontFormatException
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public MatchFinalEightUI() throws IOException, FontFormatException {
		Collections.shuffle(MatchUI.teams); // randomize teams for a new randomization (yes);
		matchView = new JFrame();
		matchView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		matchView.setResizable(false);
		matchView.setSize(1440, 900);
		
		componentPanel = new JLayeredPane();
		componentPanel.setSize(1440, 900);
		componentPanel.setBackground(Color.black);
		componentPanel.setLocation(0, 0);
		componentPanel.setOpaque(true);
		
		title = new JLabel();
		title.setSize(181, 44);
		title.setLocation(82, 72);
		title.setIcon(new ImageIcon("resources/components/matchfinaleightui/finaleighttitle.png"));
		
		team1 = new JLabel();
		team1.setSize(200, 64);
		team1.setLocation(82, 158);
		team1.setBackground(MatchUI.teams.get(0).getTeamColor());
		team1.setOpaque(true);
		team1.setText("  " + MatchUI.teams.get(0).getTeamShortName());
		team1.setForeground(Color.white);
		team1.setFont(InterSemibold36);
		
		team2 = new JLabel();
		team2.setSize(200, 64);
		team2.setLocation(82, 222);
		team2.setBackground(MatchUI.teams.get(1).getTeamColor());
		team2.setOpaque(true);
		team2.setText("  " + MatchUI.teams.get(1).getTeamShortName());
		team2.setForeground(Color.white);
		team2.setFont(InterSemibold36);
		
		team3 = new JLabel();
		team3.setSize(200, 64);
		team3.setLocation(82, 316);
		team3.setBackground(MatchUI.teams.get(2).getTeamColor());
		team3.setOpaque(true);
		team3.setText("  " + MatchUI.teams.get(2).getTeamShortName());
		team3.setForeground(Color.white);
		team3.setFont(InterSemibold36);
		
		team4 = new JLabel();
		team4.setSize(200, 64);
		team4.setLocation(82, 380);
		team4.setBackground(MatchUI.teams.get(3).getTeamColor());
		team4.setOpaque(true);
		team4.setText("  " + MatchUI.teams.get(3).getTeamShortName());
		team4.setForeground(Color.white);
		team4.setFont(InterSemibold36);
		
		team5 = new JLabel();
		team5.setSize(200, 64);
		team5.setLocation(82, 474);
		team5.setBackground(MatchUI.teams.get(4).getTeamColor());
		team5.setOpaque(true);
		team5.setText("  " + MatchUI.teams.get(4).getTeamShortName());
		team5.setForeground(Color.white);
		team5.setFont(InterSemibold36);
		
		team6 = new JLabel();
		team6.setSize(200, 64);
		team6.setLocation(82, 538);
		team6.setBackground(MatchUI.teams.get(5).getTeamColor());
		team6.setOpaque(true);
		team6.setText("  " + MatchUI.teams.get(5).getTeamShortName());
		team6.setForeground(Color.white);
		team6.setFont(InterSemibold36);
		
		team7 = new JLabel();
		team7.setSize(200, 64);
		team7.setLocation(82, 632);
		team7.setBackground(MatchUI.teams.get(6).getTeamColor());
		team7.setOpaque(true);
		team7.setText("  " + MatchUI.teams.get(6).getTeamShortName());
		team7.setForeground(Color.white);
		team7.setFont(InterSemibold36);
		
		team8 = new JLabel();
		team8.setSize(200, 64);
		team8.setLocation(82, 696);
		team8.setBackground(MatchUI.teams.get(7).getTeamColor());
		team8.setOpaque(true);
		team8.setText("  " + MatchUI.teams.get(7).getTeamShortName());
		team8.setForeground(Color.white);
		team8.setFont(InterSemibold36);
		
		startButton = new JButton();
		startButton.setSize(86, 15);
		startButton.setLocation(1272, 86);
		startButton.setIcon(new ImageIcon("resources/components/matchui/startbutton.png"));
		startButton.setContentAreaFilled(false);
		startButton.setBorderPainted(false);
		startButton.addActionListener(this);
		
		playButton = new JButton();
		playButton.setSize(86, 15);
		playButton.setLocation(1272, 86);
		playButton.setIcon(new ImageIcon("resources/components/matchui/playbutton.png"));
		playButton.setContentAreaFilled(false);
		playButton.setBorderPainted(false);
		playButton.addActionListener(this);
		playButton.setVisible(false);
		
		pauseButton = new JButton();
		pauseButton.setSize(86, 15);
		pauseButton.setLocation(1272, 86);
		pauseButton.setIcon(new ImageIcon("resources/components/matchui/pausebutton.png"));
		pauseButton.setContentAreaFilled(false);
		pauseButton.setBorderPainted(false);
		pauseButton.addActionListener(this);
		pauseButton.setVisible(false);
		
		connector21 = new JLabel();
		connector21.setIcon(new ImageIcon("resources/components/matchfinaleightui/treeconnector1.png"));
		connector21.setSize(79, 68);
		connector21.setLocation(282, 188);
		connector21.setVisible(false);
		
		connector22 = new JLabel();
		connector22.setIcon(new ImageIcon("resources/components/matchfinaleightui/treeconnector1.png"));
		connector22.setSize(79, 68);
		connector22.setLocation(282, 346);
		connector22.setVisible(false);
		
		connector23 = new JLabel();
		connector23.setIcon(new ImageIcon("resources/components/matchfinaleightui/treeconnector1.png"));
		connector23.setSize(79, 68);
		connector23.setLocation(282, 504);
		connector23.setVisible(false);
		
		connector24 = new JLabel();
		connector24.setIcon(new ImageIcon("resources/components/matchfinaleightui/treeconnector1.png"));
		connector24.setSize(79, 68);
		connector24.setLocation(282, 662);
		connector24.setVisible(false);
		
		connector31 = new JLabel();
		connector31.setIcon(new ImageIcon("resources/components/matchfinaleightui/treeconnector2.png"));
		connector31.setSize(79, 162);
		connector31.setLocation(562, 220);
		connector31.setVisible(false);
		
		connector32 = new JLabel();
		connector32.setIcon(new ImageIcon("resources/components/matchfinaleightui/treeconnector2.png"));
		connector32.setSize(79, 162);
		connector32.setLocation(562, 536);
		connector32.setVisible(false);
		
		connector4 = new JLabel();
		connector4.setSize(201, 320);
		connector4.setLocation(841, 299);
		connector4.setIcon(new ImageIcon("resources/components/matchfinaleightui/treeconnector3.png"));
		connector4.setVisible(false);
		
		team21 = new JLabel();
		team21.setSize(200, 64);
		team21.setLocation(361, 190);
		team21.setOpaque(true);
		team21.setForeground(Color.white);
		team21.setFont(InterSemibold36);
		team21.setVisible(false);
		
		team22 = new JLabel();
		team22.setSize(200, 64);
		team22.setLocation(361, 348);
		team22.setOpaque(true);
		team22.setForeground(Color.white);
		team22.setFont(InterSemibold36);
		team22.setVisible(false);
		
		team23 = new JLabel();
		team23.setSize(200, 64);
		team23.setLocation(361, 506);
		team23.setOpaque(true);
		team23.setForeground(Color.white);
		team23.setFont(InterSemibold36);
		team23.setVisible(false);

		team24 = new JLabel();
		team24.setSize(200, 64);
		team24.setLocation(361, 664);
		team24.setOpaque(true);
		team24.setForeground(Color.white);
		team24.setFont(InterSemibold36);
		team24.setVisible(false);
		
		team31 = new JLabel();
		team31.setSize(200, 64);
		team31.setLocation(641, 269);
		team31.setOpaque(true);
		team31.setForeground(Color.white);
		team31.setFont(InterSemibold36);
		team31.setVisible(false);
		
		team32 = new JLabel();
		team32.setSize(200, 64);
		team32.setLocation(641, 585);
		team32.setOpaque(true);
		team32.setForeground(Color.white);
		team32.setFont(InterSemibold36);
		team32.setVisible(false);
		
		championTeam = new JLabel();
		championTeam.setSize(316, 316);
		championTeam.setLocation(1042, 301);
		championTeam.setIcon(new ImageIcon("resources/components/matchfinaleightui/championbg.png"));
		championTeam.setOpaque(true);
		championTeam.setVisible(false);
		
		championTitle = new JLabel();
		championTitle.setSize(316, 50);
		championTitle.setLocation(1042, 320);
		championTitle.setForeground(Color.white);
		championTitle.setText("Champion");
		championTitle.setFont(InterSemibold36);
		championTitle.setHorizontalAlignment(JLabel.CENTER);
		championTitle.setVisible(false);
		
		championLogo = new JLabel();
		championLogo.setSize(316, 170);
		championLogo.setLocation(1042, 372);
		championLogo.setOpaque(false);
		championLogo.setHorizontalAlignment(JLabel.CENTER);
		championLogo.setVisible(false);
		
		championName = new JLabel();
		championName.setSize(316, 32);
		championName.setForeground(Color.white);
		championName.setLocation(1042, 545);
		championName.setFont(InterSemibold20);
		championName.setHorizontalAlignment(JLabel.CENTER);
		championName.setVisible(false);
		
		homepageButton = new JButton();
		homepageButton.setContentAreaFilled(false);
		homepageButton.setBorderPainted(false);
		homepageButton.setLocation(1222, 82);
		homepageButton.setSize(137, 24);
		homepageButton.setIcon(new ImageIcon("resources/components/matchfinaleightui/homepagebutton.png"));
		homepageButton.addActionListener(this);
		homepageButton.setVisible(false);
		
		componentPanel.add(homepageButton, JLayeredPane.DRAG_LAYER);
		componentPanel.add(championName, JLayeredPane.DRAG_LAYER);
		componentPanel.add(championLogo, JLayeredPane.DRAG_LAYER);
		componentPanel.add(championTitle, JLayeredPane.DRAG_LAYER);
		componentPanel.add(championTeam, JLayeredPane.MODAL_LAYER);
		componentPanel.add(connector4, JLayeredPane.DRAG_LAYER);
		componentPanel.add(connector32, JLayeredPane.DRAG_LAYER);
		componentPanel.add(connector31, JLayeredPane.DRAG_LAYER);
		componentPanel.add(team32, JLayeredPane.DRAG_LAYER);
		componentPanel.add(team31, JLayeredPane.DRAG_LAYER);
		componentPanel.add(team24, JLayeredPane.DRAG_LAYER);			
		componentPanel.add(team23, JLayeredPane.DRAG_LAYER);				
		componentPanel.add(team22, JLayeredPane.DRAG_LAYER);		
		componentPanel.add(team21, JLayeredPane.DRAG_LAYER);
		componentPanel.add(connector24, JLayeredPane.DRAG_LAYER);
		componentPanel.add(connector23, JLayeredPane.DRAG_LAYER);
		componentPanel.add(connector22, JLayeredPane.DRAG_LAYER);
		componentPanel.add(connector21, JLayeredPane.DRAG_LAYER);
		componentPanel.add(startButton, JLayeredPane.DRAG_LAYER);
		componentPanel.add(playButton, JLayeredPane.DRAG_LAYER);
		componentPanel.add(pauseButton, JLayeredPane.DRAG_LAYER);
		componentPanel.add(team8, JLayeredPane.DRAG_LAYER);
		componentPanel.add(team7, JLayeredPane.DRAG_LAYER);		
		componentPanel.add(team6, JLayeredPane.DRAG_LAYER);
		componentPanel.add(team5, JLayeredPane.DRAG_LAYER);
		componentPanel.add(team4, JLayeredPane.DRAG_LAYER);		
		componentPanel.add(team3, JLayeredPane.DRAG_LAYER);
		componentPanel.add(team2, JLayeredPane.DRAG_LAYER);
		componentPanel.add(team1, JLayeredPane.DRAG_LAYER);
		componentPanel.add(title, JLayeredPane.MODAL_LAYER);
		matchView.add(componentPanel);
		matchView.setVisible(true);
	}

	@Override
	/**
	 * This method is an overridden method of the interface ActionListener.
	 * It takes the action performed from sources of actions on the UI constructed
	 * above. It evaluates the source of action, and reorganizes the UI accordingly.
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == startButton) {
			startButton.setVisible(false);
			pauseButton.setVisible(true);
			timerFirstStage.start();
		} else if (e.getSource() == pauseButton) {
			if (timerFirstStage.isRunning() == true) {
				timerFirstStage.stop();
				pauseButton.setVisible(false);
				playButton.setVisible(true);
				lastRunning = timerFirstStage;
			} else if (timerSecondStage.isRunning() == true) {
				timerSecondStage.stop();
				pauseButton.setVisible(false);
				playButton.setVisible(true);
				lastRunning = timerSecondStage;
				
			} else if (finalMatch.isRunning() == true) {
				finalMatch.stop();
				pauseButton.setVisible(false);
				playButton.setVisible(true);
				lastRunning = finalMatch;
			}
		} else if (e.getSource() == playButton) {
			lastRunning.start();
			playButton.setVisible(false);
			pauseButton.setVisible(true);
		} else if (e.getSource() == homepageButton) {
			matchView.dispose();
			try {
				new HomepageUI();
			} catch (IOException | FontFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
