package team;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.awt.*;

import javax.swing.*;

import match.MatchUI;
import player.*;
import user.Login;

public class DraftingUI extends JFrame implements ActionListener {
	int counter = 0;
	String notEnoughPositionsText = "Your team must include the following:\n";
	
	JFrame draftingPage;
	JLayeredPane componentsPanel;
	JLabel background;
	JLabel title;
	JLabel teamName;
	JLabel teamLogo;
	
	HashMap<Integer, JButton> playerList = new HashMap<>();
	HashMap<Integer, JButton> playerScores = new HashMap<>();
	HashMap<Integer, Player> listedPlayers = new HashMap<>();
	ArrayList<Integer> emptySlots = new ArrayList<>();
	JLayeredPane playerInfo;
	JLabel playerName = new JLabel();
	JLabel playerPosition = new JLabel();
	JLabel playerScoreTitle = new JLabel();
	JLabel playerTotalReboundsTitle = new JLabel();
	JLabel playerTotalBlocksTitle = new JLabel();
	JLabel playerTotalStealsTitle;
	JLabel playerTotalAssistsTitle;
	JLabel playerTotalPointsTitle;
	JLabel playerScore = new JLabel();
	JLabel playerTotalRebounds = new JLabel();
	JLabel playerTotalBlocks = new JLabel();
	JLabel playerTotalSteals = new JLabel();
	JLabel playerTotalAssists = new JLabel();
	JLabel playerTotalPoints = new JLabel();
	
	JButton player1 = new JButton();
	JButton player1Score = new JButton();
	JButton player2 = new JButton();
	JButton player2Score = new JButton();
	JButton player3 = new JButton();
	JButton player3Score = new JButton();
	JButton player4 = new JButton();
	JButton player4Score = new JButton();
	JButton player5 = new JButton();
	JButton player5Score = new JButton();
	JButton player6 = new JButton();
	JButton player6Score = new JButton();
	JButton player7 = new JButton();
	JButton player7Score = new JButton();
	JButton player8 = new JButton();
	JButton player8Score = new JButton();
	JButton player9 = new JButton();
	JButton player9Score = new JButton();
	JButton player10 = new JButton();
	JButton player10Score = new JButton();
	JButton player11 = new JButton();
	JButton player11Score = new JButton();
	JButton player12 = new JButton();
	JButton player12Score = new JButton();
	JComboBox<Player> playerChooser = new JComboBox(Drafting.availablePlayers.toArray());
	JButton chooseButton;
	JButton continueButton;
	
	JButton startButton;
	
	JTextArea notEnoughPositions;
	
