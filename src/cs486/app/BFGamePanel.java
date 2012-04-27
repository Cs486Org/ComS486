package cs486.app;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import cs486.games.BFGame;

@SuppressWarnings("serial")
public class BFGamePanel extends JPanel implements ActionListener {

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
		JLabel playGame =  new JLabel("It appears you have " + runtime / 60000
				+ " minutes free.  would you like to play a game?", JLabel.CENTER);//(JLabel) this.getComponent(0);
		playGame.setSize(150, 200);
		playGame.setVisible(true);
		
		JButton playGameButton = new JButton("Play");
		
		playGameButton.addActionListener(this);
		playGameButton.setActionCommand("playPush");
		JDialog popup = new JDialog();
		popup.setLayout(new BoxLayout(popup.getContentPane(), BoxLayout.Y_AXIS));
		popup.setSize(515, 200);
		popup.setLocation(500, 300);
		popup.setVisible(true);
		
		popup.add(playGame);
		popup.add(playGameButton);

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
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if("playPush".equals(e.getActionCommand())){
	    	//setTime = 60000*1;
	    	//textField.setText("1 Minute");
			System.exit(0);
		}
		
	}
}
