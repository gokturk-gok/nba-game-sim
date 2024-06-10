package team;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;

import java.awt.*;

public class TeamViewUI extends JFrame implements ActionListener {
	JFrame teamView;
	JLayeredPane componentPanel;
	JButton backButton;
	JLabel title;
	JLabel teamName;
	JLabel teamLogo;
	JLabel teamScore;
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
	
	JLayeredPane playerInfo;
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
	public TeamViewUI() throws IOException, FontFormatException {
		teamView = new JFrame();
		teamView.setSize(1440, 900);
		teamView.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		componentPanel = new JLayeredPane();
		componentPanel.setSize(1440, 900);
		componentPanel.setBackground(Color.black);
		componentPanel.setOpaque(true);
		componentPanel.setLocation(0, 0);
		
		title = new JLabel();
		
		
		teamView.add(componentPanel);
		teamView.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
	}
}