	JLayeredPane playerInfoPopup;
	JLabel pipBlur;
	JLabel pipPanel;
	JLabel pipPlayerName;
	JLabel pipPlayerPosition;
	JLabel pipPlayerScoreTitle;
	JLabel pipPlayerScore;
	JLabel pipPlayerTotalReboundsTitle;
	JLabel pipPlayerTotalRebounds;
	JLabel pipPlayerTotalBlocksTitle;
	JLabel pipPlayerTotalBlocks;
	JLabel pipPlayerTotalStealsTitle;
	JLabel pipPlayerTotalSteals;
	JLabel pipPlayerTotalAssistsTitle;
	JLabel pipPlayerTotalAssists;
	JLabel pipPlayerTotalPointsTitle;
	JLabel pipPlayerTotalPoints;
	JButton pipBackButton;


	
	// FONT
	Font InterSemibold = Font.createFont(Font.PLAIN, new File("resources/components/fonts/Inter-SemiBold.ttf"));
	Font InterSemibold36 = InterSemibold.deriveFont((float) 36.0);
	Font InterSemibold14x4 = InterSemibold.deriveFont((float) 14.4);
	Font InterSemibold20 = InterSemibold.deriveFont((float) 20);
	Font InterRegular = Font.createFont(Font.PLAIN, new File("resources/components/fonts/Inter-Regular.ttf"));
	Font InterRegular12 = InterRegular.deriveFont((float) 12.0);
	
	
	/**
	 * This is the constructor of the Drafting page UI.
	 * It includes a JComboBox which contains the list
	 * of all available players for drafting. It shows
	 * the information about selected player such as
	 * their positions and scores, and shows a Choose
	 * button which allows users to take the Player to
	 * their teams. This allows users to remove a player
	 * from their team to take another Player instead of
	 * the removed as well, by clicking on the name of a
	 * player. In addition, if the score of a chosen player
	 * is clicked, it opens a pop-up integrated to the
	 * same page, showing the statistics of corresponding
	 * player.
	 * @throws IOException
	 * @throws FontFormatException
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public DraftingUI() throws IOException, FontFormatException {
		for (int i = 1 ; i < 13 ; i ++) {
			emptySlots.add(i);
		}
		playerList.put(1, player1);
		playerList.put(2, player2);
		playerList.put(3, player3);
		playerList.put(4, player4);
		playerList.put(5, player5);
		playerList.put(6, player6);
		playerList.put(7, player7);
		playerList.put(8, player8);
		playerList.put(9, player9);
		playerList.put(10, player10);
		playerList.put(11, player11);
		playerList.put(12, player12);
		playerScores.put(1, player1Score);
		playerScores.put(2, player2Score);
		playerScores.put(3, player3Score);
		playerScores.put(4, player4Score);
		playerScores.put(5, player5Score);
		playerScores.put(6, player6Score);
		playerScores.put(7, player7Score);
		playerScores.put(8, player8Score);
		playerScores.put(9, player9Score);
		playerScores.put(10, player10Score);
		playerScores.put(11, player11Score);
		playerScores.put(12, player12Score);
		
		draftingPage = new JFrame();
		draftingPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		draftingPage.setSize(1440, 900);
		draftingPage.setBackground(new Color(29, 66, 138));
		draftingPage.setResizable(false);
		
		componentsPanel = new JLayeredPane();
		componentsPanel.setSize(1440, 900);
		componentsPanel.setLocation(0, 0);
		
		playerInfo = new JLayeredPane();
		playerInfo.setSize(645, 650);
		playerInfo.setLocation(82, 80);
		playerInfo.setBackground(Color.white);
		playerInfo.setOpaque(false);
		
		title = new JLabel();
		title.setSize(350, 44);
		title.setFont(InterSemibold36);
		title.setText("Pick your players");
		title.setLocation(82, 72);
		
		background = new JLabel();
		background.setIcon(new ImageIcon("resources/components/draftingui/backgroundimage.png"));
		background.setSize(1440, 900);
		background.setLocation(0, 0);
		
		teamName = new JLabel();
		teamName.setText(Login.currentTeam.getTeamName());
		teamName.setLocation(690, 44);
		teamName.setSize(576, 100);
		teamName.setForeground(Login.currentTeam.getTeamColor());
		teamName.setFont(InterSemibold36);
		
		teamLogo = new JLabel();
		teamLogo.setSize(100, 100);
		teamLogo.setLocation(1296, 44);
		
		ImageIcon teamLogoIcon = new ImageIcon(Login.currentTeam.getTeamLogoPath());
		Image teamLogoImage = teamLogoIcon.getImage();
		teamLogoImage = teamLogoImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);
		teamLogo.setIcon(new ImageIcon(teamLogoImage));
		
		startButton = new JButton();
		startButton.setSize(150, 40);
		startButton.setLocation(510, 74);
		startButton.setIcon(new ImageIcon("resources/components/draftingui/startbutton.png"));
		startButton.addActionListener(this);
		

		playerChooser.setVisible(false);
		playerChooser.setSize(670, 50);
		playerChooser.setLocation(82, 228);
		playerChooser.addActionListener(this);
		
		playerName = new JLabel();
		playerName.setSize(480, 48);
		playerName.setFont(InterSemibold36);
		playerName.setLocation(20, 205);
		playerName.setForeground(Color.black);
		
		/////
		playerPosition = new JLabel();
		playerPosition.setSize(80, 34);
		playerPosition.setLocation(540, 214);
		playerPosition.setFont(InterSemibold36);
		playerPosition.setForeground(Color.black);
		// set text in loop
		
		playerScoreTitle = new JLabel();
		playerScoreTitle.setSize(100, 24);
		playerScoreTitle.setLocation(20, 268);
		playerScoreTitle.setFont(InterSemibold20);
		playerScoreTitle.setForeground(Color.black);
		playerScoreTitle.setText("SCORE");
		
		playerTotalReboundsTitle = new JLabel();
		playerTotalReboundsTitle.setSize(200, 24);
		playerTotalReboundsTitle.setLocation(20, 312);
		playerTotalReboundsTitle.setFont(InterSemibold20);
		playerTotalReboundsTitle.setForeground(new Color(98, 98, 98));
		playerTotalReboundsTitle.setText("TOTAL REBOUNDS");
		
		playerTotalBlocksTitle = new JLabel();
		playerTotalBlocksTitle.setSize(200, 24);
		playerTotalBlocksTitle.setLocation(20, 356);
		playerTotalBlocksTitle.setFont(InterSemibold20);
		playerTotalBlocksTitle.setForeground(new Color(98, 98, 98));
		playerTotalBlocksTitle.setText("TOTAL BLOCKS");
		
		playerTotalStealsTitle = new JLabel();
		playerTotalStealsTitle.setSize(200, 24);
		playerTotalStealsTitle.setLocation(20, 400);
		playerTotalStealsTitle.setFont(InterSemibold20);
		playerTotalStealsTitle.setForeground(new Color(98, 98, 98));
		playerTotalStealsTitle.setText("TOTAL STEALS");
		
		playerTotalAssistsTitle = new JLabel();
		playerTotalAssistsTitle.setSize(200, 24);
		playerTotalAssistsTitle.setLocation(20, 444);
		playerTotalAssistsTitle.setFont(InterSemibold20);
		playerTotalAssistsTitle.setForeground(new Color(98, 98, 98));
		playerTotalAssistsTitle.setText("TOTAL ASSISTS");

		playerTotalPointsTitle = new JLabel();
		playerTotalPointsTitle.setSize(200, 24);
		playerTotalPointsTitle.setLocation(20, 488);
		playerTotalPointsTitle.setFont(InterSemibold20);
		playerTotalPointsTitle.setForeground(new Color(98, 98, 98));
		playerTotalPointsTitle.setText("TOTAL POINTS");
		
		playerScore = new JLabel();
		playerScore.setSize(200, 24);
		playerScore.setLocation(540, 268);
		playerScore.setFont(InterSemibold20);
		playerScore.setForeground(Color.black);
		
		playerTotalRebounds = new JLabel();
		playerTotalRebounds.setSize(200, 24);
		playerTotalRebounds.setLocation(540, 312);
		playerTotalRebounds.setFont(InterSemibold20);
		playerTotalRebounds.setForeground(new Color(98, 98, 98));
		
		playerTotalBlocks = new JLabel();
		playerTotalBlocks.setSize(200, 24);
		playerTotalBlocks.setLocation(540, 356);
		playerTotalBlocks.setFont(InterSemibold20);
		playerTotalBlocks.setForeground(new Color(98, 98, 98));
		
		playerTotalSteals = new JLabel();
		playerTotalSteals.setSize(200, 24);
		playerTotalSteals.setLocation(540, 400);
		playerTotalSteals.setFont(InterSemibold20);
		playerTotalSteals.setForeground(new Color(98, 98, 98));
		
		playerTotalAssists = new JLabel();
		playerTotalAssists.setSize(200, 24);
		playerTotalAssists.setLocation(540, 444);
		playerTotalAssists.setFont(InterSemibold20);
		playerTotalAssists.setForeground(new Color(98, 98, 98));

		playerTotalPoints = new JLabel();
		playerTotalPoints.setSize(200, 24);
		playerTotalPoints.setLocation(540, 488);
		playerTotalPoints.setFont(InterSemibold20);
		playerTotalPoints.setForeground(new Color(98, 98, 98));
		/////
		chooseButton = new JButton();
		chooseButton.setSize(150, 40);
		chooseButton.setIcon(new ImageIcon("resources/components/draftingui/choosebutton.png"));
		chooseButton.setLocation(230, 601);
		chooseButton.addActionListener(this);
		
		int labelX = 826;
		int labelY = 186;
		int counter = 0;
		for (JButton button : playerList.values()) {
			button.setFont(InterSemibold20);
			button.setSize(480, 24);
			button.setLocation(labelX, labelY + counter * 40);
			button.setContentAreaFilled(false);
			button.setBorderPainted(false);
			button.setHorizontalAlignment(JButton.LEFT);
			button.addActionListener(this);
			counter++;
		}
		
		for (JButton button : playerList.values()) {
			componentsPanel.add(button, JLayeredPane.MODAL_LAYER);
		}
		
		int labelX2 = 1315;
		int labelY2 = 186;
		int counter2 = 0;
		for (JButton button : playerScores.values()) {
			button.setFont(InterSemibold20);
			button.setSize(72, 24);
			button.setLocation(labelX2, labelY2 + counter2 * 40);
			button.setContentAreaFilled(false);
			button.setBorderPainted(false);
			button.setHorizontalAlignment(JButton.LEFT);
			button.addActionListener(this);
			counter2++;
		}
		
		for (JButton button : playerScores.values()) {
			componentsPanel.add(button, JLayeredPane.MODAL_LAYER);
		}
		
		continueButton = new JButton();
		continueButton.setLocation(826, 800);
		continueButton.setSize(150, 40);
		continueButton.setIcon(new ImageIcon("resources/components/draftingui/continuebutton.png"));
		continueButton.addActionListener(this);
		continueButton.setContentAreaFilled(false);
		continueButton.setBorderPainted(false);
		continueButton.setOpaque(false);
		continueButton.setVisible(false);
		
		
		
		playerInfoPopup = new JLayeredPane();
		playerInfoPopup.setSize(1440, 900);
		playerInfoPopup.setLocation(0, 0);
		
		pipBlur = new JLabel();
		pipBlur.setSize(1440, 900);
		pipBlur.setIcon(new ImageIcon("resources/components/draftingui/pipblur.png"));
		pipBlur.setLocation(0, 0);
		
		pipPanel = new JLabel();
		pipPanel.setBackground(Color.black);
		pipPanel.setSize(720, 420);
		pipPanel.setLocation(360, 240);
		pipPanel.setOpaque(true);
		
		pipBackButton = new JButton();
		pipBackButton.setSize(27, 25);
		pipBackButton.setLocation(384, 270);
		pipBackButton.setIcon(new ImageIcon("resources/components/draftingui/backbutton.png"));
		pipBackButton.setBorderPainted(false);
		pipBackButton.setContentAreaFilled(false);
		pipBackButton.addActionListener(this);
		
		pipPlayerName = new JLabel();
		pipPlayerName.setFont(InterSemibold36);
		pipPlayerName.setSize(400, 44);
		pipPlayerName.setLocation(384, 311);
		pipPlayerName.setForeground(Color.white);
		// set text in actionperformed
		
		pipPlayerPosition = new JLabel();
		pipPlayerPosition.setFont(InterSemibold36);
		pipPlayerPosition.setSize(64, 44);
		pipPlayerPosition.setLocation(974, 311);
		pipPlayerPosition.setForeground(Color.white);
		// set text in actionperformed
		
		pipPlayerScoreTitle = new JLabel();
		pipPlayerScoreTitle.setFont(InterSemibold20);
		pipPlayerScoreTitle.setSize(100, 24);
		pipPlayerScoreTitle.setLocation(384, 375);
		pipPlayerScoreTitle.setForeground(Color.white);
		pipPlayerScoreTitle.setText("SCORE");
		
		pipPlayerTotalReboundsTitle = new JLabel();
		pipPlayerTotalReboundsTitle.setFont(InterSemibold20);
		pipPlayerTotalReboundsTitle.setSize(200, 24);
		pipPlayerTotalReboundsTitle.setLocation(384, 419);
		pipPlayerTotalReboundsTitle.setForeground(Color.white);
		pipPlayerTotalReboundsTitle.setText("TOTAL REBOUNDS");
		
		pipPlayerTotalBlocksTitle = new JLabel();
		pipPlayerTotalBlocksTitle.setFont(InterSemibold20);
		pipPlayerTotalBlocksTitle.setSize(200, 24);
		pipPlayerTotalBlocksTitle.setLocation(384, 463);
		pipPlayerTotalBlocksTitle.setForeground(Color.white);
		pipPlayerTotalBlocksTitle.setText("TOTAL BLOCKS");
		
		pipPlayerTotalStealsTitle = new JLabel();
		pipPlayerTotalStealsTitle.setFont(InterSemibold20);
		pipPlayerTotalStealsTitle.setSize(200, 24);
		pipPlayerTotalStealsTitle.setLocation(384, 507);
		pipPlayerTotalStealsTitle.setForeground(Color.white);
		pipPlayerTotalStealsTitle.setText("TOTAL STEALS");
		
		pipPlayerTotalAssistsTitle = new JLabel();
		pipPlayerTotalAssistsTitle.setFont(InterSemibold20);
		pipPlayerTotalAssistsTitle.setSize(200, 24);
		pipPlayerTotalAssistsTitle.setLocation(384, 551);
		pipPlayerTotalAssistsTitle.setForeground(Color.white);
		pipPlayerTotalAssistsTitle.setText("TOTAL ASSISTS");
		
		pipPlayerTotalPointsTitle = new JLabel();
		pipPlayerTotalPointsTitle.setFont(InterSemibold20);
		pipPlayerTotalPointsTitle.setSize(200, 24);
		pipPlayerTotalPointsTitle.setLocation(384, 595);
		pipPlayerTotalPointsTitle.setForeground(Color.white);
		pipPlayerTotalPointsTitle.setText("TOTAL POINTS");
		
		pipPlayerScore = new JLabel();
		pipPlayerScore.setFont(InterSemibold20);
		pipPlayerScore.setSize(80, 24);
		pipPlayerScore.setLocation(974, 375);
		pipPlayerScore.setForeground(Color.white);

		
		pipPlayerTotalRebounds = new JLabel();
		pipPlayerTotalRebounds.setFont(InterSemibold20);
		pipPlayerTotalRebounds.setSize(80, 24);
		pipPlayerTotalRebounds.setLocation(974, 419);
		pipPlayerTotalRebounds.setForeground(Color.white);

		
		pipPlayerTotalBlocks = new JLabel();
		pipPlayerTotalBlocks.setFont(InterSemibold20);
		pipPlayerTotalBlocks.setSize(80, 24);
		pipPlayerTotalBlocks.setLocation(974, 463);
		pipPlayerTotalBlocks.setForeground(Color.white);

		
		pipPlayerTotalSteals = new JLabel();
		pipPlayerTotalSteals.setFont(InterSemibold20);
		pipPlayerTotalSteals.setSize(80, 24);
		pipPlayerTotalSteals.setLocation(974, 507);
		pipPlayerTotalSteals.setForeground(Color.white);

		
		pipPlayerTotalAssists = new JLabel();
		pipPlayerTotalAssists.setFont(InterSemibold20);
		pipPlayerTotalAssists.setSize(80, 24);
		pipPlayerTotalAssists.setLocation(974, 551);
		pipPlayerTotalAssists.setForeground(Color.white);

		
		pipPlayerTotalPoints = new JLabel();
		pipPlayerTotalPoints.setFont(InterSemibold20);
		pipPlayerTotalPoints.setSize(80, 24);
		pipPlayerTotalPoints.setLocation(974, 595);
		pipPlayerTotalPoints.setForeground(Color.white);
	
		
		playerInfoPopup.add(pipPlayerTotalPoints, JLayeredPane.DRAG_LAYER);				
		playerInfoPopup.add(pipPlayerTotalAssists, JLayeredPane.DRAG_LAYER);					
		playerInfoPopup.add(pipPlayerTotalSteals, JLayeredPane.DRAG_LAYER);				
		playerInfoPopup.add(pipPlayerTotalBlocks, JLayeredPane.DRAG_LAYER);			
		playerInfoPopup.add(pipPlayerTotalRebounds, JLayeredPane.DRAG_LAYER);		
		playerInfoPopup.add(pipPlayerScore, JLayeredPane.DRAG_LAYER);		
		playerInfoPopup.add(pipPlayerTotalPointsTitle, JLayeredPane.DRAG_LAYER);				
		playerInfoPopup.add(pipPlayerTotalAssistsTitle, JLayeredPane.DRAG_LAYER);					
		playerInfoPopup.add(pipPlayerTotalStealsTitle, JLayeredPane.DRAG_LAYER);				
		playerInfoPopup.add(pipPlayerTotalBlocksTitle, JLayeredPane.DRAG_LAYER);			
		playerInfoPopup.add(pipPlayerTotalReboundsTitle, JLayeredPane.DRAG_LAYER);		
		playerInfoPopup.add(pipPlayerScoreTitle, JLayeredPane.DRAG_LAYER);
		playerInfoPopup.add(pipPlayerPosition, JLayeredPane.DRAG_LAYER);
		playerInfoPopup.add(pipPlayerName, JLayeredPane.DRAG_LAYER);
		playerInfoPopup.add(pipBackButton, JLayeredPane.DRAG_LAYER);
		playerInfoPopup.add(pipPanel, JLayeredPane.PALETTE_LAYER);
		playerInfoPopup.add(pipBlur, JLayeredPane.DEFAULT_LAYER);
		playerInfoPopup.setVisible(false);
		
		playerInfo.setVisible(false);
		playerInfo.add(chooseButton, JLayeredPane.DRAG_LAYER);
		playerInfo.add(playerPosition, JLayeredPane.DRAG_LAYER);
		playerInfo.add(playerName, JLayeredPane.DRAG_LAYER);
		playerInfo.add(playerTotalPoints, JLayeredPane.DRAG_LAYER);
		playerInfo.add(playerTotalAssists, JLayeredPane.DRAG_LAYER);
		playerInfo.add(playerTotalSteals, JLayeredPane.DRAG_LAYER);
		playerInfo.add(playerTotalBlocks, JLayeredPane.DRAG_LAYER);
		playerInfo.add(playerTotalRebounds, JLayeredPane.DRAG_LAYER);
		playerInfo.add(playerScore, JLayeredPane.DRAG_LAYER);
		playerInfo.add(playerTotalPointsTitle, JLayeredPane.DRAG_LAYER);
		playerInfo.add(playerTotalAssistsTitle, JLayeredPane.DRAG_LAYER);
		playerInfo.add(playerTotalStealsTitle, JLayeredPane.DRAG_LAYER);
		playerInfo.add(playerTotalBlocksTitle, JLayeredPane.DRAG_LAYER);
		playerInfo.add(playerTotalReboundsTitle, JLayeredPane.DRAG_LAYER);
		playerInfo.add(playerScoreTitle, JLayeredPane.DRAG_LAYER);
		
// add hashmap values
		componentsPanel.add(playerInfoPopup, JLayeredPane.DRAG_LAYER);
		componentsPanel.add(continueButton, JLayeredPane.MODAL_LAYER);
		componentsPanel.add(playerInfo, JLayeredPane.MODAL_LAYER);
		componentsPanel.add(playerChooser, JLayeredPane.MODAL_LAYER);
		componentsPanel.add(startButton, JLayeredPane.MODAL_LAYER);
		componentsPanel.add(teamLogo, JLayeredPane.MODAL_LAYER);
		componentsPanel.add(teamName, JLayeredPane.MODAL_LAYER);
		componentsPanel.add(background, JLayeredPane.DEFAULT_LAYER);
		componentsPanel.add(title, JLayeredPane.MODAL_LAYER);
		
		notEnoughPositions = new JTextArea();
		notEnoughPositions.setSize(280, 120);
		notEnoughPositions.setLocation(395, 34);
		notEnoughPositions.setForeground(new Color(0xC8102E));
		notEnoughPositions.setOpaque(false);
		notEnoughPositions.setBackground(new Color(0, 0, 0, 0));
		notEnoughPositions.setFont(InterRegular12);
		notEnoughPositions.setText("Your team must have the following:");
		notEnoughPositions.setFocusable(false);
		notEnoughPositions.setVisible(false);
		

		componentsPanel.add(notEnoughPositions, JLayeredPane.DRAG_LAYER);
		draftingPage.add(componentsPanel);
		draftingPage.setVisible(true);
		
		
	}

	@Override
	/**
	 * This overridden method of ActionListener interface
	 * takes the action from the Drafting UI, and then
	 * evaluates its source. Then accordingly, it performs
	 * the actions, such as drafting a player or removing
	 * a player, and updating the UI correspondingly.
	 * @author Göktürk Gök
	 * @date 03-01-2024
	 */
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == startButton) {
			int place = Drafting.playingTeams.indexOf(Login.currentTeam);
			startButton.setVisible(false);
			for (int i = 0 ; i < place ; i ++) {
				Player botChosenPlayer = null;
				try {
					botChosenPlayer = Drafting.botsChoosePlayer(Drafting.playingTeams.get(i));
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				playerChooser.removeItem(botChosenPlayer);
				playerChooser.repaint();
				playerChooser.revalidate();
			}


			playerChooser.setEnabled(true);
			playerChooser.setVisible(true);
			chooseButton.setVisible(true);
		} else if (e.getSource() == playerChooser) {
			playerScore.setText(((Integer)(((Player) playerChooser.getSelectedItem()).getPlayerScore())).toString());
			playerTotalRebounds.setText(String.format(((Double)(((Player) playerChooser.getSelectedItem()).getTotalRebounds())).toString()));
			playerTotalBlocks.setText(((Double)(((Player) playerChooser.getSelectedItem()).getTotalBlocks())).toString());
			playerTotalSteals.setText(((Double)(((Player) playerChooser.getSelectedItem()).getTotalSteals())).toString());
			playerTotalAssists.setText(((Double)(((Player) playerChooser.getSelectedItem()).getTotalAssists())).toString());
			playerTotalPoints.setText(((Double)(((Player) playerChooser.getSelectedItem()).getTotalPoints())).toString());
			playerName.setText(((Player) playerChooser.getSelectedItem()).getPlayerName());
			playerPosition.setText(((Player) playerChooser.getSelectedItem()).getPlayerPosition());
			playerInfo.setVisible(true);
			
		} else if (e.getSource() == chooseButton) {
			
			if (Login.currentTeam.teamPlayers.size() < 12) {
				Player selectedPlayer = (Player) playerChooser.getSelectedItem();
				playerChooser.setSelectedIndex(0);
				Login.currentTeam.teamPlayers.add(selectedPlayer);
				Drafting.availablePlayers.remove(selectedPlayer);
				playerChooser.setVisible(false);
				playerChooser.removeItem(selectedPlayer);
				playerChooser.repaint();
				playerChooser.revalidate();
				playerChooser.setVisible(true);
				playerChooser.setEnabled(true);
				
				if (selectedPlayer.getPlayerPosition().equals("C")) {
					Drafting.availablePlayerC.remove(selectedPlayer);
					Login.currentTeam.playersC.add(selectedPlayer);
				} else if (selectedPlayer.getPlayerPosition().equals("PF")) {
					Drafting.availablePlayerPF.remove(selectedPlayer);
					Login.currentTeam.playersPF.add(selectedPlayer);
				} else if (selectedPlayer.getPlayerPosition().equals("PG")) {
					Drafting.availablePlayerPG.remove(selectedPlayer);
					Login.currentTeam.playersPG.add(selectedPlayer);
				} else if (selectedPlayer.getPlayerPosition().equals("SF")) {
					Drafting.availablePlayerSF.remove(selectedPlayer);
					Login.currentTeam.playersSF.add(selectedPlayer);
				} else if (selectedPlayer.getPlayerPosition().equals("SG")) {
					Drafting.availablePlayerSG.remove(selectedPlayer);
					Login.currentTeam.playersSG.add(selectedPlayer);
				}
				
				playerList.get(emptySlots.get(0)).setText(selectedPlayer.getPlayerPosition() + " " + selectedPlayer.getPlayerName());
				playerScores.get(emptySlots.get(0)).setText(((Integer)selectedPlayer.getPlayerScore()).toString());
				listedPlayers.put(emptySlots.get(0), selectedPlayer);
				emptySlots.remove(0);
				
				if (Login.currentTeam.teamPlayers.size() == 12) {
					if (Login.currentTeam.playersC.size() == 0) {
						notEnoughPositionsText += "Center (C)\n";
						notEnoughPositions.setVisible(true);
					}
					if (Login.currentTeam.playersPF.size() == 0) {
						notEnoughPositionsText += "Power Forward (PF)\n";
						notEnoughPositions.setVisible(true);
					}
					if (Login.currentTeam.playersPG.size() == 0) {
						notEnoughPositionsText += "Point Guard (PG)\n";
						notEnoughPositions.setVisible(true);
					}
					if (Login.currentTeam.playersSF.size() == 0) {
						notEnoughPositionsText += "Small Forward (SF)\n";
						notEnoughPositions.setVisible(true);
					}
					if (Login.currentTeam.playersSG.size() == 0) {
						notEnoughPositionsText += "Shooting Guard (SG)\n";

						notEnoughPositions.setVisible(true);
					}
					notEnoughPositions.setText(notEnoughPositionsText);
					
				}
				
				

				
				if (Drafting.playingTeams.getLast().teamPlayers.size() != 12) {
					for (int i = Drafting.playingTeams.indexOf(Login.currentTeam) + 1 ; i < Drafting.playingTeams.size() ; i++) {
						Player botChosenPlayer = null;
						try {
							botChosenPlayer = Drafting.botsChoosePlayer(Drafting.playingTeams.get(i));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						playerChooser.removeItem(botChosenPlayer);
						playerChooser.repaint();
						playerChooser.revalidate();
					}

				}
				if (Drafting.playingTeams.getLast().teamPlayers.size() != 12) {	
					for (int i = 0 ; i < Drafting.playingTeams.indexOf(Login.currentTeam) ; i++) {
						Player botChosenPlayer = null;
						try {
							botChosenPlayer = Drafting.botsChoosePlayer(Drafting.playingTeams.get(i));
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						playerChooser.removeItem(botChosenPlayer);
						playerChooser.repaint();
						playerChooser.revalidate();
					}
				}
				

				if (Drafting.playingTeams.getLast().teamPlayers.size() == 12 && Login.currentTeam.teamPlayers.size() == 12 && Login.currentTeam.playersC.size() != 0 && Login.currentTeam.playersPF.size() != 0 && Login.currentTeam.playersPG.size() != 0 && Login.currentTeam.playersSF.size() != 0 && Login.currentTeam.playersSG.size() != 0) {
					continueButton.setVisible(true);
					notEnoughPositions.setVisible(false);

				}
			}



		} else if (playerList.values().contains(e.getSource())) {
			if (((JButton)e.getSource()).getText().equals("") == false) {
				((JButton) e.getSource()).setText("");
				
				ArrayList<JButton> playerListValues = new ArrayList<JButton>(playerList.values());
				int index = playerListValues.indexOf(e.getSource());
				playerScores.get(index + 1).setText("");
				Player playerToRemove = listedPlayers.get(index + 1);
				Login.currentTeam.teamPlayers.remove(playerToRemove);
				Drafting.availablePlayers.add(playerToRemove);
				if (playerToRemove.getPlayerPosition().equals("C")) {
					Drafting.availablePlayerC.add((PlayerC) playerToRemove);
					Login.currentTeam.playersC.remove(playerToRemove);
				} else if (playerToRemove.getPlayerPosition().equals("PF")) {
					Drafting.availablePlayerPF.add((PlayerPF) playerToRemove);
					Login.currentTeam.playersPF.remove(playerToRemove);
				} else if (playerToRemove.getPlayerPosition().equals("PG")) {
					Drafting.availablePlayerPG.add((PlayerPG) playerToRemove);
					Login.currentTeam.playersPG.remove(playerToRemove);
				} else if (playerToRemove.getPlayerPosition().equals("SF")) {
					Drafting.availablePlayerSF.add((PlayerSF) playerToRemove);
					Login.currentTeam.playersSF.remove(playerToRemove);
				} else if (playerToRemove.getPlayerPosition().equals("SG")) {
					Drafting.availablePlayerSG.add((PlayerSG) playerToRemove);
					Login.currentTeam.playersSG.remove(playerToRemove);
				}
				emptySlots.add(0, index + 1);
				Collections.sort(emptySlots);
				playerChooser.addItem(playerToRemove);
				playerChooser.revalidate();
				playerChooser.repaint();
				continueButton.setVisible(false);
			}
	
			
		} else if (e.getSource() == continueButton) {
			if (Drafting.playingTeams.getLast().teamPlayers.size() == 12 && Login.currentTeam.teamPlayers.size() == 12 && Login.currentTeam.playersC.size() != 0 && Login.currentTeam.playersPF.size() != 0 && Login.currentTeam.playersPG.size() != 0 && Login.currentTeam.playersSF.size() != 0 && Login.currentTeam.playersSG.size() != 0) {
				draftingPage.dispose();
				try {
					new MatchUI();
				} catch (IOException | FontFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
				
				
				
			}
		} else if (playerScores.values().contains(e.getSource())) {
			if (((JButton)e.getSource()).getText().equals("") == false) {
				ArrayList<JButton> playerScoresValues = new ArrayList<JButton>(playerScores.values());
				int index = playerScoresValues.indexOf(e.getSource());
				Player playerToShow = Login.currentTeam.teamPlayers.get(index);
				pipPlayerScore.setText(((Integer)playerToShow.getPlayerScore()).toString());
				pipPlayerTotalRebounds.setText(((Double)playerToShow.getTotalRebounds()).toString());
				pipPlayerTotalBlocks.setText(((Double)playerToShow.getTotalBlocks()).toString());
				pipPlayerTotalSteals.setText(((Double)playerToShow.getTotalSteals()).toString());
				pipPlayerTotalAssists.setText(((Double)playerToShow.getTotalAssists()).toString());
				pipPlayerTotalPoints.setText(((Double)playerToShow.getTotalPoints()).toString());
				pipPlayerName.setText(playerToShow.getPlayerName());
				pipPlayerPosition.setText(playerToShow.getPlayerPosition());
				playerInfoPopup.revalidate();
				playerInfoPopup.repaint();
				playerInfoPopup.setVisible(true);
			}

			
		} else if (e.getSource().equals(pipBackButton)) {
			playerInfoPopup.setVisible(false);
		}
	}

	
}
