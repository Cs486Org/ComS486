package cs486.app;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class BFScorePanel extends JPanel {

	public BFScorePanel() {
		this.setPreferredSize(new Dimension(200, 600));
		this.add(new JLabel("<Player profile and stats>"));
		this.setVisible(true);
	}
}
