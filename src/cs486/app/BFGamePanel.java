package cs486.app;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BFGamePanel extends JPanel {
	
	public BFGamePanel() {
		this.setPreferredSize(new Dimension(600, 600));
		JLabel welcome = new JLabel("Welcome to BrainFlex", JLabel.CENTER);
		welcome.setForeground(Color.WHITE);
		this.add(welcome);
		this.setBackground(Color.BLACK);
		this.setVisible(true);
	}

	//This is the method to prompt for game play.
	public void suggestGame(long runtime) {
		JLabel playGame = (JLabel) this.getComponent(0);
		playGame.setText("It appears you have "+runtime/60000+" minutes free.  would you like to play a game?");
		
	}
}
