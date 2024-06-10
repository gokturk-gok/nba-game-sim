package match;

import javax.swing.*;

import team.Drafting;
import team.Team;
import user.Login;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class MatchUI extends JFrame implements ActionListener {
	int matchCount = 0;
	JFrame matchView;
	JLayeredPane componentPanel;
	JLabel title;
	JLabel matchesBackground;
	JLabel team1 = new JLabel();
	JLabel team2 = new JLabel();
	JLabel team3 = new JLabel();
	JLabel team4 = new JLabel();
	JLabel team5 = new JLabel();
	JLabel team6 = new JLabel();
	JLabel team7 = new JLabel();
	JLabel team8 = new JLabel();
	JLabel team9 = new JLabel();
	JLabel team10 = new JLabel();
	JLabel team11 = new JLabel();
	JLabel team12 = new JLabel();
	JLabel team13 = new JLabel();
	JLabel team14 = new JLabel();
	JLabel team15 = new JLabel();
	JLabel team16 = new JLabel();
	JLabel team17 = new JLabel();
	JLabel team18 = new JLabel();
	JLabel team19 = new JLabel();
	JLabel team20 = new JLabel();
	JLabel team1Score = new JLabel();
	JLabel team2Score = new JLabel();
	JLabel team3Score = new JLabel();
	JLabel team4Score = new JLabel();
	JLabel team5Score = new JLabel();
	JLabel team6Score = new JLabel();
	JLabel team7Score = new JLabel();
	JLabel team8Score = new JLabel();
	JLabel team9Score = new JLabel();
	JLabel team10Score = new JLabel();
	JLabel team11Score = new JLabel();
	JLabel team12Score = new JLabel();
	JLabel team13Score = new JLabel();
	JLabel team14Score = new JLabel();
	JLabel team15Score = new JLabel();
	JLabel team16Score = new JLabel();
	JLabel team17Score = new JLabel();
	JLabel team18Score = new JLabel();
	JLabel team19Score = new JLabel();
	JLabel team20Score = new JLabel();
	JLabel match1Result = new JLabel();
	JLabel match2Result = new JLabel();
	JLabel match3Result = new JLabel();
	JLabel match4Result = new JLabel();
	JLabel match5Result = new JLabel();
	JLabel match6Result = new JLabel();
	JLabel match7Result = new JLabel();
	JLabel match8Result = new JLabel();
	JLabel match9Result = new JLabel();
	JLabel match10Result = new JLabel();
	
	JButton final8Button;

	HashMap<Integer, JLabel> teamNames = new HashMap<Integer, JLabel>();
	HashMap<Integer, JLabel> teamScores = new HashMap<Integer, JLabel>();
	HashMap<Integer, JLabel> matchResults = new HashMap<Integer, JLabel>();
	public static ArrayList<Team> teams = new ArrayList<>();
	
	JButton playButton;
	JButton pauseButton;
	JButton startButton;
	
	// TEAM VIEW
	JButton viewTeam;
	JButton backButton; //
	JLayeredPane teamView; //
	JLabel teamViewTitle; //
	JLabel teamScore;
	JLabel teamLogo; //
	JButton player1;
	JButton player2;
	JButton player3;
	JButton player4;
	JButton player5;
	JButton player6;
	JButton player7;
	JButton player8;
	JButton player9;
	JButton player10;
	JButton player11;
	JButton player12;
	
	JLabel playerName;
	JLabel playerPosition;
	JLabel playerScoreTitle;
	JLabel playerTotalReboundsTitle;
	JLabel playerTotalBlocksTitle;
	JLabel playerTotalStealsTitle;
	JLabel playerTotalAssistsTitle;
	JLabel playerTotalPointsTitle;
	JLabel playerScore;
	JLabel playerTotalRebounds;
	JLabel playerTotalBlocks;
	JLabel playerTotalSteals;
	JLabel playerTotalAssists;
	JLabel playerTotalPoints;
	JButton closeButton;
	
	
	// FONT
	Font InterSemibold = Font.createFont(Font.PLAIN, new File("resources/components/fonts/Inter-SemiBold.ttf"));
	Font InterSemibold36 = InterSemibold.deriveFont((float) 36.0);
	Font InterSemibold14x4 = InterSemibold.deriveFont((float) 14.4);
	Font InterSemibold20 = InterSemibold.deriveFont((float) 20);
	Font InterRegular = Font.createFont(Font.PLAIN, new File("resources/components/fonts/Inter-Regular.ttf"));
	Font InterRegular12 = InterRegular.deriveFont((float) 12.0);
	

	Timer timer = new Timer(500, new ActionListener() {

		@Override
		/**
		 * This is the Swing Timer object that make the league matches continue.
		 * It makes teams play matches every half seconds, using the method
		 * Match.matchesPreEight(). Then rearranges the UI accordingly, representing
		 * the winners of last matches and numbers of matches that each team won over
		 * 40 matches that all they play.
		 * @author Göktürk Gök
		 * @date 03-01-2024
		 */
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			try {
				ArrayList<Team> winners = Match.matchesPreEight();
				int teamCounter = 0;
				int initialY = 179;
				for (JLabel label : teamNames.values()) {
					label.setSize(160, 64);
					label.setBackground(Drafting.playingTeams.get(teamCounter).getTeamColor());
					label.setFont(InterSemibold36);
					label.setForeground(Color.white);
					label.setText(Drafting.playingTeams.get(teamCounter).getTeamShortName());
					label.setOpaque(true);
					label.setHorizontalAlignment(JLabel.CENTER);
					if (teamCounter % 2 == 0) {
						label.setLocation(82, initialY + (teamCounter / 2 ) * 64);
					} else {
						label.setLocation(1198, initialY + ((teamCounter - 1) / 2) * 64);
					}
					teamCounter++;
				}
				int intY = 179;
				int teamCounter2 = 0;
				for (JLabel label : teamScores.values()) {
					label.setSize(103, 64);
					label.setForeground(Color.black);
					label.setOpaque(false);
					label.setText(((Integer)Match.teamsWins.get(Drafting.playingTeams.get(teamCounter2))).toString());
					label.setFont(InterSemibold36);
					label.setHorizontalAlignment(JLabel.CENTER);
					if (teamCounter2 % 2 == 0) {
						label.setLocation(242, intY + (teamCounter2 / 2) * 64);
					} else {
						label.setLocation(1095, intY + ((teamCounter2 - 1) / 2) * 64);
					}
					label.repaint();
					label.revalidate();
					teamCounter2++;
				}
				
				int matchC = 0;
				for (JLabel label : matchResults.values()) {
					label.setSize(600, 25);
					label.setFont(InterSemibold20);
					label.setForeground(Color.black);
					label.setHorizontalAlignment(JLabel.CENTER);
					label.setLocation(420, 199 + matchC * 64);
					label.setText(winners.get(matchC).getTeamName() + " won!");
					matchC++;
				}
				componentPanel.repaint();
				componentPanel.revalidate();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			matchCount++;
			if (matchCount == 40) {
				((Timer)e.getSource()).stop();
				pauseButton.setVisible(false);
				final8Button.setVisible(true);
			}
		}
		
	});
	
	
	/**
	 * This is the constructor of the UI that represents the leauge matches before season Playoff.
	 * At initial, it represents the teams arrangement determined randomly. Then it gets reorganized
	 * by randomizing the teams again while the leauge continues. This frame allows user to pause the
	 * matches and see their team via a JLayeredPane.
	 * @throws IOException
	 * @throws FontFormatException
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public MatchUI() throws IOException, FontFormatException {
		matchView = new JFrame();
		matchView.setDefaultCloseOperation(EXIT_ON_CLOSE);
		matchView.setSize(1440, 900);
		matchView.setResizable(false);
		
		teamNames.put(0, team1);
		teamNames.put(1, team2);
		teamNames.put(2, team3);
		teamNames.put(3, team4);
		teamNames.put(4, team5);
		teamNames.put(5, team6);
		teamNames.put(6, team7);
		teamNames.put(7, team8);
		teamNames.put(8, team9);
		teamNames.put(9, team10);
		teamNames.put(10, team11);
		teamNames.put(11, team12);
		teamNames.put(12, team13);
		teamNames.put(13, team14);
		teamNames.put(14, team15);
		teamNames.put(15, team16);
		teamNames.put(16, team17);
		teamNames.put(17, team18);
		teamNames.put(18, team19);
		teamNames.put(19, team20);
		teamScores.put(0, team1Score);
		teamScores.put(1, team2Score);
		teamScores.put(2, team3Score);
		teamScores.put(3, team4Score);
		teamScores.put(4, team5Score);
		teamScores.put(5, team6Score);
		teamScores.put(6, team7Score);
		teamScores.put(7, team8Score);
		teamScores.put(8, team9Score);
		teamScores.put(9, team10Score);
		teamScores.put(10, team11Score);
		teamScores.put(11, team12Score);
		teamScores.put(12, team13Score);
		teamScores.put(13, team14Score);
		teamScores.put(14, team15Score);
		teamScores.put(15, team16Score);
		teamScores.put(16, team17Score);
		teamScores.put(17, team18Score);
		teamScores.put(18, team19Score);
		teamScores.put(19, team20Score);
		matchResults.put(1, match1Result);
		matchResults.put(2, match2Result);
		matchResults.put(3, match3Result);
		matchResults.put(4, match4Result);
		matchResults.put(5, match5Result);
		matchResults.put(6, match6Result);
		matchResults.put(7, match7Result);
		matchResults.put(8, match8Result);
		matchResults.put(9, match9Result);
		matchResults.put(10, match10Result);
		
		componentPanel = new JLayeredPane();
		componentPanel.setLocation(0	, 0);
		componentPanel.setSize(1440, 900);
		componentPanel.setBackground(Color.black);
		componentPanel.setOpaque(true);
		
		title = new JLabel();
		title.setLocation(82, 72);
		title.setFont(InterSemibold36);
		title.setText("Matches");
		title.setForeground(Color.white);
		title.setSize(300, 44);
		
		matchesBackground = new JLabel();
		matchesBackground.setBackground(new Color(242, 242, 242));
		matchesBackground.setLocation(242, 179);
		matchesBackground.setSize(956, 640);
		matchesBackground.setOpaque(true);
		
		viewTeam = new JButton();
		viewTeam.setSize(116, 15);
		viewTeam.setLocation(662, 82);
		viewTeam.addActionListener(this);
		viewTeam.setIcon(new ImageIcon("resources/components/matchui/viewteambutton.png"));
		viewTeam.setContentAreaFilled(false);
		viewTeam.setBorderPainted(false);
		
		int teamCounter = 0;
		int initialY = 179;
		for (JLabel label : teamNames.values()) {
			label.setSize(160, 64);
			label.setBackground(Drafting.playingTeams.get(teamCounter).getTeamColor());
			label.setFont(InterSemibold36);
			label.setForeground(Color.white);
			label.setText(Drafting.playingTeams.get(teamCounter).getTeamShortName());
			label.setOpaque(true);
			label.setHorizontalAlignment(JLabel.CENTER);
			if (teamCounter % 2 == 0) {
				label.setLocation(82, initialY + (teamCounter / 2 ) * 64);
			} else {
				label.setLocation(1198, initialY + ((teamCounter - 1) / 2) * 64);
			}
			componentPanel.add(label, JLayeredPane.POPUP_LAYER);
			teamCounter++;
		}
		Match.matchTeams();
		int intY = 179;
		int teamCounter2 = 0;
		for (JLabel label : teamScores.values()) {
			label.setSize(103, 64);
			label.setForeground(Color.black);
			label.setOpaque(false);
			label.setText(((Integer)Match.teamsWins.get(Drafting.playingTeams.get(teamCounter2))).toString());
			label.setFont(InterSemibold36);
			label.setHorizontalAlignment(JLabel.CENTER);
			if (teamCounter2 % 2 == 0) {
				label.setLocation(242, intY + (teamCounter2 / 2) * 64);
			} else {
				label.setLocation(1095, intY + ((teamCounter2 - 1) / 2) * 64);
			}
			componentPanel.add(label, JLayeredPane.POPUP_LAYER);
			teamCounter2++;
		}
		
		int matchC = 0;
		for (JLabel label : matchResults.values()) {
			label.setSize(600, 25);
			label.setFont(InterSemibold20);
			label.setForeground(Color.black);
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setLocation(420, 199 + matchC * 64);
			componentPanel.add(label, JLayeredPane.POPUP_LAYER);
			matchC++;
		}
		
		
		
	
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
		
		final8Button = new JButton();
		final8Button.setSize(240, 15);
		final8Button.setLocation(1118, 86);
		final8Button.setContentAreaFilled(false);
		final8Button.setBorderPainted(false);
		final8Button.setIcon(new ImageIcon("resources/components/matchui/final8button.png"));
		final8Button.addActionListener(this);
		final8Button.setVisible(false);

		
		teamView = new JLayeredPane();
		teamView.setSize(1440, 900);
		teamView.setBackground(Color.black);
		teamView.setLocation(0, 0);
		teamView.setOpaque(true);
		teamView.setVisible(false);
		
		teamViewTitle = new JLabel();
		teamViewTitle.setLocation(82, 72);
		teamViewTitle.setFont(InterSemibold36);
		teamViewTitle.setText(Login.currentTeam.getTeamName());
		teamViewTitle.setForeground(Color.white);
		teamViewTitle.setSize(500, 44);
		
		teamLogo = new JLabel();
		teamLogo.setLocation(670, 57);
		ImageIcon teamLogoIcon = new ImageIcon(Login.currentTeam.getTeamLogoPath());
		Image teamLogoImage = teamLogoIcon.getImage();
		teamLogoImage = teamLogoImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		teamLogo.setIcon(new ImageIcon(teamLogoImage));
		teamLogo.setSize(100, 100);
		teamLogo.setOpaque(false);
		
		backButton = new JButton();
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setIcon(new ImageIcon("resources/components/matchui/backbutton.png"));
		backButton.setSize(78, 16);
		backButton.setLocation(1272, 86);
		backButton.addActionListener(this);
		
		teamScore = new JLabel();
		teamScore.setText("SCORE " + ((Integer)Login.currentTeam.getTeamScore()).toString());
		teamScore.setFont(InterSemibold20);
		teamScore.setForeground(Color.white);
		teamScore.setSize(200, 24);
		teamScore.setLocation(82, 120);
		
		player1 = new JButton();
		player1.setText(Login.currentTeam.teamPlayers.get(0).getPlayerPosition() + "  " + Login.currentTeam.teamPlayers.get(0).getPlayerName());
		player1.setSize(400, 24);
		player1.setFont(InterSemibold20);
		player1.setLocation(82, 236);
		player1.setForeground(Color.white);
		player1.addActionListener(this);
		player1.setContentAreaFilled(false);
		player1.setBorderPainted(false);
		player1.setHorizontalAlignment(JLabel.LEFT);
		
		player2 = new JButton();
		player2.setText(Login.currentTeam.teamPlayers.get(1).getPlayerPosition() + "  " + Login.currentTeam.teamPlayers.get(1).getPlayerName());
		player2.setSize(400, 24);
		player2.setFont(InterSemibold20);
		player2.setLocation(82, 270);
		player2.setForeground(Color.white);
		player2.addActionListener(this);
		player2.setContentAreaFilled(false);
		player2.setBorderPainted(false);
		player2.setHorizontalAlignment(JLabel.LEFT);
		
		player3 = new JButton();
		player3.setText(Login.currentTeam.teamPlayers.get(2).getPlayerPosition() + "  " + Login.currentTeam.teamPlayers.get(2).getPlayerName());
		player3.setSize(400, 24);
		player3.setFont(InterSemibold20);
		player3.setLocation(82, 304);
		player3.setForeground(Color.white);
		player3.addActionListener(this);
		player3.setContentAreaFilled(false);
		player3.setBorderPainted(false);
		player3.setHorizontalAlignment(JLabel.LEFT);
		
		player4 = new JButton();
		player4.setText(Login.currentTeam.teamPlayers.get(3).getPlayerPosition() + "  " + Login.currentTeam.teamPlayers.get(3).getPlayerName());
		player4.setSize(400, 24);
		player4.setFont(InterSemibold20);
		player4.setLocation(82, 338);
		player4.setForeground(Color.white);
		player4.addActionListener(this);
		player4.setContentAreaFilled(false);
		player4.setBorderPainted(false);
		player4.setHorizontalAlignment(JLabel.LEFT);
		
		player5 = new JButton();
		player5.setText(Login.currentTeam.teamPlayers.get(4).getPlayerPosition() + "  " + Login.currentTeam.teamPlayers.get(4).getPlayerName());
		player5.setSize(400, 24);
		player5.setFont(InterSemibold20);
		player5.setLocation(82, 372);
		player5.setForeground(Color.white);
		player5.addActionListener(this);
		player5.setContentAreaFilled(false);
		player5.setBorderPainted(false);
		player5.setHorizontalAlignment(JLabel.LEFT);
		
		player6 = new JButton();
		player6.setText(Login.currentTeam.teamPlayers.get(5).getPlayerPosition() + "  " + Login.currentTeam.teamPlayers.get(5).getPlayerName());
		player6.setSize(400, 24);
		player6.setFont(InterSemibold20);
		player6.setLocation(82, 406);
		player6.setForeground(Color.white);
		player6.addActionListener(this);
		player6.setContentAreaFilled(false);
		player6.setBorderPainted(false);
		player6.setHorizontalAlignment(JLabel.LEFT);
		
		player7 = new JButton();
		player7.setText(Login.currentTeam.teamPlayers.get(6).getPlayerPosition() + "  " + Login.currentTeam.teamPlayers.get(6).getPlayerName());
		player7.setSize(400, 24);
		player7.setFont(InterSemibold20);
		player7.setLocation(82, 440);
		player7.setForeground(Color.white);
		player7.addActionListener(this);
		player7.setContentAreaFilled(false);
		player7.setBorderPainted(false);
		player7.setHorizontalAlignment(JLabel.LEFT);
		
		player8 = new JButton();
		player8.setText(Login.currentTeam.teamPlayers.get(7).getPlayerPosition() + "  " + Login.currentTeam.teamPlayers.get(7).getPlayerName());
		player8.setSize(400, 24);
		player8.setFont(InterSemibold20);
		player8.setLocation(82, 474);
		player8.setForeground(Color.white);
		player8.addActionListener(this);
		player8.setContentAreaFilled(false);
		player8.setBorderPainted(false);
		player8.setHorizontalAlignment(JLabel.LEFT);
		
		player9 = new JButton();
		player9.setText(Login.currentTeam.teamPlayers.get(8).getPlayerPosition() + "  " + Login.currentTeam.teamPlayers.get(8).getPlayerName());
		player9.setSize(400, 24);
		player9.setFont(InterSemibold20);
		player9.setLocation(82, 508);
		player9.setForeground(Color.white);
		player9.addActionListener(this);
		player9.setContentAreaFilled(false);
		player9.setBorderPainted(false);
		player9.setHorizontalAlignment(JLabel.LEFT);
		
		player10 = new JButton();
		player10.setText(Login.currentTeam.teamPlayers.get(9).getPlayerPosition() + "  " + Login.currentTeam.teamPlayers.get(9).getPlayerName());
		player10.setSize(400, 24);
		player10.setFont(InterSemibold20);
		player10.setLocation(82, 542);
		player10.setForeground(Color.white);
		player10.addActionListener(this);
		player10.setContentAreaFilled(false);
		player10.setBorderPainted(false);
		player10.setHorizontalAlignment(JLabel.LEFT);
		
		player11 = new JButton();
		player11.setText(Login.currentTeam.teamPlayers.get(10).getPlayerPosition() + "  " + Login.currentTeam.teamPlayers.get(10).getPlayerName());
		player11.setSize(400, 24);
		player11.setFont(InterSemibold20);
		player11.setLocation(82, 576);
		player11.setForeground(Color.white);
		player11.addActionListener(this);
		player11.setContentAreaFilled(false);
		player11.setBorderPainted(false);
		player11.setHorizontalAlignment(JLabel.LEFT);
		
		player12 = new JButton();
		player12.setText(Login.currentTeam.teamPlayers.get(11).getPlayerPosition() + "  " +Login.currentTeam.teamPlayers.get(11).getPlayerName());
		player12.setSize(400, 24);
		player12.setFont(InterSemibold20);
		player12.setLocation(82, 610);
		player12.setForeground(Color.white);
		player12.addActionListener(this);
		player12.setContentAreaFilled(false);
		player12.setBorderPainted(false);
		player12.setHorizontalAlignment(JLabel.LEFT);
		
		playerName = new JLabel();
		playerName.setSize(350, 44);
		playerName.setLocation(834, 201);
		playerName.setFont(InterSemibold36);
		playerName.setForeground(Color.white);
		playerName.setOpaque(false);
		
		playerScoreTitle = new JLabel();
		playerScoreTitle.setSize(240, 24);
		playerScoreTitle.setLocation(834, 266);
		playerScoreTitle.setFont(InterSemibold20);
		playerScoreTitle.setForeground(Color.white);
		playerScoreTitle.setText("TOTAL SCORE");
		
		playerScore = new JLabel();
		playerScore.setSize(120, 24);
		playerScore.setLocation(1190, 266);
		playerScore.setFont(InterSemibold20);
		playerScore.setForeground(Color.white);
		
		playerTotalReboundsTitle = new JLabel();
		playerTotalReboundsTitle.setSize(240, 24);
		playerTotalReboundsTitle.setLocation(834, 300);
		playerTotalReboundsTitle.setFont(InterSemibold20);
		playerTotalReboundsTitle.setForeground(Color.white);
		playerTotalReboundsTitle.setText("TOTAL REBOUNDS");
		
		playerTotalRebounds = new JLabel();
		playerTotalRebounds.setSize(120, 24);
		playerTotalRebounds.setLocation(1190, 300);
		playerTotalRebounds.setFont(InterSemibold20);
		playerTotalRebounds.setForeground(Color.white);
		
		playerTotalBlocksTitle = new JLabel();
		playerTotalBlocksTitle.setSize(240, 24);
		playerTotalBlocksTitle.setLocation(834, 334);
		playerTotalBlocksTitle.setFont(InterSemibold20);
		playerTotalBlocksTitle.setForeground(Color.white);
		playerTotalBlocksTitle.setText("TOTAL BLOCKS");
		
		playerTotalBlocks = new JLabel();
		playerTotalBlocks.setSize(120, 24);
		playerTotalBlocks.setLocation(1190, 334);
		playerTotalBlocks.setFont(InterSemibold20);
		playerTotalBlocks.setForeground(Color.white);
		
		playerTotalStealsTitle = new JLabel();
		playerTotalStealsTitle.setSize(240, 24);
		playerTotalStealsTitle.setLocation(834, 368);
		playerTotalStealsTitle.setFont(InterSemibold20);
		playerTotalStealsTitle.setForeground(Color.white);
		playerTotalStealsTitle.setText("TOTAL STEALS");
		
		playerTotalSteals = new JLabel();
		playerTotalSteals.setSize(120, 24);
		playerTotalSteals.setLocation(1190, 368);
		playerTotalSteals.setFont(InterSemibold20);
		playerTotalSteals.setForeground(Color.white);
		
		
		playerTotalAssistsTitle = new JLabel();
		playerTotalAssistsTitle.setSize(240, 24);
		playerTotalAssistsTitle.setLocation(834, 402);
		playerTotalAssistsTitle.setFont(InterSemibold20);
		playerTotalAssistsTitle.setForeground(Color.white);
		playerTotalAssistsTitle.setText("TOTAL ASSISTS");
		
		playerTotalAssists = new JLabel();
		playerTotalAssists.setSize(120, 24);
		playerTotalAssists.setLocation(1190, 402);
		playerTotalAssists.setFont(InterSemibold20);
		playerTotalAssists.setForeground(Color.white);
		
		
		playerTotalPointsTitle = new JLabel();
		playerTotalPointsTitle.setSize(240, 24);
		playerTotalPointsTitle.setLocation(834, 436);
		playerTotalPointsTitle.setFont(InterSemibold20);
		playerTotalPointsTitle.setForeground(Color.white);
		playerTotalPointsTitle.setText("TOTAL POINTS");
		
		playerTotalPoints = new JLabel();
		playerTotalPoints.setSize(120, 24);
		playerTotalPoints.setLocation(1190, 436);
		playerTotalPoints.setFont(InterSemibold20);
		playerTotalPoints.setForeground(Color.white);
		
		playerPosition = new JLabel();
		playerPosition.setFont(InterSemibold36);
		playerPosition.setForeground(Color.white);
		playerPosition.setSize(64, 44);
		playerPosition.setLocation(1190, 201);
		
		teamView.add(playerPosition, JLayeredPane.DRAG_LAYER);
		teamView.add(playerTotalPoints, JLayeredPane.DRAG_LAYER);
		teamView.add(playerTotalPointsTitle, JLayeredPane.DRAG_LAYER);
		teamView.add(playerTotalAssists, JLayeredPane.DRAG_LAYER);
		teamView.add(playerTotalAssistsTitle, JLayeredPane.DRAG_LAYER);
		teamView.add(playerTotalSteals, JLayeredPane.DRAG_LAYER);
		teamView.add(playerTotalStealsTitle, JLayeredPane.DRAG_LAYER);
		teamView.add(playerTotalBlocks, JLayeredPane.DRAG_LAYER);
		teamView.add(playerTotalBlocksTitle, JLayeredPane.DRAG_LAYER);	
		teamView.add(playerTotalRebounds, JLayeredPane.DRAG_LAYER);
		teamView.add(playerTotalReboundsTitle, JLayeredPane.DRAG_LAYER);		
		teamView.add(playerScore, JLayeredPane.DRAG_LAYER);
		teamView.add(playerScoreTitle, JLayeredPane.DRAG_LAYER);
		teamView.add(playerName, JLayeredPane.DRAG_LAYER);
		teamView.add(player12, JLayeredPane.DRAG_LAYER);	
		teamView.add(player11, JLayeredPane.DRAG_LAYER);	
		teamView.add(player10, JLayeredPane.DRAG_LAYER);	
		teamView.add(player9, JLayeredPane.DRAG_LAYER);	
		teamView.add(player8, JLayeredPane.DRAG_LAYER);	
		teamView.add(player7, JLayeredPane.DRAG_LAYER);	
		teamView.add(player6, JLayeredPane.DRAG_LAYER);	
		teamView.add(player5, JLayeredPane.DRAG_LAYER);	
		teamView.add(player4, JLayeredPane.DRAG_LAYER);	
		teamView.add(player3, JLayeredPane.DRAG_LAYER);			
		teamView.add(player2, JLayeredPane.DRAG_LAYER);		
		teamView.add(player1, JLayeredPane.DRAG_LAYER);
		teamView.add(teamScore, JLayeredPane.DRAG_LAYER);
		teamView.add(backButton, JLayeredPane.DRAG_LAYER);
		teamView.add(teamLogo, JLayeredPane.DRAG_LAYER);
		teamView.add(teamViewTitle, JLayeredPane.MODAL_LAYER);
		
		
		
		
		
		componentPanel.add(viewTeam, JLayeredPane.DRAG_LAYER);
		componentPanel.add(teamView, JLayeredPane.DRAG_LAYER);
		componentPanel.add(final8Button, JLayeredPane.POPUP_LAYER);
		componentPanel.add(pauseButton, JLayeredPane.POPUP_LAYER);
		componentPanel.add(startButton, JLayeredPane.POPUP_LAYER);
		componentPanel.add(playButton, JLayeredPane.POPUP_LAYER);
		componentPanel.add(matchesBackground, JLayeredPane.MODAL_LAYER);
		componentPanel.add(title, JLayeredPane.POPUP_LAYER);
		matchView.add(componentPanel);
		matchView.setVisible(true);
	}
	
	@Override
	/**
	 * This method is an overridden method of ActionListener interface.
	 * It gets the source of action performed and then organizes the
	 * UI accordingly, such as, hiding the Play button as the game has
	 * begun or continued.
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == startButton) {
			startButton.setVisible(false);
			pauseButton.setVisible(true);
			start();
		} else if (e.getSource() == playButton) {
			playButton.setVisible(false);
			pauseButton.setVisible(true);
			start();
		} else if (e.getSource() == pauseButton) {
			pauseButton.setVisible(false);
			playButton.setVisible(true);
			stop();
		} else if (e.getSource() == final8Button) {
			teams = Match.findFinal8(Match.teamsWins);

			matchView.dispose();
			try {
				new MatchFinalEightUI();
			} catch (IOException | FontFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} else if (e.getSource() == viewTeam) {
			stop();
			teamView.setVisible(true);
			viewTeam.setVisible(false);
		} else if (e.getSource() == backButton) {
			teamView.setVisible(false);
			pauseButton.setVisible(true);
			playButton.setVisible(false);
			viewTeam.setVisible(true);
			start();
		} else if (e.getSource() == player1) {
			playerName.setText(Login.currentTeam.getTeamPlayers().get(0).getPlayerName());
			playerScore.setText(((Integer)Login.currentTeam.getTeamPlayers().get(0).getPlayerScore()).toString());
			playerTotalRebounds.setText(((Double)Login.currentTeam.getTeamPlayers().get(0).getTotalRebounds()).toString());
			playerTotalBlocks.setText(((Double)Login.currentTeam.getTeamPlayers().get(0).getTotalBlocks()).toString());
			playerTotalSteals.setText(((Double)Login.currentTeam.getTeamPlayers().get(0).getTotalSteals()).toString());
			playerTotalAssists.setText(((Double)Login.currentTeam.getTeamPlayers().get(0).getTotalAssists()).toString());
			playerTotalPoints.setText(((Double)Login.currentTeam.getTeamPlayers().get(0).getTotalPoints()).toString());
			playerPosition.setText(Login.currentTeam.getTeamPlayers().get(0).getPlayerPosition());
		} else if (e.getSource() == player2) {
			playerName.setText(Login.currentTeam.getTeamPlayers().get(1).getPlayerName());
			playerScore.setText(((Integer)Login.currentTeam.getTeamPlayers().get(1).getPlayerScore()).toString());
			playerTotalRebounds.setText(((Double)Login.currentTeam.getTeamPlayers().get(1).getTotalRebounds()).toString());
			playerTotalBlocks.setText(((Double)Login.currentTeam.getTeamPlayers().get(1).getTotalBlocks()).toString());
			playerTotalSteals.setText(((Double)Login.currentTeam.getTeamPlayers().get(1).getTotalSteals()).toString());
			playerTotalAssists.setText(((Double)Login.currentTeam.getTeamPlayers().get(1).getTotalAssists()).toString());
			playerTotalPoints.setText(((Double)Login.currentTeam.getTeamPlayers().get(1).getTotalPoints()).toString());
			playerPosition.setText(Login.currentTeam.getTeamPlayers().get(1).getPlayerPosition());
		} else if (e.getSource() == player3) {
			playerName.setText(Login.currentTeam.getTeamPlayers().get(2).getPlayerName());
			playerScore.setText(((Integer)Login.currentTeam.getTeamPlayers().get(2).getPlayerScore()).toString());
			playerTotalRebounds.setText(((Double)Login.currentTeam.getTeamPlayers().get(2).getTotalRebounds()).toString());
			playerTotalBlocks.setText(((Double)Login.currentTeam.getTeamPlayers().get(2).getTotalBlocks()).toString());
			playerTotalSteals.setText(((Double)Login.currentTeam.getTeamPlayers().get(2).getTotalSteals()).toString());
			playerTotalAssists.setText(((Double)Login.currentTeam.getTeamPlayers().get(2).getTotalAssists()).toString());
			playerTotalPoints.setText(((Double)Login.currentTeam.getTeamPlayers().get(2).getTotalPoints()).toString());
			playerPosition.setText(Login.currentTeam.getTeamPlayers().get(2).getPlayerPosition());
		} else if (e.getSource() == player4) {
			playerName.setText(Login.currentTeam.getTeamPlayers().get(3).getPlayerName());
			playerScore.setText(((Integer)Login.currentTeam.getTeamPlayers().get(3).getPlayerScore()).toString());
			playerTotalRebounds.setText(((Double)Login.currentTeam.getTeamPlayers().get(3).getTotalRebounds()).toString());
			playerTotalBlocks.setText(((Double)Login.currentTeam.getTeamPlayers().get(3).getTotalBlocks()).toString());
			playerTotalSteals.setText(((Double)Login.currentTeam.getTeamPlayers().get(3).getTotalSteals()).toString());
			playerTotalAssists.setText(((Double)Login.currentTeam.getTeamPlayers().get(3).getTotalAssists()).toString());
			playerTotalPoints.setText(((Double)Login.currentTeam.getTeamPlayers().get(3).getTotalPoints()).toString());
			playerPosition.setText(Login.currentTeam.getTeamPlayers().get(3).getPlayerPosition());
		} else if (e.getSource() == player5) {
			playerName.setText(Login.currentTeam.getTeamPlayers().get(4).getPlayerName());
			playerScore.setText(((Integer)Login.currentTeam.getTeamPlayers().get(4).getPlayerScore()).toString());
			playerTotalRebounds.setText(((Double)Login.currentTeam.getTeamPlayers().get(4).getTotalRebounds()).toString());
			playerTotalBlocks.setText(((Double)Login.currentTeam.getTeamPlayers().get(4).getTotalBlocks()).toString());
			playerTotalSteals.setText(((Double)Login.currentTeam.getTeamPlayers().get(4).getTotalSteals()).toString());
			playerTotalAssists.setText(((Double)Login.currentTeam.getTeamPlayers().get(4).getTotalAssists()).toString());
			playerTotalPoints.setText(((Double)Login.currentTeam.getTeamPlayers().get(4).getTotalPoints()).toString());
			playerPosition.setText(Login.currentTeam.getTeamPlayers().get(4).getPlayerPosition());
		} else if (e.getSource() == player6) {
			playerName.setText(Login.currentTeam.getTeamPlayers().get(5).getPlayerName());
			playerScore.setText(((Integer)Login.currentTeam.getTeamPlayers().get(5).getPlayerScore()).toString());
			playerTotalRebounds.setText(((Double)Login.currentTeam.getTeamPlayers().get(5).getTotalRebounds()).toString());
			playerTotalBlocks.setText(((Double)Login.currentTeam.getTeamPlayers().get(5).getTotalBlocks()).toString());
			playerTotalSteals.setText(((Double)Login.currentTeam.getTeamPlayers().get(5).getTotalSteals()).toString());
			playerTotalAssists.setText(((Double)Login.currentTeam.getTeamPlayers().get(5).getTotalAssists()).toString());
			playerTotalPoints.setText(((Double)Login.currentTeam.getTeamPlayers().get(5).getTotalPoints()).toString());
			playerPosition.setText(Login.currentTeam.getTeamPlayers().get(5).getPlayerPosition());
		} else if (e.getSource() == player7) {
			playerName.setText(Login.currentTeam.getTeamPlayers().get(6).getPlayerName());
			playerScore.setText(((Integer)Login.currentTeam.getTeamPlayers().get(6).getPlayerScore()).toString());
			playerTotalRebounds.setText(((Double)Login.currentTeam.getTeamPlayers().get(6).getTotalRebounds()).toString());
			playerTotalBlocks.setText(((Double)Login.currentTeam.getTeamPlayers().get(6).getTotalBlocks()).toString());
			playerTotalSteals.setText(((Double)Login.currentTeam.getTeamPlayers().get(6).getTotalSteals()).toString());
			playerTotalAssists.setText(((Double)Login.currentTeam.getTeamPlayers().get(6).getTotalAssists()).toString());
			playerTotalPoints.setText(((Double)Login.currentTeam.getTeamPlayers().get(6).getTotalPoints()).toString());
			playerPosition.setText(Login.currentTeam.getTeamPlayers().get(6).getPlayerPosition());
		} else if (e.getSource() == player8) {
			playerName.setText(Login.currentTeam.getTeamPlayers().get(7).getPlayerName());
			playerScore.setText(((Integer)Login.currentTeam.getTeamPlayers().get(7).getPlayerScore()).toString());
			playerTotalRebounds.setText(((Double)Login.currentTeam.getTeamPlayers().get(7).getTotalRebounds()).toString());
			playerTotalBlocks.setText(((Double)Login.currentTeam.getTeamPlayers().get(7).getTotalBlocks()).toString());
			playerTotalSteals.setText(((Double)Login.currentTeam.getTeamPlayers().get(7).getTotalSteals()).toString());
			playerTotalAssists.setText(((Double)Login.currentTeam.getTeamPlayers().get(7).getTotalAssists()).toString());
			playerTotalPoints.setText(((Double)Login.currentTeam.getTeamPlayers().get(7).getTotalPoints()).toString());
			playerPosition.setText(Login.currentTeam.getTeamPlayers().get(7).getPlayerPosition());
		} else if (e.getSource() == player9) {
			playerName.setText(Login.currentTeam.getTeamPlayers().get(8).getPlayerName());
			playerScore.setText(((Integer)Login.currentTeam.getTeamPlayers().get(8).getPlayerScore()).toString());
			playerTotalRebounds.setText(((Double)Login.currentTeam.getTeamPlayers().get(8).getTotalRebounds()).toString());
			playerTotalBlocks.setText(((Double)Login.currentTeam.getTeamPlayers().get(8).getTotalBlocks()).toString());
			playerTotalSteals.setText(((Double)Login.currentTeam.getTeamPlayers().get(8).getTotalSteals()).toString());
			playerTotalAssists.setText(((Double)Login.currentTeam.getTeamPlayers().get(8).getTotalAssists()).toString());
			playerTotalPoints.setText(((Double)Login.currentTeam.getTeamPlayers().get(8).getTotalPoints()).toString());
			playerPosition.setText(Login.currentTeam.getTeamPlayers().get(8).getPlayerPosition());
		} else if (e.getSource() == player10) {
			playerName.setText(Login.currentTeam.getTeamPlayers().get(9).getPlayerName());
			playerScore.setText(((Integer)Login.currentTeam.getTeamPlayers().get(9).getPlayerScore()).toString());
			playerTotalRebounds.setText(((Double)Login.currentTeam.getTeamPlayers().get(9).getTotalRebounds()).toString());
			playerTotalBlocks.setText(((Double)Login.currentTeam.getTeamPlayers().get(9).getTotalBlocks()).toString());
			playerTotalSteals.setText(((Double)Login.currentTeam.getTeamPlayers().get(9).getTotalSteals()).toString());
			playerTotalAssists.setText(((Double)Login.currentTeam.getTeamPlayers().get(9).getTotalAssists()).toString());
			playerTotalPoints.setText(((Double)Login.currentTeam.getTeamPlayers().get(9).getTotalPoints()).toString());
			playerPosition.setText(Login.currentTeam.getTeamPlayers().get(9).getPlayerPosition());
		} else if (e.getSource() == player11) {
			playerName.setText(Login.currentTeam.getTeamPlayers().get(10).getPlayerName());
			playerScore.setText(((Integer)Login.currentTeam.getTeamPlayers().get(10).getPlayerScore()).toString());
			playerTotalRebounds.setText(((Double)Login.currentTeam.getTeamPlayers().get(10).getTotalRebounds()).toString());
			playerTotalBlocks.setText(((Double)Login.currentTeam.getTeamPlayers().get(10).getTotalBlocks()).toString());
			playerTotalSteals.setText(((Double)Login.currentTeam.getTeamPlayers().get(10).getTotalSteals()).toString());
			playerTotalAssists.setText(((Double)Login.currentTeam.getTeamPlayers().get(10).getTotalAssists()).toString());
			playerTotalPoints.setText(((Double)Login.currentTeam.getTeamPlayers().get(10).getTotalPoints()).toString());
			playerPosition.setText(Login.currentTeam.getTeamPlayers().get(10).getPlayerPosition());
		} else if (e.getSource() == player12) {
			playerName.setText(Login.currentTeam.getTeamPlayers().get(11).getPlayerName());
			playerScore.setText(((Integer)Login.currentTeam.getTeamPlayers().get(11).getPlayerScore()).toString());
			playerTotalRebounds.setText(((Double)Login.currentTeam.getTeamPlayers().get(11).getTotalRebounds()).toString());
			playerTotalBlocks.setText(((Double)Login.currentTeam.getTeamPlayers().get(11).getTotalBlocks()).toString());
			playerTotalSteals.setText(((Double)Login.currentTeam.getTeamPlayers().get(11).getTotalSteals()).toString());
			playerTotalAssists.setText(((Double)Login.currentTeam.getTeamPlayers().get(11).getTotalAssists()).toString());
			playerTotalPoints.setText(((Double)Login.currentTeam.getTeamPlayers().get(11).getTotalPoints()).toString());
			playerPosition.setText(Login.currentTeam.getTeamPlayers().get(11).getPlayerPosition());
		}
	}
	
	
	void start() {
		timer.start();
	}
	
	void stop() {
		timer.stop();
	}
}