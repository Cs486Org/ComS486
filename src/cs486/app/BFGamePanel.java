package cs486.app;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BFGamePanel extends JPanel {

	private static String[] SCREENS = { "Welcome screen", "Game 1 screen",
			"Game 2 screen", "Game 3 screen" };
	private boolean gameInPlay = false;
	
	public BFGamePanel() {
		this.setPreferredSize(new Dimension(600, 600));
		this.setLayout(new CardLayout());

		createAndAddScreens();

		this.setBackground(Color.BLACK);
		this.setVisible(true);
	}

	// This is the method to prompt for game play.
	public void suggestGame(long runtime) {
		JLabel playGame = (JLabel) this.getComponent(0);
		playGame.setText("It appears you have " + runtime / 60000
				+ " minutes free.  would you like to play a game?");

	}

	public void setVisibleGame(int gameID) {
		CardLayout cl = (CardLayout) (this.getLayout());
		cl.show(this, SCREENS[gameID]);

	}

	private void createAndAddScreens() {
		JLabel welcome = new JLabel("Welcome to BrainFlex", JLabel.CENTER);
		welcome.setForeground(Color.WHITE);
		this.add(welcome, SCREENS[0]);

		// TODO: add game(s)
		/*
		BFClickGame bfcg = new BFClickGame();
		bfcg.setPreferredSize(new Dimension(600, 600));
		this.add(bfcg, SCREENS[1]);
		*/
	}

	public boolean isGameInPlay() {
		return gameInPlay;
	}
}
