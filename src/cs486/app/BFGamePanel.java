package cs486.app;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BFGamePanel extends JPanel {
	
	public BFGamePanel() {
		this.setPreferredSize(new Dimension(600, 600));
		/* TODO: make a menu/welcome screen? */
		JLabel welcome = new JLabel("Welcome to BrainFlex", JLabel.CENTER);
		welcome.setForeground(Color.WHITE);
		this.add(welcome);

		this.setBackground(Color.BLACK);
		this.setVisible(true);
	}
}
