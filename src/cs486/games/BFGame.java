package cs486.games;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class BFGame extends JPanel implements BFPlayable {
	
	public BFGame() {
		this.setSize(600, 600);
		this.setVisible(true);
	}
}
