package cs486.app;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import cs486.games.BFGame;

@SuppressWarnings("serial")
public class BFGamePanel extends JPanel {

	private static String[] SCREENS = { "Welcome screen", "Game 1 screen",
			"Game 2 screen", "Game 3 screen" };

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
		/* TODO: make a menu/welcome screen? */
		JLabel welcome = new JLabel("Welcome to BrainFlex", JLabel.CENTER);
		welcome.setForeground(Color.WHITE);
		this.add(welcome, SCREENS[0]);

/*		BFClickGame clickGame = new BFClickGame();
		clickGame.setPreferredSize(new Dimension(600, 600));
		this.add(clickGame, SCREENS[1]);
*/
	
	    cs486.games.BFSimonGame simonGame = new cs486.games.BFSimonGame();
		simonGame.setPreferredSize(new Dimension(600, 600));
		this.add(simonGame, SCREENS[1]);
		
		setVisibleGame(1);
		simonGame.play();
		
	}
}
